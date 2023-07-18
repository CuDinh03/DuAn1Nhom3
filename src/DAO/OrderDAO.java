/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Order;

/**
 *
 * @author maccuacu
 */
public class OrderDAO {
    
    private Connection connection = JdbcHelper.getConnection();
    
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        try {
            String query = "SELECT * FROM hoaDon WHERE trangThai = 1 ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String ma = resultSet.getString("ma");
                String name = resultSet.getString("ten");
                String idKh = resultSet.getString("idKh");
                String idCh = resultSet.getString("idCh");
                Date ngayTao = resultSet.getDate("ngayTao");
                Date ngaySua = resultSet.getDate("ngaySua");
                int status = resultSet.getInt("trangThai");

                Order order = new Order(id, ma, name, idKh, idCh, ngayTao, ngaySua, status);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
    
    
    public void createOrder(Order order) {
        try  {
            String query = "INSERT INTO hoaDon ( ma, ten, idKh, idCh, ngayTao, ngaySua,trangThai ) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getMa());
            preparedStatement.setString(2, order.getName());
            preparedStatement.setString(3, order.getIdKh());
            preparedStatement.setString(4, order.getIdCh());
            preparedStatement.setDate(5, new java.sql.Date(order.getNgayTao().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(order.getNgaySua().getTime()));
            preparedStatement.setInt(7, order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Order getOrderById(String orderId) {
         String query = "SELECT * FROM hoaDon WHERE id = ? and trangThai = 1 ";
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String ma = resultSet.getString("ma");
                String name = resultSet.getString("ten");
                String idKh = resultSet.getString("idKh");
                String idCh = resultSet.getString("idCh");
                Date ngayTao = resultSet.getDate("ngayTao");
                Date ngaySua = resultSet.getDate("ngaySua");
                int status = resultSet.getInt("trangThai");

                return new Order(id, ma, name, idKh, idCh, ngayTao, ngaySua, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateOrder(Order order) {
        try  {
            String query = "UPDATE hoaDon SET ma = ?, ten = ?, idKh = ?, idCh = ?, ngayTao = ?, ngaySua = ?, trangThai = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getMa());
            preparedStatement.setString(2, order.getName());
            preparedStatement.setString(3, order.getIdKh());
            preparedStatement.setString(4, order.getIdCh());
            preparedStatement.setDate(5, new java.sql.Date(order.getNgayTao().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(order.getNgaySua().getTime()));
            preparedStatement.setInt(7, order.getStatus());
            preparedStatement.setString(8, order.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteOrder(String orderId) {
        try {
            String query = "UPDATE hoaDon SET trangThai = 0 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);

            int rowsDeleted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
