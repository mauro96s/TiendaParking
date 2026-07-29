package Modelo;

public class FichaViajeModelo {
    
    private CarroModelo carro;
    private ChoferModelo chofer;
    private PasajeroModelo pasajero;

    public FichaViajeModelo(CarroModelo carro, ChoferModelo chofer, PasajeroModelo pasajero) {
        this.carro = carro;
        this.chofer = chofer;
        this.pasajero = pasajero;
    }

    public CarroModelo getCarro() {
        return carro;
    }

    public void setCarro(CarroModelo carro) {
        this.carro = carro;
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
        return this.carro.obtener_info() + "\n" +
               this.chofer.obtener_info() + "\n" +
               this.pasajero.obtener_info();
    }
}
