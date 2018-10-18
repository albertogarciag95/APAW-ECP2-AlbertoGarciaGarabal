package api.entities;

public class Partitura {
    private String id;
    private String titulo;
    private String compas;

    public Partitura(String id, String titulo) {
        this.titulo = titulo;
        this.id = id;
    }

}