package api;

import api.dto.InstrumentoDTO;
import api.entities.FamiliaInstrumento;
import api.entities.Instrumento;
import api.restControllers.InstrumentoRestController;
import http.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstrumentoIT {

    private List<Instrumento> instrumentos = new ArrayList<>();

    @BeforeEach
    public void before() {
        instrumentos.add(new Instrumento("1").builder().nombre("Trompeta").material("Laton")
                .familia(FamiliaInstrumento.VIENTO_METAL).build());
        instrumentos.add(new Instrumento("2").builder().nombre("Clarinete").material("Madera")
                .familia(FamiliaInstrumento.VIENTO_MADERA).build());
        instrumentos.add(new Instrumento("3").builder().nombre("Timbales").material("Madera")
                .familia(FamiliaInstrumento.PERCUSION).build());
    }

    @Test
    public void test01CreateInstrumento() {
        for(int i = 0; i < instrumentos.size(); i ++ ) {
            Instrumento instrumento = new Instrumento(instrumentos.get(i).getId());
            instrumento.setNombre(instrumentos.get(i).getNombre());
            instrumento.setMaterial(instrumentos.get(i).getMaterial());
            instrumento.setFamilia(instrumentos.get(i).getFamilia());

            HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS)
                    .body(new InstrumentoDTO(instrumento)).post();
            HttpResponse response = new Client().submit(request);

            assertEquals(response.getStatus(), HttpStatus.OK);
            assertEquals(instrumento.getId(), response.getBody().toString());
        }
    }

    @Test
    public void test02CreateInstrumentoIdNull() {
        HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS)
                .body(new InstrumentoDTO(new Instrumento(null))).post();

        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    public void test03GetInstrumentoById() {
        for(int i = 0; i < instrumentos.size(); i ++ ) {
            HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS).path(InstrumentoRestController.INSTRUMENTO_ID)
                    .param("id", instrumentos.get(i).getId()).get();
            HttpResponse response = new Client().submit(request);
            Instrumento created = (Instrumento) response.getBody();

            assertEquals(response.getStatus(), HttpStatus.OK);
            assertEquals(instrumentos.get(i).getId(), created.getId());
        }
    }

    @Test
    public void test04GetInstrumentoNotFound() {
        HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS).path(InstrumentoRestController.INSTRUMENTO_ID)
                .param("id", "4").get();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());

    }

    @Test
    public void test05PutInstrumento() {
        HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS).path(InstrumentoRestController.INSTRUMENTO_ID)
                .expandPath(instrumentos.get(1).getId()).body(new InstrumentoDTO(new Instrumento("2"))).put();
        HttpResponse response = new Client().submit(request);
        assertEquals(response.getStatus(), HttpStatus.OK);
        assertEquals(response.getBody(), "2");

    }
}
