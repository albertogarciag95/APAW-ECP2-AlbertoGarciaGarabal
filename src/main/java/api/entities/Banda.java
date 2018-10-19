package api.entities;

import api.entities.builders.BandaBuilder;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;   }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDateTime fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public List<Musico> getMusicos() {
        return musicos;
    }

    public void setMusicos(List<Musico> musicos) {
        this.musicos = musicos;
    }

    public BandaBuilder builder() {
        return new BandaBuilder(this);
    }
}
