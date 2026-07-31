package modelo;

import java.util.ArrayList;
import java.util.List;

public class ApiModelo {

    private String clave = "";
    private String root = "";
    private String url = "";
    
    // listas estaticas
    private String[][] listaCarros;
    private String[][] listaMotor;
    
    // listas dinamicas
    private List<ChoferModelo> listaChoferes;
    private List<PasajeroModelo> listaPasajeros;
    private List<FichaViajeModelo> listaViajes;

    public ApiModelo(String url, String usuario, String clave) {
        this.clave = clave;
        this.root = usuario;
        this.url = url;
        this.listaCarros = new String[3][3];
        this.listaMotor = new String[3][3];
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

    public boolean validarRegistro(FichaViajeModelo ficha) {
        if (ficha != null && ficha.getCarro() != null && ficha.getMotor() != null &&
                ficha.getChofer() != null && ficha.getPasajero() != null) {
            return true;
        }
        return false;
    }

    // CRUD para Vehiculo (Carro) (Matriz 3x3 de Strings)
    public boolean crearCarro(String[] carroData) {
        for (int i = 0; i < 3; i++) {
            if (listaCarros[i][0] == null) {
                listaCarros[i] = carroData;
                return true;
            }
        }
        return false;
    }

    public String[] leerCarro(String placa) {
        for (int i = 0; i < 3; i++) {
            if (listaCarros[i][0] != null && listaCarros[i][0].equals(placa)) {
                return listaCarros[i];
            }
        }
        return null;
    }

    public boolean actualizarCarro(String placa, String[] nuevoCarroData) {
        for (int i = 0; i < 3; i++) {
            if (listaCarros[i][0] != null && listaCarros[i][0].equals(placa)) {
                listaCarros[i] = nuevoCarroData;
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCarro(String placa) {
        for (int i = 0; i < 3; i++) {
            if (listaCarros[i][0] != null && listaCarros[i][0].equals(placa)) {
                listaCarros[i] = new String[3]; // Vaciar la fila
                return true;
            }
        }
        return false;
    }
    
    public String[][] getListaCarros() {
        return listaCarros;
    }

    // CRUD para Moto (Matriz 3x3 de Strings)
    public boolean crearMotor(String[] motoData) {
        for (int i = 0; i < 3; i++) {
            if (listaMotor[i][0] == null) {
                listaMotor[i] = motoData;
                return true;
            }
        }
        return false;
    }

    public String[] leerMotor(String placa) {
        for (int i = 0; i < 3; i++) {
            if (listaMotor[i][0] != null && listaMotor[i][0].equals(placa)) {
                return listaMotor[i];
            }
        }
        return null;
    }

    public boolean actualizarMotor(String placa, String[] nuevoMotoData) {
        for (int i = 0; i < 3; i++) {
            if (listaMotor[i][0] != null && listaMotor[i][0].equals(placa)) {
                listaMotor[i] = nuevoMotoData;
                return true;
            }
        }
        return false;
    }

    public boolean eliminarMotor(String placa) {
        for (int i = 0; i < 3; i++) {
            if (listaMotor[i][0] != null && listaMotor[i][0].equals(placa)) {
                listaMotor[i] = new String[3]; // Vaciar la fila
                return true;
            }
        }
        return false;
    }
    
    public String[][] getListaMotores() {
        return listaMotor;
    }

    // CRUD para Chofer (List Dinamica)
    public boolean crearChofer(ChoferModelo chofer) {
        return listaChoferes.add(chofer);
    }

    public ChoferModelo leerChofer(String cedula) {
        for (ChoferModelo chofer : listaChoferes) {
            if (chofer.getCedulaChofer().equals(cedula)) {
                return chofer;
            }
        }
        return null;
    }

    public boolean actualizarChofer(String cedula, ChoferModelo nuevoChofer) {
        for (int i = 0; i < listaChoferes.size(); i++) {
            if (listaChoferes.get(i).getCedulaChofer().equals(cedula)) {
                listaChoferes.set(i, nuevoChofer);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarChofer(String cedula) {
        return listaChoferes.removeIf(chofer -> chofer.getCedulaChofer().equals(cedula));
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
            if (pasajero.getCedulaPasajero().equals(cedula)) {
                return pasajero;
            }
        }
        return null;
    }

    public boolean actualizarPasajero(String cedula, PasajeroModelo nuevoPasajero) {
        for (int i = 0; i < listaPasajeros.size(); i++) {
            if (listaPasajeros.get(i).getCedulaPasajero().equals(cedula)) {
                listaPasajeros.set(i, nuevoPasajero);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPasajero(String cedula) {
        return listaPasajeros.removeIf(pasajero -> pasajero.getCedulaPasajero().equals(cedula));
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
