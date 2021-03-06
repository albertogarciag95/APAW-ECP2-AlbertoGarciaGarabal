package api.restControllers;

import api.businessControllers.MusicoBusinessController;
import api.dto.MusicoDTO;
import api.entities.Instrumento;
import api.exceptions.ArgumentNotValidException;

public class MusicoRestController {

    public static final String MUSICOS = "/musicos";

    private MusicoBusinessController musicoBusinessController = new MusicoBusinessController();

    public String create(MusicoDTO musicoDTO) {
        this.validateIsNotNull(musicoDTO, "musicoDTO");
        this.validateIsNotNull(musicoDTO.getId(), "musicoDTO");
        this.validateInstrumento(musicoDTO.getInstrumento());
        return this.musicoBusinessController.create(musicoDTO);
    }

    private void validateIsNotNull(Object property, String component) {
        if (property == null) {
            throw new ArgumentNotValidException(component + " is missing");
        }
    }

    private void validateInstrumento(Instrumento instrumento) {
        if(instrumento == null || instrumento.getId() == null || instrumento.getId().isEmpty()) {
            throw new ArgumentNotValidException("Instrumento del musico is missing");
        }
    }

}
