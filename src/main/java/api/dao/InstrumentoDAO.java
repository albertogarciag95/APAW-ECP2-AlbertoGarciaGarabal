package api.dao;

import api.entities.Banda;
import api.entities.Instrumento;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InstrumentoDAO {
    private Map<String, Instrumento> map = new HashMap<>();

    public void save(Instrumento instrumento) {
        String id = instrumento.getId();
        if (id == null) {
            id = Integer.toString(new Random().nextInt());
        }
        this.map.put(id, instrumento);
        LogManager.getLogger(this.getClass()).debug("   save: " + instrumento);
    }
}
