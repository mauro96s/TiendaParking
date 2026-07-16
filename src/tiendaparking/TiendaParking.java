package tiendaparking;

import Modelo.ChoferModelo;

public class TiendaParking {

    public static void main(String[] args) {
        // Codigo principal --> ejecutar todo...
        ChoferModelo obj_chofer = new ChoferModelo("Mauricio", "Sierra", "1090495133");
        obj_chofer.setNombre_chofer("Mauro");
        String dato_nombre = obj_chofer.getNombre_chofer();

        System.out.println("nombre chofer: " + dato_nombre);
    }

}
