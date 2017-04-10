package Controlador;

import Modelo.Eetakemon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pauli on 06/03/2017.
 */
public class Funciones_Hash {


    Map<Integer,Eetakemon> hasmap = new HashMap<Integer, Eetakemon>();

    // private String[] Nombre;
    private int counter;


    public void AñadirEetakemon(Eetakemon eetakemon) {

            hasmap.put(eetakemon.getId(),eetakemon);
            counter++;


    }
    public int getCounter() {
        return counter;
    }


    public boolean borrarEetakemonID(int id) {
        boolean buscar = false;

        for (int i = 0; i < hasmap.size(); i++) {
            Eetakemon e = hasmap.get(i);

            if(hasmap.containsKey(id)) {
                buscar = true;
                hasmap.remove(id);
            }

        }

        return buscar;
    }

     public Map<Integer, Eetakemon> todos(){

        return hasmap;
    }

    public Map<Integer,Eetakemon> buscarPorNombre(String name) {
        Map<Integer,Eetakemon> datos = new HashMap<Integer,Eetakemon>();
        for (Map.Entry<Integer,Eetakemon> e: hasmap.entrySet()){
            Eetakemon valor = e.getValue();
            if(valor.getName().equals(name)) {
                datos.put(valor.getId(),valor);
            }

        }

        return datos;

    }
    public  Map<Integer,Eetakemon> buscarPorLetra(String letra){
        Map<Integer,Eetakemon> datos1 = new HashMap<Integer, Eetakemon>();
        for (Map.Entry<Integer,Eetakemon> e: hasmap.entrySet()) {
        Eetakemon valor = e.getValue();
            if(valor.getName().contains(letra)){
                datos1.put(valor.getId(),valor);
            }
        }
            return datos1;
    }
}
