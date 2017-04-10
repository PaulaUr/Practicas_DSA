package Vista;

import Controlador.Funciones_User;
import Modelo.User;

import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);//se crea el constructor de Scanner con parametro entrada x consola
        Funciones_User func_user = new Funciones_User();
        String nick;
        String password;
        int id;
        Map<String, User> UserMap;
        boolean salir = true;
        while (salir) {

        System.out.println("\nChoose the options: \n1:Create User \n2:Delete User by nick \n3:List all users \n4:Search user \n5:Login \n6:Salir del menu ");
        int opcion = entrada.nextInt();
            switch (opcion)
                {
                case 1:
                    System.out.println("Write your Nick,password, email :");
                    nick = entrada.next();
                    password = entrada.next();
                    String email = entrada.next();
                    id = func_user.getCounter();
                    User u = new User(id, nick, email, password);
                    func_user.NewUser(u);
                    System.out.println("Welcome!!!  \nNick:"+nick+ "\nEmail:" +email + "\nID: " +id);
                    System.out.println("\nDo you want to create your Etakemon ? \nThen entry 1 or entry 2 if you go back to the menu");
                    int elegir = entrada.nextInt();
                    if (elegir == 1){
                        System.out.println("\nChoose the option: \n1:Create Etakemon \n2:Delete Eetakemon by ID \n3:List all Eetakemons \n4:Search the Etakemon \n5:Search by the word \n6:Salir del menu ");
                        int opcion1 = entrada.nextInt();

                        switch (opcion1){


                        }
                    }
                        break;






            }

        }
    }
}
