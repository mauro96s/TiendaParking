package Vista;

import java.util.Scanner;

public class MotorVista {
    
    private Scanner obj_teclado = new Scanner(System.in);

    public String tomar_numero_serie(){
        System.out.print("Numero de serie del motor: ");
        String numero = obj_teclado.nextLine();
        return numero;
    }
    
    public String tomar_tipo(){
        System.out.print("Tipo de motor: ");
        String tipo = obj_teclado.nextLine();
        return tipo;
    }
}
