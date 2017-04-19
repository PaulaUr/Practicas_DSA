package edu.upc.Controlador;

import edu.upc.Modelo.Etackemon;
import edu.upc.Modelo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pauli on 19/04/2017.
 */
public class EtakemonManagerImpl implements EtakemonManager {

    final static org.apache.log4j.Logger  Logger = org.apache.log4j.Logger.getLogger(EtakemonManagerImpl.class);


    private static EtakemonManagerImpl instance = null;
    //variable q almacena una referencia al objeto
    private HashMap<String, User> cache;
    private List<Etackemon> etackemonList;

    private int counter;

    private EtakemonManagerImpl(){
        //Constructor privado para solo poder instanciarlo desde aqui
        cache = new HashMap<String, User>();
        Logger.info("Caché de usuarios creada");

    }
    public static EtakemonManagerImpl getInstance(){
// metodo publico estatico q Se encarga de crear una instancia de la clase si no se ha creado
        if(instance==null)
            instance = new EtakemonManagerImpl();
        return instance;
    }



    public void AddUser(int id,String nombre, String contraseña) {
        User user = new User();
        user.setId(id);
        user.setNombre(nombre);
        user.setContraseña(contraseña);
        cache.put(user.getNombre(),user);
        counter++;
        Logger.info("Añadido usuario: " + nombre + " y contraseña: " + contraseña);

    }
    public int getCounter(){
        return counter;
    }

    public void ModifyUser(User userModify, String nombre, String contraseña) {
       /* for (Map.Entry<String,User> entry : cache.entrySet()){
            User valor = entry.getValue();

            if(valor.getNombre().equals(nombre)){
                userModify.setNombre(nombre);
                userModify.setContraseña(contraseña);
                cache.put(userModify.getNombre(),userModify);
                User user = cache.get(entry.getKey());
                user.getNombre();
            }
        }*/
       userModify.setNombre(nombre);
        userModify.setContraseña(contraseña);
        cache.put(userModify.getNombre(),userModify);
        Logger.info("El Usuario modificado: Name= "+userModify.getNombre()+ " Contraseña= " +userModify.getContraseña());

    }

    public User selectUser(String nombre) {
        User selectUser = cache.get(nombre);

        Logger.info("selectUser: "+selectUser.getNombre());

        return selectUser;
    }

    public User InfoUser(String nombre) {
        User user= null;
        for (Map.Entry<String,User> entry: cache.entrySet()){
            if (nombre == entry.getValue().getNombre()){
                user = entry.getValue();
            }
        }
        Logger.info("Info Usuario: ID= "+user.getId()+ " Name= "+user.getNombre());

        return user;
    }

    public List<User> listUser() {
        List<User> listUser = new ArrayList<User>(cache.values());

        return listUser;
    }

    /*public void AddEtackemon(String nombre, Etackemon etackemon) {
        for (Map.Entry<String,User> entry : cache.entrySet()) {
        if (nombre == cache.getNombre()) {
                User us = cache.get(entry.getKey());
                us.AddEtackemon(etackemon);
                cache.put(entry.getKey(),us);
            }
            Logger.info("Etackemon Añadido:  "+etackemon.getNombreEtackemon()+ "\n del User= "+nombre);

        }
    }*/

    public void AddEtackemon(User user, Etackemon etackemon) {
        user.listEtackemon.add(etackemon);
    }

    public boolean DeleteEtackemon(String nombre) {
        boolean buscar = false;
        for (int i=0; i<etackemonList.size();i++){
            if(etackemonList.get(i).getNombreEtackemon().equals(nombre)){
                buscar = true;
                etackemonList.remove(nombre);
            }
            Logger.info("Etackemon Eliminado:  "+etackemonList.get(i).getNombreEtackemon());
        }
        return buscar;
    }

 /*   public List<Etackemon> InfoEtackemon(String name) {
        List<Etackemon> datos = new ArrayList<Etackemon>();

        for (int i = 0; i < etackemonList.size(); i++) {
            Etackemon eetakemon = etackemonList.get(i);

            if (eetakemon.getNombreEtackemon().equals(name)) {
                datos.add(eetakemon);
            }
        }
        return datos;
    }*/

    public List<Etackemon> InfoEtackemon(User user) {
        List<Etackemon> etackemons = user.getListEtackemon();

        return etackemons;
    }
}
