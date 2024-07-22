package org.example.sistemavotos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.sistemavotos.aplication.service.*;
import org.example.sistemavotos.infraestructure.repository.VotanteRepositoryImpl;
import org.example.sistemavotos.interfaces.VotanteRepository;

import java.io.IOException;

public class LoginController {

    private static final VotanteService votanteService;

    static {
        VotanteRepository votanteRepository = new VotanteRepositoryImpl();
        votanteService = new VotanteServiceImpl(votanteRepository);
    }
    @FXML
    private Application mainApp; //Instancia de la aplicación para llamar métodos de ventanas
    @FXML
    private Button continuarBtn; //Botón para continuar a votar luego del Login
    @FXML
    private TextField idTxT; //Espacio de texto para inserar ID
    @FXML
    private Label mensajeAdvLbl; //Mensajes de advertencia


    //Validación con los archivos persistidos para permitir o no permitir votar
    public void continuarBtnOnAction(ActionEvent event) throws IOException {

        if (idTxT.getText().isBlank()){
            mensajeAdvLbl.setText("Ingrese su identificación antes de continuar");

            /*Métodos que verifican que el id insertado no haya votado aún, se encuentre en la lista
            y se le asignen los candidatos de su respectiva jornada.
            Además, una vez exitosa la verificación, con el método siVoto se le bloquea volver a votar.
             */

        } else if (idTxT.getText().equals(Integer.toString(idDeVotante(Integer.parseInt(idTxT.getText())))) && !estadoVoto(Integer.parseInt(idTxT.getText())) && horarioJornada(Integer.parseInt(idTxT.getText())).equals("Mañana")){  //Busca en los archivos un votante con el id que se ingresó
            mainApp.abrirNuevaVentanaManana();
            Creacion.siVoto(idDeVotante(Integer.parseInt(idTxT.getText())));

        } else if (idTxT.getText().equals(Integer.toString(idDeVotante(Integer.parseInt(idTxT.getText())))) && !estadoVoto(Integer.parseInt(idTxT.getText())) && horarioJornada(Integer.parseInt(idTxT.getText())).equals("Tarde")){
            mainApp.abrirNuevaVentanaTarde();
            Creacion.siVoto(idDeVotante(Integer.parseInt(idTxT.getText())));

        } else if (idTxT.getText().equals(Integer.toString(idDeVotante(Integer.parseInt(idTxT.getText())))) && !estadoVoto(Integer.parseInt(idTxT.getText())) && horarioJornada(Integer.parseInt(idTxT.getText())).equals("Noche")){
            mainApp.abrirNuevaVentanaNoche();
            Creacion.siVoto(idDeVotante(Integer.parseInt(idTxT.getText())));

        } else {
            mensajeAdvLbl.setText("Esta id ya votó");
        }
    }

    //Método para mostrar resultados una vez se presione un botón en forma de alerta
    @FXML
    public void mostrarAlerta(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VOTOS COLSAFA");
        alert.setHeaderText("Resultados de Votación");
        alert.setContentText(obtenerCandidatos());

        alert.showAndWait();
    }

    //Llamar método para obtener resultados que se encuentra en la clase Application
    private String obtenerCandidatos() {
        return Application.resultadosCandidatos();
    }

    public void setMainApp(Application mainApp) {
        this.mainApp = mainApp;
    }

    //Métodos para recopilar información de los archivos persistidos
    public int idDeVotante(int id){
        return votanteService.findById(id).getId();
    }

    public boolean estadoVoto (int id){
        return votanteService.findById(id).isYaVoto();
    }

    public String horarioJornada (int id){
        return votanteService.findById(id).getJornada();
    }
}