package com.example.asmaasweet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
//import production_cods.TrackSOurce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;

import static javafx.application.Application.launch;
//import static production_cods.TrackSOurce.setDurationChoice;

public class WriteMyFeedback {


    @FXML
    private RadioButton button1;

    @FXML
    private RadioButton button2;
private  boolean lanch=false;
    @FXML
    private RadioButton button3;

    @FXML
    private RadioButton button4;

    @FXML
    private RadioButton button5;

    @FXML
    private ToggleGroup feedBak;

    @FXML
    private TextArea writeOpininon;
    String filePath;
    LoginPageControl log = new LoginPageControl();
private  String id;
    private String opinin;

    @FXML
    void Response(ActionEvent event) throws IOException {

        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("AdminResponse.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();





    }
    @FXML
    void logout(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Loging Out");
        alert.setHeaderText(null);
        alert.setContentText("you will Log out from your account");
        alert.showAndWait();



        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    void Save(ActionEvent event) {


        // Specify the file name and path
     filePath = "entered.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line by commas
                String[] parts = line.split(" ");
                // Check if the line has the correct number of parts

                    System.out.println("hi");
                    id = parts[0];



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        opinin="User ID"+ " "+id+": "+writeOpininon.getText();



        // Append the new product to the file
     filePath = "CustomerFeedback.txt";
        File file = new File(filePath);


        // Use try-with-resources to ensure the file is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // 'true' to open in append mode


                writer.write(opinin);
                writer.newLine();
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null,"Thanks For your FeedBack");


    }



    @FXML
    void getAction(ActionEvent event)
    {

        if (button1.isSelected())
        {



        }






    }



    @FXML
    void opinionTyped(KeyEvent event) {

    }

    public String getOpinin() {
        return opinin;
    }

    public void setOpinin(String opinin) {
        this.opinin = opinin;
    }


    public boolean isLanch() {
        return lanch;
    }

    public void setLanch(boolean lanch) {
        this.lanch = lanch;
    }

    @FXML
    void Track(ActionEvent event) throws IOException {



    }
}


