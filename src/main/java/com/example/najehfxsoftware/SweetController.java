package com.example.najehfxsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import production_cods.AllergySource;
import production_cods.LoginSource;
import production_cods.NotificationSource;
import production_cods.Product;


import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.*;

public class SweetController implements Initializable {
    @FXML
    private VBox chosenFruitCard;
    String password;
    String priceFile;
    String quantitysFile;
    String dateFile;
    String filePath;
    @FXML
    private Label fruitNameLable;
    @FXML
    private ComboBox<Integer> combox1;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private ImageView fruitImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private final List<Fruit> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    LoginSource log = new LoginSource();

    String prod1;

    String name;
    String id;
    String ids;
    String type;
    String date;
    int quantity;
    double price;
    boolean availability;
    String imagePathes;
    String Product_nameONClick;
    Vector<String>temp=new Vector<>();
    String whosEnterd;
    Vector<Product> Temp = new Vector<>();
    GmailContole gm=new GmailContole();
    AllergySource all=new AllergySource();

    StatisticsController stat=new StatisticsController();
    private List<Fruit> getData() {
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit;


        fruit = new Fruit();
        fruit.setName("Cake slice");
        fruit.setPrice(5);
        fruit.setImgSrc("images/cakeSlice.jpg");
        fruit.setColor("000000"); // Different color
        fruits.add(fruit);


        fruit = new Fruit();
        fruit.setName("Macaronis");
        fruit.setPrice(3);
        fruit.setImgSrc("images/mac.jpg");
        fruit.setColor("A133FF"); // Different color
        fruits.add(fruit);


        return fruits;
    }


    public List<Fruit> setFruit(String Product_name, double price, String imagePath) {
        List<Fruit> fruits = new ArrayList<>();


        Fruit fruit = new Fruit();
        fruit.setName(Product_name);
        fruit.setPrice(price);
        fruit.setImgSrc(imagePath);
        fruit.setColor("000000"); // Different color
        fruits.add(fruit);

        return fruits;
    }

    private void setChosenFruit(Fruit fruit) {
        fruitNameLable.setText(fruit.getName());
        fruitPriceLabel.setText(Main.CURRENCY + " " + fruit.getPrice());
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(fruit.getImgSrc())));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    public void initialize(URL location, ResourceBundle resources) {
        fruits.addAll(getData());

        String filePath = "Products.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 8) { // Ensure the line has the correct number of fields
                    name = fields[0];
                    id = fields[1];
                    type = fields[2];
                    date = fields[3];
                    quantity = Integer.parseInt(fields[4]);
                    price = Double.parseDouble(fields[5]);
                    availability = Boolean.parseBoolean(fields[6]);
                    imagePathes = fields[7];
                }
                fruits.addAll(setFruit(name, price, imagePathes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (!fruits.isEmpty()) {

            setChosenFruit(fruits.get(0));
            // setChosenFruit(fruits.get(1));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Fruit fruit) {
                    setChosenFruit(fruit);
                    Product_nameONClick = fruit.getName();


                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));


            }


            //   combox1.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
            combox1.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

            combox1.setValue(1);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void refresh(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SweetShop.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void FilterAllergy(MouseEvent event) throws IOException {


        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 1) {




                temp = all.SearchForAllergy();


                filePath = "temp.txt";

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
                    // Write each product to the file
                     for(int i=0;i<temp.size();i++){

                    writer.write(temp.get(i));
                    writer.newLine(); // To write each product on a new line
                     }
                    System.out.println("Data has been written to " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }






                // Path to your text file
                filePath = "Products.txt";

                // Vector to store the lines not containing "true"
                Vector<String> filteredLines = new Vector<>();

                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;

                    // Read file line by line
                    while ((line = br.readLine()) != null) {
                        // Check if the line contains "true"
                        if (!line.contains("true")) {
                            // Add the line to the vector if it does not contain "true"
                            filteredLines.add(line);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Write the filtered lines back to the file
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                    for (String filteredLine : filteredLines) {
                        bw.write(filteredLine);
                        bw.newLine(); // Add a new line after each entry
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }

            if (event.getClickCount() == 2) {




                // Path to your text file
                filePath = "temp.txt";

                // Vector to store the lines not containing "true"
                Vector<String> filteredLines = new Vector<>();

                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;

                    // Read file line by line
                    while ((line = br.readLine()) != null) {
                        // Check if the line contains "true"
                        if (!line.contains("false")) {
                            // Add the line to the vector if it does not contain "true"
                            filteredLines.add(line);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }














                filePath = "Products.txt";

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
                    // Write each product to the file
                    for(int i=0;i<filteredLines.size();i++){

                        writer.write(filteredLines.get(i));
                        writer.newLine(); // To write each product on a new line
                    }
                    System.out.println("Data has been written to " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }


    }














    @FXML
    void homepage(ActionEvent event) throws IOException {






        filePath = "entered.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line by the colon followed by space
                String[] parts = line.split(" ");

                whosEnterd=parts[0];
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (Objects.equals(whosEnterd, "H1414")) {
            Parent root = FXMLLoader.load(getClass().getResource("AdminChoices.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(Objects.equals(whosEnterd, "AA258"))
        {

            Parent root = FXMLLoader.load(getClass().getResource("StoreOwnerMange.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        if(Objects.equals(whosEnterd,"N002"))
        {


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
        else {

            Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }
    }

    //will detect which user entered and depends on hi password will add the product that the user bought it
    @FXML
    void seeMYbillle(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();












    }
    public static void clearFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // This will truncate the file, clearing its contents
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void AddToCart(ActionEvent event) {
        quantity = combox1.getValue();


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


        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String dataToAdd = Product_nameONClick;
        System.out.println(dataToAdd);
        filePath = "Products.txt";
        File file = new File(filePath);

        StringBuilder contentBuilder = new StringBuilder();

        // Read the file and build the updated content
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(dataToAdd)) {
                    String[] parts = line.split(",");
                    if (parts.length == 8) {
                        System.out.println("hi");

                        Product o = new Product(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Double.parseDouble(parts[5]), Boolean.parseBoolean(parts[6]), parts[7]);

                        Temp.add(o);

                        line = String.join(",", parts); // Update the line with the new email
                    }

                }
                contentBuilder.append(line).append(System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();


        }


        filePath = "PuarchedProduct.txt";

        priceFile = String.valueOf(Temp.get(0).getPrice());
        quantitysFile = String.valueOf(Temp.get(0).getQuantity());
        dateFile = Temp.get(0).getDate();
        ids=Temp.get(0).getID();

        try {
            // Read all lines from the file
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Check if the password is found and modify the line
            boolean passwordFound = false;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains(password)) {
                    lines.set(i, lines.get(i) +","+ Temp.get(0).getProduct_name() +" "+id+ " " + priceFile + "  " + quantity + "  " + dateFile);
                    passwordFound = true;
                    break;
                }
            }

            // If password is not found, add the password and data as a new line
            if (!passwordFound) {
                lines.add(password  +","+ Temp.get(0).getProduct_name() +" "+id + " " + priceFile + "  " + quantity + "  " + dateFile);
            }

            // Write the modified lines back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            for (String modifiedLine : lines) {
                writer.write(modifiedLine);
                writer.newLine();
            }
            writer.close();

            JOptionPane.showMessageDialog(null,"Successfully Added to your Cart");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    @FXML
    void SpecialOrder(ActionEvent event) throws IOException {
        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("Gmail.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();




    }





}




















