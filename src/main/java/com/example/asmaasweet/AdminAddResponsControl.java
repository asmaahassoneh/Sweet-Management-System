package com.example.asmaasweet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import production_cods.Product;

import javax.swing.*;
import java.io.*;
import java.security.PrivateKey;

public class AdminAddResponsControl {

    @FXML
    private TextArea SeeResponse;
    String filePath;
    @FXML
    private TextArea answerResponse;

    @FXML
    private Label counter;
    private String answer;

    WriteMyFeedback feed=new WriteMyFeedback();
    @FXML
    void CheckUser(ActionEvent event) {

         filePath = "CustomerFeedBack.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line by the colon followed by space
                String[] parts = line.split(": ");

                // Check if the line has the correct number of parts
                if (parts.length == 2) {
                    // parts[0] will contain the ID (e.g., N002)
                    // parts[1] will contain the feedback message (e.g., rkrkerkr)


                    SeeResponse.setText(parts[0]+"\nFeedBack=>"+parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void RturnHome(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("AdminChoices.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();






    }


    @FXML
    void SubmitResponse(ActionEvent event) {
        answer=answerResponse.getText();


System.out.println(answer);

        // Append the new product to the file
        filePath = "answers.txt";
        File file = new File(filePath);


        // Use try-with-resources to ensure the file is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // 'true' to open in append mode


            writer.write(answer);
            writer.newLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null,"Process Done");


    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}



















