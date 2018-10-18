package api.entities;

import api.entities.builders.InstrumentoBuilder;

public class Instrumento {
    private String id;
    private String nombre;
    private String material;
    private FamiliaInstrumento familia;

    public Instrumento(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMaterial() {
        return material;
    }

    public FamiliaInstrumento getFamilia() {
        return familia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setFamilia(FamiliaInstrumento familiaInstrumento) {
        this.familia = familiaInstrumento;
    }

    public InstrumentoBuilder builder() {
        return new InstrumentoBuilder(this);
    }
}
