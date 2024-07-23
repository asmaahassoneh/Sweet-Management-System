

    package com.example.najehfxsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import production_cods.SignupSource;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

    public class SignupControl implements Initializable {

        private boolean GUIsignUPData;
        @FXML
        private TextField Email;

        @FXML
        private ChoiceBox<String> SelectRole;

        private String[] role={"Admin","user","raw material provider"};
        @FXML
        private PasswordField passFiledLO;

        @FXML
        private PasswordField passconf;

        @FXML
        private TextField userFiledLO;
        private  String TakeUserName;
        private  String TakePass;
        private  String TakeConfirmPass;
        private  String TakeEmail;
        SignupSource sign =new SignupSource();





        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
SelectRole.getItems().addAll(role);    //use getValue to get the selected role





        }

        @FXML
        void UserNameSign(ActionEvent event) {
             TakeUserName=  userFiledLO.getText();
        }


        @FXML
        void EnterEmail(ActionEvent event) {
TakeEmail=Email.getText();
        }

        @FXML
        void logButton(ActionEvent event) throws IOException {
            //open or return to login page
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void passConfirm(ActionEvent event) {
TakeConfirmPass=passconf.getText();
        }

        @FXML
        void passwordSign(ActionEvent event) {
TakePass=passFiledLO.getText();
        }

        @FXML
        void signupButton(ActionEvent event) {
            checkForUserData();
        }
public void  checkForUserData()
{
    GUIsignUPData =sign.validUserInputData(TakeUserName,TakeEmail,TakePass,TakeConfirmPass);

    if(GUIsignUPData==true)
    {


      sign.SetanAccount(TakeUserName,TakeEmail,TakePass,TakeConfirmPass,SelectRole.getValue());
    }
    else {

        JOptionPane.showMessageDialog(null,"Please follow the Standers to create your account");
    }
}

    }



