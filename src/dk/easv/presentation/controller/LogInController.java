package dk.easv.presentation.controller;

import dk.easv.presentation.model.AppModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    public Button btnLogin;
    public Button btnCreate;
    @FXML
    private PasswordField enterPassword;
    @FXML
    private TextField enterEmail;
    private AppModel model;
    @FXML
    private ImageView logoImage;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new AppModel();
    }


    public void signUp(ActionEvent actionEvent) {
        System.out.println("Sign-Up");
    }

    public void handleLogIn(ActionEvent actionEvent) {
        model.loadUsers();
        model.loginUserFromUsername(enterEmail.getText());
        if(model.getObsLoggedInUser()!=null){
            try {

                Platform.runLater(() -> {
                    Stage closeLogInView = (Stage) btnLogin.getScene().getWindow();
                    closeLogInView.close();
                });


                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainWindow.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Movie Recommendation System 0.01 Beta");
                stage.show();
                //AppController controller = loader.getController();

                //controller.setModel(model);


            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Could not load MainWindow.fxml");
                alert.showAndWait();
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password");
            alert.showAndWait();
        }
    }

    public void handleCreate(ActionEvent actionEvent) {
        try {
            Platform.runLater(() -> {
                Stage closeLogInView = (Stage) btnCreate.getScene().getWindow();
                closeLogInView.close();
            });


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CreateAccount.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Movie Recommendation System 0.01 Beta");
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could not load MainWindow.fxml");
            alert.showAndWait();
        }
    }
}
