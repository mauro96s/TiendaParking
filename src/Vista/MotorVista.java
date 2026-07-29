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

    public String tomar_cilindraje(){
        System.out.print("Cilindraje: ");
        String cilindraje = obj_teclado.nextLine();
        return cilindraje;
    }

    public void mostrar_mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
