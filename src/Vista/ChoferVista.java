package Vista;

import java.util.Scanner;

public class ChoferVista {
    
    private Scanner obj_teclado = new Scanner(System.in);

    public String tomar_nombre(){
        System.out.print("Nombre: ");
        String nombre = obj_teclado.nextLine();
        return nombre;
    }
    
    public String tomar_licencia(){
        System.out.print("Licencia: ");
        String licencia = obj_teclado.nextLine();
        return licencia;
    }
    
    public String tomar_cedula(){
        System.out.print("Cedula: ");
        String cedula = obj_teclado.nextLine();
        return cedula;
    }

    public void mostrar_mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
