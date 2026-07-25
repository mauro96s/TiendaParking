package Controlador;

import Modelo.*;
import Vista.*;

public class GeneralController {

    SistemaVista vistaSistema;
    ChoferVista vistaChofer;
    CarroVista vistaCarro;
    MotorVista vistaMotor;
    PasajeroVista vistaPasajero;
    ApiModelo apiModelo;

    public GeneralController(SistemaVista sistema, ChoferVista chofer, CarroVista carro, MotorVista motor, PasajeroVista pasajero, ApiModelo api) {
        this.vistaSistema = sistema;
        this.vistaChofer = chofer;
        this.vistaCarro = carro;
        this.vistaMotor = motor;
        this.vistaPasajero = pasajero;
        this.apiModelo = api;
    }

    public void procesar_datos() {
        boolean salir = false;

        while (!salir) {
            String opcion = this.vistaSistema.tomar_opcion_menu();

            if (opcion.equals("1")) {
                this.vistaSistema.mostrar_mensaje("\n=== REGISTRO DE VIAJE ===");

                CarroModelo objCarro = procesar_carro();
                MotorModelo objMotor = procesar_motor();
                ChoferModelo objChofer = procesar_chofer();
                PasajeroModelo objPasajero = procesar_pasajero();

                // Agrupar en FichaViajeModelo (Estructura Externa)
                FichaViajeModelo ficha = new FichaViajeModelo(objCarro, objMotor, objChofer, objPasajero);

                // Validar con ApiModelo (Base de Datos)
                this.vistaSistema.mostrar_mensaje("\nProcesando guardado en Base de Datos...");
                if (this.apiModelo.validar_registro(ficha)) {
                    this.vistaSistema.mostrar_mensaje("Exito: Viaje registrado correctamente en la base de datos.");
                    this.vistaSistema.mostrar_mensaje(ficha.obtener_info());
                } else {
                    this.vistaSistema.mostrar_mensaje("Error: No se pudo registrar el viaje. Faltan datos criticos.");
                }
            } else if (opcion.equals("2")) {
                this.vistaSistema.mostrar_mensaje("\nSaliendo del sistema... Hasta luego!");
                salir = true;
            } else {
                this.vistaSistema.mostrar_mensaje("\nError: Opcion no valida. Intente de nuevo.");
            }
        }
    }

    private CarroModelo procesar_carro() {
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Carro ---");
        String placaCarro = this.vistaCarro.tomar_placa();
        String marcaCarro = this.vistaCarro.tomar_marca();
        String modeloCarro = this.vistaCarro.tomar_modelo();
        CarroModelo objCarro = new CarroModelo(placaCarro, marcaCarro, modeloCarro);

        while (!objCarro.validar_placa().equals("OK") || !objCarro.validar_marca().equals("OK") || !objCarro.validar_modelo().equals("OK")) {
            this.vistaCarro.mostrar_mensaje("Error: Datos del carro incompletos o invalidos.");
            if (!objCarro.validar_placa().equals("OK")) {
                this.vistaCarro.mostrar_mensaje(objCarro.validar_placa());
                objCarro.setPlaca_carro(this.vistaCarro.tomar_placa());
            }
            if (!objCarro.validar_marca().equals("OK")) {
                this.vistaCarro.mostrar_mensaje(objCarro.validar_marca());
                objCarro.setMarca_carro(this.vistaCarro.tomar_marca());
            }
            if (!objCarro.validar_modelo().equals("OK")) {
                this.vistaCarro.mostrar_mensaje(objCarro.validar_modelo());
                objCarro.setModelo_carro(this.vistaCarro.tomar_modelo());
            }
        }
        this.vistaSistema.mostrar_mensaje("\n" + objCarro.obtener_info());
        return objCarro;
    }

    private MotorModelo procesar_motor() {
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Motor ---");
        String serieMotor = this.vistaMotor.tomar_numero_serie();
        String tipoMotor = this.vistaMotor.tomar_tipo();
        MotorModelo objMotor = new MotorModelo(serieMotor, tipoMotor);

        while (!objMotor.validar_numero_serie().equals("OK") || !objMotor.validar_tipo().equals("OK")) {
            this.vistaMotor.mostrar_mensaje("Error: Datos del motor incompletos o invalidos.");
            if (!objMotor.validar_numero_serie().equals("OK")) {
                this.vistaMotor.mostrar_mensaje(objMotor.validar_numero_serie());
                objMotor.setNumero_serie_motor(this.vistaMotor.tomar_numero_serie());
            }
            if (!objMotor.validar_tipo().equals("OK")) {
                this.vistaMotor.mostrar_mensaje(objMotor.validar_tipo());
                objMotor.setTipo_motor(this.vistaMotor.tomar_tipo());
            }
        }
        this.vistaSistema.mostrar_mensaje("\n" + objMotor.obtener_info());
        return objMotor;
    }

    private ChoferModelo procesar_chofer() {
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Chofer ---");
        String cedulaChofer = this.vistaChofer.tomar_cedula();
        String nombreChofer = this.vistaChofer.tomar_nombre();
        String licenciaChofer = this.vistaChofer.tomar_licencia();
        ChoferModelo objChofer = new ChoferModelo(cedulaChofer, nombreChofer, licenciaChofer);

        while (!objChofer.validar_cedula().equals("OK") || !objChofer.validar_nombre().equals("OK") || !objChofer.validar_licencia().equals("OK")) {
            this.vistaChofer.mostrar_mensaje("Error: Datos del chofer incompletos o invalidos.");
            if (!objChofer.validar_cedula().equals("OK")) {
                this.vistaChofer.mostrar_mensaje(objChofer.validar_cedula());
                objChofer.setCedula_chofer(this.vistaChofer.tomar_cedula());
            }
            if (!objChofer.validar_nombre().equals("OK")) {
                this.vistaChofer.mostrar_mensaje(objChofer.validar_nombre());
                objChofer.setNombre_chofer(this.vistaChofer.tomar_nombre());
            }
            if (!objChofer.validar_licencia().equals("OK")) {
                this.vistaChofer.mostrar_mensaje(objChofer.validar_licencia());
                objChofer.setLicencia_chofer(this.vistaChofer.tomar_licencia());
            }
        }
        this.vistaSistema.mostrar_mensaje("\n" + objChofer.obtener_info());
        return objChofer;
    }

    private PasajeroModelo procesar_pasajero() {
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Pasajero ---");
        String cedulaPasajero = this.vistaPasajero.tomar_cedula();
        String nombrePasajero = this.vistaPasajero.tomar_nombre();
        PasajeroModelo objPasajero = new PasajeroModelo(cedulaPasajero, nombrePasajero);

        while (!objPasajero.validar_cedula().equals("OK") || !objPasajero.validar_nombre().equals("OK")) {
            this.vistaPasajero.mostrar_mensaje("Error: Datos del pasajero incompletos o invalidos.");
            if (!objPasajero.validar_cedula().equals("OK")) {
                this.vistaPasajero.mostrar_mensaje(objPasajero.validar_cedula());
                objPasajero.setCedula_pasajero(this.vistaPasajero.tomar_cedula());
            }
            if (!objPasajero.validar_nombre().equals("OK")) {
                this.vistaPasajero.mostrar_mensaje(objPasajero.validar_nombre());
                objPasajero.setNombre_pasajero(this.vistaPasajero.tomar_nombre());
            }
        }
        this.vistaSistema.mostrar_mensaje("\n" + objPasajero.obtener_info());
        return objPasajero;
    }
}
