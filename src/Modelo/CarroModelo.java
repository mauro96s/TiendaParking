package modelo;

public class CarroModelo {

    private String placaCarro = "";
    private String marcaCarro = "";
    private String modeloCarro = "";

    public CarroModelo(String datoPlaca, String datoMarca, String datoModelo) {
        this.placaCarro = datoPlaca;
        this.marcaCarro = datoMarca;
        this.modeloCarro = datoModelo;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String validarPlaca() {
        if (this.placaCarro == null || this.placaCarro.trim().isEmpty()) {
            return "-> La placa no puede estar vacia.";
        }
        if (!this.placaCarro.matches("[A-Z]{3}-[0-9]{3,4}")) {
            return "-> La placa debe tener el formato (Ej: ABC-1234).";
        }
        return "OK";
    }

    public String validarMarca() {
        if (this.marcaCarro == null || this.marcaCarro.trim().isEmpty()) {
            return "-> La marca no puede estar vacia.";
        }
        if (this.marcaCarro.trim().length() < 3) {
            return "-> La marca debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validarModelo() {
        if (this.modeloCarro == null || this.modeloCarro.trim().isEmpty()) {
            return "-> El modelo no puede estar vacio.";
        }
        if (this.modeloCarro.trim().length() < 2) {
            return "-> El modelo debe tener al menos 2 caracteres.";
        }
        return "OK";
    }

    public String obtenerInfo() {
        return "Placa: " + this.placaCarro + " | Marca: " + this.marcaCarro + " | Modelo: " + this.modeloCarro;
    }
}
