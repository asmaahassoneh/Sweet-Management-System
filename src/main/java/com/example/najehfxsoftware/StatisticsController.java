package com.example.najehfxsoftware;

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
import production_cods.ProductManageSource;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.najehfxsoftware.SweetController.clearFile;

public class StatisticsController implements Initializable {
    ProductManageSource prod = new ProductManageSource();
    @FXML
    private TableView<StariscsTable> AdminTabl;
    private double total;

    @FXML
    private TableColumn<StariscsTable, String> Allergy;
    @FXML
    private TableColumn<StariscsTable, Double> Price;
    @FXML
    private TableColumn<StariscsTable, String> Product_Name;
    @FXML
    private TableColumn<StariscsTable, String> imagePath;

    @FXML
    private TableColumn<StariscsTable, String> Product_id;
    @FXML
    private TableColumn<StariscsTable, String> Date;
    @FXML
    private TableColumn<StariscsTable, String> discriptionTable;
    @FXML
    private TableColumn<StariscsTable, Integer> Stock;

    @FXML
    private Label cost;



    @FXML
    private TextField productFiled;
    String id;
    @FXML
    private Button MyBill;
    String filePath;
    String password;
    String cakeId;
    String matchingLine;
    String cake;
    double cakePrice;
    String cakeQuantity;
    String purchaseDate = String.valueOf(Date);

    public Label getCost() {
        return cost;
    }

    public void setCost(Label cost) {
        this.cost = cost;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Product_Name.setCellValueFactory(new PropertyValueFactory<StariscsTable, String>("Product_Name"));

        Product_id.setCellValueFactory(new PropertyValueFactory<StariscsTable, String>("Product_id"));

        Price.setCellValueFactory(new PropertyValueFactory<StariscsTable, Double>("Price"));

        Stock.setCellValueFactory(new PropertyValueFactory<StariscsTable, Integer>("Stock"));

        Date.setCellValueFactory(new PropertyValueFactory<StariscsTable, String>("Date"));




    }



    @FXML
    void productFiledMethod(ActionEvent event) {
        id = productFiled.getText();
    }


    @FXML
    void SeeMybill(ActionEvent event) {

        // Specify the file name and path
        String filePath = "entered.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while (true) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                // Split the line by commas
                String[] parts = line.split(",");
                // Check if the line has the correct number of parts
                if (parts.length == 1) {
                    password = parts[0];

                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

   

        filePath = "PuarchedProduct.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2); // Split the line into 2 parts at the first comma
                if (parts.length > 0 && parts[0].trim().equals(password)) {
                    System.out.println("Matching line: " + line);
                    String[] products = parts[1].trim().split(","); // Split the remaining part by commas

                    for (String product : products) {
                        String[] details = product.trim().split("\\s+"); // Split each section by spaces

                        if (details.length >= 5) {
                            String name = details[0] ;
                            String productId=details[1];// Combine the first two sections as ID
                            String quantity = details[3];
                            double price = Double.parseDouble(details[2]);
                            //  String date = details[5];
                            LocalDate date = LocalDate.now();


                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                            String formattedDate = date.format(formatter);






                            // Print the extracted information
                            System.out.println("Product ID: " + productId);
                            System.out.println("Name: " + name);
                            System.out.println("Price: " + price);
                            System.out.println("Quantity: " + quantity);
                            System.out.println("Date: " + formattedDate);

                            // Save these values to variables or use them as needed
                            cakeId = productId;
                            cake = name;
                            cakePrice = price;
                            cakeQuantity= quantity;
                            purchaseDate=formattedDate;
total+=price;

                            StariscsTable sta = new StariscsTable(
                                    cake,cakeId,cakeQuantity,purchaseDate,cakePrice
                            );

                            ObservableList<StariscsTable> adds = AdminTabl.getItems();
                            adds.add(sta);
                            AdminTabl.setItems(adds);

                            cost.setText(String.valueOf(total));
                        } else {
                            System.out.println("Line section does not have enough details: " + product);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }









    @FXML
    void DeletItam(ActionEvent event) {



        int Slect= AdminTabl.getSelectionModel().getSelectedIndex();
        AdminTabl.getItems().remove(Slect);




        boolean b = prod.removeProduct(id);

        if(b)
        {
            JOptionPane.showMessageDialog(null,"the Product has been deleted From Receipt");
        }




    }

    @FXML
    void FeedBack(ActionEvent event) throws IOException {
        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("WriteMyFeedback.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Purchase(ActionEvent event) {
JOptionPane.showMessageDialog(null,"Purchased was Successfully done Thanks.");

clearFile("PuarchedProduct.txt");
    }

    @FXML
    void ReturnShope(ActionEvent event) throws IOException {

        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("SweetShop.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void select(MouseEvent event) throws SQLException {

        StariscsTable clickedData=AdminTabl.getSelectionModel().getSelectedItem();
        productFiled.setText( String.valueOf(clickedData.getProduct_id()));



    }

}
