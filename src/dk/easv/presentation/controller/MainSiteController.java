package dk.easv.presentation.controller;

import dk.easv.entities.ThumbPic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainSiteController implements Initializable {

    @FXML
    private GridPane videoGridOne;

    @FXML
    private GridPane videoGridTwo;

    private List<ThumbPic> thumbPicList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        thumbPicList = new ArrayList<>(thumbPicList());

        int columns = 0;
        int row = 1;

        try {
            for (int i = 0; i < thumbPicList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Thumb.fxml"));
                VBox box = fxmlLoader.load();
                ThumbController thumbController = fxmlLoader.getController();
                thumbController.setData(thumbPicList.get(i));

                if (columns == 3) {
                    columns = 0;
                    ++row;
                }

                videoGridOne.add(box, columns++, row);
                GridPane.setMargin(box, new Insets(10));

                //videoGridTwo.add(box, columns++, row);
                //GridPane.setMargin(box, new Insets(10));


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private List<ThumbPic> thumbPicList() {
        List<ThumbPic> ls = new ArrayList<>();

        for (int i=0; i<100; i++) {
            ThumbPic thumbPic = new ThumbPic();
            thumbPic.setThumbSrc("/data/Pictures/blueBackground.jpg");
            ls.add(thumbPic);
        }
        return ls;
    }
}
