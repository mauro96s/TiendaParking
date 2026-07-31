package vista;

import java.util.Scanner;

public class CarroVista {

    private Scanner objTeclado = new Scanner(System.in);

    public String tomarPlaca() {
        System.out.print("Placa: ");
        String placa = objTeclado.nextLine();
        return placa;
    }

    public String tomarMarca() {
        System.out.print("Marca: ");
        String marca = objTeclado.nextLine();
        return marca;
    }

    public String tomarModelo() {
        System.out.print("Modelo: ");
        String modelo = objTeclado.nextLine();
        return modelo;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEncabezadoRegistro() {
        System.out.println("\n--- Datos del Carro ---");
    }

    public void mostrarEncabezadoLista() {
        System.out.println("\n--- LISTA DE CARROS ---");
    }

    public void mostrarEncabezadoModificar() {
        System.out.println("\n--- MODIFICAR CARRO ---");
    }

    public void mostrarEncabezadoActualizando(String placa) {
        System.out.println("\n--- Modificando Carro (Placa Inmutable: " + placa + ") ---");
    }

    public void mostrarEncabezadoEliminar() {
        System.out.println("\n--- ELIMINAR CARRO ---");
    }
}
