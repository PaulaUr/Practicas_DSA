package edu.upc.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauli on 19/04/2017.
 */
public class User {
    private int id;
    private String nombre;
    private String contraseña;
    public List<Etackemon> listEtackemon = new ArrayList<Etackemon>();

    public User() {
    }
    public User(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    public User(int id, String nombre, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }



    public List<Etackemon> getListEtackemon() {
        return listEtackemon;
    }

    public void setListEtackemon(List<Etackemon> listEtackemon) {
        this.listEtackemon = listEtackemon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void AddEtackemon( Etackemon etackemon){
        listEtackemon.add(etackemon);
    }
}
