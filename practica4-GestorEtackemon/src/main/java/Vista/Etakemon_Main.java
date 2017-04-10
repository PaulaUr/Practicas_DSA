package Vista;

import Controlador.FunHash_Etakemon;
import Controlador.Funciones_Location;
import Controlador.Funciones_User;
import Modelo.Eetakemon;
import Modelo.Location;
import Modelo.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pauli on 06/03/2017.
 */
public class Etakemon_Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);//se crea el constructor de Scanner con parametro entrada x consola
        FunHash_Etakemon fun_hashEtakemon = new FunHash_Etakemon();
       // Funciones_User func_user = new Funciones_User();
        Funciones_Location func_location = new Funciones_Location();
      //  HashMap<Integer,Integer> mapGeneral = new HashMap<Integer, Integer>();

        boolean salir = true;
        while (salir) {
           /* System.out.println("\n1:Usuario o 2:Etakemon?");
            int elegir = entrada.nextInt();
            if (elegir == 2) {*/
                System.out.println("\nElige una opción: \n1:Añadir Eetakemon \n2:Borrar Eetakemon por ID \n3:Lista todos los Eetakemon \n4:Busca por nombre \n5:Busca x letra " +
                        "\n6:Añadir localizaciones \n7:Aleatorio \n8:Salir del menu ");
                int opcion = entrada.nextInt(); //entero q elusuario introduzca

                // Eetakemon eetakemon = new Eetakemon();

                switch (opcion) {
                    case 1:
                        System.out.println("Escribe el nombre del Eetakemon, nivel, ID:");
                        String name = entrada.next();
                        int nivel = entrada.nextInt();
                        int id = fun_hashEtakemon.getCounter();
                        Eetakemon eetakemon = new Eetakemon(id, nivel, name);
                        fun_hashEtakemon.AñadirEetakemon(eetakemon);
                        System.out.println("Tu Eetakemon ha sido creado: \nName: " + name + "\nNivel: " + nivel + "\nID: " + id);

                        break;
                    case 2:
                        System.out.println("Escribe el ID del Eetakemon que quieres borrar: ");
                        int ident = entrada.nextInt();
                        fun_hashEtakemon.borrarEetakemonID(ident);
                        System.out.println("El Eetakemon eliminado es :" + ident);
                        break;
                    case 3:
                        Map<Integer, Eetakemon> eetakemonMap = fun_hashEtakemon.todos();
                        System.out.println("\nEn la lista hay los siguientes Eetakemons:");
                        //Map.Entry = Entrada de mapa,devuelve una vista de coleccion del mapa
                        for (Map.Entry<Integer, Eetakemon> entry : eetakemonMap.entrySet()) {
                            // entrySet => devuelve las asiganciones contenidas en este mapa
                            // Integer key= entry.getKey(); //devuelve la clave
                            Eetakemon value = entry.getValue(); // devuelve el valor del objeto
                            System.out.println("\nName:" + value.getName() + "\nNivel:" + value.getNivel() + "\nID " + value.getId());
                        }
                        break;
                    case 4:
                        System.out.println("Escribe el nombre del Eetakemon");
                        String name1 = entrada.next();
                        Map<Integer, Eetakemon> eetakemonMap1 = fun_hashEtakemon.buscarPorNombre(name1);
                        for (Map.Entry<Integer, Eetakemon> entry : eetakemonMap1.entrySet()) {
                            Eetakemon value = entry.getValue(); // devuelve el valor del objeto
                            System.out.println("El Eetakemon que buscas es: \nName: " + value.getName() + "\nNivel: " + value.getNivel() + "\nID:" + value.getId());
                        }
                        break;
                    case 5:
                        System.out.println("Escribe la letra del Eetakemon");
                        String letra = entrada.next();
                        Map<Integer, Eetakemon> eetakemonMap2 = fun_hashEtakemon.buscarPorLetra(letra);
                        System.out.println("Los Eetakemmons que coinciden con las letras introdcuidas son:");
                        for (Map.Entry<Integer, Eetakemon> entry : eetakemonMap2.entrySet()) {
                            Eetakemon value = entry.getValue(); // devuelve el valor del objeto
                            System.out.println("\nName: " + value.getName() + "\nNivel: " + value.getNivel() + "\nID:" + value.getId());
                        }
                        break;
                    case 6:
                        System.out.println("Añade la latitud y altitud");
                        double latitud= entrada.nextDouble();
                        double longitud= entrada.nextDouble();
                        int idLocation = func_location.getCounter();
                        Location location = new Location(latitud,longitud,idLocation);
                        func_location.AddLocation(location);
                        System.out.println("Coordenadas añadidas a localizaciones! \nID "+idLocation);
                        break;
                    case 7:

                        //Eetakemon eetakemon1 = new Eetakemon();
                        func_location.LocationbyEtakemon(fun_hashEtakemon);
                        Map<Integer,Integer> aleatorio = func_location.lista();
                        for(Map.Entry<Integer,Integer> entry:aleatorio.entrySet()){
                            Integer value = entry.getValue();
                            Integer value1= entry.getKey();
                            System.out.println("ID localizacion: "+value1+ " ID Etakemon: "+value);
                        }
                        break;
                    case 8:
                        System.out.println("Hasta pronto!!");
                        salir = false;
                }
                //mapGeneral.put()

            }
            }


        }



