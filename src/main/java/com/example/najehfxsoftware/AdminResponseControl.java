package com.example.najehfxsoftware;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminResponseControl {

    @FXML
    private TextArea SeeAnswers;
    private String enteredUser;
String filePath;
    AdminAddResponsControl add=new AdminAddResponsControl();




    public void readd(javafx.event.ActionEvent event) {


        filePath = "entered.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Directly read the ID from each line
                enteredUser = line.trim(); // Remove any leading/trailing whitespace
                System.out.println(enteredUser);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
















       filePath = "answers.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line by the colon followed by space
                String[] parts = line.split(":");

                // Check if the line has the correct number of parts
                if (parts.length == 2) {

                    // Check if the ID matches the search ID
                    if (parts[0].equals(enteredUser)) {
                        ;
                     SeeAnswers.setText("Admin Says =>"+" "+parts[1]);
                        break; // Exit loop once the ID is found
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }












    }


