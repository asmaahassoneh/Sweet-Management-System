package com.example.najehfxsoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import production_cods.TrackSOurce;

public class Main extends Application{
    public static final String CURRENCY = "ILS";

    @Override
    public void start(Stage stage) {
        try {

            Parent root;
            root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
            Scene scene = new Scene(root);


            stage.setScene(scene);
            stage.show();


        }
        catch (Exception e) {

            // e.printStackTrace();

        }







    }


    public static void main(String[] args) {


    launch(args);




    }

}