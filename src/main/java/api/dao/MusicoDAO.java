package api.dao;

import api.entities.Musico;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;
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
}
