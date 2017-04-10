package edu.eetac.dsa;

/**
 * Created by pauli on 01/03/2017.
 */
public class Message_Exception extends Exception
{

    private  String message;
    private double a;
    private  double b;

    public Message_Exception(){
        //super("Numeros negativos");
        //this.message = message;
    }


    public void negativosMessage(double a, double b){
        if (a<b) {
            message = "Numeros Ngeativos";
            System.out.println(message);
        }
    }
    public  void  divisionMessage(double a,double b){

        if(b == 0){
            message = "InfinitoOOOOOO";
            System.out.println(message);

        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
