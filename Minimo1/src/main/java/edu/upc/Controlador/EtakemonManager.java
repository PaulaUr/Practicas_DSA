package edu.upc.Controlador;

import edu.upc.Modelo.Etackemon;
import edu.upc.Modelo.User;

import java.util.List;

/**
 * Created by pauli on 19/04/2017.
 */
public interface EtakemonManager {


    public void AddUser(int id,String nombre, String contraseña);
    public void ModifyUser(User user,String nombre, String contraseña);

    public User InfoUser(String nombre);
    public User selectUser(String nombre);
    public List<User> listUser();

    //public void AddEtackemon(String nombre, Etackemon etackemon);
    public void AddEtackemon(User user, Etackemon etackemon);


    public boolean DeleteEtackemon(String nombre);
    //public List<Etackemon> InfoEtackemon(String nombre);
    public List<Etackemon> InfoEtackemon(User user);
}
