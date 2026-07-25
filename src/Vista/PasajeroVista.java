package Vista;

import java.util.Scanner;

public class PasajeroVista {
    
    private Scanner obj_teclado = new Scanner(System.in);

    public String tomar_cedula(){
        System.out.print("Cedula: ");
        String cedula = obj_teclado.nextLine();
        return cedula;
    }
    
    public String tomar_nombre(){
        System.out.print("Nombre: ");
        String nombre = obj_teclado.nextLine();
        return nombre;
    }

    public void mostrar_mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
