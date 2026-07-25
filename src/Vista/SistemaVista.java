package Vista;

import java.util.Scanner;

public class SistemaVista {
    
    private Scanner obj_teclado = new Scanner(System.in);
    
    // Esta clase tiene la ÚNICA responsabilidad de mostrar mensajes generales del sistema
    // (títulos, menús, confirmaciones globales) que no pertenecen a una entidad específica.
    
    public void mostrar_mensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public String tomar_opcion_menu() {
        System.out.println("\n=================================");
        System.out.println("      SISTEMA TIENDA PARKING       ");
        System.out.println("=================================");
        System.out.println("1. Registrar nueva Ficha de Viaje");
        System.out.println("2. Salir del sistema");
        System.out.print("Seleccione una opcion: ");
        return obj_teclado.nextLine();
    }
}
