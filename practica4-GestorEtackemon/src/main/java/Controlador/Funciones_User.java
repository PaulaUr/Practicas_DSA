package Controlador;

import Modelo.Eetakemon;
import Modelo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pauli on 09/03/2017.
 */
public class Funciones_User {

    Map<String, User> hasmap = new HashMap<String, User>();

    // private String[] Nombre;
    private int counter;


    public void NewUser(User user) {

        hasmap.put(user.getNick(), user);
        counter++;
    }
    public int getCounter() {
        return counter;
    }

    public Map<String, User> Login(String nick, String password){

        Map<String, User> datos = new HashMap<String,User>();
        for (Map.Entry<String,User> e: hasmap.entrySet()){
            User valor = e.getValue();
            if(valor.getNick().equals(nick) && valor.getPassword().equals(password)) {
                datos.put(valor.getNick(),valor);
            }
        }
        return datos;
    }

    public boolean deleteUser(String nick) {
        boolean buscar = false;

        for (int i = 0; i < hasmap.size(); i++) {
            User u = hasmap.get(i);

            if(hasmap.containsKey(nick)) {
                buscar = true;
                hasmap.remove(nick);
            }
        }
        return buscar;
    }
    public Map<String, User> todos(){

        return hasmap;
    }

    public Map<String, User> FindUser(String nick) {
        Map<String, User> datos = new HashMap<String,User>();
        for (Map.Entry<String,User> e: hasmap.entrySet()){
            User valor = e.getValue();
            if(valor.getNick().equals(nick)) {
                datos.put(valor.getNick(),valor);
            }
        }
        return datos;

    }


}
