package com.example.duan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL ="jdbc:mysql://localhost:3306/quanlyshopbandienthoai";
    private static final String USER1 = "root";
    private static final String PASSWORD1 = "1209";
    private static final String USER2 = "root";
    private static final String PASSWORD2 = "linhnhi124";
    public static Connection getConnection(int user) throws SQLException {
        switch (user) {
            case 1:
            return DriverManager.getConnection(URL, USER1, PASSWORD1);
            case 2:
                return DriverManager.getConnection(URL, USER2, PASSWORD2);
            default:
                System.out.println("Không tìm thấy tài khoản Database");
                return null;
        }
    }
}
