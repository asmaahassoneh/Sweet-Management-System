module com.example.sweet_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sweet_system to javafx.fxml;
    exports com.example.sweet_system;
}