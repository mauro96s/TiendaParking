package Modelo;

public class ApiModelo {

    String clave = "";
    String root = "";
    String url = "";

    public ApiModelo(String url, String usuario, String clave) {
        this.clave = clave;
        this.root = usuario;
        this.url = url;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean validar_conexion() {
        if (this.clave.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }

    public void desconexion() {
        System.out.println("Desconexion realizada...");
    }
    
    public void buscar_chofer(String info_cedula){
        System.out.println("Cliente se esta buscando...");
    }
    
    
}
