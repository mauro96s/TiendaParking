package Modelo;

public class MotorModelo {

    String numero_serie_motor = "";
    String tipo_motor = "";
    String cilindraje = "";

    public MotorModelo(String dato_numero_serie, String dato_tipo, String dato_cilindraje) {
        this.numero_serie_motor = dato_numero_serie;
        this.tipo_motor = dato_tipo;
        this.cilindraje = dato_cilindraje;
    }

    public String getNumero_serie_motor() {
        return numero_serie_motor;
    }

    public void setNumero_serie_motor(String numero_serie_motor) {
        this.numero_serie_motor = numero_serie_motor;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String validar_numero_serie() {
        if (this.numero_serie_motor == null || this.numero_serie_motor.trim().isEmpty()) {
            return "-> El numero de serie no puede estar vacio.";
        }
        if (this.numero_serie_motor.trim().length() < 3) {
            return "-> El numero de serie debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validar_tipo() {
        if (this.tipo_motor == null || this.tipo_motor.trim().isEmpty()) {
            return "-> El tipo de motor no puede estar vacio.";
        }
        if (this.tipo_motor.trim().length() < 3) {
            return "-> El tipo de motor debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validar_cilindraje() {
        if (this.cilindraje == null || this.cilindraje.trim().isEmpty()) {
            return "-> El cilindraje no puede estar vacio.";
        }
        if (this.cilindraje.trim().length() < 2) {
            return "-> El cilindraje debe tener al menos 2 caracteres.";
        }
        return "OK";
    }

    public String obtener_info() {
        return "Serie: " + this.numero_serie_motor + " | Tipo: " + this.tipo_motor + " | Cilindraje: " + this.cilindraje;
    }
}
