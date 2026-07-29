package Modelo;

import java.util.ArrayList;
import java.util.List;

public class ApiModelo {

    String clave = "";
    String root = "";
    String url = "";
    CarroModelo[][] matrizCarros;
    List<ChoferModelo> listaChoferes;
    List<PasajeroModelo> listaPasajeros;
    List<FichaViajeModelo> listaViajes;

    public ApiModelo(String url, String usuario, String clave) {
        this.clave = clave;
        this.root = usuario;
        this.url = url;
        this.matrizCarros = new CarroModelo[3][3];
        this.listaChoferes = new ArrayList<>();
        this.listaPasajeros = new ArrayList<>();
        this.listaViajes = new ArrayList<>();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean validar_conexion() {
        if (this.clave.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }

    public String desconexion() {
        return "Desconexion realizada...";
    }

    public boolean validar_registro(FichaViajeModelo ficha) {
        if (ficha != null && ficha.getCarro() != null && ficha.getCarro().getMotor() != null &&
                ficha.getChofer() != null && ficha.getPasajero() != null) {
            return true;
        }
        return false;
    }

    // CRUD para Vehiculo (Carro + Motor) (Matriz 3x3)
    public boolean crearCarro(CarroModelo carro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] == null) {
                    matrizCarros[i][j] = carro;
                    return true;
                }
            }
        }
        return false;
    }

    public CarroModelo leerCarro(String placa) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] != null && matrizCarros[i][j].getPlaca_carro().equals(placa)) {
                    return matrizCarros[i][j];
                }
            }
        }
        return null;
    }

    public boolean actualizarCarro(String placa, CarroModelo nuevoCarro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] != null && matrizCarros[i][j].getPlaca_carro().equals(placa)) {
                    matrizCarros[i][j] = nuevoCarro;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean eliminarCarro(String placa) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] != null && matrizCarros[i][j].getPlaca_carro().equals(placa)) {
                    matrizCarros[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }
    
    public CarroModelo[][] getMatrizCarros() {
        return matrizCarros;
    }

    // CRUD para Chofer (List Dinamica)
    public boolean crearChofer(ChoferModelo chofer) {
        return listaChoferes.add(chofer);
    }

    public ChoferModelo leerChofer(String cedula) {
        for (ChoferModelo chofer : listaChoferes) {
            if (chofer.getCedula_chofer().equals(cedula)) {
                return chofer;
            }
        }
        return null;
    }

    public boolean actualizarChofer(String cedula, ChoferModelo nuevoChofer) {
        for (int i = 0; i < listaChoferes.size(); i++) {
            if (listaChoferes.get(i).getCedula_chofer().equals(cedula)) {
                listaChoferes.set(i, nuevoChofer);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarChofer(String cedula) {
        return listaChoferes.removeIf(chofer -> chofer.getCedula_chofer().equals(cedula));
    }
    
    public List<ChoferModelo> getListaChoferes() {
        return listaChoferes;
    }

    // CRUD para Pasajero (List Dinamica)
    public boolean crearPasajero(PasajeroModelo pasajero) {
        return listaPasajeros.add(pasajero);
    }

    public PasajeroModelo leerPasajero(String cedula) {
        for (PasajeroModelo pasajero : listaPasajeros) {
            if (pasajero.getCedula_pasajero().equals(cedula)) {
                return pasajero;
            }
        }
        return null;
    }

    public boolean actualizarPasajero(String cedula, PasajeroModelo nuevoPasajero) {
        for (int i = 0; i < listaPasajeros.size(); i++) {
            if (listaPasajeros.get(i).getCedula_pasajero().equals(cedula)) {
                listaPasajeros.set(i, nuevoPasajero);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPasajero(String cedula) {
        return listaPasajeros.removeIf(pasajero -> pasajero.getCedula_pasajero().equals(cedula));
    }
    
    public List<PasajeroModelo> getListaPasajeros() {
        return listaPasajeros;
    }
    
    // CRUD para Viajes (List Dinamica)
    public boolean crearViaje(FichaViajeModelo ficha) {
        return listaViajes.add(ficha);
    }
    
    public List<FichaViajeModelo> getListaViajes() {
        return listaViajes;
    }
}
