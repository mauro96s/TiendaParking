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
    
    public void buscar_pasajero (String info_cedula){
        System.out.println("Buscando pasajero...");
    }
}
