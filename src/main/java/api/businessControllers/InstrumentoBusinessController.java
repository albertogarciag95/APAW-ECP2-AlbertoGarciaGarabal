package api.businessControllers;

import api.dao.InstrumentoDAO;
import api.dto.InstrumentoDTO;
import api.entities.Instrumento;
import api.exceptions.NotFoundException;

public class InstrumentoBusinessController {

    public InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    public String create(InstrumentoDTO instrumentoDTO) {
        Instrumento instrumento = new Instrumento(instrumentoDTO.getId()).builder().nombre(instrumentoDTO.getNombre())
                .material(instrumentoDTO.getMaterial()).familia(instrumentoDTO.getFamilia()).build();

        instrumentoDAO.save(instrumento);

        return instrumento.getId();
    }

    public Instrumento findById(String id) {
        return instrumentoDAO.read(id).orElseThrow(() -> new NotFoundException("Musico with id " + id + " is not found"));
    }
}

