
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            final double DESCUENTO = 0.10;
            final double   UMBRAL_DESCUENTO = 1000.0;
            double total=0;


            double subtotal = pedirDouble(scanner, "Subtotal: ");
            if (subtotal > UMBRAL_DESCUENTO) {
               total= subtotal - (subtotal * DESCUENTO);
            }else{
                total=subtotal;
            }
            System.out.printf("Total a pagar: %.2f%n", total);
        }

        public static double pedirDouble(Scanner scanner, String mensaje) {
            System.out.print(mensaje);
            return scanner.nextDouble();
        }
    }


