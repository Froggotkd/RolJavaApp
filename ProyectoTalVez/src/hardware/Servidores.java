package hardware;

public class Servidores extends Hardware{
    private String potencia;
    private String cantMemoria;

    public Servidores(String marca, String modelo, String numSerie, String potencia, String cantMemoria) {
        super(marca, modelo, numSerie);
        this.potencia = potencia;
        this.cantMemoria = cantMemoria;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCantMemoria() {
        return cantMemoria;
    }

    public void setCantMemoria(String cantMemoria) {
        this.cantMemoria = cantMemoria;
    }

    public String toString(){
        return String.format("El servidor %s tiene una potencia %s W, su memoria es de %s GB", imprimir(), potencia, cantMemoria);
    }

    public static Servidores s1 = new Servidores("HPE", "ProLiant", "5005", "250", "180");
}
