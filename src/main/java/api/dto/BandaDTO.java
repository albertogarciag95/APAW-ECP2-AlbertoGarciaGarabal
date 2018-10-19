package api.dto;

import api.entities.Banda;
import api.entities.Musico;

import java.time.LocalDateTime;
import java.util.List;

public class BandaDTO {
    private String id;
    private String nombre;
    private String direccion;
    private String email;
    private LocalDateTime fechaFundacion;
    private List<Musico> musicos;

    public BandaDTO(Banda banda) {
        this.id = banda.getId();
        this.nombre = banda.getNombre();
        this.direccion = banda.getDireccion();
        this.email = banda.getEmail();
        this.fechaFundacion = banda.getFechaFundacion();
        this.musicos = banda.getMusicos();
    }

    public List<Musico> getMusicos() {
        return musicos;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFechaFundacion() {
        return fechaFundacion;
    }
}
