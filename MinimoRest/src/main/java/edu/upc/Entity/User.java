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
    public List<ObjectUser> listObjectByUser = new ArrayList<ObjectUser>() ;

    public User() {
    }

    public User(String nombre) {
        this.nombre = nombre;
    }

    public List<ObjectUser> getListObject() {

        return listObjectByUser;
    }

    public void setListObjectByUser(List<ObjectUser> listObjectByUser) {

        this.listObjectByUser = listObjectByUser;
    }


    public User(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.listObjectByUser = new ArrayList<ObjectUser>();
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



    // public void AddEtackemon( ObjectUser objectUser){
   //     listObjectByUser.add(objectUser);
    //}

}
