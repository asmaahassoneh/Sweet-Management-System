package com.example.najehfxsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import production_cods.ProfitsSource;

import java.io.IOException;

public class ProfitesController {

    ProfitsSource p=new ProfitsSource();

        @FXML
        private TextField lessSoldedText;

        @FXML
        private TextField mostSloded;

        @FXML
        private TextField totalProfitText;

        @FXML
        void LessMethod(ActionEvent event) {




        }

        @FXML
        void LogOut(ActionEvent event) throws IOException {



            //open or return to login page
            Parent root = FXMLLoader.load(getClass().getResource("AdminAddRespons.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }

        @FXML
        void MostMethod(ActionEvent event) {

        }

        @FXML
        void MostSolded(ActionEvent event) {
           int x= p.mostRepated();

            mostSloded.setText(p.getMAXproductName()+" "+"Purchased times:"+x);


        }

        @FXML
        void ProfitMethodd(ActionEvent event) {

        }

        @FXML
        void TotalProfit(ActionEvent event) {
           totalProfitText.setText(String.valueOf(p.ProfitCalculated()));







        }

        @FXML
        void lessSolded(ActionEvent event) {

           int y= p.lessRepated();

            lessSoldedText.setText(p.getLessproductName()+" "+"Purchased times:"+y);
        }

    }









