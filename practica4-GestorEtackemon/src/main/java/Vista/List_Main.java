package Vista;

import Controlador.FunList_Etakemon;
import Modelo.Eetakemon;

import java.util.List;
import java.util.Scanner;

/**
 * Created by pauli on 21/02/2017.
 */
public class List_Main {


    public  static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);//se crea el constructor de Scanner con parametro entrada x consola
        FunList_Etakemon funcionesEtakemon = new FunList_Etakemon();
        // String name;
        //int nivel=0;
        boolean salir = true;
        while (salir) {
            System.out.println("\nElige una opción: \n1:Añadir Eetakemon \n2:Borrar Eetakemon por ID \n3:Lista todos los Eetakemon \n4:Busca x nombre \n5:Busca x letra \n6:Salir del menu ");
            int opcion = entrada.nextInt(); //entero q elusuario introduzca


            // Eetakemon eetakemon = new Eetakemon();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe el nombre del Eetakemon, nivel:");
                    String name = entrada.next();
                    int nivel = entrada.nextInt();
                    int id= funcionesEtakemon.getCounter();
                    Eetakemon eetakemon = new Eetakemon(id,nivel, name);
                    funcionesEtakemon.AñadirEetakemon(eetakemon);
                    System.out.println("Tu Eetakemon ha sido creado: \n:Name "+name+"\n:Nivel "+nivel+ "\n:ID " +id);
                    break;
                case 2:
                    System.out.println("Escribe el ID del Eetakemon que quieres borrar: ");
                    int ident= entrada.nextInt();
                    funcionesEtakemon.borrarEetakemonID(ident);
                    System.out.println("El Eetakemon eliminado es :"+ident);
                    break;
                case 3:
                    List<Eetakemon> list = funcionesEtakemon.todos();
                    System.out.println("\nEn la lista hay los siguientes Eetakemons:");
                    for (Eetakemon l: list) {
                        System.out.println("\nName:" +l.getName()+"\nNivel:" +l.getNivel()+"\nID " +l.getId());
                    }
                    break;
                case 4:
                    System.out.println("Escribe el nombre del Eetakemon");
                    String name1 = entrada.next();
                    List<Eetakemon> list1 = funcionesEtakemon.buscarPorNombre(name1);
                    /// / Eetakemon eetakemon1 = new Eetakemon(name1);
                    //funcionesEtakemon.buscarPorNombre(name1);
                    for( Eetakemon f: list1) {
                        System.out.println("El Eetakemon que buscas es: \nName: " +f.getName() + "\nNivel: " +f.getNivel()+"\nID:" +f.getId());
                    }
                        break;
                case  5:
                    System.out.println("Escribe la letra del Eetakemon");
                    String letra = entrada.next();
                    List<Eetakemon> list2 = funcionesEtakemon.buscarPorLetra(letra);
                    System.out.println("Los Eetakemmons que coinciden con las letras introdcuidas son:");
                    for( Eetakemon f: list2) {
                        System.out.println("\nName: " +f.getName() + "\nNivel: " +f.getNivel()+"\nID:" +f.getId());
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
