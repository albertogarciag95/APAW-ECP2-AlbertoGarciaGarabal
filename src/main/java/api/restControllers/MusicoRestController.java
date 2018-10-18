package api.restControllers;

import api.businessControllers.MusicoBusinessController;
import api.dto.MusicoDTO;
import api.exceptions.ArgumentNotValidException;

import javax.swing.text.StringContent;

public class MusicoRestController {

    public static final String MUSICOS = "/musicos";

    private MusicoBusinessController musicoBusinessController = new MusicoBusinessController();

    public String create(MusicoDTO musicoDTO) {
        this.validateIsNotNull(musicoDTO, "musicoDTO");
        this.validateIsNotNull(musicoDTO.getId(), "musicoDTO");
        return this.musicoBusinessController.create(musicoDTO);
    }

    private void validateIsNotNull(Object property, String component) {
        if (property == null) {
            throw new ArgumentNotValidException(component + " is missing");
        }
    }

}
