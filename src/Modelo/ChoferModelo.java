package Modelo;

public class ChoferModelo {

    // inicializamos variables
    String cedula_chofer = "";
    String nombre_chofer = "";
    String licencia_chofer = "";

    // constructor
    public ChoferModelo(String dato_cedula, String dato_nombre, String dato_licencia) {
        this.cedula_chofer = dato_cedula;
        this.nombre_chofer = dato_nombre;
        this.licencia_chofer = dato_licencia;
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

    // metodos de responsabilidad
    // son los que van directamente con los datos de la base de datos
    // ... son los atributos --> reglas del negocio
    // 1. la cedula sea valida
    // 2. validar licencia
    // 3. validar nombre y apellidos

    public String validar_nombre() {
        if (this.nombre_chofer == null || this.nombre_chofer.trim().isEmpty()) {
            return "-> El nombre no puede estar vacio.";
        }
        if (!this.nombre_chofer.matches("[a-zA-Z áéíóúÁÉÍÓÚñÑ]+")) {
            return "-> El nombre solo puede contener letras y espacios.";
        }
        return "OK";
    }

    public String validar_licencia() {
        if (this.licencia_chofer == null || this.licencia_chofer.trim().isEmpty()) {
            return "-> La licencia no puede estar vacia.";
        }
        if (this.licencia_chofer.length() < 3) {
            return "-> La licencia debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validar_cedula() {
        if (this.cedula_chofer == null || this.cedula_chofer.trim().isEmpty()) {
            return "-> La cedula no puede estar vacia.";
        }
        if (!this.cedula_chofer.matches("[0-9]+")) {
            return "-> La cedula solo debe contener numeros.";
        }
        if (this.cedula_chofer.length() < 8 || this.cedula_chofer.length() > 10) {
            return "-> La cedula debe tener entre 8 y 10 digitos.";
        }
        return "OK";
    }

    public String obtener_info() {
        return "CHOFER -> CI: " + this.cedula_chofer + " | Nombre: " + this.nombre_chofer + " | Licencia: " + this.licencia_chofer;
    }
}
