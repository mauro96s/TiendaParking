package modelo;

public class PasajeroModelo {

    private String cedulaPasajero = "";
    private String nombrePasajero = "";

    public PasajeroModelo(String datoCedula, String datoNombre) {
        this.cedulaPasajero = datoCedula;
        this.nombrePasajero = datoNombre;
    }

    public String getCedulaPasajero() {
        return cedulaPasajero;
    }

    public void setCedulaPasajero(String cedulaPasajero) {
        this.cedulaPasajero = cedulaPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String validarCedula() {
        if (this.cedulaPasajero == null || this.cedulaPasajero.trim().isEmpty()) {
            return "-> La cedula no puede estar vacia.";
        }
        if (!this.cedulaPasajero.matches("[0-9]+")) {
            return "-> La cedula solo debe contener numeros.";
        }
        if (this.cedulaPasajero.length() < 8 || this.cedulaPasajero.length() > 10) {
            return "-> La cedula debe tener entre 8 y 10 digitos.";
        }
        return "OK";
    }

    public String validarNombre() {
        if (this.nombrePasajero == null || this.nombrePasajero.trim().isEmpty()) {
            return "-> El nombre no puede estar vacio.";
        }
        if (!this.nombrePasajero.matches("[a-zA-Z áéíóúÁÉÍÓÚñÑ]+")) {
            return "-> El nombre solo puede contener letras y espacios.";
        }
        return "OK";
    }

    public String obtenerInfo() {
        return "CI: " + this.cedulaPasajero + " | Nombre: " + this.nombrePasajero;
    }
}
