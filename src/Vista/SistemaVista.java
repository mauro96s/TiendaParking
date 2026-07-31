package vista;

import java.util.Scanner;

public class SistemaVista {

    private Scanner objTeclado = new Scanner(System.in);

    // Esta clase tiene la ÃƒÅ¡NICA responsabilidad de mostrar mensajes generales del
    // sistema
    // (tÃƒÂ­tulos, menÃƒÂºs, confirmaciones globales) que no pertenecen a una entidad
    // especÃƒÂ­fica.

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String tomarOpcionMenu() {
        System.out.println("\n=================================");
        System.out.println("      SISTEMA TIENDA PARKING       ");
        System.out.println("=================================");
        System.out.println("1. Gestionar Carros");
        System.out.println("2. Gestionar Motores");
        System.out.println("3. Gestionar Choferes");
        System.out.println("4. Gestionar Pasajeros");
        System.out.println("5. Gestionar Fichas de Viaje");
        System.out.println("6. Salir del sistema");
        System.out.print("Seleccione una opcion: ");
        return objTeclado.nextLine();
    }

    public String tomarOpcionSubmenu(String entidad) {
        System.out.println("\n--- GESTION DE " + entidad.toUpperCase() + " ---");
        System.out.println("1. Registrar nuevo");
        System.out.println("2. Ver todos");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Regresar al menu principal");
        System.out.print("Seleccione una opcion: ");
        return objTeclado.nextLine();
    }
}
