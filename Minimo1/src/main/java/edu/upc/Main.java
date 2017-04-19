package edu.upc;

import edu.upc.Controlador.EtakemonManagerImpl;
import edu.upc.Modelo.Etackemon;
import edu.upc.Modelo.User;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        org.apache.log4j.Logger  Logger = org.apache.log4j.Logger.getLogger(Main.class);

        EtakemonManagerImpl etakemonManagerImpl = EtakemonManagerImpl.getInstance();
        etakemonManagerImpl.AddUser(0,"Vidal","pass1");
        etakemonManagerImpl.AddUser(1,"Marc","pass2");

       User Marc = etakemonManagerImpl.selectUser("Marc");
        User Vidal = etakemonManagerImpl.selectUser("Vidal");
        etakemonManagerImpl.InfoUser("Vidal");

   //     etakemonManagerImpl.ModifyUser(Vidal,"nombreNew", "passNew");


        /*List<User> list = etakemonManagerImpl.listUser();
        for (User l:list ) {
            System.out.println("Id: "+l.getId()+ "\nName: "+l.getNombre());
        }*/

        Etackemon etackemon = new Etackemon();
        etackemon.setId(1);
        etackemon.setNombreEtackemon("Dog");
        etackemon.setTipo("Agua");
        etakemonManagerImpl.AddEtackemon(Vidal,etackemon );

        Etackemon e1 = new Etackemon();
        e1.setId(2);
        e1.setNombreEtackemon("Cat");
        e1.setTipo("tierra");
        etakemonManagerImpl.AddEtackemon(Marc,etackemon);


      // etakemonManagerImpl.InfoEtackemon(Vidal);
      //  Logger.info(etakemonManagerImpl.InfoEtackemon(Marc));

        List<Etackemon> list1 = etakemonManagerImpl.InfoEtackemon(Vidal);

        for (Etackemon l:list1 ) {
            Etackemon e2 = new Etackemon();
            System.out.println("\nEl User "+Vidal.getNombre() +" con Eetackemon de ID= "+l.getId()+" NOMBRE= "+l.getNombreEtackemon()+ " TIPO= "+l.getTipo());
        }
    }
}
