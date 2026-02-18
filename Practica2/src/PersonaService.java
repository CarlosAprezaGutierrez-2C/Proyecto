public class PersonaService {


    static boolean validarHoras(int horas){
        return horas >= 0;
    }


    static boolean validarTarifa(double tarifa){
      return tarifa> 0;
    }

    static double aplicarDescuentoHoras(double total, int horas){
       if(horas>10){
           total *=0.88 ;
       }
      return total;
    }

    static double aplicarDescuentoBoleto(double total, boolean tieneBoleto){
      if (tieneBoleto){
          total*=0.95;
      }
      return total;
    }




}
