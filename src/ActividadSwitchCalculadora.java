import java.util.Scanner;

public class ActividadSwitchCalculadora {

    // Variables globales
    public static double a, b;
    public static String Opcion;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos
        PedirNumeros(sc);
        PedirOpciones(sc);

        // Resolver operación
        double resultado = SwitchOpciones(sc);

        // Mostrar resultados
        System.out.println("La opcion que eligiste fue: " + Opcion);
        System.out.println("El resultado de la operacion es: " + resultado);
        System.out.println("Los numeros ingresados fueron: a = " + a + " y b = " + b);

        sc.close();
    }

    // Metodo para pedir los numeros
    public static void PedirNumeros(Scanner leer) {
        System.out.println("Ingrese el numero a:");
        a = leer.nextDouble();

        System.out.println("Ingrese el numero b:");
        b = leer.nextDouble();

        leer.nextLine();
    }

    // Metodo para que el usuario pueda pedir opciones
    public static String PedirOpciones(Scanner leer) {
        System.out.println("Ingresa una opcion");
        System.out.println("Sumar");
        System.out.println("Restar");
        System.out.println("Multiplicar");
        System.out.println("Dividir");
        System.out.println("Salir");

        Opcion = leer.nextLine().trim().toLowerCase();
        return Opcion;
    }

    // Metodos para las operaciones
    public static double sumar() {
        return a + b;
    }

    public static double restar() {
        return a - b;
    }

    public static double multiplicar() {
        return a * b;
    }

    public static double dividir() {
        if (b == 0.0) {
            System.out.println("No se puede dividir por cero");
            return 0;
        }
        return a / b;
    }

    // Metodo para el switch
    public static double SwitchOpciones(Scanner leer) {
        switch (Opcion) {
            case "sumar":
                return sumar();

            case "restar":
                return restar();

            case "multiplicar":
                return multiplicar();

            case "dividir":
                return dividir();

            case "salir":
                System.out.println("Saliendo...");
                return 0;

            default:
                System.out.println("Opcion no valida");
                return 0;
        }
    }
}
