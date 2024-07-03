package hardware;

public class Almacenamiento extends Hardware {
    private  String tipo;
    private  double capacidad;

    public Almacenamiento(String marca, String modelo, String numSerie, String tipo, double capacidad) {
        super(marca, modelo, numSerie);
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public  String toString(){
        return String.format("El almacenamiento %s, de tipo %s, su capacidad es %.2f gb", imprimir(), tipo, capacidad);
    }
    public static Almacenamiento al1 = new Almacenamiento("Seagate","PRO","200","En la Nube",5);
}
