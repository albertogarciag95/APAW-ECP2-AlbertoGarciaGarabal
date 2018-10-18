package api.restControllers;

import api.businessControllers.InstrumentoBusinessController;
import api.dto.InstrumentoDTO;
import api.entities.Instrumento;
import api.exceptions.ArgumentNotValidException;

public class InstrumentoRestController {
    public static final String INSTRUMENTOS = "/instrumentos";

    public static final String INSTRUMENTO_ID = "/{id}";

    private InstrumentoBusinessController instrumentoBusinessController = new InstrumentoBusinessController();

    public String create(InstrumentoDTO instrumentoDTO) {
        this.validateIsNotNull(instrumentoDTO, "instrumentoDTO");
        this.validateIsNotNull(instrumentoDTO.getId(), "instrumentoId");
        return this.instrumentoBusinessController.create(instrumentoDTO);
    }

    public Instrumento findById(String id) {
        this.validateIsNotNull(id, "Id of instrumento");
        return this.instrumentoBusinessController.findById(id);
    }

    private void validateIsNotNull(Object property, String component) {
        if (property == null) {
            throw new ArgumentNotValidException(component + " is missing");
        }
    }


}
