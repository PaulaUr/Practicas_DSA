package upc.eetac.dsa;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal implements Figura
{
    public static void main( String[] args ) throws NullPointerException {//-suma(list<Figura> figuras):double=>

        Figura[] figuras = new Figura[4];

        double suma = 0;
      //  for (Figura f : figuras) { //f esta instanciando una clase q implementa una interfaz
              // suma = suma + f.area();
              //  System.out.println(" Area de la figura: " +f + " tiene un area de " + f.area());
            double[] arraySuma = new double[4];
            Scanner entrada = new Scanner(System.in);
            Arrays.sort(arraySuma);

            for(int i=0; i<5;i++){
                //  for(Figura f:figuras){
             // while (salir){
                System.out.println("Elige la figura: \n1:Rectangulo \n2:Cuadrado \n3: Circulo \n4:Triangulo \n5:Suma de todas las areas");
                int opcion = entrada.nextInt();//se almacenara el eproximo entero(nextInt)
                    switch (opcion) {
                case 1://cuadrado
                    System.out.println("Introduce la base y la altura: ");
                    figuras[i] = new Rectangulo(entrada.nextDouble(), entrada.nextDouble());
                    System.out.println("area es: " + figuras[i].area());
                     arraySuma[i] = figuras[i].area();
                    break;
                case 2:
                    System.out.println("Introduce el lado: ");
                    figuras[i] = new Cuadrado(entrada.nextDouble(), entrada.nextDouble());
                    System.out.println("area es: " + figuras[i].area());
                    arraySuma[i] = figuras[i].area();
                    break;
                case 3:
                    System.out.println("Introduce el radio: ");
                    figuras[i] = new Circulo(entrada.nextDouble());
                    System.out.println("area es: " + figuras[i].area());
                    arraySuma[i] = figuras[i].area();
                    break;
                case 4:
                    System.out.println("Introduce la base y la altura: ");
                    figuras[i] = new Triangulo(entrada.nextDouble(), entrada.nextDouble());
                    System.out.println("area es: " + figuras[i].area());
                    arraySuma[i] = figuras[i].area();
                    break;
                case 5:
                    System.out.println("Las areas de la suma de todo es : "+suma);

                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;


            }
            //}
               // suma = suma + figuras[i].area();
              suma = suma + arraySuma[i] ;
               // Arrays.sort(figuras);

            }



    }

    //}

 /*   public double suma( Figura[] figuras){//List<Figura> list){
        double ret=0;
        for(Figura f:figuras){ //f esta instanciando una clase q implementa una interfaz

            ret = f.area();//metodo polimorfico-instancias de varias clases  que ocmparten un metodo"area"
        }return ret;
    }*/

    public double area() {

        return area();
    }

 //   public void sort(List list){
   //     Collections.sort(list); //tiene un metodo compareto que va mirando lo q tiene con lo q le va llegando
    //}

    public int compareTo(Object o) {

        Figura otraFigura = (Figura) o;
        if(this.area()<otraFigura.area()){
            return -1;
        }
        if(this.area()>otraFigura.area()){
            return 1;
        }
            return 0;

    }
}
