package Modelo;

public class MotorModelo {

    String numero_serie_motor = "";
    String cilindraje_motor = "";
    String combustible_motor = "";

    public MotorModelo(String dato_numero_serie, String dato_cilindraje, String dato_combustible) {
        this.numero_serie_motor = dato_numero_serie;
        this.cilindraje_motor = dato_cilindraje;
        this.combustible_motor = dato_combustible;
    }

    public String getNumero_serie_motor() {
        return numero_serie_motor;
    }

    public void setNumero_serie_motor(String numero_serie_motor) {
        this.numero_serie_motor = numero_serie_motor;
    }

    public String getCilindraje_motor() {
        return cilindraje_motor;
    }

    public void setCilindraje_motor(String cilindraje_motor) {
        this.cilindraje_motor = cilindraje_motor;
    }

    public String getCombustible_motor() {
        return combustible_motor;
    }

    public void setCombustible_motor(String combustible_motor) {
        this.combustible_motor = combustible_motor;
    }
    
    public void buscar_motor(String info_numero_serie){
        System.out.println("Buscando motor...");
    }
}
