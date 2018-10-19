package api.businessControllers;

import api.dao.BandaDAO;
import api.dao.MusicoDAO;
import api.dto.BandaDTO;
import api.entities.Banda;
import api.entities.Musico;
import api.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BandaBusinessController {

    private BandaDAO bandaDAO = new BandaDAO();

    private MusicoDAO musicoDAO = new MusicoDAO();

    public String create(BandaDTO bandaDTO) {
        List<Musico> musicos = new ArrayList<>();
        if(bandaDTO.getMusicos() != null) {
            if(bandaDTO.getMusicos() != null) {
                for (Musico musicoDTO : bandaDTO.getMusicos()) {
                    Musico musico = musicoDAO.read(musicoDTO.getId())
                            .orElseThrow(() -> new NotFoundException("Musico with id " + musicoDTO.getId() + " is not found"));
                    musicos.add(musico);
                }
            }
        }
        Banda banda = new Banda(bandaDTO.getId()).builder().nombre(bandaDTO.getNombre()).direccion(bandaDTO.getDireccion())
                .email(bandaDTO.getEmail()).fechaFundacion(bandaDTO.getFechaFundacion()).musicos(musicos).build();

        bandaDAO.save(banda);
        return banda.getId();
    }

}
