import java.util.Scanner;

public class PersonaService {


    static boolean esCodigoValido(String codigo){
      if (codigo==null || codigo.length()!=6 || !codigo.matches("[A-Za-z0-9]{6}")){
          return false;
      }
      return true;
    }
    static String PedirMensaje(String msg,Scanner input){
       String codigo;
        do{
        System.out.println(msg);
        codigo=input.nextLine();
            if (!esCodigoValido(codigo)){
                System.out.println("Ingresa un codigo valido");
            }
        } while (!esCodigoValido(codigo));

        return codigo;
        }


    static boolean esHorarioPermitido(int hora, boolean esAlumno){
      if (esAlumno){
           return hora >= 8 && hora <= 20;
    } else {
          return hora >= 10 && hora <= 18;
      }

    }
}
