package com.example.najehfxsoftware;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import production_cods.TrackSOurce;

public class TrackerControll {


    @FXML
    private HBox box;

    @FXML
    public Label lable;


    public void edit()
    {

        lable = new Label();
        lable.setStyle("-fx-font-size: 24px; -fx-text-fill: #000000;");

        // Set up the VBox layout and add the label
        HBox vbox = new HBox(lable);
        vbox.setAlignment(Pos.CENTER); // Center the label in the VBox
        vbox.setSpacing(10);



    }
    public HBox getBox() {
        return box;
    }

    public void setBox(HBox box) {
        this.box = box;
    }

    public Label getLable() {
        return lable;
    }

    public void setLable(Label lable) {
        this.lable = lable;
    }
}
