


    package com.example.najehfxsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import production_cods.LoginSource;

import javax.swing.*;
import java.io.IOException;

    public class LoginPageControl {

        @FXML
        private PasswordField passFiled;

        @FXML
        private TextField userFiled;
        LoginSource log=new LoginSource();
        String Takepass;
        String TakeUserName;
        @FXML
        void loggPageButton(ActionEvent event) {
log.CheckLoginVaildinFile(TakeUserName,Takepass);
if(log.getFoundaccount())
{
    JOptionPane.showMessageDialog(null,"Welcome to you Account");
}
else
{
    JOptionPane.showMessageDialog(null,"Please make Sure from the Entered data");
}
        }

        @FXML
        void loginUserName(ActionEvent event) {

           TakeUserName= userFiled.getText();

        }

        @FXML
        void logoutbutton(ActionEvent event) throws IOException {
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

        @FXML
        void passWord(ActionEvent event) {
Takepass=passFiled.getText();
        }

    }














