package edu.upc.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauli on 19/04/2017.
 */
public class EtackemonByUser {

    private int id;
    private String nombre;
    protected List<Etackemon> listEtackemon = new ArrayList<Etackemon>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Etackemon> getListEtackemon() {
        return listEtackemon;
    }

    public void setListEtackemon(List<Etackemon> listEtackemon) {
        this.listEtackemon = listEtackemon;
    }
    public void AddEtackemon( Etackemon etackemon){
        listEtackemon.add(etackemon);
    }

}
