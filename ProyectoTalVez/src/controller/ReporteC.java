package controller;
import alertas.MensajeAlerta;
import controllerActivos.MenuActivosC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteC {
    @FXML
    private Button btnMostrarR;

    @FXML
    private Button btnSalidaR;

    @FXML
    private Label lblAcciones;

    @FXML
    private Label lblIngreso;

    @FXML
    private Label lblTituloR;

    @FXML
    private Pane reportePane;

    public static String fecha(int dia, int mes, int anio, int segundo, int minuto, int hora ){
        return String.format("\n * Día: %d. Mes: %d. Año: %d. Con %d horas con %d minutos y %d segundos. * ", dia,mes + 1,anio,hora,minuto,segundo);
    }

    @FXML
    void actionMostrarR(ActionEvent event) {

        String ingresoRealizado = "\nEl usuario " + LoginC.usuarioIngresado + " ingresó al sistema en la fecha:" + LoginC.tiempoReg;
        String accionesRealizadas = "\nRealizó " + MenuActivosC.cont +" acciones: " + MenuActivosC.accionesR();

        lblIngreso.setText(ingresoRealizado);
        lblAcciones.setText(accionesRealizadas);

        String ruta = "reporte.txt";
        File fl1 = new File(ruta);

        FileWriter fw1;

        try {
            fw1 = new FileWriter(fl1);
            fw1.write(ingresoRealizado + "\n");
            fw1.write(accionesRealizadas + "\n");
            fw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void actionSalidaR(ActionEvent event) {
        MensajeAlerta.menDespedida("¿Está seguro de salir?");
    }
}