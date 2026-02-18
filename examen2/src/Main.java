import java.util.Scanner;

public class Main {
     static PersonaService persona=new PersonaService();
     static double subtotalActual;
   static double descuentoCompra;
   static double precio;
   static int metodoPago;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ticket(input);
    }


    public static double calcularSubtotal (String subtotal, Scanner input){
       do{
        System.out.println(subtotal);
        if (!input.hasNextDouble()){
            System.out.println("Entrada inválida");
              input.nextLine();
              return 0;
        }
        precio=input.nextDouble();
        if (!persona.esPrecioValido(precio)){
            System.out.println("Ingresa un precio valido");
            continue;
        }
        subtotalActual+=precio;

    }while(precio>0);
        return subtotalActual;
}


public static double calcularDescuento (String descuento, Scanner input){
   do{
    System.out.println(descuento);
    if (!input.hasNextInt()){
        System.out.println("Ingresa un dato valido (1-Efectivo 2-Tarjeta)");
        input.nextLine();
        return 0;
    }
    metodoPago=input.nextInt();


} while(metodoPago!=1 && metodoPago!=2);
    descuentoCompra=persona.calcularDescuento(subtotalActual,metodoPago);
    return descuentoCompra;
    }



public static double calcularTotal (){
        Double totalFinal=persona.calcularTotal(subtotalActual,descuentoCompra);
       return totalFinal;
    }
  public static void ticket (Scanner input){
        //input

      double calcularSubtotal=calcularSubtotal("Ingresa el costo del producto",input);
      double calcularDescuento=calcularDescuento("Ingresa el metodo de pago (1-efectivo 2-tarjeta",input);
      double calcularTotal=calcularTotal();



      System.out.println("El subtotal es de : "+calcularSubtotal);
      System.out.println("El descuento es de : "+calcularDescuento);
      System.out.println("El total es de : "+calcularTotal);
  }

}



























