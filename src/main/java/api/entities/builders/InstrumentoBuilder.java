package api.entities.builders;

import api.entities.FamiliaInstrumento;
import api.entities.Instrumento;

public class InstrumentoBuilder {
    private Instrumento instrumento;

    public InstrumentoBuilder(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public InstrumentoBuilder nombre(String nombre) {
        this.instrumento.setNombre(nombre);
        return this;
    }

    public InstrumentoBuilder id(String id) {
        this.instrumento.setId(id);
        return this;
    }

    public InstrumentoBuilder material(String material) {
        this.instrumento.setMaterial(material);
        return this;
    }

    public InstrumentoBuilder familia(FamiliaInstrumento familiaInstrumento) {
        this.instrumento.setFamilia(familiaInstrumento);
        return this;
    }

    public Instrumento build() {
        return this.instrumento;
    }
}
