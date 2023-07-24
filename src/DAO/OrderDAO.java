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

    private final Connection connection = JdbcHelper.getConnection();

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM hoaDon WHERE trangThai = 1 ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String ma = resultSet.getString(2);
                String name = resultSet.getString(3);
                Date ngayTao = resultSet.getDate(4);
                Date ngaySua = resultSet.getDate(5);
                String tenKh = resultSet.getString(6);
                String idCh = resultSet.getString(7);
                int status = resultSet.getInt(8);

                Order order = new Order(id, ma, name, tenKh, idCh, ngayTao, ngaySua, status);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public List<Order> findAllByStatus() {
        List<Order> orders = new ArrayList<>();

        try {
            String query = "SELECT * FROM hoaDon WHERE trangThai = 0 ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String ma = resultSet.getString(2);
                String name = resultSet.getString(3);
                String tenNv = resultSet.getString(4);
                Date ngayTao = resultSet.getDate(5);
                Date ngaySua = resultSet.getDate(6);
                String tenKh = resultSet.getString(7);
                String idCh = resultSet.getString(8);
                int status = resultSet.getInt(9);
                Order order = new Order(id, ma, name, tenNv, tenKh, idCh, ngayTao, ngaySua, status);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public void createOrder(Order order) {
        try {
            String query = "INSERT INTO hoaDon ( ma, ten, tenNv, ngayTao, ngaySua, tenKh, idCh, trangThai ) VALUES ( ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getMa());
            preparedStatement.setString(2, order.getName());
            preparedStatement.setString(3, order.getTenNv());
            preparedStatement.setDate(4, new java.sql.Date(order.getNgayTao().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(order.getNgaySua().getTime()));
            preparedStatement.setString(6, order.getTenKh());
            preparedStatement.setString(7, order.getIdCh());
            preparedStatement.setInt(8, order.getStatus());
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
                String tenKh = resultSet.getString("tenKh");
                String idCh = resultSet.getString("idCh");
                Date ngayTao = resultSet.getDate("ngayTao");
                Date ngaySua = resultSet.getDate("ngaySua");
                int status = resultSet.getInt("trangThai");

                return new Order(id, ma, name, tenKh, idCh, ngayTao, ngaySua, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateOrder(Order order) {
        try {
            String query = "UPDATE hoaDon SET ma = ?, ten = ?, tenNv =?,  tenKh = ?, idCh = ?,ngaySua = ?, trangThai = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getMa());
            preparedStatement.setString(2, order.getName());
            preparedStatement.setString(3, order.getTenNv());
            preparedStatement.setString(4, order.getIdKh());
            preparedStatement.setString(5, order.getIdCh());
            preparedStatement.setDate(6, new java.sql.Date(order.getNgaySua().getTime()));
            preparedStatement.setInt(7, order.getStatus());

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

    public int calculateTotalPaidInvoices() {
        int totalPaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM hoaDon WHERE trangThai = 1 ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalPaidInvoices = resultSet.getInt("tongHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPaidInvoices;
    }

}
