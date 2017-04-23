package edu.upc.Entity;

import edu.upc.DDBB;

/**
 * Created by pauli on 19/04/2017.
 */
public class ObjectUser extends DDBB{

    private String nombre;
    private String tipo;

    public ObjectUser() {
    }

    public ObjectUser(String nombre, String tipo) {
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


}
