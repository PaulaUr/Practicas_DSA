package edu.upc.Entity;

import edu.upc.DDBB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauli on 19/04/2017.
 */
public class User extends DDBB{
    private int id;
    private String nombre;
    private String contraseña;
  //  public List<ObjectUser> listObjectByUser = new ArrayList<ObjectUser>() ;



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
      // this.listObjectByUser = new ArrayList<ObjectUser>();
    }



  /*  public List<ObjectUser> getListObject() {
        return listObjectByUser;
    }

    public void setListObjectByUser(List<ObjectUser> listObjectByUser) {
        this.listObjectByUser = listObjectByUser;
    }
*/
    public String getId() {
        return String.valueOf(id);
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

}
