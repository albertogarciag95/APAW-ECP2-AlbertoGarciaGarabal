package api.dto;

import api.entities.Instrumento;
import api.entities.Musico;

public class MusicoDTO {
    private String id;
    private String nombre;
    private int edad;
    private boolean profesional;
    private Instrumento instrumento;

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

    public int getEdad() {
        return edad;
    }

    public boolean isProfesional() {
        return profesional;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public MusicoDTO(Musico musico) {
        this.id = musico.getId();
        this.nombre = musico.getNombre();
        this.edad = musico.getEdad();
        this.profesional = musico.isProfesional();
        this.instrumento = musico.getInstrumento();
    }
}
