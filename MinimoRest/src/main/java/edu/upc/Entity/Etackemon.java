package edu.upc.Entity;

/**
 * Created by pauli on 19/04/2017.
 */
public class Etackemon {

    private String nombre;
    private String tipo;
    private int id;

    public Etackemon() {
    }

    public Etackemon(int id, String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }
}
