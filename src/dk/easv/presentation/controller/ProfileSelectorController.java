package dk.easv.presentation.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileSelectorController {
    @FXML
    private Button btnSelectProfile1;

    @FXML
    private Button btnSelectProfile2;

    @FXML
    private Button btnSignout;

    @FXML
    private Label profSelectUser;

    private String username;

    private MainWindowController mainWindowController;

    public void setUsername(String username) {
        this.username = username;
    }

    private String getUsername() {
        return username;
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    private void handleProfile1(ActionEvent event) throws IOException {
            mainWindowController.displayName(getUsername());
            AnchorPane view = FXMLLoader.load(getClass().getResource("/View/MoviesView.fxml"));
            mainWindowController.MainBorderPane.setCenter(view);
        }


    @FXML
    private void handleProfile2(ActionEvent event) throws IOException {
        mainWindowController.setLblUserNameP2();
        AnchorPane view = FXMLLoader.load(getClass().getResource("/View/MoviesView.fxml"));
        mainWindowController.MainBorderPane.setCenter(view);
    }

    public void setProf1SelectName(String username) {
        profSelectUser.setText(username);
    }


    public void handleSignout(ActionEvent event) throws IOException {
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
