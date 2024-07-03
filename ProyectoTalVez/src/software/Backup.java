package software;

public class Backup extends Software{
    private String fechaCreacion;
    private String frecuencia;

    public Backup(String version, String estado, String fechaCreacion, String frecuencia) {
        super(version, estado);
        this.fechaCreacion = fechaCreacion;
        this.frecuencia = frecuencia;
    }

    public String toString(){
        return String.format("El activo de BackUp %s, fue creado en %s y se actualiza cada %s", imprimir(), fechaCreacion,frecuencia);
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public static Backup bu1 = new Backup("1.0.0.1", "activo", "20/06/2023", "30 días");
}
