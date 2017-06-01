package edu.upc.Entity;

/**
 * Created by pauli on 31/05/2017.
 */
public class Login {
    private String nombre;
    private String contraseña;

    public Login() {
    }

    public Login(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
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
