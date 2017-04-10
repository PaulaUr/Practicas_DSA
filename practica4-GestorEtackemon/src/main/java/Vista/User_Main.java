package Vista;

import Controlador.FunHash_Etakemon;
import Controlador.Funciones_User;
import Modelo.Eetakemon;
import Modelo.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pauli on 09/03/2017.
 */
public class User_Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);//se crea el constructor de Scanner con parametro entrada x consola
        Funciones_User func_user = new Funciones_User();
        String nick;
        String password;
        int  id;
        Map<String, User> UserMap;


        boolean salir = true;
        while (salir) {
        System.out.println("\nChoose the options: \n1:Create User \n2:Delete User by nick \n3:List all users \n4:Find user \n5:Login \n6:Salir del menu ");
        int opcion = entrada.nextInt(); //entero q elusuario introduzca

        switch (opcion) {
            case 1:
                System.out.println("Write your Nick,password, email :");
                nick = entrada.next();
                password = entrada.next();
                String email = entrada.next();
                id = func_user.getCounter();
                User u = new User(id, nick, email, password);
                func_user.NewUser(u);
                System.out.println("Welcome!!!  \nNick:"+nick+ "\nEmail:" +email + "\nID: " +id);
                break;
            case 2:
                System.out.println("Write the nick for delete the user: ");
                nick = entrada.next();
                func_user.deleteUser(nick);
                System.out.println("The user deleted was :" + nick);
                break;
            case 3:
                UserMap = func_user.todos();
                System.out.println("\nList all users:");
                //Map.Entry = Entrada de mapa,devuelve una vista de coleccion del mapa
                for (Map.Entry<String, User> entry : UserMap.entrySet()) {
                    // entrySet => devuelve las asiganciones contenidas en este mapa
                    // Integer key= entry.getKey(); //devuelve la clave
                    User value = entry.getValue(); // devuelve el valor del objeto
                    System.out.println("\n " + value.getNick() + " with email " + value.getEmail()+" and ID "+value.getId());
                }
                break;
            case 4:
                System.out.println("Enter nick to search for user");
                String name1 = entrada.next();

                UserMap = func_user.FindUser(name1);
                for (Map.Entry<String, User> entry : UserMap.entrySet()) {
                    User value = entry.getValue(); // devuelve el valor del objeto
                    System.out.println("The user you search is: \nName: " + value.getNick() + "\nEmail: " + value.getEmail() + "\nID:" + value.getId());
                }
                break;
            case 5:
                System.out.println("Write your Nick,password :");
                nick = entrada.next();
                password = entrada.next();
               // User user = new User(nick,password);
                //func_user.Login(user);
                Map<String,User> userMap = func_user.Login(nick, password);
                for (Map.Entry<String, User> entry : userMap.entrySet()) {
                    User value = entry.getValue(); // devuelve el valor del objeto
                    System.out.println("Welcome again: \nName: " + value.getNick() + "\nEmail: " + value.getEmail() + "\nID:" + value.getId());
                }
                break;

            case 6:
                System.out.println("Hasta pronto!!");
                salir = false;
                break;

        }
        }
    }
}