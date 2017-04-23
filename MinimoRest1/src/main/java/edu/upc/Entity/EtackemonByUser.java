package edu.upc.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauli on 19/04/2017.
 */
public class EtackemonByUser {

    private int id;
    private String nombre;
    protected List<ObjectUser> listObjectUser = new ArrayList<ObjectUser>();

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

    public List<ObjectUser> getListObjectUser() {
        return listObjectUser;
    }

    public void setListObjectUser(List<ObjectUser> listObjectUser) {
        this.listObjectUser = listObjectUser;
    }
    public void AddEtackemon( ObjectUser objectUser){
        listObjectUser.add(objectUser);
    }

}
