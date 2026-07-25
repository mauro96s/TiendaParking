package Modelo;

public class ChoferModelo {

    // inicializamos variables
    String nombre_chofer = "";
    String licencia_chofer = "";
    String cedula_chofer = "";

    // constructor
    public ChoferModelo(String dato_nombre, String dato_licencia, String dato_cedula) {
        this.nombre_chofer = dato_nombre;
        this.licencia_chofer = dato_licencia;
        this.cedula_chofer = dato_cedula;
    }

    // getters y setters
    public String getNombre_chofer() {
        return nombre_chofer;
    }

    public void setNombre_chofer(String nombre_chofer) {
        this.nombre_chofer = nombre_chofer;
    }

    public String getLicencia_chofer() {
        return licencia_chofer;
    }

    public void setLicencia_chofer(String licencia_chofer) {
        this.licencia_chofer = licencia_chofer;
    }

    public String getCedula_chofer() {
        return cedula_chofer;
    }

    public void setCedula_chofer(String cedula_chofer) {
        this.cedula_chofer = cedula_chofer;
    }

    public String buscar_chofer(String info_cedula) {
        return "Buscando chofer con cedula " + info_cedula + "...";
    }

    // metodos de responsabilidad
    // son los que van directamente con los datos de la base de datos
    // ... son los atributos --> reglas del negocio
    // 1. la cedula sea valida
    // 2. validar licencia
    // 3. validar nombre y apellidos

    public boolean nombre_valido() {
        if (this.nombre_chofer != null && !this.nombre_chofer.trim().isEmpty()) {
            if (this.nombre_chofer.matches("[a-zA-Z áéíóúÁÉÍÓÚñÑ]+")) {
                return true;
            }
        }
        return false;
    }

    public boolean licencia_valida() {
        if (this.licencia_chofer != null && !this.licencia_chofer.trim().isEmpty()) {
            if (this.licencia_chofer.length() >= 3) {
                return true;
            }
        }
        return false;
    }

    public boolean cedula_valida() {
        if (this.cedula_chofer != null && !this.cedula_chofer.trim().isEmpty()) {
            if (this.cedula_chofer.matches("[0-9]+") && this.cedula_chofer.length() == 10) {
                return true;
            }
        }
        return false;
    }
}
