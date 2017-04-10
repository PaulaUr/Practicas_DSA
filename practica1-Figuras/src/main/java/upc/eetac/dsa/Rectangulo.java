package upc.eetac.dsa;

/**
 * Created by pauli on 22/02/2017.
 */
//extenderan de la clase abstracta
public class Rectangulo extends Principal implements Comparable{ //extends FuguraBasica


    public double l1,l2;

    public Rectangulo(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public double area() {
        return l1*l2;
    }

    public int compareTo(Object o) {
        return 0;
    }
}
