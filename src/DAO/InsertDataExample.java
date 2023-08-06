/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

public class InsertDataExample {
    public static void main(String[] args) {
        // Database connection parameters
         String url = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1";
            String username = "sa";
            String pass = "Password.1";

        // Data for the new record to be inserted
        String code = "SP0028";
        String name = "Sản phẩm mới";
        int quantity = 50;
        String origin = "New Origin";
        double originalPrice = 300;
        String manufacturingDate = "2023-07-31";
        String expirationDate = "2023-08-31";
        String categoryId = "ff9f0d7b-41ef-482a-9e84-2b81e7aa6e37"; // ID from danhMuc table

        try (Connection connection = DriverManager.getConnection(url, username, pass)) {
            // SQL query with placeholders for parameters
            String insertQuery = "INSERT INTO sanPham (ma, ten, soLuong, nguonGoc, giaGoc, ngaySx, hanSD, idDanhMuc, ngayTao, ngaySua, trangThai) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

// Create a PreparedStatement and set the values for the placeholders
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, code);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, quantity);
                preparedStatement.setString(4, origin);
                preparedStatement.setDouble(5, originalPrice);
                preparedStatement.setString(6, manufacturingDate);
                preparedStatement.setString(7, expirationDate);
                preparedStatement.setString(8, categoryId);
                preparedStatement.setString(9, "2023-07-31"); // Created Date
                preparedStatement.setString(10, "2023-07-31"); // Modified Date
                preparedStatement.setInt(11, 1); // Status

                // Execute the INSERT operation
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("New record inserted successfully.");
                } else {
                    System.out.println("Failed to insert the new record.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

