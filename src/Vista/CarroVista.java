package Vista;

import java.util.Scanner;

public class CarroVista {
    
    private Scanner obj_teclado = new Scanner(System.in);

    public String tomar_placa(){
        System.out.print("Placa del carro: ");
        String placa = obj_teclado.nextLine();
        return placa;
    }
    
    public String tomar_marca(){
        System.out.print("Marca del carro: ");
        String marca = obj_teclado.nextLine();
        return marca;
    }
    
    public String tomar_modelo(){
        System.out.print("Modelo del carro: ");
        String modelo = obj_teclado.nextLine();
        return modelo;
    }

    public void mostrar_mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
