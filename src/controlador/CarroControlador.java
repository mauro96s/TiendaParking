package controlador;

import modelo.ApiModelo;
import modelo.CarroModelo;
import modelo.FichaViajeModelo;
import vista.CarroVista;
import vista.SistemaVista;

public class CarroControlador {
    private SistemaVista vistaSistema;
    private CarroVista vistaCarro;
    private ApiModelo apiModelo;

    public CarroControlador(SistemaVista vistaSistema, CarroVista vistaCarro, ApiModelo apiModelo) {
        this.vistaSistema = vistaSistema;
        this.vistaCarro = vistaCarro;
        this.apiModelo = apiModelo;
    }

    public void gestionarCarros() {
        boolean volver = false;
        while (!volver) {
            String op = this.vistaSistema.tomarOpcionSubmenu("Carros");
            if (op.equals("1")) {
                if (esMatrizLlenaCarros()) {
                    this.vistaCarro.mostrarMensaje("Error: Limite maximo alcanzado. No hay espacio para mas carros.");
                    continue;
                }
                String[] carro = procesarCarro();
                if (this.apiModelo.crearCarro(carro)) {
                    this.vistaCarro.mostrarMensaje("Carro guardado exitosamente.");
                }
            } else if (op.equals("2") || op.equals("3") || op.equals("4")) {
                if (esMatrizVaciaCarros()) {
                    this.vistaCarro.mostrarMensaje("La lista de Carros esta vacia.");
                    continue;
                }
                
                if (op.equals("2")) {
                    this.vistaCarro.mostrarEncabezadoLista();
                    String[][] matriz = this.apiModelo.getListaCarros();
                    for (int i = 0; i < 3; i++) {
                        if (matriz[i][0] != null) {
                            CarroModelo tempCarro = new CarroModelo(matriz[i][0], matriz[i][1], matriz[i][2]);
                            this.vistaCarro.mostrarMensaje(tempCarro.obtenerInfo());
                        }
                    }
                } else if (op.equals("3")) {
                    this.vistaCarro.mostrarEncabezadoModificar();
                    String placa = this.vistaCarro.tomarPlaca();
                    if (this.apiModelo.leerCarro(placa) != null) {
                        String[] nuevo = modificarCarro(placa);
                        this.apiModelo.actualizarCarro(placa, nuevo);
                        this.vistaCarro.mostrarMensaje("Carro modificado exitosamente.");
                    } else {
                        this.vistaCarro.mostrarMensaje("Error: Carro no encontrado.");
                    }
                } else if (op.equals("4")) {
                    this.vistaCarro.mostrarEncabezadoEliminar();
                    String placa = this.vistaCarro.tomarPlaca();
                    if (this.apiModelo.leerCarro(placa) != null) {
                        if (estaEnUsoCarro(placa)) {
                            this.vistaCarro.mostrarMensaje("Error: No se puede eliminar. El carro esta asociado a una ficha de viaje.");
                        } else {
                            this.apiModelo.eliminarCarro(placa);
                            this.vistaCarro.mostrarMensaje("Carro eliminado exitosamente.");
                        }
                    } else {
                        this.vistaCarro.mostrarMensaje("Error: Carro no encontrado.");
                    }
                }
            } else if (op.equals("5")) {
                volver = true;
            } else {
                this.vistaCarro.mostrarMensaje("Opcion invalida.");
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

    private boolean estaEnUsoCarro(String placa) {
        for (FichaViajeModelo f : this.apiModelo.getListaViajes()) {
            if (f.getCarro().getPlacaCarro().equals(placa)) return true;
        }
        return false;
    }

    private String[] procesarCarro() {
        this.vistaCarro.mostrarEncabezadoRegistro();
        String placaCarro = this.vistaCarro.tomarPlaca();
        String marcaCarro = this.vistaCarro.tomarMarca();
        String modeloCarro = this.vistaCarro.tomarModelo();
        
        CarroModelo objCarro = new CarroModelo(placaCarro, marcaCarro, modeloCarro);

        while (!objCarro.validarPlaca().equals("OK") || !objCarro.validarMarca().equals("OK") || !objCarro.validarModelo().equals("OK")) {
            this.vistaCarro.mostrarMensaje("Error: Datos del carro incompletos o invalidos.");
            if (!objCarro.validarPlaca().equals("OK")) {
                this.vistaCarro.mostrarMensaje(objCarro.validarPlaca());
                objCarro.setPlacaCarro(this.vistaCarro.tomarPlaca());
            }
            if (!objCarro.validarMarca().equals("OK")) {
                this.vistaCarro.mostrarMensaje(objCarro.validarMarca());
                objCarro.setMarcaCarro(this.vistaCarro.tomarMarca());
            }
            if (!objCarro.validarModelo().equals("OK")) {
                this.vistaCarro.mostrarMensaje(objCarro.validarModelo());
                objCarro.setModeloCarro(this.vistaCarro.tomarModelo());
            }
        }
        return new String[]{objCarro.getPlacaCarro(), objCarro.getMarcaCarro(), objCarro.getModeloCarro()};
    }

    private String[] modificarCarro(String placa) {
        this.vistaCarro.mostrarEncabezadoActualizando(placa);
        String marcaCarro = this.vistaCarro.tomarMarca();
        String modeloCarro = this.vistaCarro.tomarModelo();
        
        CarroModelo objCarro = new CarroModelo(placa, marcaCarro, modeloCarro);

        while (!objCarro.validarMarca().equals("OK") || !objCarro.validarModelo().equals("OK")) {
            this.vistaCarro.mostrarMensaje("Error: Datos del carro incompletos o invalidos.");
            if (!objCarro.validarMarca().equals("OK")) {
                this.vistaCarro.mostrarMensaje(objCarro.validarMarca());
                objCarro.setMarcaCarro(this.vistaCarro.tomarMarca());
            }
            if (!objCarro.validarModelo().equals("OK")) {
                this.vistaCarro.mostrarMensaje(objCarro.validarModelo());
                objCarro.setModeloCarro(this.vistaCarro.tomarModelo());
            }
        }
        return new String[]{objCarro.getPlacaCarro(), objCarro.getMarcaCarro(), objCarro.getModeloCarro()};
    }
}
