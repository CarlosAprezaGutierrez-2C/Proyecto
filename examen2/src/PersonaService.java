public class PersonaService {
    static double descuentoEfectivo=0.08;
    static double descuentoTarjeta=0.05;

    static boolean esPrecioValido(double p){
        return p >= 0;
    }
    static double calcularSubtotal(double subtotalActual, double precio){
        return subtotalActual += precio;
    }
    static double calcularDescuento(double subtotal, int metodoPago){
        if (subtotal>500){
            if (metodoPago==1){
                return subtotal*descuentoEfectivo;
            }else  if (metodoPago==2){
                return subtotal*descuentoTarjeta;
            }
        }
        return subtotal;
    }

    static double calcularTotal(double subtotal, double descuento){
     return subtotal-descuento;
    }

}
