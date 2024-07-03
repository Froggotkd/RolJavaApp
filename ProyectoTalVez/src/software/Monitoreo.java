package software;

public class Monitoreo extends Software{
    private boolean alertasActivas;
    private String tipoAlerta;

    public Monitoreo(String version, String estado, boolean alertasActivas, String tipoAlerta) {
        super(version, estado);
        this.alertasActivas = alertasActivas;
        this.tipoAlerta = tipoAlerta;
    }

    public String toString(){
        if(alertasActivas){
            return String.format("El activo de monitoreo de software %s, tiene las alertas %s activas",imprimir(), tipoAlerta);
        } else{
            return String.format("El activo de monitoreo de software %s, tiene las alertas %s no activas", imprimir(), tipoAlerta);
        }
    }



    public boolean isAlertasActivas() {
        return alertasActivas;
    }

    public void setAlertasActivas(boolean alertasActivas) {
        this.alertasActivas = alertasActivas;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public static Monitoreo m1 = new Monitoreo("1.1.1.1", "activo", false, "sensor de entrada");
}
