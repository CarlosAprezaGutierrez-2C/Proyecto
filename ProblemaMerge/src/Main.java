
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            final double IVA=0.16;
            double subtotal = pedirDouble(scanner, "Subtotal: ");
            double calcularTotal = subtotal+(subtotal*IVA);

            System.out.printf("Total a pagar: %.2f%n", calcularTotal);
        }

        public static double pedirDouble(Scanner scanner, String mensaje) {
            System.out.print(mensaje);
            return scanner.nextDouble();
        }
    }


