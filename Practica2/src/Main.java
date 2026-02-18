import java.util.Scanner;

public class Main {
    PersonaService persona = new PersonaService();

    // Metodo para pedir horas
    public int pedirHoras(Scanner input, String msg){
        System.out.println(msg);
        if (!input.hasNextInt()){
            System.out.println("Entrada inválida");
            input.nextLine();
            return 0;
        }
        int horas = input.nextInt();
        input.nextLine();

        if (!PersonaService.validarHoras(horas)){
            System.out.println("Horas inválidas");
            return 0;
        }
        return horas;
    }

    // metpdp
    public double pedirTarifa(Scanner input, String msg){
        System.out.println(msg);
        if (!input.hasNextDouble()){
            System.out.println("Entrada inválida");
            input.nextLine();
            return 0;
        }
        double tarifa = input.nextDouble();
        input.nextLine();

        if (!PersonaService.validarTarifa(tarifa)){
            System.out.println("Tarifa inválida");
            return 0;
        }
        return tarifa;
    }

    // Método para pedir booleano (boleto de descuento)
    public boolean esBolean(String msg, Scanner input){
        System.out.println(msg);
        if (!input.hasNextBoolean()){
            System.out.println("Entrada inválida");
            input.nextLine();
            return false;
        }0
        boolean boleto = input.nextBoolean();
        input.nextLine();
        return boleto;
    }

    // Método que hace toda la lógica y muestra resultados
    public void imprimirResultado(Scanner input){
        int horas = pedirHoras(input, "Ingresa las horas que va a estar disponible:");
        double costo = pedirTarifa(input, "Ingresa el costo del estacionamiento:");
        boolean tieneBoleto = esBolean("¿Tiene boleto de descuento? (true/false):", input);

        double subtotal = horas * costo;
        double totalHoras = PersonaService.aplicarDescuentoHoras(subtotal, horas);
        double totalFinal = PersonaService.aplicarDescuentoBoleto(totalHoras, tieneBoleto);

        // Output con 2 decimales
        System.out.printf("El subtotal es: %.2f\n", subtotal);
        System.out.printf("El descuento aplicado es: %.2f\n", subtotal - totalHoras + (totalHoras - totalFinal));
        System.out.printf("El total final es: %.2f\n", totalFinal);

        if (totalFinal > 1000){
            System.out.println("Se requiere autorización");
        }
    }

    // MAIN
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Main m = new Main();
        m.imprimirResultado(input);
        input.close();
    }
}
