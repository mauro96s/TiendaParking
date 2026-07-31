package main;

import controlador.PrincipalControlador;
import modelo.ApiModelo;
import vista.*;

public class Main {

    public static void main(String[] args) {
        
        // Instanciar Vistas
        SistemaVista vistaSistema = new SistemaVista();
        ChoferVista vistaChofer = new ChoferVista();
        CarroVista vistaCarro = new CarroVista();
        MotorVista vistaMotor = new MotorVista();
        PasajeroVista vistaPasajero = new PasajeroVista();
        FichaViajeVista vistaViaje = new FichaViajeVista();
        
        // Instanciar Modelo DB
        ApiModelo api = new ApiModelo("http://api.com", "root", "1234");
        
        // Inyectar dependencias al controlador
        PrincipalControlador objControlador = new PrincipalControlador(vistaSistema, vistaChofer, vistaCarro, vistaMotor, vistaPasajero, vistaViaje, api);
        objControlador.procesarDatos();
    }

}
