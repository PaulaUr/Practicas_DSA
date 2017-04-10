package upc.eetac.dsa;

/**
 * Created by pauli on 23/02/2017.
 */
public class Triangulo extends Principal implements Comparable{


    public double b;
    public double h;

    //constructor
    public Triangulo(double b, double h) {
        this.b = b;
        this.h = h;
    }

    //metodos
    public double area() {

        return b*(h/2);
    }

    public int compareTo(Object o) {

        return 0;
    }
}
