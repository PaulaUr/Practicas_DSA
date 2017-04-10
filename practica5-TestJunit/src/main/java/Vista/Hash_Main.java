package Vista;

import Controlador.Funciones_Hash;
import Modelo.Eetakemon;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by pauli on 06/03/2017.
 */
public class Hash_Main {

    public  static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);//se crea el constructor de Scanner con parametro entrada x consola
        Funciones_Hash funciones_hash = new Funciones_Hash();
        // String name;
        //int nivel=0;
        boolean salir = true;
        while (salir) {
            System.out.println("\nElige una opción: \n1:Añadir Eetakemon \n2:Borrar Eetakemon por ID \n3:Lista todos los Eetakemon \n4:Busca por nombre \n5:Busca x letra \n6:Salir del menu ");
            int opcion = entrada.nextInt(); //entero q elusuario introduzca


            // Eetakemon eetakemon = new Eetakemon();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe el nombre del Eetakemon, nivel, ID:");
                    String name = entrada.next();
                    int nivel = entrada.nextInt();
                    int id= funciones_hash.getCounter();
                    Eetakemon eetakemon = new Eetakemon(id,nivel, name);
                    funciones_hash.AñadirEetakemon(eetakemon);
                    System.out.println("Tu Eetakemon ha sido creado: \nName: "+name+"\nNivel: "+nivel+ "\nID: "+id);
                    break;
                case 2:
                    System.out.println("Escribe el ID del Eetakemon que quieres borrar: ");
                    int ident= entrada.nextInt();
                    funciones_hash.borrarEetakemonID(ident);
                    System.out.println("El Eetakemon eliminado es :"+ident);
                    break;
                case 3:
                    Map<Integer, Eetakemon> eetakemonMap = funciones_hash.todos();
                    System.out.println("\nEn la lista hay los siguientes Eetakemons:");
                    //Map.Entry = Entrada de mapa,devuelve una vista de coleccion del mapa
                    for (Map.Entry<Integer, Eetakemon> entry: eetakemonMap.entrySet()) {
                        // entrySet => devuelve las asiganciones contenidas en este mapa
                       // Integer key= entry.getKey(); //devuelve la clave
                        Eetakemon value= entry.getValue(); // devuelve el valor del objeto
                        System.out.println("\nName:" +value.getName()+"\nNivel:" +value.getNivel()+"\nID " +value.getId());
                    }
                    break;
                case 4:
                    System.out.println("Escribe el nombre del Eetakemon");
                    String name1 = entrada.next();

                    Map<Integer, Eetakemon> eetakemonMap1 = funciones_hash.buscarPorNombre(name1);
                    for( Map.Entry<Integer, Eetakemon> entry: eetakemonMap1.entrySet()) {
                        Eetakemon value= entry.getValue(); // devuelve el valor del objeto
                        System.out.println("El Eetakemon que buscas es: \nName: " +value.getName() + "\nNivel: " +value.getNivel()+"\nID:" +value.getId());
                    }
                    break;
                case  5:
                    System.out.println("Escribe la letra del Eetakemon");
                    String letra = entrada.next();
                    Map<Integer, Eetakemon> eetakemonMap2 = funciones_hash.buscarPorLetra(letra);
                    System.out.println("Los Eetakemmons que coinciden con las letras introdcuidas son:");
                    for( Map.Entry<Integer, Eetakemon> entry: eetakemonMap2.entrySet()) {
                        Eetakemon value= entry.getValue(); // devuelve el valor del objeto
                        System.out.println("\nName: " +value.getName() + "\nNivel: " +value.getNivel()+"\nID:" +value.getId());
                    }
                    break;
                case 6:
                    System.out.println("Hasta pronto!!");
                    salir=false;
            }
//            list.add(eetakemon);


        }
    }
}

