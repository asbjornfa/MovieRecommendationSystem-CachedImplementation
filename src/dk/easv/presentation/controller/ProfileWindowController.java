package dk.easv.presentation.controller;

import dk.easv.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileWindowController {

    @FXML
    private Button btnSelectProfile1;

    @FXML
    private Button btnSignout;

    @FXML
    private Label profileWinUser;

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    @FXML
    private void handleSelectProfile1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainWindow.fxml"));
        Parent root = loader.load();

        MainWindowController mainWindowController = loader.getController();
        mainWindowController.displayName(getUsername());
        mainWindowController.setUsername(username);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Movie Recommendation System 0.01 Beta");
        stage.show();

        Platform.runLater(() -> {
            Stage closeProfileView = (Stage) btnSelectProfile1.getScene().getWindow();
            closeProfileView.close();
        });
    }

    @FXML
    public void handleSelectProfile2(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainWindow.fxml"));
        Parent root = loader.load();
        MainWindowController mainWindowController = loader.getController();
        mainWindowController.setLblUserNameP2();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Movie Recommendation System 0.01 Beta");
        stage.show();

        Platform.runLater(() -> {
            Stage closeProfileView = (Stage) btnSelectProfile1.getScene().getWindow();
            closeProfileView.close();
        });
    }

    public void setProfile1Name() {
        profileWinUser.setText(username);
    }

    @FXML
    private void handleSignout(ActionEvent event) throws IOException {
        System.out.println("Virker");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LogIn.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.show();

        Platform.runLater(() -> {
            Stage closeProfileView = (Stage) btnSignout.getScene().getWindow();
            closeProfileView.close();
        });
    }
}
