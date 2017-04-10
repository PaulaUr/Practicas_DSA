package Controlador;

import Modelo.Eetakemon;
import Modelo.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pauli on 11/03/2017.
 */
public class Funciones_Location {

    Map<Integer, Location> mapLocation = new HashMap<Integer, Location>();
    Map<Integer, Integer> locaEtakemon = new HashMap<Integer, Integer>();
  //  FunHash_Etakemon funHash_etakemon= new FunHash_Etakemon();

    private int counter;


    public  void AddLocation(Location location){
        mapLocation.put(location.getIdLocation(),location);

        counter++;
    }
    public int getCounter(){

        return counter;
    }
    public void  LocationbyEtakemon(FunHash_Etakemon funHash_etakemon){
        Location location = new Location();


        for(int i=0; i<mapLocation.size();i++) {
           // Eetakemon idEtako = funHash_etakemon.hasmap.get(i);
            int idEtak = funHash_etakemon.hasmap.get(i);
            int aleatorio = (int) (Math.random() * idEtak);
            int aleatorio1= (int) (Math.random() * location.getIdLocation());
            locaEtakemon.put(aleatorio,aleatorio1 );
        }
    }

    public  Map<Integer,Integer> lista(){

        return locaEtakemon;
    }




}
