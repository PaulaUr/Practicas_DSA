package edu.upc.Controlador;

import edu.upc.Entity.ObjectUser;
import edu.upc.Entity.User;


import java.util.List;

/**
 * Created by pauli on 19/04/2017.
 */
public interface EtakemonManager {


//    public void AddUser(int id, String nombre, String contraseña);
    public void AddUser(User user);
    public void ModifyUser(User user);

    //public void ModifyUser(User user, String nombre, String contraseña);

    public User InfoUser(String nombre);
    public List<User> listUserOrdenados();

    //public void AddEtackemon(String nombre, ObjectUser objectUser);
    public void AddEtackemon(User user, ObjectUser objectUser);


    public boolean DeleteEtackemon(String nombre);
    public List<ObjectUser> AllObject();
    public  List<ObjectUser> ListObjectByUser(String nombre);
}
