package com.example.duan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 480);
        stage.setTitle("DuAnBanDienThoai!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
        Test test = new Test();
        String query = "Select * from User";
        test.show(query);
    }
}
