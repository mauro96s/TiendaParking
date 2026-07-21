package Controlador;

import Modelo.ChoferModelo;
import Vista.ChoferVista;

public class GeneralController {

    ChoferVista vista;

    public GeneralController(ChoferVista obj_vista) {
        this.vista = obj_vista;
    }

    public void procesar_datos() {
        String nombre = this.vista.tomar_nombre();
        String licencia = this.vista.tomar_licencia();
        String cedula = this.vista.tomar_cedula();

        ChoferModelo obj_chofer = new ChoferModelo(nombre, licencia, cedula);

        if (!obj_chofer.nombre_valido()) {
            System.out.println("Falta Nombre");
            nombre = this.vista.tomar_nombre();
            obj_chofer.setNombre_chofer(nombre);
        } else if (!obj_chofer.licencia_valida()) {
            System.out.println("Falta Licencia");
            licencia = this.vista.tomar_licencia();
            obj_chofer.setLicencia_chofer(licencia);
        } else if (!obj_chofer.cedula_valida()) {
            System.out.println("Falta Cedula");
            cedula = this.vista.tomar_cedula();
            obj_chofer.setCedula_chofer(cedula);
        } else {
            System.out.println("Datos procesados...");
        }
    }
}
