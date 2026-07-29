package Modelo;

public class FichaViajeModelo {

    private CarroModelo carro;
    private MotorModelo motor;
    private ChoferModelo chofer;
    private PasajeroModelo pasajero;

    public FichaViajeModelo(CarroModelo carro, MotorModelo motor, ChoferModelo chofer, PasajeroModelo pasajero) {
        this.carro = carro;
        this.motor = motor;
        this.chofer = chofer;
        this.pasajero = pasajero;
    }

    public CarroModelo getCarro() {
        return carro;
    }

    public void setCarro(CarroModelo carro) {
        this.carro = carro;
    }

    public MotorModelo getMotor() {
        return motor;
    }

    public void setMotor(MotorModelo motor) {
        this.motor = motor;
    }

    public ChoferModelo getChofer() {
        return chofer;
    }

    public void setChofer(ChoferModelo chofer) {
        this.chofer = chofer;
    }

    public PasajeroModelo getPasajero() {
        return pasajero;
    }

    public void setPasajero(PasajeroModelo pasajero) {
        this.pasajero = pasajero;
    }

    public String obtener_info() {
        return "[CARRO] " + this.carro.obtener_info()
                + "\n[MOTOR] " + this.motor.obtener_info()
                + "\n[CHOFER] " + this.chofer.obtener_info() 
                + "\n[PASAJERO] "+ this.pasajero.obtener_info();
    }
}
