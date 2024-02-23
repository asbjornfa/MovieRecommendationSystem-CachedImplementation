package dk.easv.presentation.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable {
    public Button clickNextBtn;
    public Button clickCancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleCancel(ActionEvent actionEvent) throws IOException {

        Platform.runLater(() -> {
            Stage closeCreateView = (Stage) clickCancelBtn.getScene().getWindow();
            closeCreateView.close();
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LogIn.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Movie Collection");
        stage.show();

    }

    public void handleNext(ActionEvent actionEvent) throws IOException {

        Platform.runLater(() -> {
            Stage closeCreateView = (Stage) clickNextBtn.getScene().getWindow();
            closeCreateView.close();
        });


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Payment.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Movie Collection");
        stage.show();


    }
}
