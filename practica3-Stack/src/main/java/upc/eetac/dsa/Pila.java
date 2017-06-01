package upc.eetac.dsa;

import java.util.ArrayList;
import java.util.Stack;


public interface Pila<E> {




    public void push(E e) throws PilaPlena;
    public E pop() throws PilaBuida;
    public int size();

    //push(E e); lanzar otra ecepcion cunado la pila etse llena(throws Full)
    //pop():E lanzar una excepción cuando la pila esta vacia
    //size():int



}
