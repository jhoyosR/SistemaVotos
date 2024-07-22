package org.example.sistemavotos;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.sistemavotos.aplication.service.Creacion;

import java.io.IOException;

public class Application extends javafx.application.Application {

    public static String resultadosCandidatos(){
        return Creacion.obtenerCandidatos();
    }

    //Crea la ventana Login principal
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        LoginController controller = fxmlLoader.getController();
        controller.setMainApp(this);

        stage.setTitle("VOTACIONES COLSAFA");
        stage.setScene(scene);

        // Establecer tamaño y bloquear el tamaño de la ventana
        stage.setWidth(480);    // Ancho deseado
        stage.setHeight(310);   // Alto deseado
        stage.setResizable(false); // Bloquear el cambio de tamaño

        // Mostrar la nueva ventana
        stage.show();
    }

    //Inicializa la ventana
    public static void main(String[] args) {
        launch();
    }

    //Ventana para jornada de la mañana
    public void abrirNuevaVentanaManana() throws IOException {
        Stage nuevaVentana1 = new Stage();
        nuevaVentana1.setTitle("VOTACIONES COLSAFA");

        FXMLLoader fxmlLoader1 = new FXMLLoader(Application.class.getResource("votomanana-view.fxml"));
        Scene segundaEscena = new Scene(fxmlLoader1.load(), 230, 100);

        nuevaVentana1.setScene(segundaEscena);

        // Establecer tamaño y bloquear el tamaño de la ventana
        nuevaVentana1.setWidth(480); // Ancho deseado
        nuevaVentana1.setHeight(310); // Alto deseado
        nuevaVentana1.setResizable(false); // Bloquear el cambio de tamaño


        // Mostrar la nueva ventana
        nuevaVentana1.show();


    }

    //Ventana para jornada de la tarde
    public void abrirNuevaVentanaTarde() throws IOException {
        Stage nuevaVentana2 = new Stage();
        nuevaVentana2.setTitle("VOTACIONES COLSAFA");

        FXMLLoader fxmlLoader2 = new FXMLLoader(Application.class.getResource("vototarde-view.fxml"));
        Scene terceraEscena = new Scene(fxmlLoader2.load(), 230, 100);

        nuevaVentana2.setScene(terceraEscena);

        // Establecer tamaño y bloquear el tamaño de la ventana
        nuevaVentana2.setWidth(480); // Ancho deseado
        nuevaVentana2.setHeight(310); // Alto deseado
        nuevaVentana2.setResizable(false); // Bloquear el cambio de tamaño

        // Mostrar la nueva ventana
        nuevaVentana2.show();

    }

    //Ventana para jornada de la noche
    public void abrirNuevaVentanaNoche() throws IOException {
        Stage nuevaVentana3 = new Stage();
        nuevaVentana3.setTitle("VOTACIONES COLSAFA");

        FXMLLoader fxmlLoader3 = new FXMLLoader(Application.class.getResource("votonoche-view.fxml"));
        Scene cuartaEscena = new Scene(fxmlLoader3.load(), 230, 100);

        nuevaVentana3.setScene(cuartaEscena);

        // Establecer tamaño y bloquear el tamaño de la ventana
        nuevaVentana3.setWidth(480); // Ancho deseado
        nuevaVentana3.setHeight(310); // Alto deseado
        nuevaVentana3.setResizable(false); // Bloquear el cambio de tamaño

        // Mostrar la nueva ventana
        nuevaVentana3.show();

    }

}