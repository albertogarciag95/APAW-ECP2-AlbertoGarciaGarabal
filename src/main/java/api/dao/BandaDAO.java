package api.dao;

import api.entities.Banda;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public class BandaDAO {

    private static Map<String, Banda> map = new HashMap<>();

    public void save(Banda banda) {
        String id = banda.getId();
        map.put(id, banda);
        LogManager.getLogger(this.getClass()).debug("   save: " + banda);
    }

}
