package dk.easv.presentation.controller;


import dk.easv.dataaccess.TMDBConnector;
import dk.easv.entities.TMDBMovie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private BorderPane MainBorderPane;

    @FXML
    private Label lblHome;

    @FXML
    private Label lblMovieCollection;

    @FXML
    private Label lblMovies;

    @FXML
    private Label lblMyList;

    @FXML
    private Label lblSearch;

    @FXML
    private Label lblTVShows;

    @FXML
    private Label lblUserName;

    @FXML
    private Circle profileImage;

    @FXML
    private GridPane movieGrid;

    private Node originalCenter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            // Create a TMDBConnector instance to fetch movies from TMDb
            TMDBConnector tmdbConnector = new TMDBConnector();

            // Get the list of TMDBMovie objects from the connector
            List<TMDBMovie> tmdbMovies = tmdbConnector.getMoviesFound();

            int columns = 0;

           //for (int i = 0; i < movies().size(); i++) {
            for (TMDBMovie tmdbMovie : tmdbMovies) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/MovieSample.fxml"));
                VBox box = fxmlLoader.load();
                MovieSampleController movieSampleController = fxmlLoader.getController();

                // Set data for the MovieSampleController using TMDBMovie
                movieSampleController.setData(tmdbMovie);

                movieGrid.add(box, columns++, 1);
                GridPane.setMargin(box, new Insets(15));

                originalCenter = MainBorderPane.getCenter();
            }
    } catch (IOException | JSONException | URISyntaxException | InterruptedException e) {
        throw new RuntimeException(e);
    }
    }

    @FXML
    private void handleClickMovie(MouseEvent mouseEvent) throws IOException {
        AnchorPane moviesView = FXMLLoader.load(getClass().getResource("/View/MoviesView.fxml"));
        MainBorderPane.setCenter(moviesView);
        System.out.println("working");
    }

    @FXML
    private void handleClickHome(MouseEvent mouseEvent) {
        MainBorderPane.setCenter(originalCenter);
    }

    @FXML
    private void handleClickSearch(MouseEvent mouseEvent) throws IOException {
        AnchorPane searchView = FXMLLoader.load(getClass().getResource("/View/SearchView.fxml"));
        MainBorderPane.setCenter(searchView);
    }
}


