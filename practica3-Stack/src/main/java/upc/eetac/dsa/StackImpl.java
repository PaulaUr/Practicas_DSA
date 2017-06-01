package upc.eetac.dsa;

import java.util.Stack;

public class StackImpl<E> implements Pila<E>{


    private E[] elementos;
    int i;


    public void push(E o) throws PilaPlena {
//        if()
        this.elementos[this.i++]=o;
    }

    public E pop() throws PilaBuida {
        return null;
    }

    public int size() {
        return 0;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    Stack<Integer> st = new Stack<Integer>();//Integer es un objeto del entero

}
