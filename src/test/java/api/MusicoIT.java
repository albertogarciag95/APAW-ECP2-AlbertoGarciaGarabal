package api;

import api.dto.InstrumentoDTO;
import api.dto.MusicoDTO;
import api.entities.Instrumento;
import api.entities.Musico;
import api.restControllers.InstrumentoRestController;
import api.restControllers.MusicoRestController;
import http.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MusicoIT {

    private Musico musicoDummie;

    @BeforeEach
    public void before() {
        musicoDummie = new Musico("1").builder().nombre("Alberto Garcia Garabal").edad(23)
                .profesional(false).instrumento(new Instrumento("1")).build();
    }

    @Test
    public void createMusico() {
        musicoDummie.setInstrumento(new Instrumento(this.createInstrumento("1")));
        HttpRequest request = HttpRequest.builder(MusicoRestController.MUSICOS)
                .body(new MusicoDTO(musicoDummie)).post();
        HttpResponse response = new Client().submit(request);

        assertEquals(response.getStatus(), HttpStatus.OK);
        assertEquals(musicoDummie.getId(), response.getBody().toString());
    }

    private String createInstrumento(String id) {
        HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS)
                .body(new InstrumentoDTO(new Instrumento(id))).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    public void createMusicoIdNull() {
        HttpRequest request = HttpRequest.builder(MusicoRestController.MUSICOS)
                .body(new MusicoDTO(new Musico(null))).post();

        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    public void createMusicoSinInstrumento() {
        musicoDummie.setInstrumento(null);
        HttpRequest request = HttpRequest.builder(MusicoRestController.MUSICOS)
                .body(new MusicoDTO(musicoDummie)).post();

        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    public void updateIsProfesional() {
        this.createMusico();
        HttpRequest request = HttpRequest.builder(MusicoRestController.MUSICOS).path(MusicoRestController.MUSICO_ID)
                .expandPath(musicoDummie.getId()).path(MusicoRestController.PROFESIONAL).body(true).patch();
        HttpResponse response = new Client().submit(request);
        assertEquals(response.getStatus(), HttpStatus.OK);
    }

}
