package vista;

import java.util.Scanner;

public class PasajeroVista {
    
    private Scanner objTeclado = new Scanner(System.in);

    public String tomarCedula(){
        System.out.print("Cedula: ");
        String cedula = objTeclado.nextLine();
        return cedula;
    }
    
    public String tomarNombre(){
        System.out.print("Nombre: ");
        String nombre = objTeclado.nextLine();
        return nombre;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEncabezadoRegistro() {
        System.out.println("\n--- Datos del Pasajero ---");
    }

    public void mostrarEncabezadoLista() {
        System.out.println("\n--- LISTA DE PASAJEROS ---");
    }

    public void mostrarEncabezadoModificar() {
        System.out.println("\n--- MODIFICAR PASAJERO ---");
    }

    public void mostrarEncabezadoActualizando(String cedula) {
        System.out.println("\n--- Modificando Pasajero (CI Inmutable: " + cedula + ") ---");
    }

    public void mostrarEncabezadoEliminar() {
        System.out.println("\n--- ELIMINAR PASAJERO ---");
    }
}
