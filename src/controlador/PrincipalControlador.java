package controlador;

import modelo.ApiModelo;
import vista.CarroVista;
import vista.ChoferVista;
import vista.MotorVista;
import vista.PasajeroVista;
import vista.SistemaVista;
import vista.FichaViajeVista;

public class PrincipalControlador {
    private SistemaVista vistaSistema;
    private CarroControlador carroControlador;
    private MotorControlador motorControlador;
    private ChoferControlador choferControlador;
    private PasajeroControlador pasajeroControlador;
    private FichaViajeControlador fichaViajeControlador;

    public PrincipalControlador(SistemaVista sistema, ChoferVista chofer, CarroVista carro, MotorVista motor, PasajeroVista pasajero, FichaViajeVista viaje, ApiModelo api) {
        this.vistaSistema = sistema;
        this.carroControlador = new CarroControlador(sistema, carro, api);
        this.motorControlador = new MotorControlador(sistema, motor, api);
        this.choferControlador = new ChoferControlador(sistema, chofer, api);
        this.pasajeroControlador = new PasajeroControlador(sistema, pasajero, api);
        this.fichaViajeControlador = new FichaViajeControlador(sistema, viaje, api);
    }

    public void procesarDatos() {
        boolean salir = false;

        while (!salir) {
            String opcion = this.vistaSistema.tomarOpcionMenu();

            switch (opcion) {
                case "1":
                    this.carroControlador.gestionarCarros();
                    break;
                case "2":
                    this.motorControlador.gestionarMotores();
                    break;
                case "3":
                    this.choferControlador.gestionarChoferes();
                    break;
                case "4":
                    this.pasajeroControlador.gestionarPasajeros();
                    break;
                case "5":
                    this.fichaViajeControlador.gestionarViajes();
                    break;
                case "6":
                    this.vistaSistema.mostrarMensaje("\nSaliendo del sistema... Hasta luego!");
                    salir = true;
                    break;
                default:
                    this.vistaSistema.mostrarMensaje("\nError: Opcion no valida. Intente de nuevo.");
            }
        }
    }
}
