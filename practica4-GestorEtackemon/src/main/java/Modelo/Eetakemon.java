package Modelo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pauli on 21/02/2017.
 */
//MODELO
public class Eetakemon {

    private int id;
    private int nivel;
    private String name;
    private HashMap<Eetakemon,Location> etakemonLocation= new HashMap<Eetakemon, Location>();


    public Eetakemon(int id, int nivel, String name) {
        this.id = id;
        this.nivel = nivel;
        this.name = name;
    }

    public Eetakemon() {
    }

    public HashMap<Eetakemon, Location> getEtakemonLocation() {
        return etakemonLocation;
    }

    public void setEtakemonLocation(HashMap<Eetakemon, Location> etakemonLocation) {
        this.etakemonLocation = etakemonLocation;
    }

    public Eetakemon(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<String> getListEetakemon() {
        return listEetakemon;
    }

    public void setListEetakemon(List<String> listEetakemon) {
        this.listEetakemon = listEetakemon;
    }*/

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
