package controlador;

import modelo.ApiModelo;
import modelo.FichaViajeModelo;
import modelo.PasajeroModelo;
import vista.PasajeroVista;
import vista.SistemaVista;

public class PasajeroControlador {
    private SistemaVista vistaSistema;
    private PasajeroVista vistaPasajero;
    private ApiModelo apiModelo;

    public PasajeroControlador(SistemaVista vistaSistema, PasajeroVista vistaPasajero, ApiModelo apiModelo) {
        this.vistaSistema = vistaSistema;
        this.vistaPasajero = vistaPasajero;
        this.apiModelo = apiModelo;
    }

    public void gestionarPasajeros() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomarOpcionSubmenu("Pasajeros");
            if (op.equals("1")) {
                PasajeroModelo pasajero = procesarPasajero();
                this.apiModelo.crearPasajero(pasajero);
                this.vistaPasajero.mostrarMensaje("Pasajero guardado exitosamente.");
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (this.apiModelo.getListaPasajeros().isEmpty()) {
                    this.vistaPasajero.mostrarMensaje("La lista de Pasajeros esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaPasajero.mostrarEncabezadoLista();
                    for (PasajeroModelo p : this.apiModelo.getListaPasajeros()) {
                        this.vistaPasajero.mostrarMensaje(p.obtenerInfo());
                    }
                } else if (op.equals("3")) {
                    this.vistaPasajero.mostrarEncabezadoModificar();
                    String cedula = this.vistaPasajero.tomarCedula();
                    if (this.apiModelo.leerPasajero(cedula) != null) {
                        PasajeroModelo nuevo = modificarPasajero(cedula);
                        this.apiModelo.actualizarPasajero(cedula, nuevo);
                        this.vistaPasajero.mostrarMensaje("Pasajero modificado exitosamente.");
                    } else {
                        this.vistaPasajero.mostrarMensaje("Error: Pasajero no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaPasajero.mostrarEncabezadoEliminar();
                    String cedula = this.vistaPasajero.tomarCedula();
                    if (this.apiModelo.leerPasajero(cedula) != null) {
                        if (estaEnUsoPasajero(cedula)) {
                            this.vistaPasajero.mostrarMensaje("Error: No se puede eliminar. El pasajero esta asociado a una ficha de viaje.");
                        } else {
                            this.apiModelo.eliminarPasajero(cedula);
                            this.vistaPasajero.mostrarMensaje("Pasajero eliminado exitosamente.");
                        }
                    } else {
                        this.vistaPasajero.mostrarMensaje("Error: Pasajero no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaPasajero.mostrarMensaje("Opcion invalida.");
            }
        }
    }

    private boolean estaEnUsoPasajero(String cedula) {
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            if (f.getPasajero().getCedulaPasajero().equals(cedula)) return true;
        }
        return false;
    }

    private PasajeroModelo procesarPasajero() {
        this.vistaPasajero.mostrarEncabezadoRegistro();
        String cedulaPasajero = this.vistaPasajero.tomarCedula();
        String nombrePasajero = this.vistaPasajero.tomarNombre();
        PasajeroModelo objPasajero = new PasajeroModelo(cedulaPasajero, nombrePasajero);

        while (!objPasajero.validarCedula().equals("OK") || !objPasajero.validarNombre().equals("OK")) {
            this.vistaPasajero.mostrarMensaje("Error: Datos del pasajero incompletos o invalidos.");
            if (!objPasajero.validarCedula().equals("OK")) {
                this.vistaPasajero.mostrarMensaje(objPasajero.validarCedula());
                objPasajero.setCedulaPasajero(this.vistaPasajero.tomarCedula());
            }
            if (!objPasajero.validarNombre().equals("OK")) {
                this.vistaPasajero.mostrarMensaje(objPasajero.validarNombre());
                objPasajero.setNombrePasajero(this.vistaPasajero.tomarNombre());
            }
        }
        return objPasajero;
    }

    private PasajeroModelo modificarPasajero(String cedula) {
        this.vistaPasajero.mostrarEncabezadoActualizando(cedula);
        String nombrePasajero = this.vistaPasajero.tomarNombre();
        PasajeroModelo objPasajero = new PasajeroModelo(cedula, nombrePasajero);

        while (!objPasajero.validarNombre().equals("OK")) {
            this.vistaPasajero.mostrarMensaje("Error: Datos del pasajero incompletos o invalidos.");
            if (!objPasajero.validarNombre().equals("OK")) {
                this.vistaPasajero.mostrarMensaje(objPasajero.validarNombre());
                objPasajero.setNombrePasajero(this.vistaPasajero.tomarNombre());
            }
        }
        return objPasajero;
    }
}
