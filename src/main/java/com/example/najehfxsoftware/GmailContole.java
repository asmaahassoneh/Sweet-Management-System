package com.example.najehfxsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import production_cods.NotificationSource;

import java.io.IOException;

public class GmailContole {

    @FXML
    private TextArea massegeArea;
    NotificationSource not=new NotificationSource();
    @FXML
    private TextField title;

    private String AreaMassege;


    @FXML
    void SendMasseg(ActionEvent event) {

        AreaMassege=massegeArea.getText();


        not.sendEmail(
                NotificationSource.MANAGER_EMAIL,
                AreaMassege,title.getText()


        );


    }
    @FXML
    void home(ActionEvent event) throws IOException {
        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("SweetShop.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
