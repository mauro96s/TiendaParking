package vista;

import java.util.Scanner;

public class MotorVista {
    
    private Scanner objTeclado = new Scanner(System.in);

    public String tomarNumeroSerie(){
        System.out.print("Serie: ");
        String numero = objTeclado.nextLine();
        return numero;
    }
    
    public String tomarTipo(){
        System.out.print("Tipo: ");
        String tipo = objTeclado.nextLine();
        return tipo;
    }

    public String tomarCilindraje(){
        System.out.print("Cilindraje: ");
        String cilindraje = objTeclado.nextLine();
        return cilindraje;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEncabezadoRegistro() {
        System.out.println("\n--- Datos del Motor ---");
    }

    public void mostrarEncabezadoLista() {
        System.out.println("\n--- LISTA DE MOTORES ---");
    }

    public void mostrarEncabezadoModificar() {
        System.out.println("\n--- MODIFICAR MOTOR ---");
    }

    public void mostrarEncabezadoActualizando(String serie) {
        System.out.println("\n--- Modificando Motor (Serie Inmutable: " + serie + ") ---");
    }

    public void mostrarEncabezadoEliminar() {
        System.out.println("\n--- ELIMINAR MOTOR ---");
    }
}
