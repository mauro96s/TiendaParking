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
    
    public String buscar_pasajero (String info_cedula){
        return "Buscando pasajero con cedula " + info_cedula + "...";
    }

    public boolean cedula_valida() {
        if (this.cedula_pasajero != null && !this.cedula_pasajero.trim().isEmpty()) {
            if (this.cedula_pasajero.matches("[0-9]+") && this.cedula_pasajero.length() == 10) {
                return true;
            }
        }
        return false;
    }

    public boolean nombre_valido() {
        if (this.nombre_pasajero != null && !this.nombre_pasajero.trim().isEmpty()) {
            if (this.nombre_pasajero.matches("[a-zA-Z áéíóúÁÉÍÓÚñÑ]+")) {
                return true;
            }
        }
        return false;
    }
}
