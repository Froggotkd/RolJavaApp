package controllerActivos;

import alertas.MensajeAlerta;
import controller.LoginC;
import controller.ReporteC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.io.IOException;

import static hardware.Almacenamiento.al1;
import static hardware.Redes.r1;
import static hardware.Servidores.s1;
import static software.Backup.bu1;
import static software.Gestionar.g1;
import static software.Monitoreo.m1;

public class MenuActivosC {
    @FXML
    private MenuButton atGCT, atBackUp, atMonitoreo, atAlmacenamiento, atRedes, atServidores;

    @FXML
    private Button btnAlmacenamiento, btnBackUp, btnVerReporteAc, btnGCT, btnManejoLogin, btnMonitoreo, btnRedes, btnServidor, btnGuardarCambios, btnLimpieza;

    @FXML
    private TextField txtGCT, txtBackUp, txtMonitoreo, txtAlmacenamiento, txtRedes, txtServidores;
    @FXML
    private Label lblTituloAM;
    public String accionRealizada = " ";
    public static ArrayList<String> acciones = new ArrayList<>();
    public static int cont = 0;
    public static int anioA, mesA, diaA, horaA, minutoA, segundoA;


    @FXML
    void actionAtBackup(ActionEvent event) {
    }

    @FXML
    void actionAtGCT(ActionEvent event) {
    }

    @FXML
    void actionAtMonitoreo(ActionEvent event) {
    }

    private void registrarAccion(String accion) {
        Calendar fecha1 = new GregorianCalendar();
        anioA = fecha1.get(Calendar.YEAR);
        mesA = fecha1.get(Calendar.MONTH);
        diaA = fecha1.get(Calendar.DAY_OF_MONTH);
        horaA = fecha1.get(Calendar.HOUR_OF_DAY);
        minutoA = fecha1.get(Calendar.MINUTE);
        segundoA = fecha1.get(Calendar.SECOND);
        String tiempo = "\n\n * " + accion + " - " + ReporteC.fecha(diaA, mesA, anioA, segundoA, minutoA, horaA);
        cont++;
        acciones.add(tiempo);
    }

    @FXML
    void actionLimpieza(ActionEvent event) {
        registrarAccion("Limpieza");
        MensajeAlerta.mensaje("Se ha registrado la limpieza");
    }

    @FXML
    void actionGuardarCambios(ActionEvent event) {
        String cambiosGCT = atGCT.getText();
        String cambiosBackUp = atBackUp.getText();
        String cambiosMonitoreo = atMonitoreo.getText();
        String cambiosAlmacenamiento = atAlmacenamiento.getText();
        String cambiosRedes = atRedes.getText();
        String cambioServidor = atServidores.getText();

        switch (cambiosGCT) {
            case ("Categoria"):
                String cat = g1.getCategoria();
                g1.setCategoria(txtGCT.getText());
                registrarAccion("En Gestión de Cargas de Trabajo se modificó el valor: Categoría de " + cat + " a " + g1.getCategoria());
                break;
            case ("Estado"):
                String est = g1.getEstado();
                g1.setEstado(txtGCT.getText());
                registrarAccion("En Gestión de Cargas de Trabajo se modificó el valor: Estado de " + est + " a " + g1.getEstado());
                break;
            case ("Recursos"):
                String rec = g1.getRecursosAsignados();
                g1.setRecursosAsignados(txtGCT.getText());
                registrarAccion("En Gestión de Cargas de Trabajo se modificó el valor: Recursos Asignados de " + rec + " a " + g1.getRecursosAsignados());
                break;
            case ("Versión"):
                String ver = g1.getVersion();
                g1.setVersion(txtGCT.getText());
                registrarAccion("En Gestión de Cargas de Trabajo se modificó el valor: Versión de " + ver + " a " + g1.getVersion());
                break;
        }
        switch (cambiosBackUp) {
            case ("Fecha Creación"):
                String fc = bu1.getFechaCreacion();
                bu1.setFechaCreacion(txtBackUp.getText());
                registrarAccion("En Back-Up se modificó el valor: Fecha de Creación de " + fc + " a la fecha " + bu1.getFechaCreacion());
                break;
            case ("Estado"):
                String est = bu1.getEstado();
                bu1.setEstado(txtBackUp.getText());
                registrarAccion("En Back-Up se modificó el valor: Estado de " + est + " a " + bu1.getEstado());
                break;
            case ("Frecuencia"):
                String frec = bu1.getFrecuencia();
                bu1.setFrecuencia(txtBackUp.getText());
                registrarAccion("En Back-Up se modificó el valor: Frecuencia de " + frec + " días a cada " + bu1.getFrecuencia() + " días");
                break;
            case ("Versión"):
                String verb = bu1.getVersion();
                bu1.setVersion(txtBackUp.getText());
                registrarAccion("En Back-Up se modificó el valor: Versión de " + verb + " a " + bu1.getVersion());
                break;
            default:
                break;
        }
        switch (cambiosMonitoreo) {
            case ("Alertas Activas"):
                boolean alAct = m1.isAlertasActivas();
                if (txtMonitoreo.getText().equals("Verdadero")) {
                    m1.setAlertasActivas(true);
                } else if (txtMonitoreo.getText().equals("Falso")) {
                    m1.setAlertasActivas(false);
                } else {
                    MensajeAlerta.mensaje("Valor inválido");
                }
                registrarAccion("En Monitoreo se modificó el valor: Alertas activas de " + alAct + " a " + m1.isAlertasActivas());
                break;
            case ("Alertas"):
                String al = m1.getTipoAlerta();
                m1.setTipoAlerta(txtMonitoreo.getText());
                registrarAccion("En Monitoreo se modificó el valor: Alertas de " + al + " a " + m1.getTipoAlerta());
                break;
            case ("Estado"):
                String estM = m1.getEstado();
                m1.setEstado(txtMonitoreo.getText());
                registrarAccion("En Monitoreo se modificó el valor: Estado de " + estM + " a " + m1.getEstado());
                break;
            case ("Versión"):
                String versM = m1.getVersion();
                m1.setVersion(txtMonitoreo.getText());
                registrarAccion("En Monitoreo se modificó el valor: Versión de " + versM + " a " + m1.getVersion());
                break;
        }
        switch (cambiosAlmacenamiento) {
            case ("Capacidad"):
                if (txtAlmacenamiento.getText().matches("\\d+")) {
                    double cap = al1.getCapacidad();
                    al1.setCapacidad(Double.parseDouble(txtAlmacenamiento.getText()));
                    registrarAccion("En Almacenamiento se modificó el valor: Capacidad de " + cap + " a " + al1.getCapacidad() + " GB");
                } else {
                    MensajeAlerta.mensaje("Capacidad de Almacenamiento deben ser Números.");
                }
                break;
            case ("Marca"):
                String marc = al1.getMarca();
                al1.setMarca(txtAlmacenamiento.getText());
                registrarAccion("En Almacenamiento se modificó el valor: Marca de " + marc + " a " + al1.getMarca());
                break;
            case ("Modelo"):
                String mod = al1.getModelo();
                al1.setModelo(txtAlmacenamiento.getText());
                registrarAccion("En Almacenamiento se modificó el valor: Modelo de " + mod + " a " + al1.getModelo());
                break;
            case ("Num. Serie"):
                String num = al1.getNumSerie();
                al1.setNumSerie(txtAlmacenamiento.getText());
                registrarAccion("En Almacenamiento se modificó el valor: Número de Serie de " + num + " a " + al1.getNumSerie());
                break;
            case ("Tipo"):
                String tipo = al1.getTipo();
                al1.setTipo(txtAlmacenamiento.getText());
                registrarAccion("En Almacenamiento se modificó el valor: Tipo de " + tipo + " a " + al1.getTipo());
                break;
        }
        switch (cambiosRedes) {
            case ("Ancho Banda"):
                String ab = r1.getAnchoBanda();
                r1.setAnchoBanda(txtRedes.getText());
                registrarAccion("En Redes se modificó el valor: Ancho de Banda de " + ab + " Mbps a " + r1.getAnchoBanda() + " Mbps");
                break;
            case ("Marca"):
                String marca = r1.getMarca();
                r1.setMarca(txtRedes.getText());
                registrarAccion("En Redes se modificó el valor: Marca de " + marca + " a " + r1.getMarca());
                break;
            case ("Modelo"):
                String mod = r1.getModelo();
                r1.setModelo(txtRedes.getText());
                registrarAccion("En Redes se modificó el valor: Modelo de " + mod + " a " + r1.getModelo());
                break;
            case ("Num. Serie"):
                String num = r1.getNumSerie();
                r1.setNumSerie(txtRedes.getText());
                registrarAccion("En Redes se modificó el valor: Número de Serie de " + num + " a " + r1.getNumSerie());
                break;
            case ("Tipo Con."):
                String tipcon = r1.getTipoConexion();
                r1.setTipoConexion(txtRedes.getText());
                registrarAccion("En Redes se modificó el valor: Tipo de Conexión de " + tipcon + " a " + r1.getTipoConexion());
                break;
        }
        switch (cambioServidor) {
            case ("Cant. Memoria"):
                String cant = s1.getCantMemoria();
                s1.setCantMemoria(txtServidores.getText());
                registrarAccion("En Servidores se modifico el valor: Cantidad de Memoria de " + cant + " GB a " + s1.getCantMemoria() + " GB");
                break;
            case ("Marca"):
                String marc = s1.getMarca();
                s1.setMarca(txtServidores.getText());
                registrarAccion("En Servidores se modifico el valor: Marca de " + marc + " a " + s1.getMarca());
                break;
            case ("Modelo"):
                String mod = s1.getModelo();
                s1.setModelo(txtServidores.getText());
                registrarAccion("En Servidores se modificó el valor: Modelo de " + mod + " a " + s1.getModelo());
                break;
            case ("Num. Serie"):
                String num = s1.getNumSerie();
                s1.setNumSerie(txtServidores.getText());
                registrarAccion("En Servidores se modificó el valor: Número de Serie de " + num + " a " + s1.getNumSerie());
                break;
            case ("Potencia"):
                String pot = s1.getPotencia();
                s1.setPotencia(txtServidores.getText());
                registrarAccion("En Servidores se modificó el valor: Potencia de " + pot + " a " + s1.getPotencia());
                break;
        }
        txtGCT.setText("");
        txtBackUp.setText("");
        txtMonitoreo.setText("");
        txtAlmacenamiento.setText("");
        txtRedes.setText("");
        txtServidores.setText("");

    }


    @FXML
    void actionAlmacenamiento(ActionEvent event) {
        accionRealizada = "Almacenamiento";
        manejoMenus();
    }

    @FXML
    void actionAtAlmacenamiento(ActionEvent event) {
    }

    @FXML
    void actionCapAlm(ActionEvent event) {
        accionRealizada = "Almacenamiento";
        atAlmacenamiento.setText("Capacidad");
        manejoMenus();
    }

    @FXML
    void actionMarcaAlm(ActionEvent event) {
        accionRealizada = "Almacenamiento";
        atAlmacenamiento.setText("Marca");
        manejoMenus();
    }

    @FXML
    void actionModeloAlm(ActionEvent event) {
        accionRealizada = "Almacenamiento";
        atAlmacenamiento.setText("Modelo");
        manejoMenus();
    }

    @FXML
    void actionNumSerieAlm(ActionEvent event) {
        accionRealizada = "Almacenamiento";
        atAlmacenamiento.setText("Num. Serie");
        manejoMenus();
    }

    @FXML
    void actionTipoAlm(ActionEvent event) {
        accionRealizada = "Almacenamiento";
        atAlmacenamiento.setText("Tipo");
        manejoMenus();
    }

    @FXML
    void actionBackUp(ActionEvent event) {
        accionRealizada = "Back-Up";
        manejoMenus();
    }

    @FXML
    void actionEstadoBackUp(ActionEvent event) {
        accionRealizada = "Back-Up";
        atBackUp.setText("Estado");
        manejoMenus();
    }

    @FXML
    void actionFechCreacionBackUp(ActionEvent event) {
        accionRealizada = "Back-Up";
        atBackUp.setText("Fecha Creación");
        manejoMenus();
    }

    @FXML
    void actionFrecBackUp(ActionEvent event) {
        accionRealizada = "Back-Up";
        atBackUp.setText("Frecuencia");
        manejoMenus();
    }

    @FXML
    void actionVersionBackUp(ActionEvent event) {
        accionRealizada = "Back-Up";
        atBackUp.setText("Versión");
        manejoMenus();
    }

    @FXML
    void actionGCT(ActionEvent event) {
        accionRealizada = "Gestión Cargas de Trabajo";
        manejoMenus();
    }

    @FXML
    void actionCatGCT(ActionEvent event) {
        accionRealizada = "Gestión Cargas de Trabajo";
        atGCT.setText("Categoría");
        manejoMenus();
    }

    @FXML
    void actionEstadoGCT(ActionEvent event) {
        accionRealizada = "Gestión Cargas de Trabajo";
        atGCT.setText("Estado");
        manejoMenus();

    }

    @FXML
    void actionRecursosGCT(ActionEvent event) {
        accionRealizada = "Gestión Cargas de Trabajo";
        atGCT.setText("Recursos");
        manejoMenus();

    }

    @FXML
    void actionVersionGCT(ActionEvent event) {
        accionRealizada = "Gestión Cargas de Trabajo";
        atGCT.setText("Versión");
        manejoMenus();
    }

    @FXML
    void actionManejoLogin(ActionEvent event) throws IOException {
        String estadoPerfil = LoginC.perfil;
        accionRealizada = "Manejo de Logins";
        registrarAccion(accionRealizada);
        manejoMenus();

        if (estadoPerfil.equals("Administrador")) {
            btnManejoLogin.getScene().getWindow().hide();
            Stage main = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ManejoLogins.fxml"));
            main.setScene(new Scene(root));
            main.show();
        } else {

            manejoMenus();
        }

    }

    @FXML
    void actionMonitoreo(ActionEvent event) {
        accionRealizada = "Monitoreo";
        manejoMenus();
    }

    @FXML
    void actionAlActivasMonitoreo(ActionEvent event) {
        accionRealizada = "Monitoreo";
        txtMonitoreo.setPromptText("Verdadero o Falso");
        atMonitoreo.setText("Alertas Activas");
        manejoMenus();
    }

    @FXML
    void actionAlertasMonitoreo(ActionEvent event) {
        accionRealizada = "Monitoreo";
        atMonitoreo.setText("Alertas");
        manejoMenus();
    }

    @FXML
    void actionEstadoMonitoreo(ActionEvent event) {
        accionRealizada = "Monitoreo";
        atMonitoreo.setText("Estado");
        manejoMenus();
    }

    @FXML
    void actionVersionMonitoreo(ActionEvent event) {
        accionRealizada = "Monitoreo";
        atMonitoreo.setText("Versión");
        manejoMenus();
    }

    @FXML
    void actionRedes(ActionEvent event) {
        accionRealizada = "Redes";
        manejoMenus();
    }

    @FXML
    void actionAnchoBandRedes(ActionEvent event) {
        accionRealizada = "Redes";
        atRedes.setText("Ancho Banda");
        manejoMenus();
    }

    @FXML
    void actionMarcaRedes(ActionEvent event) {
        accionRealizada = "Redes";
        atRedes.setText("Marca");
        manejoMenus();
    }

    @FXML
    void actionModeloRedes(ActionEvent event) {
        accionRealizada = "Redes";
        atRedes.setText("Modelo");
        manejoMenus();
    }

    @FXML
    void actionNumSerieRedes(ActionEvent event) {
        accionRealizada = "Redes";
        atRedes.setText("Num. Serie");
        manejoMenus();
    }

    @FXML
    void actionTipoConRedes(ActionEvent event) {
        accionRealizada = "Redes";
        atRedes.setText("Tipo Con.");
        txtRedes.setPromptText("Tipo de conexión");
        manejoMenus();
    }

    @FXML
    void actionServidor(ActionEvent event) {
        accionRealizada = "Servidor";
        manejoMenus();

    }

    @FXML
    void actionCantMemoriaServidor(ActionEvent event) {
        atServidores.setText("Cant. Memoria");
        accionRealizada = "Servidor";
        txtServidores.setPromptText("Cantidad de Memoria");
        manejoMenus();
    }

    @FXML
    void actionMarcaServidor(ActionEvent event) {
        accionRealizada = "Servidor";
        atServidores.setText("Marca");
        manejoMenus();
    }

    @FXML
    void actionModeloServidor(ActionEvent event) {
        accionRealizada = "Servidor";
        atServidores.setText("Modelo");
        manejoMenus();
    }

    @FXML
    void actionNumSerieServidor(ActionEvent event) {
        atServidores.setText("Num. Serie");
        accionRealizada = "Servidor";
        manejoMenus();
    }

    @FXML
    void actionPotenciaServidor(ActionEvent event) {
        atServidores.setText("Potencia");
        accionRealizada = "Servidor";
        manejoMenus();
    }

    @FXML
    void actionVerReporteAc(ActionEvent event) throws IOException {
        btnVerReporteAc.getScene().getWindow().hide();
        Stage main = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Reporte.fxml"));
        main.setScene(new Scene(root));
        main.show();
    }


    public void manejoMenus() {
        String estadoPerfil = " ";
        estadoPerfil = LoginC.perfil;

        if (estadoPerfil.equals("Programador")) {
            lblTituloAM.setText("Bienvenido, Programador");

            switch (accionRealizada) {
                case ("Gestión Cargas de Trabajo"):
                    MensajeAlerta.info(g1.toString());
                    break;
                case ("Monitoreo"):
                    MensajeAlerta.info(m1.toString());
                    break;
                case ("Back-Up"):
                    MensajeAlerta.info(bu1.toString());
                    break;
                case ("Servidor"):
                case ("Almacenamiento"):
                case ("Manejo de Logins"):
                case ("Redes"):
                case("Limpieza"):
                    MensajeAlerta.mensaje("No tiene acceso a este activo");
                    btnAlmacenamiento.setDisable(true);
                    btnServidor.setDisable(true);
                    btnManejoLogin.setDisable(true);
                    btnRedes.setDisable(true);
                    atAlmacenamiento.setDisable(true);
                    txtAlmacenamiento.setDisable(true);
                    atRedes.setDisable(true);
                    txtRedes.setDisable(true);
                    atServidores.setDisable(true);
                    txtServidores.setDisable(true);
                    btnLimpieza.setDisable(true);

            }

        } else if (estadoPerfil.equals("Administrador")) {
            lblTituloAM.setText("Bienvenido, Administrador");

            switch (accionRealizada) {

                case ("Redes"):
                    MensajeAlerta.info(r1.toString());
                    break;
                case ("Servidor"):
                    MensajeAlerta.info(s1.toString());
                    break;
                case ("Almacenamiento"):
                    MensajeAlerta.info(al1.toString());
                    break;
                case ("Back-Up"):
                    MensajeAlerta.info(bu1.toString());
                    break;
                case ("Gestión Cargas de Trabajo"):
                    MensajeAlerta.info(g1.toString());
                    break;
                case ("Monitoreo"):
                    MensajeAlerta.info(m1.toString());
                    break;
            }

        } else if (estadoPerfil.equals("Mantenimiento")) {
            lblTituloAM.setText("Bienvenido, Personal de Mantenimiento");


            switch (accionRealizada) {
                case ("Redes"):
                    MensajeAlerta.info(r1.toString());
                    break;
                case ("Servidor"):
                    MensajeAlerta.info(s1.toString());
                    break;
                case ("Almacenamiento"):
                    MensajeAlerta.info(al1.toString());
                    break;
                case ("Gestión Cargas de Trabajo"):
                case ("Back-Up"):
                case ("Manejo de Logins"):
                case ("Monitoreo"):
                    MensajeAlerta.mensaje("No tiene acceso a este activo");
                    btnGCT.setDisable(true);
                    btnBackUp.setDisable(true);
                    btnManejoLogin.setDisable(true);
                    btnMonitoreo.setDisable(true);
                    atGCT.setDisable(true);
                    txtGCT.setDisable(true);
                    atMonitoreo.setDisable(true);
                    txtMonitoreo.setDisable(true);
                    atBackUp.setDisable(true);
                    txtBackUp.setDisable(true);
            }
        } else if (estadoPerfil.equals("Limpieza")) {
            lblTituloAM.setText("Bienvenido, Personal de Limpieza");
            switch (accionRealizada) {
                case ("Gestión Cargas de Trabajo"):
                case ("Back-Up"):
                case ("Manejo de Logins"):
                case ("Monitoreo"):
                case ("Almacenamiento"):
                case ("Servidor"):
                case ("Redes"):
                    MensajeAlerta.mensaje("No tiene acceso a este activo");
                    btnGCT.setDisable(true);
                    btnBackUp.setDisable(true);
                    btnManejoLogin.setDisable(true);
                    btnAlmacenamiento.setDisable(true);
                    btnServidor.setDisable(true);
                    btnMonitoreo.setDisable(true);
                    btnRedes.setDisable(true);
                    atGCT.setDisable(true);
                    txtGCT.setDisable(true);
                    atMonitoreo.setDisable(true);
                    txtMonitoreo.setDisable(true);
                    atBackUp.setDisable(true);
                    txtBackUp.setDisable(true);
                    atAlmacenamiento.setDisable(true);
                    txtAlmacenamiento.setDisable(true);
                    atRedes.setDisable(true);
                    txtRedes.setDisable(true);
                    atServidores.setDisable(true);
                    txtServidores.setDisable(true);
                    btnGuardarCambios.setDisable(true);
            }

        }
    }

    public static String accionesR() {
        return String.join(" ", acciones);
    }
}
