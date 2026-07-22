package Modelo;

public class MotorModelo {

    String numero_serie_motor = "";
    String tipo_motor = "";

    public MotorModelo(String dato_numero_serie, String dato_tipo) {
        this.numero_serie_motor = dato_numero_serie;
        this.tipo_motor = dato_tipo;
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

    public String buscar_motor(String info_numero_serie){
        return "Buscando motor con serie " + info_numero_serie + "...";
    }

    public boolean numero_serie_valido() {
        if (this.numero_serie_motor != null && !this.numero_serie_motor.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean tipo_valido() {
        if (this.tipo_motor != null && !this.tipo_motor.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
