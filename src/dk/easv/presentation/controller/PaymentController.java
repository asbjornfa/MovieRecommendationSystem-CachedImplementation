package dk.easv.presentation.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {
    public Button clickBackBtn;
    public Button clickFinishBtn;

    public void handleFinish(ActionEvent actionEvent) throws IOException {
        Platform.runLater(() -> {
            Stage closeCreateView = (Stage) clickFinishBtn.getScene().getWindow();
            closeCreateView.close();
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainWindow.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Movie Recommendation System 0.01 Beta");
        stage.show();
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        Platform.runLater(() -> {
            Stage closeCreateView = (Stage) clickBackBtn.getScene().getWindow();
            closeCreateView.close();
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CreateAccount.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Movie Recommendation System 0.01 Beta");
        stage.show();
    }
}
