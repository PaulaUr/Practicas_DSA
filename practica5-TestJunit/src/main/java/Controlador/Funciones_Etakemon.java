package Controlador;// OpERACIÓN & Lista


import Modelo.Eetakemon;

import java.util.ArrayList;
import java.util.List;

public class Funciones_Etakemon {


    ArrayList<Eetakemon> listEetakemon = new ArrayList<Eetakemon>();
    private int counter;


    public void AñadirEetakemon(Eetakemon eetakemon) {

        listEetakemon.add(eetakemon);
        counter++;
    }

    public boolean borrarEetakemonID(int id) {
        boolean buscar = false;

        for (int i = 0; i < listEetakemon.size(); i++) {

            if (listEetakemon.get(i).getId() == id) {
                buscar = true;
                listEetakemon.remove(id);
            }

        }
        return buscar;
    }

    public int getCounter() {
        return counter;
    }


    public List<Eetakemon> todos() {

        return listEetakemon;
    }

    public List<Eetakemon> buscarPorNombre(String name) {
        List<Eetakemon> datos = new ArrayList<Eetakemon>();

        for (int i = 0; i < listEetakemon.size(); i++) {
            Eetakemon eetakemon = listEetakemon.get(i);

            if (eetakemon.getName().equals(name)) {
                datos.add(eetakemon);
            }
        }
        return datos;

    }
    public List<Eetakemon> buscarPorLetra(String letra){
        List<Eetakemon> datos = new ArrayList<Eetakemon>();

        for (Eetakemon e: listEetakemon) {
            if (e.getName().contains(letra)){
            datos.add(e);
            }
        }

    /* Map<Integer,Eetakemon> buscarPorLetra(String letra){

        Map<Integer,Eetakemon> datos1 = new HashMap<Integer, Eetakemon>();
        for (Map.Entry<Integer,Eetakemon> e: hasmap.entrySet()) {
            Eetakemon valor = e.getValue();
            if(valor.getName().contains(letra)){
                datos1.put(valor.getId(),valor);
            }
        }*/
        return datos;
    }
}