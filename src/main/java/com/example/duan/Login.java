package com.example.duan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
   @FXML
    private Hyperlink sign;
   @FXML
    private Hyperlink forgetPassword;

   public void initialize() {
   }


    public void Login(ActionEvent actionEvent) throws SQLException {
        String username = this.username.getText();
        String password = this.password.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        String role = checkUser(username, password);
        if(role != null){
            System.out.println("Đăng nhập thành công");
            alert.setHeaderText("Welcome to my Shop!");
            switch(role) {
                case "Admin":
                    alert.setContentText("Admin Login " + username );
                    break;
                case "User":
                    alert.setContentText("User Login " + username );
                    break;
                case "Customer":
                    alert.setContentText("Customer Login " + username );
                    break;
            }
        }else{
            System.out.println("Đăng nhập thất bại");
            alert.setHeaderText("Good Bye!");
            alert.setContentText("Login fail");
        }

        alert.showAndWait();
        this.username.requestFocus();
    }

    private String checkUser(String username, String password) throws SQLException {
       Connection conn = DatabaseConnection.getConnection();
       String query = "select * from user where username=? and password=?";
       try(PreparedStatement ps = conn.prepareStatement(query)){
           ps.setString(1,username);
           ps.setString(2,password);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               return rs.getString("role");
           } else {
               return null;
           }

       }catch (SQLException e){
           e.printStackTrace();
           System.out.println("Lỗi kết nối database");
           return null;
       }
    }
}
