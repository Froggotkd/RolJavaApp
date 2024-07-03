package hardware;

public class Redes extends Hardware{

    private String anchoBanda;
    private String tipoConexion;

    public Redes(String marca, String modelo, String numSerie, String anchoBanda, String tipoConexion) {
        super(marca, modelo, numSerie);
        this.anchoBanda = anchoBanda;
        this.tipoConexion = tipoConexion;
    }

    public String getAnchoBanda() {
        return anchoBanda;
    }

    public void setAnchoBanda(String anchoBanda) {
        this.anchoBanda = anchoBanda;
    }



    public String getTipoConexion() {
        return tipoConexion;
    }

    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }

    public String toString(){
        return String.format("La red %s tiene un ancho de banda %s Mbps, y su tipo de conexión es %s", imprimir(), anchoBanda, tipoConexion);
    }

    public static Redes r1 = new Redes("Xerox", "Light", "1001", "500",  "LAN");
}
