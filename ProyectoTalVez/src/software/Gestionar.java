package software;

public class Gestionar extends Software {
    private String categoria;
    private String recursosAsignados;

    Software s1 = new Software("", "");

    public Gestionar(String version, String estado, String categoria, String recursosAsignados) {
        super(version, estado);
        this.categoria = categoria;
        this.recursosAsignados = recursosAsignados;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRecursosAsignados() {
        return recursosAsignados;
    }

    public void setRecursosAsignados(String recursosAsignados) {
        this.recursosAsignados = recursosAsignados;
    }

    public void updateEstado(String newEstado) {
        setEstado(newEstado);
    }


    public String toString(){
        return String.format("El activo que gestiona cargas de trabajo %s, tiene una categoría %s y se le han asignado los recursos %s", imprimir(), categoria, recursosAsignados);
    }

    public static Gestionar g1 = new Gestionar("1.2.0.0", "no activo", "empresarial", "memoria y monitoreo");
}
