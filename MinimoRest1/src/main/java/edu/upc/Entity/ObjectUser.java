package edu.upc.Entity;

import edu.upc.DDBB;

/**
 * Created by pauli on 19/04/2017.
 */
public class ObjectUser extends DDBB{

    private Integer id;

    private String nombre;
    private String tipo;

    public ObjectUser() {
    }

    public ObjectUser(Integer id) {
        this.id = id;
    }

    public ObjectUser(String nombre) {
        this.nombre = nombre;
    }

    public ObjectUser(Integer id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
