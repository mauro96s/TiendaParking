package modelo;

public class MotorModelo {

    private String numeroSerieMotor = "";
    private String tipoMotor = "";
    private String cilindraje = "";

    public MotorModelo(String datoNumeroSerie, String datoTipo, String datoCilindraje) {
        this.numeroSerieMotor = datoNumeroSerie;
        this.tipoMotor = datoTipo;
        this.cilindraje = datoCilindraje;
    }

    public String getNumeroSerieMotor() {
        return numeroSerieMotor;
    }

    public void setNumeroSerieMotor(String numeroSerieMotor) {
        this.numeroSerieMotor = numeroSerieMotor;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String validarNumeroSerie() {
        if (this.numeroSerieMotor == null || this.numeroSerieMotor.trim().isEmpty()) {
            return "-> El numero de serie no puede estar vacio.";
        }
        if (this.numeroSerieMotor.trim().length() < 3) {
            return "-> El numero de serie debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validarTipo() {
        if (this.tipoMotor == null || this.tipoMotor.trim().isEmpty()) {
            return "-> El tipo de motor no puede estar vacio.";
        }
        if (this.tipoMotor.trim().length() < 3) {
            return "-> El tipo de motor debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validarCilindraje() {
        if (this.cilindraje == null || this.cilindraje.trim().isEmpty()) {
            return "-> El cilindraje no puede estar vacio.";
        }
        if (this.cilindraje.trim().length() < 2) {
            return "-> El cilindraje debe tener al menos 2 caracteres.";
        }
        return "OK";
    }

    public String obtenerInfo() {
        return "Serie: " + this.numeroSerieMotor + " | Tipo: " + this.tipoMotor + " | Cilindraje: " + this.cilindraje;
    }
}
