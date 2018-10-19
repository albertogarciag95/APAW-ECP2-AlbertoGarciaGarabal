package api.dao;

import api.entities.Instrumento;
import org.apache.logging.log4j.LogManager;

import java.util.*;

public class InstrumentoDAO {

    public static Map<String, Instrumento> map = new HashMap<>();

    public void save(Instrumento instrumento) {
        String id = instrumento.getId();
        if (id == null) {
            id = Integer.toString(new Random().nextInt());
        }
        map.put(id, instrumento);
        LogManager.getLogger(this.getClass()).debug("   save: " + instrumento);
    }

    public Optional<Instrumento> read(String id) {
        Instrumento entity = map.get(id);
        LogManager.getLogger(this.getClass()).debug("   read(" + id + "): " + entity);
        return Optional.ofNullable(entity);
    }

    public List<Instrumento> findAll() {
        ArrayList<Instrumento> list = new ArrayList<>(map.values());
        LogManager.getLogger(this.getClass()).debug("   findAll: " + list);
        return list;
    }

    public void deleteById(String id) {
        LogManager.getLogger(this.getClass()).debug("   deleteById(" + id + "): " + map.remove(id));
    }
}
