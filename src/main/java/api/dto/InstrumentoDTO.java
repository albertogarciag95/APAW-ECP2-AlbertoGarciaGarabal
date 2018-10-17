package api.dto;

import api.entities.FamiliaInstrumento;
import api.entities.Instrumento;

public class InstrumentoDTO {
    private String id;
    private String nombre;
    private String material;
    private FamiliaInstrumento familia;

    public InstrumentoDTO(Instrumento instrumento) {
        this.id = instrumento.getId();
        this.nombre = instrumento.getNombre();
        this.material = instrumento.getMaterial();
        this.familia = instrumento.getFamilia();
    }

    public String getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public String getNombre() {
        return nombre;
    }

    public FamiliaInstrumento getFamilia() {
        return familia;
    }
}
