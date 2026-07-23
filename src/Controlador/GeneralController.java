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
        this.vistaSistema.mostrar_mensaje("=== REGISTRO DE VIAJE ===");
        
        // 1. Datos del Carro (Criterio 1)
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Carro ---");
        String placaCarro = this.vistaCarro.tomar_placa();
        String marcaCarro = this.vistaCarro.tomar_marca();
        String modeloCarro = this.vistaCarro.tomar_modelo();
        CarroModelo objCarro = new CarroModelo(placaCarro, marcaCarro, modeloCarro);
        while (!objCarro.placa_valida() || !objCarro.marca_valida() || !objCarro.modelo_valido()) {
            this.vistaCarro.mostrar_mensaje("Error: Datos del carro incompletos.");
            if (!objCarro.placa_valida()) {
                objCarro.setPlaca_carro(this.vistaCarro.tomar_placa());
            }
            if (!objCarro.marca_valida()) {
                objCarro.setMarca_carro(this.vistaCarro.tomar_marca());
            }
            if (!objCarro.modelo_valido()) {
                objCarro.setModelo_carro(this.vistaCarro.tomar_modelo());
            }
        }

        // 2. Datos del Motor (Criterio 2)
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Motor ---");
        String serieMotor = this.vistaMotor.tomar_numero_serie();
        String tipoMotor = this.vistaMotor.tomar_tipo();
        MotorModelo objMotor = new MotorModelo(serieMotor, tipoMotor);
        while (!objMotor.numero_serie_valido() || !objMotor.tipo_valido()) {
            this.vistaMotor.mostrar_mensaje("Error: Datos del motor incompletos.");
            if (!objMotor.numero_serie_valido()) {
                objMotor.setNumero_serie_motor(this.vistaMotor.tomar_numero_serie());
            }
            if (!objMotor.tipo_valido()) {
                objMotor.setTipo_motor(this.vistaMotor.tomar_tipo());
            }
        }

        // 3. Datos del Chofer (Criterio 3)
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Chofer ---");
        String nombreChofer = this.vistaChofer.tomar_nombre();
        String licenciaChofer = this.vistaChofer.tomar_licencia();
        String cedulaChofer = this.vistaChofer.tomar_cedula();
        ChoferModelo objChofer = new ChoferModelo(nombreChofer, licenciaChofer, cedulaChofer);
        while (!objChofer.nombre_valido() || !objChofer.licencia_valida() || !objChofer.cedula_valida()) {
            this.vistaChofer.mostrar_mensaje("Error: Datos del chofer incompletos.");
            if (!objChofer.nombre_valido()) {
                objChofer.setNombre_chofer(this.vistaChofer.tomar_nombre());
            }
            if (!objChofer.licencia_valida()) {
                objChofer.setLicencia_chofer(this.vistaChofer.tomar_licencia());
            }
            if (!objChofer.cedula_valida()) {
                objChofer.setCedula_chofer(this.vistaChofer.tomar_cedula());
            }
        }

        // 4. Datos del Pasajero (Criterio 4)
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Pasajero ---");
        String cedulaPasajero = this.vistaPasajero.tomar_cedula();
        String nombrePasajero = this.vistaPasajero.tomar_nombre();
        PasajeroModelo objPasajero = new PasajeroModelo(cedulaPasajero, nombrePasajero);
        while (!objPasajero.cedula_valida() || !objPasajero.nombre_valido()) {
            this.vistaPasajero.mostrar_mensaje("Error: Datos del pasajero incompletos.");
            if (!objPasajero.cedula_valida()) {
                objPasajero.setCedula_pasajero(this.vistaPasajero.tomar_cedula());
            }
            if (!objPasajero.nombre_valido()) {
                objPasajero.setNombre_pasajero(this.vistaPasajero.tomar_nombre());
            }
        }

        // 5. Agrupar en FichaViajeModelo (Estructura Externa)
        FichaViajeModelo ficha = new FichaViajeModelo(objCarro, objMotor, objChofer, objPasajero);

        // 6. Validar con ApiModelo (Base de Datos)
        this.vistaSistema.mostrar_mensaje("\nProcesando guardado en Base de Datos...");
        if (this.apiModelo.validar_registro(ficha)) {
            this.vistaSistema.mostrar_mensaje("Exito: Viaje registrado correctamente en la base de datos.");
        } else {
            this.vistaSistema.mostrar_mensaje("Error: No se pudo registrar el viaje. Faltan datos criticos.");
        }
    }
}
