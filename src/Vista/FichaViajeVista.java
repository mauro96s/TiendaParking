package vista;

import java.util.Scanner;

public class FichaViajeVista {
    private Scanner objTeclado;

    public FichaViajeVista() {
        this.objTeclado = new Scanner(System.in);
    }

    public String tomarPlacaCarro() {
        System.out.print("Placa carro: ");
        return objTeclado.nextLine();
    }

    public String tomarSerieMotor() {
        System.out.print("Serie motor: ");
        return objTeclado.nextLine();
    }

    public String tomarCedulaChofer() {
        System.out.print("Cedula chofer: ");
        return objTeclado.nextLine();
    }

    public String tomarCedulaPasajero() {
        System.out.print("Cedula pasajero: ");
        return objTeclado.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEncabezadoGenerar() {
        System.out.println("\n=== GENERAR FICHA DE VIAJE ===");
    }

    public void mostrarEncabezadoLista() {
        System.out.println("\n--- LISTA DE VIAJES ---");
    }

    public void mostrarEncabezadoEliminar() {
        System.out.println("\n--- ELIMINAR VIAJE ---");
    }

    public String tomarPlacaEliminar() {
        System.out.println("Ingrese la placa del Carro del viaje a eliminar:");
        System.out.print("Placa: ");
        return objTeclado.nextLine();
    }
}
