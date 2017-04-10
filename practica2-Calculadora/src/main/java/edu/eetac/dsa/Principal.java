package edu.eetac.dsa;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Principal

{
    public static void main(String[] args) {


        //Scanner entrada = new Scanner(System.in);

        double a=0;
        double b=0;
        Calculadora calculadora = new Calculadora(a,b);
        //calculadora.suma(4,2);
        System.out.println(" "+calculadora.suma(4,2));
        System.out.println(" "+calculadora.resta(10,2));
        System.out.println(" "+calculadora.producto(7,9));
        System.out.println(" "+calculadora.division(22,2));

        }
        /*
        boolean salir= true;
        while(salir) {

            System.out.println("Elige la operación: \n1:Suma \n2:Resta \n3:Producto \n4:Division \n5:Salir");
            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1://cuadrado
                    System.out.println("Introduce valor de a y b: ");
                    a = entrada.nextDouble();
                    b = entrada.nextDouble();
                    Calculadora calculadora = new Calculadora(a, b);
                    System.out.println(calculadora.suma());
                    break;
                case 2:
                    System.out.println("Introduce valor de a y b:");
                    a = entrada.nextDouble();
                    b = entrada.nextDouble();
                    Calculadora calculadora1 = new Calculadora(a, b);
                    System.out.println(calculadora1.resta());

                    break;
                case 3:
                    System.out.println("Introduce valor de a y b:");
                    a = entrada.nextDouble();
                    b = entrada.nextDouble();
                    Calculadora calculadora2 = new Calculadora(a, b);
                    System.out.println(calculadora2.multiplicar());

                    break;
                case 4:
                    System.out.println("Introduce valor de a y b:");
                    a = entrada.nextDouble();
                    b = entrada.nextDouble();
                    Calculadora calculadora3 = new Calculadora(a, b);
                    System.out.println(calculadora3.dividir());
                    break;
                case 5:
                    salir= false;
            }
        }*/
    }

