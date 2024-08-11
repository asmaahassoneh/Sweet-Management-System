package com.example.asmaasweet;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import production_cods.MANAGE_AccSource;
import production_cods.SignupSource;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class AdminManageAccountControl implements Initializable {

    @FXML
    private TableView<AdminTAblebill> AdminTable;

    @FXML
    private TextField CityText;

    @FXML
    private TableColumn<AdminTAblebill, String> Email;

    @FXML
    private TextField EmailText;

    @FXML
    private TableColumn<AdminTAblebill, String> Password;

    @FXML
    private TableColumn<AdminTAblebill, String> Role;

    @FXML
    private TextField RoleText;

    @FXML
    private TextField UserNameTexr;

    @FXML
    private TableColumn<AdminTAblebill, String> User_name;

    @FXML
    private TableColumn<AdminTAblebill, String> city;

    @FXML
    private TextField passwordText;

    private String TakeCity;
    private String TakeRole;
    private String TakePass;
    private String TakeUser_Name;
    private String TakeEmail;
    private  boolean ValidAccountADDed;
    SignupSource sign=new SignupSource();


    MANAGE_AccSource manges=new MANAGE_AccSource();


    private Vector<User> TempUser = new Vector<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Email.setCellValueFactory(new PropertyValueFactory<AdminTAblebill,String>("Email"));

        Password.setCellValueFactory(new PropertyValueFactory<AdminTAblebill,String>("Password"));

        Role.setCellValueFactory(new PropertyValueFactory<AdminTAblebill,String>("Role"));

        User_name.setCellValueFactory(new PropertyValueFactory<AdminTAblebill,String>("User_name"));

        city.setCellValueFactory(new PropertyValueFactory<AdminTAblebill,String>("city"));


    }


    @FXML
    void LogOut(ActionEvent event) throws IOException {


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
    void Addbutton(ActionEvent event) {


ValidAccountADDed=sign.validUserInputData(TakeUser_Name,TakeCity,TakeEmail,TakePass,TakePass);

if(ValidAccountADDed)
{
    sign.SetanAccount(TakeUser_Name,TakeCity,TakeEmail,TakePass,TakePass,TakeRole);
}



    }

    @FXML
    void CityTextMethod(ActionEvent event) {
        TakeCity=CityText.getText();

    }

    @FXML
    void EmailTextMethod(ActionEvent event) {
TakeEmail=EmailText.getText();
    }

    @FXML
    void HomeButton(ActionEvent event) throws IOException {



        //open or return to login page
        Parent root = FXMLLoader.load(getClass().getResource("AdminChoices.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();






    }

    @FXML
    void RoleMethod(ActionEvent event) {
 TakeRole=RoleText.getText();
    }

    @FXML
    void UserNameTexrMethod(ActionEvent event) {
TakeUser_Name=UserNameTexr.getText();
    }

    @FXML
    void deletButton(ActionEvent event) {

boolean deleteUser=manges.DeleteUser(TakePass);

if(deleteUser)
{
    JOptionPane.showMessageDialog(null,"The user has been deleted Successfuly");
}


    }

    @FXML
    void loadFromBase(ActionEvent event) {
        TempUser=manges.PullTheUsersFromFile();

        for(int i=0;i<TempUser.size();i++) {


            AdminTAblebill Ad=new AdminTAblebill(TempUser.get(i).getUserName(),TempUser.get(i).getCity(),TempUser.get(i).getEmail()
                    ,TempUser.get(i).getPassWord(),TempUser.get(i).getRole());


            ObservableList<AdminTAblebill> adds= AdminTable.getItems();
            adds.add(Ad);
            AdminTable.setItems(adds);
        }


    }

    @FXML
    void passwordTextMethod(ActionEvent event) {
TakePass=passwordText.getText();
    }

    @FXML
    void select(MouseEvent event) {

        AdminTAblebill clickedData=AdminTable.getSelectionModel().getSelectedItem();
        passwordText.setText(String.valueOf(clickedData.getPassword()));
        EmailText.setText( String.valueOf(clickedData.getEmail()));
        CityText.setText( String.valueOf(clickedData.getCity()));
        UserNameTexr.setText( String.valueOf(clickedData.getUser_name()));
        RoleText.setText(String.valueOf(clickedData.getRole()));
    }

    @FXML
    void updateButton(ActionEvent event) {

        boolean UpdatedDone=manges.UpdateEmail(TakeEmail,TakeUser_Name,TakeRole,TakeCity,TakePass);


        if (UpdatedDone)
        {

            JOptionPane.showMessageDialog(null,"You have been Update the Account Successfuly");

        }

    }

}
