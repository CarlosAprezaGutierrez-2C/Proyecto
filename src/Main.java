import java.util.Scanner;

public class Main {

    public static final double IVA = 0.16;
    public static final double UMBRAL_DESCUENTO = 1000;
    public static final double DESCUENTO = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Subtotal: ");

        double iva = calcularIva(subtotal);
        double totalConIva = subtotal + iva;

        double totalFinal = calcularDescuento(totalConIva);

        System.out.println("IVA: " + iva);
        System.out.println("Total antes del descuento: " + totalConIva);
        System.out.println("Total a pagar: " + totalFinal);
    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public static double calcularIva(double subtotal) {
        return subtotal * IVA;
    }

    public static double calcularDescuento(double total) {
        if (total > UMBRAL_DESCUENTO) {
            total = total - (total * DESCUENTO);
        }
        return total;
    }
}
