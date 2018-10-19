package api;

import api.dto.BandaDTO;
import api.dto.InstrumentoDTO;
import api.dto.MusicoDTO;
import api.entities.Banda;
import api.entities.Instrumento;
import api.entities.Musico;
import api.restControllers.BandaRestController;
import api.restControllers.InstrumentoRestController;
import api.restControllers.MusicoRestController;
import http.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BandaIT {
    @Test
    public void createBanda() {
        List<Musico> musicos = this.createMusicos();
        Banda banda = new Banda("Banda1");
        banda.setFechaFundacion(LocalDateTime.now());
        banda.setNombre("Banda de Almansa");
        banda.setMusicos(musicos);
        HttpRequest request = HttpRequest.builder(BandaRestController.BANDAS)
                .body(new BandaDTO(banda)).post();
        HttpResponse response = new Client().submit(request);

        assertEquals(banda.getId(), response.getBody());
    }

    private List<Musico> createMusicos() {
        List<Musico> musicos = new ArrayList<>();
        String idInstrumento = this.createInstrumento();

        for (int i = 0; i < 5; i++) {
            HttpRequest request = HttpRequest.builder(MusicoRestController.MUSICOS)
                    .body(new MusicoDTO(new Musico(String.valueOf(i)).builder().
                            instrumento(new Instrumento(idInstrumento)).build())).post();
            HttpResponse response = new Client().submit(request);

            assertEquals(response.getStatus(), HttpStatus.OK);
            assertEquals(String.valueOf(i), response.getBody().toString());

            musicos.add(new Musico(response.getBody().toString()));
        }

        return musicos;
    }

    private String createInstrumento() {
        HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS)
                .body(new InstrumentoDTO(new Instrumento("1"))).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    public void createBandaWithNoId() {
        Banda banda = new Banda(null);
        HttpRequest request = HttpRequest.builder(BandaRestController.BANDAS)
                .body(new BandaDTO(banda)).post();

        assertThrows(HttpException.class, () -> new Client().submit(request), "BandaId is missing");
    }
}
