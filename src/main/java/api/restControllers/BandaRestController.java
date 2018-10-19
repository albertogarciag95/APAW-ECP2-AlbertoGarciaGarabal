package api.restControllers;

import api.businessControllers.BandaBusinessController;
import api.dto.BandaDTO;
import api.exceptions.ArgumentNotValidException;

public class BandaRestController {

    public static final String BANDAS = "/bandas";

    private BandaBusinessController bandaBusinessController = new BandaBusinessController();

    public String create(BandaDTO bandaDTO) {
        this.validateIsNotNull(bandaDTO, "BandaDTO");
        this.validateIsNotNull(bandaDTO.getId(), "BandaId");
        return this.bandaBusinessController.create(bandaDTO);
    }

    private void validateIsNotNull(Object property, String component) {
        if (property == null) {
            throw new ArgumentNotValidException(component + " is missing");
        }
    }
}
