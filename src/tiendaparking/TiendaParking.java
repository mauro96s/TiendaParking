package tiendaparking;

import Controlador.GeneralController;
import Modelo.ApiModelo;
import Vista.*;

public class TiendaParking {

    public static void main(String[] args) {
        
        // Instanciar Vistas
        SistemaVista vistaSistema = new SistemaVista();
        ChoferVista vistaChofer = new ChoferVista();
        CarroVista vistaCarro = new CarroVista();
        MotorVista vistaMotor = new MotorVista();
        PasajeroVista vistaPasajero = new PasajeroVista();
        
        // Instanciar Modelo DB
        ApiModelo api = new ApiModelo("http://api.com", "root", "1234");
        
        // Inyectar dependencias al controlador
        GeneralController obj_controlador = new GeneralController(vistaSistema, vistaChofer, vistaCarro, vistaMotor, vistaPasajero, api);
        obj_controlador.procesar_datos();
    }

}
