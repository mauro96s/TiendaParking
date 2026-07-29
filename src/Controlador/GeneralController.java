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

            switch (opcion) {
                case "1":
                    gestionar_carros();
                    break;
                case "2":
                    gestionar_motores();
                    break;
                case "3":
                    gestionar_choferes();
                    break;
                case "4":
                    gestionar_pasajeros();
                    break;
                case "5":
                    gestionar_viajes();
                    break;
                case "6":
                    this.vistaSistema.mostrar_mensaje("\nSaliendo del sistema... Hasta luego!");
                    salir = true;
                    break;
                default:
                    this.vistaSistema.mostrar_mensaje("\nError: Opcion no valida. Intente de nuevo.");
            }
        }
    }

    private boolean esMatrizLlenaCarros() {
        String[][] matriz = this.apiModelo.getListaCarros();
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == null) return false;
        }
        return true;
    }

    private boolean esMatrizVaciaCarros() {
        String[][] matriz = this.apiModelo.getListaCarros();
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] != null) return false;
        }
        return true;
    }

    private boolean esMatrizLlenaMotos() {
        String[][] matriz = this.apiModelo.getListaMotores();
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == null) return false;
        }
        return true;
    }

    private boolean esMatrizVaciaMotos() {
        String[][] matriz = this.apiModelo.getListaMotores();
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] != null) return false;
        }
        return true;
    }

    private boolean estaEnUsoCarro(String placa) {
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            if (f.getCarro().getPlaca_carro().equals(placa)) return true;
        }
        return false;
    }

    private boolean estaEnUsoChofer(String cedula) {
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            if (f.getChofer().getCedula_chofer().equals(cedula)) return true;
        }
        return false;
    }

    private boolean estaEnUsoPasajero(String cedula) {
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            if (f.getPasajero().getCedula_pasajero().equals(cedula)) return true;
        }
        return false;
    }

    private void gestionar_carros() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomar_opcion_submenu("Carros");
            if (op.equals("1")) {
                if (esMatrizLlenaCarros()) {
                    this.vistaSistema.mostrar_mensaje("Error: Limite maximo alcanzado. No hay espacio para mas carros.");
                    continue;
                }
                String[] carro = procesar_carro();
                if (this.apiModelo.crearCarro(carro)) {
                    this.vistaSistema.mostrar_mensaje("Carro guardado exitosamente.");
                }
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (esMatrizVaciaCarros()) {
                    this.vistaSistema.mostrar_mensaje("La lista de Carros esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaSistema.mostrar_mensaje("\n--- LISTA DE CARROS ---");
                    String[][] matriz = this.apiModelo.getListaCarros();
                    for (int i = 0; i < 3; i++) {
                        if (matriz[i][0] != null) {
                            CarroModelo tempCarro = new CarroModelo(matriz[i][0], matriz[i][1], matriz[i][2]);
                            this.vistaSistema.mostrar_mensaje(tempCarro.obtener_info());
                        }
                    }
                } else if (op.equals("3")) {
                    this.vistaSistema.mostrar_mensaje("\n--- MODIFICAR CARRO ---");
                    String placa = this.vistaCarro.tomar_placa();
                    if (this.apiModelo.leerCarro(placa) != null) {
                        String[] nuevo = modificar_carro(placa);
                        this.apiModelo.actualizarCarro(placa, nuevo);
                        this.vistaSistema.mostrar_mensaje("Carro modificado exitosamente.");
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Carro no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaSistema.mostrar_mensaje("\n--- ELIMINAR CARRO ---");
                    String placa = this.vistaCarro.tomar_placa();
                    if (this.apiModelo.leerCarro(placa) != null) {
                        if (estaEnUsoCarro(placa)) {
                            this.vistaSistema.mostrar_mensaje("Error: No se puede eliminar. El carro esta asociado a una ficha de viaje.");
                        } else {
                            this.apiModelo.eliminarCarro(placa);
                            this.vistaSistema.mostrar_mensaje("Carro eliminado exitosamente.");
                        }
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Carro no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaSistema.mostrar_mensaje("Opcion invalida.");
            }
        }
    }

    private void gestionar_motores() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomar_opcion_submenu("Motores");
            if (op.equals("1")) {
                if (esMatrizLlenaMotos()) {
                    this.vistaSistema.mostrar_mensaje("Error: Limite maximo alcanzado. No hay espacio para mas motores.");
                    continue;
                }
                String[] motor = procesar_motor();
                if (this.apiModelo.crearMotor(motor)) {
                    this.vistaSistema.mostrar_mensaje("Motor guardado exitosamente.");
                }
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (esMatrizVaciaMotos()) {
                    this.vistaSistema.mostrar_mensaje("La lista de Motores esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaSistema.mostrar_mensaje("\n--- LISTA DE MOTORES ---");
                    String[][] matriz = this.apiModelo.getListaMotores();
                    for (int i = 0; i < 3; i++) {
                        if (matriz[i][0] != null) {
                            MotorModelo tempMotor = new MotorModelo(matriz[i][0], matriz[i][1], matriz[i][2]);
                            this.vistaSistema.mostrar_mensaje(tempMotor.obtener_info());
                        }
                    }
                } else if (op.equals("3")) {
                    this.vistaSistema.mostrar_mensaje("\n--- MODIFICAR MOTOR ---");
                    String serie = this.vistaMotor.tomar_numero_serie();
                    if (this.apiModelo.leerMotor(serie) != null) {
                        String[] nuevo = modificar_motor(serie);
                        this.apiModelo.actualizarMotor(serie, nuevo);
                        this.vistaSistema.mostrar_mensaje("Motor modificado exitosamente.");
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Motor no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaSistema.mostrar_mensaje("\n--- ELIMINAR MOTOR ---");
                    String serie = this.vistaMotor.tomar_numero_serie();
                    if (this.apiModelo.leerMotor(serie) != null) {
                        this.apiModelo.eliminarMotor(serie);
                        this.vistaSistema.mostrar_mensaje("Motor eliminado exitosamente.");
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Motor no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaSistema.mostrar_mensaje("Opcion invalida.");
            }
        }
    }

    private void gestionar_choferes() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomar_opcion_submenu("Choferes");
            if (op.equals("1")) {
                ChoferModelo chofer = procesar_chofer();
                this.apiModelo.crearChofer(chofer);
                this.vistaSistema.mostrar_mensaje("Chofer guardado exitosamente.");
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (this.apiModelo.getListaChoferes().isEmpty()) {
                    this.vistaSistema.mostrar_mensaje("La lista de Choferes esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaSistema.mostrar_mensaje("\n--- LISTA DE CHOFERES ---");
                    for (ChoferModelo ch : this.apiModelo.getListaChoferes()) {
                        this.vistaSistema.mostrar_mensaje(ch.obtener_info());
                    }
                } else if (op.equals("3")) {
                    this.vistaSistema.mostrar_mensaje("\n--- MODIFICAR CHOFER ---");
                    String cedula = this.vistaChofer.tomar_cedula();
                    if (this.apiModelo.leerChofer(cedula) != null) {
                        ChoferModelo nuevo = modificar_chofer(cedula);
                        this.apiModelo.actualizarChofer(cedula, nuevo);
                        this.vistaSistema.mostrar_mensaje("Chofer modificado exitosamente.");
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Chofer no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaSistema.mostrar_mensaje("\n--- ELIMINAR CHOFER ---");
                    String cedula = this.vistaChofer.tomar_cedula();
                    if (this.apiModelo.leerChofer(cedula) != null) {
                        if (estaEnUsoChofer(cedula)) {
                            this.vistaSistema.mostrar_mensaje("Error: No se puede eliminar. El chofer esta asociado a una ficha de viaje.");
                        } else {
                            this.apiModelo.eliminarChofer(cedula);
                            this.vistaSistema.mostrar_mensaje("Chofer eliminado exitosamente.");
                        }
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Chofer no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaSistema.mostrar_mensaje("Opcion invalida.");
            }
        }
    }

    private void gestionar_pasajeros() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomar_opcion_submenu("Pasajeros");
            if (op.equals("1")) {
                PasajeroModelo pasajero = procesar_pasajero();
                this.apiModelo.crearPasajero(pasajero);
                this.vistaSistema.mostrar_mensaje("Pasajero guardado exitosamente.");
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (this.apiModelo.getListaPasajeros().isEmpty()) {
                    this.vistaSistema.mostrar_mensaje("La lista de Pasajeros esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaSistema.mostrar_mensaje("\n--- LISTA DE PASAJEROS ---");
                    for (PasajeroModelo p : this.apiModelo.getListaPasajeros()) {
                        this.vistaSistema.mostrar_mensaje(p.obtener_info());
                    }
                } else if (op.equals("3")) {
                    this.vistaSistema.mostrar_mensaje("\n--- MODIFICAR PASAJERO ---");
                    String cedula = this.vistaPasajero.tomar_cedula();
                    if (this.apiModelo.leerPasajero(cedula) != null) {
                        PasajeroModelo nuevo = modificar_pasajero(cedula);
                        this.apiModelo.actualizarPasajero(cedula, nuevo);
                        this.vistaSistema.mostrar_mensaje("Pasajero modificado exitosamente.");
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Pasajero no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaSistema.mostrar_mensaje("\n--- ELIMINAR PASAJERO ---");
                    String cedula = this.vistaPasajero.tomar_cedula();
                    if (this.apiModelo.leerPasajero(cedula) != null) {
                        if (estaEnUsoPasajero(cedula)) {
                            this.vistaSistema.mostrar_mensaje("Error: No se puede eliminar. El pasajero esta asociado a una ficha de viaje.");
                        } else {
                            this.apiModelo.eliminarPasajero(cedula);
                            this.vistaSistema.mostrar_mensaje("Pasajero eliminado exitosamente.");
                        }
                    } else {
                        this.vistaSistema.mostrar_mensaje("Error: Pasajero no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaSistema.mostrar_mensaje("Opcion invalida.");
            }
        }
    }

    private void gestionar_viajes() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomar_opcion_submenu("Fichas de Viaje");
            if (op.equals("1")) {
                generar_viaje();
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (this.apiModelo.getListaViajes().isEmpty()) {
                    this.vistaSistema.mostrar_mensaje("La lista de Viajes esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    mostrar_viajes();
                } else if (op.equals("3")) {
                    this.vistaSistema.mostrar_mensaje("\nModificacion de viajes no disponible actualmente por reglas de negocio. Debes eliminar y recrear.");
                } else if (op.equals("4")) {
                    this.vistaSistema.mostrar_mensaje("\n--- ELIMINAR VIAJE ---");
                    this.vistaSistema.mostrar_mensaje("Ingrese la placa del Carro del viaje a eliminar:");
                    String placa = this.vistaCarro.tomar_placa();
                    boolean eliminado = this.apiModelo.getListaViajes().removeIf(v -> v.getCarro().getPlaca_carro().equals(placa));
                    if (eliminado) {
                        this.vistaSistema.mostrar_mensaje("Viaje eliminado exitosamente.");
                    } else {
                        this.vistaSistema.mostrar_mensaje("No se encontro viaje con esa placa.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaSistema.mostrar_mensaje("Opcion invalida.");
            }
        }
    }

    private void generar_viaje() {
        this.vistaSistema.mostrar_mensaje("\n=== GENERAR FICHA DE VIAJE ===");

        this.vistaSistema.mostrar_mensaje("Ingrese la placa del Carro a usar:");
        String placa = this.vistaCarro.tomar_placa();
        String[] carroData = this.apiModelo.leerCarro(placa);
        if (carroData == null) {
            this.vistaSistema.mostrar_mensaje("Error: Carro no encontrado.");
            return;
        }
        CarroModelo carro = new CarroModelo(carroData[0], carroData[1], carroData[2]);

        this.vistaSistema.mostrar_mensaje("Ingrese la serie del Motor a usar:");
        String serie = this.vistaMotor.tomar_numero_serie();
        String[] motorData = this.apiModelo.leerMotor(serie);
        if (motorData == null) {
            this.vistaSistema.mostrar_mensaje("Error: Motor no encontrado.");
            return;
        }
        MotorModelo motor = new MotorModelo(motorData[0], motorData[1], motorData[2]);

        this.vistaSistema.mostrar_mensaje("Ingrese la cedula del Chofer:");
        String cedulaChofer = this.vistaChofer.tomar_cedula();
        ChoferModelo chofer = this.apiModelo.leerChofer(cedulaChofer);
        if (chofer == null) {
            this.vistaSistema.mostrar_mensaje("Error: Chofer no encontrado.");
            return;
        }

        this.vistaSistema.mostrar_mensaje("Ingrese la cedula del Pasajero:");
        String cedulaPasajero = this.vistaPasajero.tomar_cedula();
        PasajeroModelo pasajero = this.apiModelo.leerPasajero(cedulaPasajero);
        if (pasajero == null) {
            this.vistaSistema.mostrar_mensaje("Error: Pasajero no encontrado.");
            return;
        }

        FichaViajeModelo ficha = new FichaViajeModelo(carro, motor, chofer, pasajero);
        if (this.apiModelo.validar_registro(ficha)) {
            this.apiModelo.crearViaje(ficha);
            this.vistaSistema.mostrar_mensaje("Viaje registrado correctamente en la base de datos.");
        } else {
            this.vistaSistema.mostrar_mensaje("Error: No se pudo registrar el viaje. Faltan datos criticos.");
        }
    }

    private void mostrar_viajes() {
        this.vistaSistema.mostrar_mensaje("\n--- LISTA DE VIAJES ---");
        int contador = 1;
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            this.vistaSistema.mostrar_mensaje("\nVIAJE " + contador);
            this.vistaSistema.mostrar_mensaje(f.obtener_info());
            contador++;
        }
    }

    private String[] procesar_carro() {
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
        return new String[]{objCarro.getPlaca_carro(), objCarro.getMarca_carro(), objCarro.getModelo_carro()};
    }

    private String[] modificar_carro(String placa) {
        this.vistaSistema.mostrar_mensaje("\n--- Modificando Carro (Placa Inmutable: " + placa + ") ---");
        String marcaCarro = this.vistaCarro.tomar_marca();
        String modeloCarro = this.vistaCarro.tomar_modelo();
        
        CarroModelo objCarro = new CarroModelo(placa, marcaCarro, modeloCarro);

        while (!objCarro.validar_marca().equals("OK") || !objCarro.validar_modelo().equals("OK")) {
            this.vistaCarro.mostrar_mensaje("Error: Datos del carro incompletos o invalidos.");
            if (!objCarro.validar_marca().equals("OK")) {
                this.vistaCarro.mostrar_mensaje(objCarro.validar_marca());
                objCarro.setMarca_carro(this.vistaCarro.tomar_marca());
            }
            if (!objCarro.validar_modelo().equals("OK")) {
                this.vistaCarro.mostrar_mensaje(objCarro.validar_modelo());
                objCarro.setModelo_carro(this.vistaCarro.tomar_modelo());
            }
        }
        return new String[]{objCarro.getPlaca_carro(), objCarro.getMarca_carro(), objCarro.getModelo_carro()};
    }

    private String[] procesar_motor() {
        this.vistaSistema.mostrar_mensaje("\n--- Datos del Motor ---");
        String serieMotor = this.vistaMotor.tomar_numero_serie();
        String tipoMotor = this.vistaMotor.tomar_tipo();
        String cilindraje = this.vistaMotor.tomar_cilindraje();
        MotorModelo objMotor = new MotorModelo(serieMotor, tipoMotor, cilindraje);

        while (!objMotor.validar_numero_serie().equals("OK") || !objMotor.validar_tipo().equals("OK") || !objMotor.validar_cilindraje().equals("OK")) {
            this.vistaMotor.mostrar_mensaje("Error: Datos del motor incompletos o invalidos.");
            if (!objMotor.validar_numero_serie().equals("OK")) {
                this.vistaMotor.mostrar_mensaje(objMotor.validar_numero_serie());
                objMotor.setNumero_serie_motor(this.vistaMotor.tomar_numero_serie());
            }
            if (!objMotor.validar_tipo().equals("OK")) {
                this.vistaMotor.mostrar_mensaje(objMotor.validar_tipo());
                objMotor.setTipo_motor(this.vistaMotor.tomar_tipo());
            }
            if (!objMotor.validar_cilindraje().equals("OK")) {
                this.vistaMotor.mostrar_mensaje(objMotor.validar_cilindraje());
                objMotor.setCilindraje(this.vistaMotor.tomar_cilindraje());
            }
        }
        return new String[]{objMotor.getNumero_serie_motor(), objMotor.getTipo_motor(), objMotor.getCilindraje()};
    }

    private String[] modificar_motor(String serie) {
        this.vistaSistema.mostrar_mensaje("\n--- Modificando Motor (Serie Inmutable: " + serie + ") ---");
        String tipoMotor = this.vistaMotor.tomar_tipo();
        String cilindraje = this.vistaMotor.tomar_cilindraje();
        MotorModelo objMotor = new MotorModelo(serie, tipoMotor, cilindraje);

        while (!objMotor.validar_tipo().equals("OK") || !objMotor.validar_cilindraje().equals("OK")) {
            this.vistaMotor.mostrar_mensaje("Error: Datos del motor incompletos o invalidos.");
            if (!objMotor.validar_tipo().equals("OK")) {
                this.vistaMotor.mostrar_mensaje(objMotor.validar_tipo());
                objMotor.setTipo_motor(this.vistaMotor.tomar_tipo());
            }
            if (!objMotor.validar_cilindraje().equals("OK")) {
                this.vistaMotor.mostrar_mensaje(objMotor.validar_cilindraje());
                objMotor.setCilindraje(this.vistaMotor.tomar_cilindraje());
            }
        }
        return new String[]{objMotor.getNumero_serie_motor(), objMotor.getTipo_motor(), objMotor.getCilindraje()};
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
        return objChofer;
    }

    private ChoferModelo modificar_chofer(String cedula) {
        this.vistaSistema.mostrar_mensaje("\n--- Modificando Chofer (CI Inmutable: " + cedula + ") ---");
        String nombreChofer = this.vistaChofer.tomar_nombre();
        String licenciaChofer = this.vistaChofer.tomar_licencia();
        ChoferModelo objChofer = new ChoferModelo(cedula, nombreChofer, licenciaChofer);

        while (!objChofer.validar_nombre().equals("OK") || !objChofer.validar_licencia().equals("OK")) {
            this.vistaChofer.mostrar_mensaje("Error: Datos del chofer incompletos o invalidos.");
            if (!objChofer.validar_nombre().equals("OK")) {
                this.vistaChofer.mostrar_mensaje(objChofer.validar_nombre());
                objChofer.setNombre_chofer(this.vistaChofer.tomar_nombre());
            }
            if (!objChofer.validar_licencia().equals("OK")) {
                this.vistaChofer.mostrar_mensaje(objChofer.validar_licencia());
                objChofer.setLicencia_chofer(this.vistaChofer.tomar_licencia());
            }
        }
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
        return objPasajero;
    }

    private PasajeroModelo modificar_pasajero(String cedula) {
        this.vistaSistema.mostrar_mensaje("\n--- Modificando Pasajero (CI Inmutable: " + cedula + ") ---");
        String nombrePasajero = this.vistaPasajero.tomar_nombre();
        PasajeroModelo objPasajero = new PasajeroModelo(cedula, nombrePasajero);

        while (!objPasajero.validar_nombre().equals("OK")) {
            this.vistaPasajero.mostrar_mensaje("Error: Datos del pasajero incompletos o invalidos.");
            if (!objPasajero.validar_nombre().equals("OK")) {
                this.vistaPasajero.mostrar_mensaje(objPasajero.validar_nombre());
                objPasajero.setNombre_pasajero(this.vistaPasajero.tomar_nombre());
            }
        }
        return objPasajero;
    }
}
