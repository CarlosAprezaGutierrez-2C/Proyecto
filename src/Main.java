
import java.util.Scanner;

public class Main {

    public static double IVA = 0.16;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Subtotal: ");
        double total = subtotal;
        double PrecioTotal=CalcularTotal(total);

        System.out.printf("Total a pagar: %.2f%n", PrecioTotal);
    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }
    public static double CalcularTotal(Double subtotal){
        return subtotal+(subtotal*IVA);
    }
}