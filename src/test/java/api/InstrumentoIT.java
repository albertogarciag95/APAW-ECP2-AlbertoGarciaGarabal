package api;

import api.dto.InstrumentoDTO;
import api.entities.FamiliaInstrumento;
import api.entities.Instrumento;
import api.restControllers.InstrumentoRestController;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstrumentoIT {

    private List<Instrumento> instrumentos = new ArrayList<>();

    @BeforeEach
    public void before() {
        instrumentos.add(new Instrumento("1").builder().nombre("Trompeta").material("Laton")
                .familia(FamiliaInstrumento.VIENTO_METAL).build());
        instrumentos.add(new Instrumento("2").builder().nombre("Clarinete").material("Madera")
                .familia(FamiliaInstrumento.VIENTO_MADERA).build());
        instrumentos.add(new Instrumento("3").builder().nombre("Timbales").material("Plastico")
                .familia(FamiliaInstrumento.PERCUSION).build());
    }

    @Test
    public void testCreateInstrumento() {
        for(int i = 0; i < instrumentos.size(); i ++ ) {
            Instrumento instrumento = new Instrumento(instrumentos.get(i).getId());
            instrumento.setNombre(instrumentos.get(i).getNombre());
            instrumento.setMaterial(instrumentos.get(i).getMaterial());
            instrumento.setFamilia(instrumentos.get(i).getFamilia());

            HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS)
                    .body(new InstrumentoDTO(instrumento)).post();
            HttpResponse response = new Client().submit(request);

            assertEquals(instrumento.getId(), response.getBody().toString());
        }
    }

    @Test
    public void testGetInstrumentosById() {
        for(int i = 0; i < instrumentos.size(); i ++ ) {

            HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS + InstrumentoRestController.INSTRUMENTO_ID)
                    .body(instrumentos.get(i).getId()).get();
            HttpResponse response = new Client().submit(request);

            Instrumento created = (Instrumento) response.getBody();

            assertEquals(instrumentos.get(i).getId(), created.getId());
            assertEquals(instrumentos.get(i).getNombre(), created.getNombre());
        }
    }
}
