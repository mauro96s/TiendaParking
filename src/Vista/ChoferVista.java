package vista;

import java.util.Scanner;

public class ChoferVista {
    
    private Scanner objTeclado = new Scanner(System.in);

    public String tomarNombre(){
        System.out.print("Nombre: ");
        String nombre = objTeclado.nextLine();
        return nombre;
    }
    
    public String tomarLicencia(){
        System.out.print("Licencia: ");
        String licencia = objTeclado.nextLine();
        return licencia;
    }
    
    public String tomarCedula(){
        System.out.print("Cedula: ");
        String cedula = objTeclado.nextLine();
        return cedula;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEncabezadoRegistro() {
        System.out.println("\n--- Datos del Chofer ---");
    }

    public void mostrarEncabezadoLista() {
        System.out.println("\n--- LISTA DE CHOFERES ---");
    }

    public void mostrarEncabezadoModificar() {
        System.out.println("\n--- MODIFICAR CHOFER ---");
    }

    public void mostrarEncabezadoActualizando(String cedula) {
        System.out.println("\n--- Modificando Chofer (CI Inmutable: " + cedula + ") ---");
    }

    public void mostrarEncabezadoEliminar() {
        System.out.println("\n--- ELIMINAR CHOFER ---");
    }
}
