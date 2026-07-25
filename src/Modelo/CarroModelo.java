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

    public String buscar_placa(String info_placa) {
        return "Buscando carro con placa " + info_placa + "...";
    }

    public boolean placa_valida() {
        if (this.placa_carro != null && !this.placa_carro.trim().isEmpty()) {
            if (this.placa_carro.matches("[A-Z]{3}-[0-9]{3,4}")) {
                return true;
            }
        }
        return false;
    }

    public boolean marca_valida() {
        if (this.marca_carro != null && !this.marca_carro.trim().isEmpty()) {
            if (this.marca_carro.trim().length() >= 3) {
                return true;
            }
        }
        return false;
    }

    public boolean modelo_valido() {
        if (this.modelo_carro != null && !this.modelo_carro.trim().isEmpty()) {
            if (this.modelo_carro.trim().length() >= 2) {
                return true;
            }
        }
        return false;
    }
}
