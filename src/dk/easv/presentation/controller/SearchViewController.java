package dk.easv.presentation.controller;

import dk.easv.dataaccess.TMDBConnector;
import dk.easv.entities.TMDBMovie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TilePane searchTilePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            // Create a TMDBConnector instance to fetch movies from TMDb
            TMDBConnector tmdbConnector = new TMDBConnector();

            // Get the list of TMDBMovie objects from the connector
            List<TMDBMovie> tmdbMovies = tmdbConnector.getMoviesFound();

            for (TMDBMovie tmdbMovie : tmdbMovies) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/MovieSample.fxml"));
                VBox box = fxmlLoader.load();
                MovieSampleController movieSampleController = fxmlLoader.getController();

                // Set data for the MovieSampleController using TMDBMovie
                movieSampleController.setData(tmdbMovie);

                searchTilePane.getChildren().add(box);
                TilePane.setMargin(box, new Insets(15));

            }
        } catch (IOException | JSONException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
