package org.example.sistemavotos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.sistemavotos.aplication.service.Creacion;

public class VotosController {

    //Botones para votar cada respectivo candidato
    @FXML
    private Button votoCandidato1JM;
    @FXML
    private Button votoCandidato2JM;
    @FXML
    private Button votoCandidatoBJM;
    @FXML
    private Button votoCandidato1JT;
    @FXML
    private Button votoCandidato2JT;
    @FXML
    private Button votoCandidatoBJT;
    @FXML
    private Button votoCandidato1JN;
    @FXML
    private Button votoCandidato2JN;
    @FXML
    private Button votoCandidatoBJN;


    //Métodos para asignar al botón del respectivo candidado un voto
    public void votarBtnOnAction1JM(ActionEvent event){
        Creacion.sumarVoto(11);
        Stage stage = (Stage) votoCandidato1JM.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnAction2JM(ActionEvent event){
        Creacion.sumarVoto(12);
        Stage stage = (Stage) votoCandidato2JM.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnActionBJM(ActionEvent event){
        Creacion.sumarVoto(13);
        Stage stage = (Stage) votoCandidatoBJM.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnAction1JT(ActionEvent event){
        Creacion.sumarVoto(21);
        Stage stage = (Stage) votoCandidato1JT.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnAction2JT(ActionEvent event){
        Creacion.sumarVoto(22);
        Stage stage = (Stage) votoCandidato2JT.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnActionBJT(ActionEvent event){
        Creacion.sumarVoto(23);
        Stage stage = (Stage) votoCandidatoBJT.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnAction1JN(ActionEvent event){
        Creacion.sumarVoto(31);
        Stage stage = (Stage) votoCandidato1JN.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnAction2JN(ActionEvent event){
        Creacion.sumarVoto(32);
        Stage stage = (Stage) votoCandidato2JN.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    public void votarBtnOnActionBJN(ActionEvent event){
        Creacion.sumarVoto(33);
        Stage stage = (Stage) votoCandidatoBJN.getScene().getWindow();
        stage.close();
        agradecerVoto();
    }

    //Método de agradecimiento por votar en formato de alerta
    @FXML
    public void agradecerVoto(){
        Alert alertAgradecimiento = new Alert(Alert.AlertType.CONFIRMATION);
        alertAgradecimiento.setTitle("VOTOS COLSAFA");
        alertAgradecimiento.setHeaderText("Voto registrado correctamente");
        alertAgradecimiento.setContentText("Gracias por votar");

        alertAgradecimiento.showAndWait();

    }
}
