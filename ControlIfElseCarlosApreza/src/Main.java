import java.util.Scanner;

public class Main {
    public static int edad;
    public static  boolean esEstudiante;
    public static double pagarTotal=0.0;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ingresaEdad(sc);
        eresEstudiante(sc);

        System.out.println("la edad ingresada de la persona es de  :  " +edad);
        System.out.println("La persona es estudiante? (true/false):  " +esEstudiante);
        validarEdad(sc);

    }

    public static void ingresaEdad(Scanner sc){
        System.out.println("Ingresa tu edad");
        edad = sc.nextInt();
    }
    public static void eresEstudiante(Scanner sc){
        if (edad <= 0 || edad >= 120) {
            System.out.println("Ingresa una edad valida");
            sc.close();
        }else if (edad<12){
            System.out.println("No eres apto para un descuento");
            sc.close();
        } else {
            System.out.println("Eres estudiante?(true/false)");
            esEstudiante = sc.nextBoolean();
        }



    }
    public static void validarEdad(Scanner sc){
        if (edad <= 0 || edad > 120) {
            System.out.println("ERROR INGRESA UNA EDAD VALIDA");
            sc.close();
        }
        if (edad<12 && edad>0){
            System.out.println("El total a pagar es de 50");
        } else if (edad>=12 && edad<=17 ){
            if (esEstudiante){
                System.out.println("El total a pagar es de 60");


            }else {
                System.out.println("El total a pagar es de 80");
            }
        }
        if (edad>=18 && edad<120){
            if (esEstudiante){
                System.out.println("El total a pagar es de 90");
            }
            else {
                System.out.println("El total a pagar es de 120");
            }
        }
    }


}
