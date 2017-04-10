package upc.eetac.dsa;

/**
 * Created by pauli on 22/02/2017.
 */
public class Circulo extends Principal implements Comparable {
    public double r;
    public double pi=3.15;

    public Circulo(double r) {
        this.r = r;
        //this.pi = pi;
    }

    //implementar el COMPARETO
    public double area() {
        return pi*(r*r);
    }

    public int compareTo(Object o) {
        return 0;
    }
}
