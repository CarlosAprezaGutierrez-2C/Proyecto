import java.util.Scanner;

public class Main {
    PersonaService persona=new PersonaService();

    public static void main(String[] args) {

    }

    public static void esHorarioPermitido (String msgAlumno,Scanner input,String msgHorario){
        boolean esAlumno;
        int hora;
        System.out.println(msgAlumno);
        esAlumno=input.nextBoolean();
        System.out.println(msgHorario);
        hora=input.nextInt();
        boolean horarioPermitido;
        if (hora<=0 || hora >=23){
            System.out.println("Horario invalida");
            input.nextLine();
            return;

        }
        horarioPermitido= PersonaService.esHorarioPermitido(hora,esAlumno);

        if (horarioPermitido){
            System.out.println("Horario permitido");
            input.nextLine();
            return;
        }else{
            System.out.println("Horario no permitido");
            return;
        }

    }
    public static void pedirCodigo(String msg,Scanner input){
        String codigo;
        while (true){
            codigo = PersonaService.PedirMensaje(msg, input);
            if (codigo.equalsIgnoreCase("salir")){
                System.out.println("Gracias por usar este programa");
                break;

            }
            esHorarioPermitido("ES alumno solo responde (true/false)",input, "Ingresa el horario en el que vas a ingresar solo con numeros enteros");
        }
    }



}
