package Modelo;

public class ChoferModelo {

    // inicializamos variables
    String nombre_chofer = "";
    String apellido_chofer = "";
    String cedula_chofer = "";

    // constructor
    public ChoferModelo(String dato_nombre, String dato_apellido, String dato_cedula) {
        this.nombre_chofer = dato_nombre;
        this.apellido_chofer = dato_apellido;
        this.cedula_chofer = dato_cedula;
    }

    // getters y setters
    public String getNombre_chofer() {
        return nombre_chofer;
    }

    public void setNombre_chofer(String nombre_chofer) {
        this.nombre_chofer = nombre_chofer;
    }

    public String getApellido_chofer() {
        return apellido_chofer;
    }

    public void setApellido_chofer(String apellido_chofer) {
        this.apellido_chofer = apellido_chofer;
    }

    public String getCedula_chofer() {
        return cedula_chofer;
    }

    public void setCedula_chofer(String cedula_chofer) {
        this.cedula_chofer = cedula_chofer;
    }
    
    public void buscar_chofer (String info_cedula){
        System.out.println("Buscando chofer...");
    }
}
