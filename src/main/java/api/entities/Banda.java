package api.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Banda {
    private String id;
    private String nombre;
    private String direccion;
    private String email;
    private LocalDateTime fechaFundacion;
    private List<Musico> musicos;

    public Banda(String id) {
        this.id = id;
    }
}