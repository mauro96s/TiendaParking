package tiendaparking;

import Controlador.GeneralController;
import Modelo.ChoferModelo;
import Vista.ChoferVista;

public class TiendaParking {

    public static void main(String[] args) {
        
        ChoferVista obj_vista = new ChoferVista();
        GeneralController obj_controlador = new GeneralController(obj_vista);
        obj_controlador.procesar_datos();
    }

}
