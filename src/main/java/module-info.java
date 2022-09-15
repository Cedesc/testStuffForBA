module com.example.teststuffforba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.teststuffforba to javafx.fxml;
    exports com.example.teststuffforba;
}