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

        // ciclo while que se repite si falla CUALQUIERA de las validaciones
        while (!obj_chofer.nombre_valido() || !obj_chofer.licencia_valida() || !obj_chofer.cedula_valida()) {
            System.out.println("Error: Faltan datos obligatorios. Por favor, complete la informacion.");

            if (!obj_chofer.nombre_valido()) {
                nombre = this.vista.tomar_nombre();
                obj_chofer.setNombre_chofer(nombre);
            }

            if (!obj_chofer.licencia_valida()) {
                licencia = this.vista.tomar_licencia();
                obj_chofer.setLicencia_chofer(licencia);
            }

            if (!obj_chofer.cedula_valida()) {
                cedula = this.vista.tomar_cedula();
                obj_chofer.setCedula_chofer(cedula);
            }
        }

        System.out.println("Datos procesados correctamente...");
    }
}
