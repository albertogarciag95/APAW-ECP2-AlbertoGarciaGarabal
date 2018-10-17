package api.restControllers;

import api.businessControllers.InstrumentoBusinessController;
import api.dto.InstrumentoDTO;
import api.exceptions.ArgumentNotValidException;

public class InstrumentoRestController {
    public static final String INSTRUMENTOS = "/instrumentos";

    private InstrumentoBusinessController instrumentoBusinessController = new InstrumentoBusinessController();

    public String create(InstrumentoDTO instrumentoDTO) {
        this.validateIsNotNull(instrumentoDTO, "instrumentoDTO");
        this.validateIsNotNull(instrumentoDTO.getId(), "instrumentoId");
        return this.instrumentoBusinessController.create(instrumentoDTO);
    }

    private void validateIsNotNull(Object property, String component) {
        if (property == null) {
            throw new ArgumentNotValidException(component + " is missing");
        }
    }
}
