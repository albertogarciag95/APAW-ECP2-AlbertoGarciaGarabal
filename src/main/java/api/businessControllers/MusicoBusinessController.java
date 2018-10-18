package api.businessControllers;

import api.dao.InstrumentoDAO;
import api.dao.MusicoDAO;
import api.dto.MusicoDTO;
import api.entities.Instrumento;
import api.entities.Musico;
import api.exceptions.NotFoundException;


public class MusicoBusinessController {

    public MusicoDAO musicoDAO = new MusicoDAO();

    public InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    public String create(MusicoDTO musicoDTO) {

        if(musicoDTO.getInstrumento() != null) {
            Instrumento instrumento = instrumentoDAO.read(musicoDTO.getInstrumento().getId())
                    .orElseThrow(() -> new NotFoundException("Musico with id " + musicoDTO.getId() + " is not found"));
        }

        Musico musico = new Musico(musicoDTO.getId()).builder().nombre(musicoDTO.getNombre())
                .edad(musicoDTO.getEdad()).profesional(musicoDTO.isProfesional()).instrumento(musicoDTO.getInstrumento()).build();

        musicoDAO.save(musico);

        return musico.getId();
    }
}
