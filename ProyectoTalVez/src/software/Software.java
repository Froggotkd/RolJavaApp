package software;

public class Software {
    private  String version;
    private  String estado;

    public Software(String version, String estado) {
        this.version = version;
        this.estado = estado;
    }

    public String getVersion() {
        return version;
    }

    public String getEstado() {
        return estado;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public  void setEstado(String estado) {
        this.estado = estado;
    }

    public String imprimir(){
        return String.format("actualmente tiene la versión %s y su estado es %s", this.version, this.estado);
    }
}
