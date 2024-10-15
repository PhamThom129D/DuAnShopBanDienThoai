module com.example.duan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.duan to javafx.fxml;
    exports com.example.duan;
}