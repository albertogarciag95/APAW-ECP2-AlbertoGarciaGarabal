package api.businessControllers;

import api.dao.InstrumentoDAO;
import api.dto.InstrumentoDTO;
import api.entities.Instrumento;
import api.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class InstrumentoBusinessController {

    public InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    public String create(InstrumentoDTO instrumentoDTO) {
        Instrumento instrumento = new Instrumento(instrumentoDTO.getId()).builder().nombre(instrumentoDTO.getNombre())
                .material(instrumentoDTO.getMaterial()).familia(instrumentoDTO.getFamilia()).build();

        instrumentoDAO.save(instrumento);

        return instrumento.getId();
    }

    public Instrumento findById(String id) {
        return instrumentoDAO.read(id).orElseThrow(() -> new NotFoundException("Instrumendo with id " + id + " is not found"));
    }

    public String update(String id, InstrumentoDTO instrumentoDTO) {
        Instrumento instrumento = instrumentoDAO.read(id).orElseThrow(() -> new NotFoundException("User id: " + id));
        instrumento.setFamilia(instrumentoDTO.getFamilia());
        instrumento.setMaterial(instrumentoDTO.getMaterial());
        instrumento.setNombre(instrumentoDTO.getNombre());
        instrumentoDAO.save(instrumento);

        return instrumento.getId();
    }

    public List<InstrumentoDTO> findAll() {
        return instrumentoDAO.findAll()
                .stream().map(InstrumentoDTO::new)
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        instrumentoDAO.deleteById(id);
    }
}

