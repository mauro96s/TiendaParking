package Modelo;

public class PasajeroModelo {

    String cedula_pasajero = "";
    String nombre_pasajero = "";

    public PasajeroModelo(String dato_cedula, String dato_nombre) {
        this.cedula_pasajero = dato_cedula;
        this.nombre_pasajero = dato_nombre;
    }

    public String getCedula_pasajero() {
        return cedula_pasajero;
    }

    public void setCedula_pasajero(String cedula_pasajero) {
        this.cedula_pasajero = cedula_pasajero;
    }

    public String getNombre_pasajero() {
        return nombre_pasajero;
    }

    public void setNombre_pasajero(String nombre_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
    }

    public String validar_cedula() {
        if (this.cedula_pasajero == null || this.cedula_pasajero.trim().isEmpty()) {
            return "-> La cedula no puede estar vacia.";
        }
        if (!this.cedula_pasajero.matches("[0-9]+")) {
            return "-> La cedula solo debe contener numeros.";
        }
        if (this.cedula_pasajero.length() < 8 || this.cedula_pasajero.length() > 10) {
            return "-> La cedula debe tener entre 8 y 10 digitos.";
        }
        return "OK";
    }

    public String validar_nombre() {
        if (this.nombre_pasajero == null || this.nombre_pasajero.trim().isEmpty()) {
            return "-> El nombre no puede estar vacio.";
        }
        if (!this.nombre_pasajero.matches("[a-zA-Z áéíóúÁÉÍÓÚñÑ]+")) {
            return "-> El nombre solo puede contener letras y espacios.";
        }
        return "OK";
    }

    public String obtener_info() {
        return "PASAJERO -> Nombre: " + this.nombre_pasajero + " | CI: " + this.cedula_pasajero;
    }
}
