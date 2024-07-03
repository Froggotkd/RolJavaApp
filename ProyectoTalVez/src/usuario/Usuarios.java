package usuario;

import java.io.Serializable;

public class Usuarios implements Serializable {
    private String nombre;
    private String usuario;
    private String password;
    private String perfil;

    public Usuarios(String nombre, String usuario, String password, String perfil) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
