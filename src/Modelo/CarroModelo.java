package Modelo;

public class CarroModelo {

    String placa_carro = "";
    String marca_carro = "";
    String modelo_carro = "";

    // Relaciones POO
    private MotorModelo motor_carro;
    private ChoferModelo chofer_carro;

    public CarroModelo(String dato_placa, String dato_marca, String dato_modelo,
            MotorModelo dato_motor, ChoferModelo dato_chofer) {
        this.placa_carro = dato_placa;
        this.marca_carro = dato_marca;
        this.modelo_carro = dato_modelo;
        this.motor_carro = dato_motor;
        this.chofer_carro = dato_chofer;
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

    public MotorModelo getMotor_carro() {
        return motor_carro;
    }

    public void setMotor_carro(MotorModelo motor_carro) {
        this.motor_carro = motor_carro;
    }

    public ChoferModelo getChofer_carro() {
        return chofer_carro;
    }

    public void setChofer_carro(ChoferModelo chofer_carro) {
        this.chofer_carro = chofer_carro;
    }

    public String buscar_placa(String info_placa) {
        return "Buscando carro con placa " + info_placa + "...";
    }

    public boolean placa_valida() {
        if (this.placa_carro != null && !this.placa_carro.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean marca_valida() {
        if (this.marca_carro != null && !this.marca_carro.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean modelo_valido() {
        if (this.modelo_carro != null && !this.modelo_carro.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
