package Modelo;

public class CarroModelo {

    String placa_carro = "";
    String marca_carro = "";
    String modelo_carro = "";

    public CarroModelo(String dato_placa, String dato_marca, String dato_modelo) {
        this.placa_carro = dato_placa;
        this.marca_carro = dato_marca;
        this.modelo_carro = dato_modelo;
    }

    public String getPlaca_carro() {
        return placa_carro;
    }

    public void setPlaca_carro(String placa_carro) {
        this.placa_carro = placa_carro;
    }

    public String getMarca_carro() {
        return marca_carro;
    }

    public void setMarca_carro(String marca_carro) {
        this.marca_carro = marca_carro;
    }

    public String getModelo_carro() {
        return modelo_carro;
    }

    public void setModelo_carro(String modelo_carro) {
        this.modelo_carro = modelo_carro;
    }

    public String validar_placa() {
        if (this.placa_carro == null || this.placa_carro.trim().isEmpty()) {
            return "-> La placa no puede estar vacia.";
        }
        if (!this.placa_carro.matches("[A-Z]{3}-[0-9]{3,4}")) {
            return "-> La placa debe tener el formato (Ej: ABC-1234).";
        }
        return "OK";
    }

    public String validar_marca() {
        if (this.marca_carro == null || this.marca_carro.trim().isEmpty()) {
            return "-> La marca no puede estar vacia.";
        }
        if (this.marca_carro.trim().length() < 3) {
            return "-> La marca debe tener al menos 3 caracteres.";
        }
        return "OK";
    }

    public String validar_modelo() {
        if (this.modelo_carro == null || this.modelo_carro.trim().isEmpty()) {
            return "-> El modelo no puede estar vacio.";
        }
        if (this.modelo_carro.trim().length() < 2) {
            return "-> El modelo debe tener al menos 2 caracteres.";
        }
        return "OK";
    }

    public String obtener_info() {
        return "Placa: " + this.placa_carro + " | Marca: " + this.marca_carro + " | Modelo: " + this.modelo_carro;
    }
}
