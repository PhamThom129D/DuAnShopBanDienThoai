package com.example.duan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    Connection connection = DatabaseConnection.getConnection();
    Statement statement = connection.createStatement();

    public Test() throws SQLException {
    }
    public void show(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String role = resultSet.getString("role");
            String state = resultSet.getString("state");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phoneNumber");
            System.out.println("Thông tin khách hàng : "+role+" "+state+" "+username+" "+password+" "+address+" "+phoneNumber);
        }
    }

}
