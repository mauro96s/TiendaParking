package Vista;

import java.util.Scanner;

public class PasajeroVista {
    
    private Scanner obj_teclado = new Scanner(System.in);

    public String tomar_cedula(){
        System.out.print("Cedula del pasajero: ");
        String cedula = obj_teclado.nextLine();
        return cedula;
    }
    
    public String tomar_nombre(){
        System.out.print("Nombre del pasajero: ");
        String nombre = obj_teclado.nextLine();
        return nombre;
    }
}
