package com.example.hibasweet;

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
import production_cods.Purchased;

import javax.swing.*;
import java.io.*;
import java.util.Objects;

    public class LoginPageControl {
        Purchased pur=new Purchased();

        @FXML
        private PasswordField passFiled;

        @FXML
        private TextField userFiled;
        LoginSource log=new LoginSource();
 private String Takepass;
        private  String TakeUserName;

private String setLable;

        public String getTakeUserName() {
            return TakeUserName;
        }

        public void setTakeUserName(String takeUserName) {
            TakeUserName = takeUserName;
        }

        public String getTakepass() {
            return Takepass;
        }

        public void setTakepass(String takepass) {
            Takepass = takepass;
        }

        @FXML
        void loggPageButton(ActionEvent event) throws IOException {
log.checkLoginValidInFile(TakeUserName,Takepass);
if(log.getFoundAccount())
{

    JOptionPane.showMessageDialog(null,"Welcome to you Account");
if(Objects.equals(log.getWorkRole(), "Employee"))
    {

        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("StoreOwnerMange.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
if(log.getWorkRole().equals("user"))
{



    //open or return to login page
    Parent root = FXMLLoader.load(getClass().getResource("SweetShop.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
    if(log.getWorkRole().equals("Admin"))
    {

        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("AdminChoices.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
else
{
    JOptionPane.showMessageDialog(null,"Please make Sure from the Entered data");
}
        }

        @FXML
        void loginUserName(ActionEvent event) throws IOException {

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


            // Append the new product to the file
            String filePath = "entered.txt";
            File file = new File(filePath);


            // Use try-with-resources to ensure the file is closed properly
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // 'true' to open in append mode


                    writer.write(passFiled.getText());
                    writer.newLine();



            } catch (IOException e) {
                e.printStackTrace();

            }












setTakepass(passFiled.getText());


        }

    }














