package api;

import api.dto.InstrumentoDTO;
import api.dto.MusicoDTO;
import api.entities.FamiliaInstrumento;
import api.entities.Instrumento;
import api.entities.Musico;
import api.restControllers.InstrumentoRestController;
import api.restControllers.MusicoRestController;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicoIT {

    private List<Musico> musicos = new ArrayList<>();

    @Before
    public void before() {
        musicos.add(new Musico("1").builder().nombre("Alberto Garcia Garabal").edad(23)
                .profesional(false).instrumento(new Instrumento("1")).build());
        musicos.add(new Musico("2").builder().nombre("Louis Armstrong").edad(70)
                .profesional(true).instrumento(new Instrumento("2")).build());
        musicos.add(new Musico("3").builder().nombre("Dennis Brain").edad(36)
                .profesional(true).instrumento(new Instrumento("3")).build());
    }

    @Test
    public void test01CreateInstrumento() {
        for(int i = 0; i < musicos.size(); i ++ ) {
            Musico musico = new Musico(musicos.get(i).getId());
            musico.setNombre(musicos.get(i).getNombre());
            musico.setProfesional(musicos.get(i).isProfesional());
            musico.setEdad(musicos.get(i).getEdad());

            HttpRequest request = HttpRequest.builder(MusicoRestController.MUSICOS)
                    .body(new MusicoDTO(musico)).post();
            HttpResponse response = new Client().submit(request);

            assertEquals(response.getStatus(), HttpStatus.OK);
            assertEquals(musico.getId(), response.getBody().toString());
        }
    }
}
