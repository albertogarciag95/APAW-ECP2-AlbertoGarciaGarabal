package api.entities.builders;

import api.entities.Instrumento;
import api.entities.Musico;

public class MusicoBuilder {
    private Musico musico;

    public MusicoBuilder(Musico musico) {
        this.musico = musico;
    }

    public MusicoBuilder nombre(String nombre) {
        this.musico.setNombre(nombre);
        return this;
    }

    public MusicoBuilder edad(int edad) {
        this.musico.setEdad(edad);
        return this;
    }

    public MusicoBuilder profesional(boolean profesional) {
        this.musico.setProfesional(profesional);
        return this;
    }

    public MusicoBuilder instrumento(Instrumento instrumento) {
        this.musico.setInstrumento(instrumento);
        return this;
    }

    public Musico build() {
        return this.musico;
    }
}
