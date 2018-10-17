package api.entities;

public class Musico  {
    private String id;
    private String nombre;
    private int edad;
    private boolean profesional;
    private Instrumento instrumento;

    public Musico(String id) {
        this.id = id;
    }
}
