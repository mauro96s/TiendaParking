package controlador;

import modelo.ApiModelo;
import modelo.ChoferModelo;
import modelo.FichaViajeModelo;
import vista.ChoferVista;
import vista.SistemaVista;

public class ChoferControlador {
    private SistemaVista vistaSistema;
    private ChoferVista vistaChofer;
    private ApiModelo apiModelo;

    public ChoferControlador(SistemaVista vistaSistema, ChoferVista vistaChofer, ApiModelo apiModelo) {
        this.vistaSistema = vistaSistema;
        this.vistaChofer = vistaChofer;
        this.apiModelo = apiModelo;
    }

    public void gestionarChoferes() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomarOpcionSubmenu("Choferes");
            if (op.equals("1")) {
                ChoferModelo chofer = procesarChofer();
                this.apiModelo.crearChofer(chofer);
                this.vistaChofer.mostrarMensaje("Chofer guardado exitosamente.");
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (this.apiModelo.getListaChoferes().isEmpty()) {
                    this.vistaChofer.mostrarMensaje("La lista de Choferes esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaChofer.mostrarEncabezadoLista();
                    for (ChoferModelo ch : this.apiModelo.getListaChoferes()) {
                        this.vistaChofer.mostrarMensaje(ch.obtenerInfo());
                    }
                } else if (op.equals("3")) {
                    this.vistaChofer.mostrarEncabezadoModificar();
                    String cedula = this.vistaChofer.tomarCedula();
                    if (this.apiModelo.leerChofer(cedula) != null) {
                        ChoferModelo nuevo = modificarChofer(cedula);
                        this.apiModelo.actualizarChofer(cedula, nuevo);
                        this.vistaChofer.mostrarMensaje("Chofer modificado exitosamente.");
                    } else {
                        this.vistaChofer.mostrarMensaje("Error: Chofer no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaChofer.mostrarEncabezadoEliminar();
                    String cedula = this.vistaChofer.tomarCedula();
                    if (this.apiModelo.leerChofer(cedula) != null) {
                        if (estaEnUsoChofer(cedula)) {
                            this.vistaChofer.mostrarMensaje("Error: No se puede eliminar. El chofer esta asociado a una ficha de viaje.");
                        } else {
                            this.apiModelo.eliminarChofer(cedula);
                            this.vistaChofer.mostrarMensaje("Chofer eliminado exitosamente.");
                        }
                    } else {
                        this.vistaChofer.mostrarMensaje("Error: Chofer no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaChofer.mostrarMensaje("Opcion invalida.");
            }
        }
    }

    private boolean estaEnUsoChofer(String cedula) {
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            if (f.getChofer().getCedulaChofer().equals(cedula)) return true;
        }
        return false;
    }

    private ChoferModelo procesarChofer() {
        this.vistaChofer.mostrarEncabezadoRegistro();
        String cedulaChofer = this.vistaChofer.tomarCedula();
        String nombreChofer = this.vistaChofer.tomarNombre();
        String licenciaChofer = this.vistaChofer.tomarLicencia();
        ChoferModelo objChofer = new ChoferModelo(cedulaChofer, nombreChofer, licenciaChofer);

        while (!objChofer.validarCedula().equals("OK") || !objChofer.validarNombre().equals("OK") || !objChofer.validarLicencia().equals("OK")) {
            this.vistaChofer.mostrarMensaje("Error: Datos del chofer incompletos o invalidos.");
            if (!objChofer.validarCedula().equals("OK")) {
                this.vistaChofer.mostrarMensaje(objChofer.validarCedula());
                objChofer.setCedulaChofer(this.vistaChofer.tomarCedula());
            }
            if (!objChofer.validarNombre().equals("OK")) {
                this.vistaChofer.mostrarMensaje(objChofer.validarNombre());
                objChofer.setNombreChofer(this.vistaChofer.tomarNombre());
            }
            if (!objChofer.validarLicencia().equals("OK")) {
                this.vistaChofer.mostrarMensaje(objChofer.validarLicencia());
                objChofer.setLicenciaChofer(this.vistaChofer.tomarLicencia());
            }
        }
        return objChofer;
    }

    private ChoferModelo modificarChofer(String cedula) {
        this.vistaChofer.mostrarEncabezadoActualizando(cedula);
        String nombreChofer = this.vistaChofer.tomarNombre();
        String licenciaChofer = this.vistaChofer.tomarLicencia();
        ChoferModelo objChofer = new ChoferModelo(cedula, nombreChofer, licenciaChofer);

        while (!objChofer.validarNombre().equals("OK") || !objChofer.validarLicencia().equals("OK")) {
            this.vistaChofer.mostrarMensaje("Error: Datos del chofer incompletos o invalidos.");
            if (!objChofer.validarNombre().equals("OK")) {
                this.vistaChofer.mostrarMensaje(objChofer.validarNombre());
                objChofer.setNombreChofer(this.vistaChofer.tomarNombre());
            }
            if (!objChofer.validarLicencia().equals("OK")) {
                this.vistaChofer.mostrarMensaje(objChofer.validarLicencia());
                objChofer.setLicenciaChofer(this.vistaChofer.tomarLicencia());
            }
        }
        return objChofer;
    }
}
