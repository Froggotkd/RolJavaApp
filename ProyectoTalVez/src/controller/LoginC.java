package controller;

import alertas.MensajeAlerta;
import controllerActivos.MenuActivosC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import usuario.Usuarios;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoginC {
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lblModo;

    @FXML
    private Label lblPass;

    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblUsuario;

    @FXML
    private MenuItem menuAdmin;

    @FXML
    private MenuItem menuLimpieza;

    @FXML
    private MenuItem menuMantenimiento;

    @FXML
    private MenuButton menuPerfil;

    @FXML
    private MenuItem menuProgramador;

    @FXML
    private AnchorPane rootP;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUsuario;



    @FXML
    void actionAdmin(ActionEvent event) {
        menuPerfil.setText("Administrador");
    }

    @FXML
    void actionLimpieza(ActionEvent event) {
        menuPerfil.setText("Limpieza");
    }

    @FXML
    void actionMantenimiento(ActionEvent event) {
        menuPerfil.setText("Mantenimiento");
    }

    @FXML
    void actionProg(ActionEvent event) {
        menuPerfil.setText("Programador");
    }

    @FXML
    void actionCancelar(ActionEvent event) {
        MensajeAlerta.menDespedida("¿Está seguro de salir?");
    }


    public static List<Usuarios> datosLista = new ArrayList<>();
    public static String perfil = "";
    public static String usuarioIngresado = "";
    public String contrasenaIngresada = "";
    public int anio, mes, dia, hora, minuto, segundo;
    public static String tiempoReg;




    @FXML
    void actionInicio(ActionEvent event) throws IOException {
        Calendar fecha = new GregorianCalendar();
        perfil = menuPerfil.getText();
        usuarioIngresado = txtUsuario.getText();
        contrasenaIngresada = txtPass.getText();

        String ruta = "logins.txt";
        File fl1 = new File(ruta);

        FileOutputStream fileOP = null;
        ObjectOutputStream objectOP = null;

        Usuarios u1 = null;
        Usuarios u2 = null;
        Usuarios u3 = null;
        Usuarios u4 = null;

        try {

            fileOP = new FileOutputStream(fl1);
            objectOP = new ObjectOutputStream(fileOP);

            u1 = new Usuarios("Daniel Moya", "daniel.mo@empresa.com", "123456", "Administrador");
            u2 = new Usuarios("Maria Perez", "maria.pe@empresa.com", "000222", "Mantenimiento");
            u3 = new Usuarios("Jose Pereira", "jose.pe@empresa.com", "111222", "Limpieza");
            u4 = new Usuarios("Gabriela Herrera", "gabriela.he@empresa.com", "202020", "Programador");

            objectOP.writeObject(u1);
            objectOP.writeObject(u2);
            objectOP.writeObject(u3);
            objectOP.writeObject(u4);

            datosLista.add(u1);
            datosLista.add(u2);
            datosLista.add(u3);
            datosLista.add(u4);

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {

            try {

                if (objectOP != null) {
                    objectOP.close();
                }
                if (fileOP != null) {
                    fileOP.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean accesoExitoso = false;

        for (Usuarios datos : datosLista) {
            if (usuarioIngresado.equals(datos.getUsuario()) && contrasenaIngresada.equals(datos.getPassword())) {
                accesoExitoso = true;
                break;
            }
        }

        if (accesoExitoso) {
            btnAceptar.getScene().getWindow().hide();
            Stage main = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ActivosMenu.fxml"));
            main.setScene(new Scene(root));
            main.show();

            anio = fecha.get(Calendar.YEAR);
            mes = fecha.get(Calendar.MONTH);
            dia = fecha.get(Calendar.DAY_OF_MONTH);
            hora = fecha.get(Calendar.HOUR_OF_DAY);
            minuto = fecha.get(Calendar.MINUTE);
            segundo = fecha.get(Calendar.SECOND);

            tiempoReg = ReporteC.fecha(dia,mes,anio,segundo,minuto,hora);


        } else {
            MensajeAlerta.mensaje("Acceso denegado");
            txtUsuario.setText("");
            txtPass.setText("");
            menuPerfil.setText("Perfil");
        }
    }


}
