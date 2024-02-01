package dk.easv.presentation.controller;


import dk.easv.entities.ThumbPic;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ThumbController {
    @FXML
    private ImageView thumbNail;

    public ThumbController() {

    }





    public void setData(ThumbPic thumbPic) {
        Image image = new Image(getClass().getResourceAsStream(thumbPic.getThumbSrc()));
        thumbNail.setImage(image);
    }
}
