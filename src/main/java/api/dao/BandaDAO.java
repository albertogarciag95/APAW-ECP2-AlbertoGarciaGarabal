package api.dao;

import api.entities.Banda;
import api.entities.Musico;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public class BandaDAO {

    private Map<String, Banda> map = new HashMap<>();

    public void save(Banda banda) {
        String id = banda.getId();
        this.map.put(id, banda);
        LogManager.getLogger(this.getClass()).debug("   save: " + banda);
    }

}
