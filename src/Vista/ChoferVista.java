package Vista;

import java.util.Scanner;

public class ChoferVista {
    
    public String tomar_nombre(){
        Scanner obj_teclado = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = obj_teclado.nextLine();
        return nombre;
    }
    
    public String tomar_licencia(){
        Scanner obj_teclado = new Scanner(System.in);
        System.out.print("Licencia: ");
        String licencia = obj_teclado.nextLine();
        return licencia;
    }
    
    public String tomar_cedula(){
        Scanner obj_teclado = new Scanner(System.in);
        System.out.print("Cedula: ");
        String cedula = obj_teclado.nextLine();
        return cedula;
    }
}
