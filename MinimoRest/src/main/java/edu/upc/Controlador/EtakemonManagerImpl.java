package edu.upc.Controlador;

import edu.upc.Entity.ObjectUser;
import edu.upc.Entity.User;


import java.util.*;

/**
 * Created by pauli on 19/04/2017.
 */
public class EtakemonManagerImpl implements EtakemonManager {

   // final static org.apache.log4j.Logger  Logger = org.apache.log4j.Logger.getLogger(EtakemonManagerImpl.class);

    private static EtakemonManagerImpl instance = null;

    //variable q almacena una referencia al objeto
    private HashMap<String, User> cache;
    private List<ObjectUser> cacheEtak = new ArrayList<ObjectUser>();
    private int counter;


    private EtakemonManagerImpl(){
        //Constructor privado para solo poder instanciarlo desde aqui
        cache = new HashMap<String, User>();
     //   Logger.info("Caché de usuarios creada");

    }
    public static EtakemonManagerImpl getInstance(){
// metodo publico estatico q Se encarga de crear una instancia de la clase si no se ha creado
        if(instance==null)
            instance = new EtakemonManagerImpl();
        return instance;
    }



    public void AddUser(User user) {

        cache.put(user.getNombre(),user);
        counter++;
    }
    public int getCounter(){
        return counter;
    }

    public void ModifyUser(User userModify) {

       for (Map.Entry<String,User> entry : cache.entrySet()){
            User valor = entry.getValue();

            if(valor.getNombre().equals(userModify.getNombre())){
                cache.put(userModify.getNombre(),userModify);
            }
        }
    }

    public User InfoUser(String nombre) {
        User user= null;
        for (Map.Entry<String,User> entry: cache.entrySet()){
            if (nombre == entry.getValue().getNombre()){
                user = entry.getValue();
            }
        }
        return user;
    }

    public List<User> listUserOrdenados() {
        List<User> listUser = new ArrayList<User>(cache.values());
        List<String> listUser2 = new ArrayList<String>();

        for(int i=0;i<listUser.size();i++){
            listUser2.add(listUser.get(i).getNombre());
        }
        Collections.sort(listUser2);
        listUser.clear();
        for(int j=0; j<listUser2.size();j++){
            listUser.add(cache.get(listUser2.get(j)));
        }
        return listUser;
    }
    public void AddEtackemon(User user, ObjectUser objectUser) {
        List<ObjectUser> list = new ArrayList<ObjectUser>();
        for (Map.Entry<String,User> entry : cache.entrySet()) {
            User valor = entry.getValue();
            if (valor.getNombre().equals(user.getNombre())) {
                valor.listObjectByUser.add(objectUser);
                 list.add(objectUser);
                //cacheEtak = new ArrayList<ObjectUser>(list);
            }
        }
        for (int i=0;i<list.size();i++) {
            cacheEtak.add(list.get(i));
        }
    }
    public List<ObjectUser> AllObject() {

        return cacheEtak;
    }
    public boolean DeleteEtackemon(String nombre) {
        boolean buscar = false;
        for (int i = 0; i< cacheEtak.size(); i++){
            if(cacheEtak.get(i).getNombre().equals(nombre)){
                buscar = true;
                cacheEtak.remove(nombre);
            }
            //   Logger.info("ObjectUser Eliminado:  "+cacheEtak.get(i).getNombre());
        }
        return buscar;
    }

    @Override
    public List<ObjectUser> ListObjectByUser(String nombre) {
        List<ObjectUser> list2 = new ArrayList<ObjectUser>();
       // ObjectUser o = new ObjectUser();
        for (Map.Entry<String,User> entry : cache.entrySet()) {
            User valor = entry.getValue();
            if (valor.getNombre().equals(nombre)) {
                list2 = new ArrayList<ObjectUser>(valor.getListObject());
            }
        }
        return list2;
    }
}
