package api;

import api.dto.InstrumentoDTO;
import api.entities.FamiliaInstrumento;
import api.entities.Instrumento;
import api.restControllers.InstrumentoRestController;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstrumentoIT {

    @Test
    public void createInstrumento() {
        Instrumento instrumento = new Instrumento("1234");
        instrumento.setNombre("Trompeta");
        instrumento.setMaterial("Metal");
        instrumento.setFamilia(FamiliaInstrumento.VIENTO_METAL);

        HttpRequest request = HttpRequest.builder(InstrumentoRestController.INSTRUMENTOS)
                .body(new InstrumentoDTO(instrumento)).post();
        HttpResponse response = new Client().submit(request);

        assertEquals(instrumento.getId(), response.getBody().toString());
    }
}
