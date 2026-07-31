package controlador;

import modelo.ApiModelo;
import modelo.FichaViajeModelo;
import modelo.MotorModelo;
import vista.MotorVista;
import vista.SistemaVista;

public class MotorControlador {
    private SistemaVista vistaSistema;
    private MotorVista vistaMotor;
    private ApiModelo apiModelo;

    public MotorControlador(SistemaVista vistaSistema, MotorVista vistaMotor, ApiModelo apiModelo) {
        this.vistaSistema = vistaSistema;
        this.vistaMotor = vistaMotor;
        this.apiModelo = apiModelo;
    }

    public void gestionarMotores() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomarOpcionSubmenu("Motores");
            if (op.equals("1")) {
                if (esMatrizLlenaMotos()) {
                    this.vistaMotor.mostrarMensaje("Error: Limite maximo alcanzado. No hay espacio para mas motores.");
                    continue;
                }
                String[] motor = procesarMotor();
                if (this.apiModelo.crearMotor(motor)) {
                    this.vistaMotor.mostrarMensaje("Motor guardado exitosamente.");
                }
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (esMatrizVaciaMotos()) {
                    this.vistaMotor.mostrarMensaje("La lista de Motores esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaMotor.mostrarEncabezadoLista();
                    String[][] matriz = this.apiModelo.getListaMotores();
                    for (int i = 0; i < 3; i++) {
                        if (matriz[i][0] != null) {
                            MotorModelo tempMotor = new MotorModelo(matriz[i][0], matriz[i][1], matriz[i][2]);
                            this.vistaMotor.mostrarMensaje(tempMotor.obtenerInfo());
                        }
                    }
                } else if (op.equals("3")) {
                    this.vistaMotor.mostrarEncabezadoModificar();
                    String serie = this.vistaMotor.tomarNumeroSerie();
                    if (this.apiModelo.leerMotor(serie) != null) {
                        String[] nuevo = modificarMotor(serie);
                        this.apiModelo.actualizarMotor(serie, nuevo);
                        this.vistaMotor.mostrarMensaje("Motor modificado exitosamente.");
                    } else {
                        this.vistaMotor.mostrarMensaje("Error: Motor no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaMotor.mostrarEncabezadoEliminar();
                    String serie = this.vistaMotor.tomarNumeroSerie();
                    if (this.apiModelo.leerMotor(serie) != null) {
                        if (estaEnUsoMotor(serie)) {
                            this.vistaMotor.mostrarMensaje("Error: No se puede eliminar. El motor esta asociado a una ficha de viaje.");
                        } else {
                            this.apiModelo.eliminarMotor(serie);
                            this.vistaMotor.mostrarMensaje("Motor eliminado exitosamente.");
                        }
                    } else {
                        this.vistaMotor.mostrarMensaje("Error: Motor no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaMotor.mostrarMensaje("Opcion invalida.");
            }
        }
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

    private boolean estaEnUsoMotor(String serie) {
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            if (f.getMotor().getNumeroSerieMotor().equals(serie)) return true;
        }
        return false;
    }

    private String[] procesarMotor() {
        this.vistaMotor.mostrarEncabezadoRegistro();
        String serieMotor = this.vistaMotor.tomarNumeroSerie();
        String tipoMotor = this.vistaMotor.tomarTipo();
        String cilindraje = this.vistaMotor.tomarCilindraje();
        
        MotorModelo objMotor = new MotorModelo(serieMotor, tipoMotor, cilindraje);

        while (!objMotor.validarNumeroSerie().equals("OK") || !objMotor.validarTipo().equals("OK") || !objMotor.validarCilindraje().equals("OK")) {
            this.vistaMotor.mostrarMensaje("Error: Datos del motor incompletos o invalidos.");
            if (!objMotor.validarNumeroSerie().equals("OK")) {
                this.vistaMotor.mostrarMensaje(objMotor.validarNumeroSerie());
                objMotor.setNumeroSerieMotor(this.vistaMotor.tomarNumeroSerie());
            }
            if (!objMotor.validarTipo().equals("OK")) {
                this.vistaMotor.mostrarMensaje(objMotor.validarTipo());
                objMotor.setTipoMotor(this.vistaMotor.tomarTipo());
            }
            if (!objMotor.validarCilindraje().equals("OK")) {
                this.vistaMotor.mostrarMensaje(objMotor.validarCilindraje());
                objMotor.setCilindraje(this.vistaMotor.tomarCilindraje());
            }
        }
        return new String[]{objMotor.getNumeroSerieMotor(), objMotor.getTipoMotor(), objMotor.getCilindraje()};
    }

    private String[] modificarMotor(String serie) {
        this.vistaMotor.mostrarEncabezadoActualizando(serie);
        String tipoMotor = this.vistaMotor.tomarTipo();
        String cilindraje = this.vistaMotor.tomarCilindraje();
        
        MotorModelo objMotor = new MotorModelo(serie, tipoMotor, cilindraje);

        while (!objMotor.validarTipo().equals("OK") || !objMotor.validarCilindraje().equals("OK")) {
            this.vistaMotor.mostrarMensaje("Error: Datos del motor incompletos o invalidos.");
            if (!objMotor.validarTipo().equals("OK")) {
                this.vistaMotor.mostrarMensaje(objMotor.validarTipo());
                objMotor.setTipoMotor(this.vistaMotor.tomarTipo());
            }
            if (!objMotor.validarCilindraje().equals("OK")) {
                this.vistaMotor.mostrarMensaje(objMotor.validarCilindraje());
                objMotor.setCilindraje(this.vistaMotor.tomarCilindraje());
            }
        }
        return new String[]{objMotor.getNumeroSerieMotor(), objMotor.getTipoMotor(), objMotor.getCilindraje()};
    }
}
