package controlador;

import modelo.ApiModelo;
import modelo.CarroModelo;
import modelo.ChoferModelo;
import modelo.FichaViajeModelo;
import modelo.MotorModelo;
import modelo.PasajeroModelo;
import vista.SistemaVista;
import vista.FichaViajeVista;

public class FichaViajeControlador {
    private SistemaVista vistaSistema;
    private FichaViajeVista vistaViaje;
    private ApiModelo apiModelo;

    public FichaViajeControlador(SistemaVista vistaSistema, FichaViajeVista vistaViaje, ApiModelo apiModelo) {
        this.vistaSistema = vistaSistema;
        this.vistaViaje = vistaViaje;
        this.apiModelo = apiModelo;
    }

    public void gestionarViajes() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomarOpcionSubmenu("Fichas de Viaje");
            if (op.equals("1")) {
                generarViaje();
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (this.apiModelo.getListaViajes().isEmpty()) {
                    this.vistaSistema.mostrarMensaje("La lista de Viajes esta vacia.");
                    continue;
                }

                if (op.equals("2")) {
                    mostrarViajes();
                } else if (op.equals("3")) {
                    this.vistaViaje.mostrarMensaje(
                            "\nModificacion de viajes no disponible actualmente por reglas de negocio. Debes eliminar y recrear.");
                } else if (op.equals("4")) {
                    this.vistaViaje.mostrarEncabezadoEliminar();
                    String placa = this.vistaViaje.tomarPlacaEliminar();
                    boolean eliminado = this.apiModelo.getListaViajes()
                            .removeIf(v -> v.getCarro().getPlacaCarro().equals(placa));
                    if (eliminado) {
                        this.vistaViaje.mostrarMensaje("Viaje eliminado exitosamente.");
                    } else {
                        this.vistaViaje.mostrarMensaje("No se encontro viaje con esa placa.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaSistema.mostrarMensaje("Opcion invalida.");
            }
        }
    }

    private void generarViaje() {
        this.vistaViaje.mostrarEncabezadoGenerar();

        String placa = this.vistaViaje.tomarPlacaCarro();
        String[] carroData = this.apiModelo.leerCarro(placa);
        if (carroData == null) {
            this.vistaViaje.mostrarMensaje("Error: Carro no encontrado.");
            return;
        }
        CarroModelo carro = new CarroModelo(carroData[0], carroData[1], carroData[2]);

        String serie = this.vistaViaje.tomarSerieMotor();
        String[] motorData = this.apiModelo.leerMotor(serie);
        if (motorData == null) {
            this.vistaViaje.mostrarMensaje("Error: Motor no encontrado.");
            return;
        }
        MotorModelo motor = new MotorModelo(motorData[0], motorData[1], motorData[2]);

        String cedulaChofer = this.vistaViaje.tomarCedulaChofer();
        ChoferModelo chofer = this.apiModelo.leerChofer(cedulaChofer);
        if (chofer == null) {
            this.vistaViaje.mostrarMensaje("Error: Chofer no encontrado.");
            return;
        }

        String cedulaPasajero = this.vistaViaje.tomarCedulaPasajero();
        PasajeroModelo pasajero = this.apiModelo.leerPasajero(cedulaPasajero);
        if (pasajero == null) {
            this.vistaViaje.mostrarMensaje("Error: Pasajero no encontrado.");
            return;
        }

        FichaViajeModelo ficha = new FichaViajeModelo(carro, motor, chofer, pasajero);
        if (this.apiModelo.validarRegistro(ficha)) {
            this.apiModelo.crearViaje(ficha);
            this.vistaViaje.mostrarMensaje("Viaje registrado correctamente en la base de datos.");
        } else {
            this.vistaViaje.mostrarMensaje("Error: No se pudo registrar el viaje. Faltan datos criticos.");
        }
    }

    private void mostrarViajes() {
        this.vistaViaje.mostrarEncabezadoLista();
        int contador = 1;
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            this.vistaViaje.mostrarMensaje("\nVIAJE " + contador);
            this.vistaViaje.mostrarMensaje(f.obtenerInfo());
            contador++;
        }
    }
}
