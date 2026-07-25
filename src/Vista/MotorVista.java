package Vista;

import java.util.Scanner;

public class MotorVista {
    
    private Scanner obj_teclado = new Scanner(System.in);

    public String tomar_numero_serie(){
        System.out.print("Serie: ");
        String numero = obj_teclado.nextLine();
        return numero;
    }
    
    public String tomar_tipo(){
        System.out.print("Tipo: ");
        String tipo = obj_teclado.nextLine();
        return tipo;
    }

    public void mostrar_mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
