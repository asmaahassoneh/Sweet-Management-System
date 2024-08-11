package com.example.najehfxsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminChoices {


    LoginPageControl log=new LoginPageControl();


    @FXML
    void feedback(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("AdminAddRespons.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();




    }


    @FXML
    void CheckOutShop(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("SweetShop.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();




    }

    @FXML
    void CheckStore(ActionEvent event) throws IOException {



        Parent root = FXMLLoader.load(getClass().getResource("StoreOwnerMange.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void ManageaccountButton(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("AdminManageAccount.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();








    }

    @FXML
    void exit(ActionEvent event) throws IOException {


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Loging Out");
            alert.setHeaderText(null);
            alert.setContentText("you will Log out from your account");
            alert.showAndWait();



            //open or return to login page
            Parent root = FXMLLoader.load(getClass().getResource("SignUpControl.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


    }


