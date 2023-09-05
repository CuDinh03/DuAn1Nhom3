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
        String query = "SELECT * FROM inventory WHERE inventoryStatus = 1 ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String ma = resultSet.getString(2);
                String name = resultSet.getString(3);
                String idCustomer = resultSet.getString(4);
                String idUser = resultSet.getString(5);

                Date createDate = resultSet.getDate(6);
                Date updateDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);

                Order order = new Order(id, ma, name, idCustomer, idUser, createDate, updateDate, status);
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
            String query = "SELECT * FROM inventory WHERE inventoryStatus = 0 ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String ma = resultSet.getString(2);
                String name = resultSet.getString(3);
                String idCustomer = resultSet.getString(4);

                String idUser = resultSet.getString(5);
                Date createDate = resultSet.getDate(6);
                Date updateDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);
                Order order = new Order(id, ma, name, idCustomer, idUser, createDate, updateDate, status);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public void createOrder(Order order) {
        try {
            String query = "INSERT INTO inventory ( code, inventoryName,idCustomer, idUser,  createDate, updateDate,  inventoryStatus ) VALUES ( ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getCode());
            preparedStatement.setString(2, order.getInventoryName());
            preparedStatement.setString(3, order.getIdCustomer());
            preparedStatement.setString(4, order.getIdUser());
            preparedStatement.setDate(5, new java.sql.Date(order.getCreateDate().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(order.getUpdateDate().getTime()));
            preparedStatement.setInt(7, order.getInventoryStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order getOrderById(String orderId) {
        String query = "SELECT * FROM inventory WHERE id = ? and inventoryStatus = 1 ";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String ma = resultSet.getString("code");
                String name = resultSet.getString("inventoryName");
                String idCustomer = resultSet.getString("idCustomer");

                String namestaff = resultSet.getString("idUser");
                Date createDate = resultSet.getDate("createDate");
                Date updateDate = resultSet.getDate("updateDate");
                int status = resultSet.getInt("inventoryStatus");

                return new Order(id, ma, name, idCustomer, namestaff, createDate, updateDate, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateOrder(Order order) {
        try {
            String query = "UPDATE inventory SET code = ?, inventoryName = ?,   idCustomer = ?, idUser =?,updateDate = ?, inventoryStatus = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getCode());
            preparedStatement.setString(2, order.getInventoryName());
            preparedStatement.setString(3, order.getIdCustomer());
            preparedStatement.setString(4, order.getIdUser());
            preparedStatement.setDate(5, new java.sql.Date(order.getUpdateDate().getTime()));
            preparedStatement.setInt(6, order.getInventoryStatus());
            preparedStatement.setString(7, order.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(String orderId) {
        try {
            String query = "UPDATE inventory SET inventoryStatus = 2 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);

            int rowsDeleted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrderByMa(String orderma) {
        try {
            String query = "UPDATE inventory SET inventoryStatus = 2 WHERE code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderma);

            int rowsDeleted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderByMa(String orderma) {
        try {
            String query = "UPDATE inventory SET inventoryStatus = 1 WHERE code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderma);

            int rowsDeleted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int calculateTotalPaidInvoices() {
        int totalPaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM inventory WHERE inventoryStatus = 1 ";

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
        public int calculateTotalPaidInvoices2() {
        int totalPaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM inventory WHERE inventoryStatus = 0 ";

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
                public int calculateTotalPaidInvoices3() {
        int totalPaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM inventory ";

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

    public Order getOrderByMa(String orderMa) {
        String query = "SELECT * FROM inventory WHERE code = ? AND inventoryStatus = 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderMa);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String ma = resultSet.getString(2);
                String name = resultSet.getString(3);
                String idCustomer = resultSet.getString(4);

                String tennv = resultSet.getString(5);
                Date createDate = resultSet.getDate(6);
                Date updateDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);

                return new Order(id, ma, name, idCustomer, tennv, createDate, updateDate, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        public Order getOrderByMa2(String orderMa) {
        String query = "SELECT * FROM inventory WHERE code = ? AND inventoryStatus = 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderMa);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String ma = resultSet.getString(2);
                String name = resultSet.getString(3);
                String idCustomer = resultSet.getString(4);

                String tennv = resultSet.getString(5);
                Date createDate = resultSet.getDate(6);
                Date updateDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);

                return new Order(id, ma, name, idCustomer, tennv, createDate, updateDate, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getPendingOrdersByCustomerName(String customerName) {
        List<Order> pendingOrders = new ArrayList<>();
        String query = "SELECT * FROM inventory WHERE idCustomer = ? AND inventoryStatus = 0";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customerName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String ma = resultSet.getString("code");
                    String name = resultSet.getString("inventoryName");
                    String idCustomer = resultSet.getString("idCustomer");

                    String idUser = resultSet.getString("idUser");
                    Date createDate = resultSet.getDate("createDate");
                    Date updateDate = resultSet.getDate("updateDate");
                    int status = resultSet.getInt("inventoryStatus");

                    Order order = new Order(id, ma, name, idCustomer, idUser, createDate, updateDate, status);
                    pendingOrders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pendingOrders;
    }

}
