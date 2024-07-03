package hardware;

public class Hardware {

    private  String marca;
    private  String modelo;
    private  String numSerie;

    public Hardware(String marca, String modelo, String numSerie) {
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String imprimir(){
        return String.format("de marca %s, modelo %s, con número de serie %s", this.marca,this.modelo,this.numSerie);
    }


}
