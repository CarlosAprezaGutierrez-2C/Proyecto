import java.util.Scanner;

public class Main{

    public static int Opcion;
    public static double suma = 0.0;
    public static double promedio;

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Ingresa cuantos numeros quieres sumar: ");
        Opcion = leer.nextInt();

        suma = PedirEntero(leer);
        promedio = Promedio();

        System.out.println("La Suma de los numeros es: " + suma);
        System.out.println("El Promedio es: " + promedio);

        leer.close();
    }

    public static double PedirEntero(Scanner leer) {
        suma = 0.0;

        for (int i = 1; i <= Opcion; i++) {
            System.out.println("Ingresa el numero " + i + ":");
            suma += leer.nextDouble();
        }
        return suma;
    }

    public static double Promedio() {
        return suma / Opcion;
    }
}
