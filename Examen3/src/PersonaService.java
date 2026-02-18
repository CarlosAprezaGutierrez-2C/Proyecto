public class PersonaService {
    final static double recargoMetodoPago =0.05;
    final static double DESCUENTO_COMPRA_GRANDE=0.12;
    final static double DESCUENTO_CLIENTE_VIP=0.08;
    boolean boletosValidos(int boletos){
        return boletos>0;
    }

    double calcularSubtotal(int boletos, double precio){
        return boletos * precio;
    }

    double calcularRecargo(double subtotal, int metodoPago){
        if(metodoPago==1){
            return subtotal* recargoMetodoPago;
        }
        return subtotal;
    }

    double calcularDescuento(double subtotalConRecargo, int boletos, int tipoCliente){
        if (boletos>4){
            return subtotalConRecargo * DESCUENTO_COMPRA_GRANDE;
        } if (tipoCliente==1){
            return  subtotalConRecargo * DESCUENTO_CLIENTE_VIP;
        }
        return subtotalConRecargo;
    }


    double calcularTotal(double subtotal, double recargo, double descuento){
        return subtotal+recargo-descuento;
    }


}