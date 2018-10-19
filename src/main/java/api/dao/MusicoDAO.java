package api.dao;

import api.entities.Musico;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class MusicoDAO {

    private static Map<String, Musico> map = new HashMap<>();

    private InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    public void save(Musico musico) {
        String id = musico.getId();
        if (id == null) {
            id = Integer.toString(new Random().nextInt());
        }
        this.map.put(id, musico);
        LogManager.getLogger(this.getClass()).debug("   save: " + musico);
    }

    public Optional<Musico> read(String id) {
        if(id == null) {
            id = String.valueOf(new Random().nextInt());
        }
        Musico musico = map.get(id);
        LogManager.getLogger(this.getClass()).debug("   read(" + id + "): " + musico);
        return Optional.ofNullable(musico);
    }
}
