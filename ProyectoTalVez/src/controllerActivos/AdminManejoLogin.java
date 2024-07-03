package controllerActivos;

import alertas.MensajeAlerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import usuario.Usuarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AdminManejoLogin {
    @FXML
    private Button btnAnadir;

    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnMostrarLogins;

    @FXML
    private Button btnSalirML;

    @FXML
    private Label lblTituloML;

    @FXML
    private TableView<Usuarios> tbLogins;

    @FXML
    private TableColumn<Usuarios, String> tbNombre;

    @FXML
    private TableColumn<Usuarios, String> tbPass;

    @FXML
    private TableColumn<Usuarios, String> tbPerfil;

    @FXML
    private TableColumn<Usuarios, String> tbUsuario;
    @FXML
    private TextField txtEditarNombre;

    @FXML
    private TextField txtEditarPass;

    @FXML
    private TextField txtEditarPerfil;

    @FXML
    private TextField txtEditarUsuario;

    public boolean anadirUs = false;
    public static Usuarios uNuevo = null;

    /*@FXML
    void actionAnadir(ActionEvent event) throws IOException {
        String ruta = "logins.txt";
        File fl1 = new File(ruta);

        FileOutputStream fileOP = null;
        ObjectOutputStream objectOP = null;
        try{
            String anadirNombre = txtEditarNombre.getText();
            String anadirPass = txtEditarPass.getText();
            String anadirUsuario = txtEditarUsuario.getText();
            String anadirPerfil = txtEditarPerfil.getText();

            if(anadirUsuario.contains("@empresa.com")){
                if(anadirPerfil.equals("Administrador") || anadirPerfil.equals("Mantenimiento") ||anadirPerfil.equals("Limpieza") ||anadirPerfil.equals("Programador")){
                     uNuevo = new Usuarios(anadirNombre,anadirUsuario,anadirPass,anadirPerfil);
                    fileOP = new FileOutputStream(fl1, true);
                    objectOP = new ObjectOutputStream(fileOP);
                    //objectOP.writeBytes(anadirNombre + anadirPass + anadirPerfil + anadirUsuario);
                    objectOP.writeObject(uNuevo);
                    MensajeAlerta.mensaje("Usuario agregado exitosamente");
                    anadirUs = true;

                    txtEditarNombre.setText("");
                    txtEditarPass.setText("");
                    txtEditarPerfil.setText("");
                    txtEditarUsuario.setText("");
                    tbLogins.getItems().add(uNuevo);

                } else{
                    MensajeAlerta.mensaje("El perfil que desea agregar, no existe.");
                }
            }else{
                MensajeAlerta.mensaje("El usuario debe ser un correo de la empresa");
            }

        }catch (IOException e){
            System.out.println(e.getMessage());

        }finally {

            try{

                if(objectOP != null){
                    objectOP.close();
                }
                if(fileOP != null){
                    fileOP.close();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    void actionEliminar(ActionEvent event) throws IOException {

    }*/



   @FXML
    void actionLogins(ActionEvent event) throws IOException {
        FileInputStream fileIS = null;
        ObjectInputStream objectIS = null;


        Usuarios u1 = null;
        Usuarios u2 = null;
        Usuarios u3 = null;
        Usuarios u4 = null;

        String ruta = "logins.txt";
        File fl1 = new File(ruta);
        fileIS = new FileInputStream(fl1);
        objectIS = new ObjectInputStream(fileIS);

        try {
            fileIS = new FileInputStream(fl1);
            objectIS = new ObjectInputStream(fileIS);


            u1 = (Usuarios) objectIS.readObject();
            u2 = (Usuarios) objectIS.readObject();
            u3 = (Usuarios) objectIS.readObject();
            u4 = (Usuarios) objectIS.readObject();

            try{
                while(true){
                    Usuarios u = (Usuarios) objectIS.readObject();
                }
            }catch (Exception e){

            }

            if(anadirUs){
                tbLogins.getItems().addAll(u1, u2, u3, u4, uNuevo);
            } else{
                tbLogins.getItems().addAll(u1, u2, u3, u4);

            }

            tbNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tbUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
            tbPass.setCellValueFactory(new PropertyValueFactory<>("password"));
            tbPerfil.setCellValueFactory(new PropertyValueFactory<>("perfil"));

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (objectIS != null) {
                    objectIS.close();
                }
                if (fileIS != null) {
                    fileIS.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    @FXML
    void actionSalirML(ActionEvent event) throws IOException {
        MensajeAlerta.menRegresoLogin("Va a salir a ver el reporte.");

        if (MensajeAlerta.confirmoLogin) {
            btnSalirML.getScene().getWindow().hide();

        }
    }


}
