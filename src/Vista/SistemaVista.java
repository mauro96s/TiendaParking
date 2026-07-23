package Vista;

public class SistemaVista {
    
    // Esta clase tiene la ÚNICA responsabilidad de mostrar mensajes generales del sistema
    // (títulos, menús, confirmaciones globales) que no pertenecen a una entidad específica.
    
    public void mostrar_mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
