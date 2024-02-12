package dk.easv.presentation.controller;

import dk.easv.dataaccess.TMDBConnector;
import dk.easv.entities.TMDBMovie;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MoviesViewController implements Initializable {
    public GridPane movieGridMovies;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            // Create a TMDBConnector instance to fetch movies from TMDb
            TMDBConnector tmdbConnector = new TMDBConnector();

            // Get the list of TMDBMovie objects from the connector
            List<TMDBMovie> tmdbMovies = tmdbConnector.getMoviesFound();

            int columns = 0; // Initialize the column index

            // Loop through each TMDBMovie object
            for (TMDBMovie tmdbMovie : tmdbMovies) {
                // Load the MovieSample.fxml file using FXMLLoader
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/MovieSample.fxml"));
                // Load the VBox container from the FXML file
                VBox box = fxmlLoader.load();
                // Get the controller associated with the FXML file
                MovieSampleController movieSampleController = fxmlLoader.getController();

                // Set data for the MovieSampleController using TMDBMovie
                movieSampleController.setData(tmdbMovie);

                // Add the VBox container to the movieGridMovies GridPane at the current column index and row index 1
                movieGridMovies.add(box, columns++, 1);
                // Set margin for the VBox container
                GridPane.setMargin(box, new Insets(15));

            }
        } catch (IOException | JSONException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
