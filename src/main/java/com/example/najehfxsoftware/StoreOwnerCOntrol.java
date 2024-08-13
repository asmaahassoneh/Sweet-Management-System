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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import production_cods.Product;
import production_cods.ProductManageSource;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Vector;

public class StoreOwnerCOntrol implements Initializable {


    Vector<Product> Temp = new Vector<>();

    ProductManageSource prod = new ProductManageSource();
    @FXML
    private TableView<StoreOwnerTable> AdminTabl;

    @FXML
    private TableColumn<StoreOwnerTable, String> Allergy;
    @FXML
    private TableColumn<StoreOwnerTable, Double> PriceINTable;
    @FXML
    private TableColumn<StoreOwnerTable, String> Product_Name;
    @FXML
    private TableColumn<StoreOwnerTable, String> imagePath;

    @FXML
    private TableColumn<StoreOwnerTable, String> Product_id;
    @FXML
    private TableColumn<StoreOwnerTable, String> dateTable;
    @FXML
    private TableColumn<StoreOwnerTable, String> discriptionTable;
    @FXML
    private TableColumn<StoreOwnerTable, Integer> StockTable;

    private String imagePPath;
    @FXML
    private TextField ProductID;
    @FXML
    private TextField allergy;
    @FXML
    private TextField Stock;

    @FXML
    private TextField date;

    @FXML
    private TextField discription;

    @FXML
    private TextField priceTextFiled;

    @FXML
    private TextField product_name;
    String ProdNameTemp;

    String Product_id_Temp;
    String discriptionTemp;
    String dateTemp;
    int stockTemp;
    Stage primaryStage;
    int pricetemp;
    String Product_id_TempBase;
    String ProdNameTempBase;
    String discriptionTempBase;

    @FXML
    private Button imgbutton;
    String dateTempBase;
    int pricetempBase;
    int stockTempBase;
    String allergyTemp;

    @FXML
    private ImageView img;
    String desiredPart = null;

    @FXML
    private AnchorPane imgAnchorpane;
LoginPageControl log=new LoginPageControl();

    @FXML
    void ProductIDMethod(ActionEvent event) {

        Product_id_Temp = ProductID.getText();

    }

    @FXML
    void StockMethod(ActionEvent event) {
        stockTemp = Integer.parseInt(Stock.getText());
    }

    @FXML
    void dateMethod(ActionEvent event) {
        dateTemp = date.getText();

    }

    @FXML
    void discriptionMethod(ActionEvent event) {

        discriptionTemp = discription.getText();
    }

    @FXML
    void priceMethodd(ActionEvent event) {

        pricetemp = Integer.parseInt(priceTextFiled.getText());

    }

    @FXML
    void prodNameMethod(ActionEvent event) {

        ProdNameTemp = product_name.getText();

    }

    void allergyMethod(ActionEvent event) {
        allergyTemp = allergy.getText();
    }


    /*
        ObservableList<AdminTAble>list= FXCollections.observableArrayList(

                    new AdminTAble( pricetempBase,ProdNameTempBase,Product_id_TempBase,dateTempBase,discriptionTempBase,stockTempBase)




            );

     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Product_Name.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, String>("Product_Name"));

        Product_id.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, String>("Product_id"));

        discriptionTable.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, String>("discriptionTable"));

        PriceINTable.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, Double>("Price"));

        StockTable.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, Integer>("StockTable"));

        dateTable.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, String>("dateTable"));

        imagePath.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, String>("imagePath"));

        Allergy.setCellValueFactory(new PropertyValueFactory<StoreOwnerTable, String>("Allergy"));


    }

    @FXML
    void HomeButtons(ActionEvent event) throws IOException {

        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("SweetShop.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Addbutton(ActionEvent event) throws IOException {




prod.DuplicateID(Product_id_Temp);



if(!prod.isIdFound()) {
    StoreOwnerTable addBase = new StoreOwnerTable(
            pricetemp, ProdNameTemp, Product_id_Temp, dateTemp, discriptionTemp, stockTemp, desiredPart, Boolean.parseBoolean(allergyTemp)
    );
    ObservableList<StoreOwnerTable> adds = AdminTabl.getItems();
    adds.add(addBase);
    AdminTabl.setItems(adds);
    boolean b = prod.addNewProduct(ProdNameTemp, discriptionTemp, Product_id_Temp, dateTemp, stockTemp, pricetemp, Boolean.parseBoolean(allergyTemp),desiredPart);

    if (b) {
        JOptionPane.showMessageDialog(null, "You have been add new Product Successfully");
    } else {

        JOptionPane.showMessageDialog(null, "Please make sure To confirm the ID");
    }
}
else {
    JOptionPane.showMessageDialog(null, "Please  This ID Used Before please Change it");

}
}


    public String getProdNameTemp() {
        return ProdNameTemp;
    }

    public void setProdNameTemp(String prodNameTemp) {
        ProdNameTemp = prodNameTemp;
    }

    @FXML
    void loadFromBase(ActionEvent event) throws IOException {

        String filePath = "Products.txt";
        File file = new File(filePath);


        // Use try-with-resources to ensure the file is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                if (parts.length == 8) {
                    Product user = new Product(parts[0], parts[2], parts[1], parts[3], Integer.parseInt(parts[4]), Double.parseDouble(parts[5]), Boolean.parseBoolean(parts[6]), parts[7]);
                    Temp.add(user);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }



for(int i=0;i<Temp.size();i++){
        StoreOwnerTable addBase = new StoreOwnerTable(
                (int) Temp.get(i).getPrice(), Temp.get(i).getProduct_name(), Temp.get(i).getID(), Temp.get(i).getDate(), Temp.get(i).getDescription(), Temp.get(i).getQuantity(), Temp.get(i).getImagePath(), Temp.get(i).isAllerges()
        );


        ObservableList<StoreOwnerTable> adds = AdminTabl.getItems();
        adds.add(addBase);
        AdminTabl.setItems(adds);

    }
        Temp.clear();
}






        @FXML
        void deletButton(ActionEvent event) { //delete on the product_id so you msut press enter to the id that you want to delete
int Slect= AdminTabl.getSelectionModel().getSelectedIndex();
AdminTabl.getItems().remove(Slect);


            boolean b = prod.removeProduct(Product_id_Temp);

            if(b)
            {
                JOptionPane.showMessageDialog(null,"the Product has been deleted From the Store");
            }


        }
        @FXML
        void select(MouseEvent event) throws SQLException {

            StoreOwnerTable clickedData=AdminTabl.getSelectionModel().getSelectedItem();
       priceTextFiled.setText(String.valueOf(clickedData.getPrice()));
               date.setText( String.valueOf(clickedData.getDateTable()));
               product_name.setText( String.valueOf(clickedData.getProduct_Name()));
                ProductID.setText( String.valueOf(clickedData.getProduct_id()));
               Stock.setText(String.valueOf(clickedData.getStockTable()));
                discription.setText(String.valueOf(clickedData.getDiscriptionTable()));
                allergy.setText(String.valueOf(clickedData.getAllergy()));









        }

    public int getPricetemp() {
        return pricetemp;
    }

    public void setPricetemp(int pricetemp) {
        this.pricetemp = pricetemp;
    }

    @FXML
        void updateButton(ActionEvent event) {




                StoreOwnerTable addBase=new StoreOwnerTable(
                        pricetemp,ProdNameTemp,Product_id_Temp,dateTemp,discriptionTemp,stockTemp,desiredPart,Boolean.parseBoolean(allergyTemp)
                );
                ObservableList<StoreOwnerTable> adds= AdminTabl.getItems();
                adds.add(addBase);
                AdminTabl.setItems(adds);
prod.UpdateProduct(ProdNameTemp,Product_id_Temp,discriptionTemp,dateTemp, stockTemp, pricetemp, Boolean.parseBoolean(allergyTemp),desiredPart);

        }

    @FXML
    void AdminHomeMthode(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("Market.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();





    }



    @FXML
    void importImg(ActionEvent event) {


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            img.setImage(image);
        }
        AnchorPane.setBottomAnchor(img, 40.0);


        imagePPath = selectedFile.getAbsolutePath();
        String delimiter = "\\images\\";

        // Find the index of the last occurrence of \photo\
        int lastIndex = imagePPath.lastIndexOf(delimiter);

        if (lastIndex != -1) {
            // Extract the substring from the last occurrence of \photo\ to the end
            desiredPart = imagePPath.substring(lastIndex + delimiter.length());

            // Replace backslashes with forward slashes
            desiredPart = "images/" + desiredPart;
System.out.println(desiredPart);
        }

    }

    public int getPricetempBase() {
        return pricetempBase;
    }

    public void setPricetempBase(int pricetempBase) {
        this.pricetempBase = pricetempBase;
    }

    public String getDesiredPart() {
        return desiredPart;
    }

    public void setDesiredPart(String desiredPart) {
        this.desiredPart = desiredPart;
    }

    public void allergyesMethod(ActionEvent event) {

        allergyTemp=allergy.getText();

    }

    public String getDiscriptionTempBase() {
        return discriptionTempBase;
    }

    public void setDiscriptionTempBase(String discriptionTempBase) {
        this.discriptionTempBase = discriptionTempBase;
    }

    public String getProduct_id_TempBase() {
        return Product_id_TempBase;
    }

    public void setProduct_id_TempBase(String product_id_TempBase) {
        Product_id_TempBase = product_id_TempBase;
    }

}













