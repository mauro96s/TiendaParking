package modelo;

public class ChoferModelo {

    // inicializamos variables
    private String cedulaChofer = "";
    private String nombreChofer = "";
    private String licenciaChofer = "";

    // constructor
    public ChoferModelo(String datoCedula, String datoNombre, String datoLicencia) {
        this.cedulaChofer = datoCedula;
        this.nombreChofer = datoNombre;
        this.licenciaChofer = datoLicencia;
    }

    // getters y setters
    public String getNombreChofer() {
        return nombreChofer;
    }

    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }

    public String getLicenciaChofer() {
        return licenciaChofer;
    }

    public void setLicenciaChofer(String licenciaChofer) {
        this.licenciaChofer = licenciaChofer;
    }

    public String getCedulaChofer() {
        return cedulaChofer;
    }

    public void setCedulaChofer(String cedulaChofer) {
        this.cedulaChofer = cedulaChofer;
    }

    // metodos de responsabilidad
    // son los que van directamente con los datos de la base de datos
    // ... son los atributos --> reglas del negocio
    // 1. la cedula sea valida
    // 2. validar licencia
    // 3. validar nombre y apellidos

    public String validarNombre() {
        if (this.nombreChofer == null || this.nombreChofer.trim().isEmpty()) {
            return "-> El nombre no puede estar vacio.";
        }
        if (!this.nombreChofer.matches("[a-zA-Z áéíóúÁÉÍÓÚñÑ]+")) {
            return "-> El nombre solo puede contener letras y espacios.";
        }
        return "OK";
    }

    public String validarLicencia() {
        if (this.licenciaChofer == null || this.licenciaChofer.trim().isEmpty()) {
            return "-> La licencia no puede estar vacia.";
        }
        if (this.licenciaChofer.length() < 3) {
            return "-> La licencia debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validarCedula() {
        if (this.cedulaChofer == null || this.cedulaChofer.trim().isEmpty()) {
            return "-> La cedula no puede estar vacia.";
        }
        if (!this.cedulaChofer.matches("[0-9]+")) {
            return "-> La cedula solo debe contener numeros.";
        }
        if (this.cedulaChofer.length() < 8 || this.cedulaChofer.length() > 10) {
            return "-> La cedula debe tener entre 8 y 10 digitos.";
        }
        return "OK";
    }

    public String obtenerInfo() {
        return "CI: " + this.cedulaChofer + " | Nombre: " + this.nombreChofer + " | Licencia: " + this.licenciaChofer;
    }
}
