/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.*;

import model.Order;

/**
 *
 * @author maccuacu
 */
public class OrderDAO {
    
    private Connection connection = JdbcHelper.getConnection();
    
    public Order getOrderById(String orderId) {
         String query = "SELECT * FROM Orders WHERE id = ?";
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String ma = resultSet.getString("ma");
                String name = resultSet.getString("name");
                String idKh = resultSet.getString("idKh");
                String idCh = resultSet.getString("idCh");
                Date ngayTao = resultSet.getDate("ngayTao");
                Date ngaySua = resultSet.getDate("ngaySua");
                boolean status = resultSet.getBoolean("status");

                return new Order(id, ma, name, idKh, idCh, ngayTao, ngaySua, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updateOrder(Order order) {
        try (Connection connection = JdbcHelper.getConnection()) {
            String query = "UPDATE Orders SET ma = ?, name = ?, idKh = ?, idCh = ?, ngayTao = ?, ngaySua = ?, status = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getMa());
            preparedStatement.setString(2, order.getName());
            preparedStatement.setString(3, order.getIdKh());
            preparedStatement.setString(4, order.getIdCh());
            preparedStatement.setDate(5, new java.sql.Date(order.getNgayTao().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(order.getNgaySua().getTime()));
            preparedStatement.setBoolean(7, order.isStatus());
            preparedStatement.setString(8, order.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteOrder(String orderId) {
        try (Connection connection = JdbcHelper.getConnection()) {
            String query = "DELETE FROM Orders WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
