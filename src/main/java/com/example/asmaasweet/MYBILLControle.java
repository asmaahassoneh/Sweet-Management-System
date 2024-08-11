package com.example.asmaasweet;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;

public class MYBILLControle implements Initializable {


    @FXML
    private TableView<AdminMYbillTAble> billTAble;

    @FXML
    private TableColumn<AdminMYbillTAble, Integer> PriceColumn;
    @FXML
    private TableColumn<AdminMYbillTAble, String> dateOFbuyy;
    @FXML
    private TableColumn<AdminMYbillTAble, String> Product_Name;

    @FXML
    private TableColumn<AdminMYbillTAble, Integer> StockTable;

    @FXML
    private TableColumn<AdminMYbillTAble, String> discriptionTable;
    @FXML
    private Label priceLable;
    String productSSN ;
    int quan;
    Vector<String>ids=new Vector<>();
    Vector<String>Mycart=new Vector<>();
    Vector<String>ids2=new Vector<>();
    Vector<Integer>quantitybase=new Vector<>();
    int price ;
    String productName ;
    String description;
    int i=0;
    int temp;
    @FXML
    private TextField deleteTExtx;
    String id;

Vector<String>getdate=new Vector<>();
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Product_Name.setCellValueFactory(new PropertyValueFactory<AdminMYbillTAble, String>("Product_Name"));

        PriceColumn.setCellValueFactory(new PropertyValueFactory<AdminMYbillTAble, Integer>("PriceColumn"));


        StockTable.setCellValueFactory(new PropertyValueFactory<AdminMYbillTAble, Integer>("StockTable"));





    }
    @FXML
    void selected(MouseEvent event) throws SQLException {

        AdminMYbillTAble clickedData=billTAble.getSelectionModel().getSelectedItem();

       deleteTExtx.setText(String.valueOf(clickedData.getProduct_name()));


    }
    @FXML
    void delete(ActionEvent event) {
        int Slect= billTAble.getSelectionModel().getSelectedIndex();
        billTAble.getItems().remove(Slect);

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText("You have been Delete the Product Successfully");
    alert.showAndWait();
}


/*
    @FXML
    void bill(ActionEvent event) {



        AdminMYbillTAble addBase = new AdminTAblebill(    //give it the data that you want to fill the tabel with

                    );
                    ObservableList<AdminMYbillTAble> adds = billTAble.getItems();
                    adds.add(addBase);
                    billTAble.setItems(adds);

                }








    @FXML
    void mycart(ActionEvent event) {

                    AdminTAblebill addBase = new AdminTAblebill(


                    );

                    ObservableList<AdminMYbillTAble> adds = billTAble.getItems();
                    adds.add(addBase);
                    billTAble.setItems(adds);

                }

*/


    @FXML
    void purchase(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(null);
     //   alert.setContentText("you have been Purchase Sucsessfully"+" "+ data.getMemberName());
        alert.showAndWait();

    }

    @FXML
    void rreturnHShop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SweetShop.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
