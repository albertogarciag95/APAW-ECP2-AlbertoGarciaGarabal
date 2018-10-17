package api.businessControllers;

import api.dao.InstrumentoDAO;
import api.dto.InstrumentoDTO;
import api.entities.Instrumento;

public class InstrumentoBusinessController {

    public InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    public String create(InstrumentoDTO instrumentoDTO) {
        Instrumento instrumento = new Instrumento(instrumentoDTO.getId()).builder().nombre(instrumentoDTO.getNombre())
                .material(instrumentoDTO.getMaterial()).familia(instrumentoDTO.getFamilia()).build();

        instrumentoDAO.save(instrumento);

        return instrumento.getId();
    }

}

