package dk.easv.presentation.controller;


import dk.easv.entities.TMDBMovie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MovieSampleController {

    @FXML
    private ImageView moviePoster;

    @FXML
    private Label lblMovieName;

    public void setData(TMDBMovie tmdbMovie) {
        String posterPath = tmdbMovie.getPoster_path();
        Image image = new Image("https://image.tmdb.org/t/p/original" + posterPath);
        moviePoster.setImage(image);

        lblMovieName.setText(tmdbMovie.getOriginal_title());
    }
}
