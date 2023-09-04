package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetail;
import Utilities.JdbcHelper;

public class OrderDetailDAO {

    private final Connection connection = JdbcHelper.getConnection();

    // Create a new OrderDetail record in the database
    public void addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO inventory_detail (code, inventoryId, total, createDate, updateDate, inventoryStatus) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, orderDetail.getCode());
            statement.setObject(2, orderDetail.getInventoryId());
            statement.setBigDecimal(3, orderDetail.getTotal());
            statement.setDate(4, new java.sql.Date(orderDetail.getCreateDate().getTime()));
            statement.setDate(5, new java.sql.Date(orderDetail.getUpdateDate().getTime()));
            statement.setInt(6, orderDetail.getInventoryStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read an OrderDetail record by ID
    public OrderDetail getOrderDetailById(String id) {
        String sql = "SELECT * FROM inventory_detail WHERE inventoryId = ?";
        OrderDetail orderDetail = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                orderDetail = new OrderDetail(
                        resultSet.getString("ID"),
                        resultSet.getString("code"),
                        resultSet.getString("inventoryId"),
                        resultSet.getBigDecimal("total"),
                        resultSet.getDate("createDate"),
                        resultSet.getDate("updateDate"),
                        resultSet.getInt("inventoryStatus")
                );
                System.out.println(orderDetail.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetail;
    }

    // Update an existing OrderDetail record
    public void updateOrderDetail(OrderDetail orderDetail) {
        String sql = "UPDATE inventory_detail SET ma = ?, inventoryId = ?, total = ?, createDate = ?, updateDate = ?, inventoryStatus = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, orderDetail.getCode());
            statement.setObject(2, orderDetail.getInventoryId());
            statement.setBigDecimal(3, orderDetail.getTotal());
            statement.setDate(4, new java.sql.Date(orderDetail.getCreateDate().getTime()));
            statement.setDate(5, new java.sql.Date(orderDetail.getUpdateDate().getTime()));
            statement.setInt(6, orderDetail.getInventoryStatus());
            statement.setString(7, orderDetail.getID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an OrderDetail record by ID
    public void deleteOrderDetailById(String id) {
        String sql = "DELETE FROM inventory_detail WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all OrderDetail records from the database
    public List<OrderDetail> getAllOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String sql = "SELECT * FROM inventory_detail";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Create the OrderDetail object from the retrieved data and add it to the list
                OrderDetail orderDetail = new OrderDetail(
                        resultSet.getString("ID"),
                        resultSet.getString("ma"),
                        resultSet.getString("inventoryId"),
                        resultSet.getBigDecimal("total"),
                        resultSet.getDate("createDate"),
                        resultSet.getDate("updateDate"),
                        resultSet.getInt("inventoryStatus")
                );
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetails;
    }

    public OrderDetail findSingleOrderDetailByCode(String code) {
        String sql = "SELECT * FROM inventory_detail WHERE inventoryId = ?";
        OrderDetail orderDetail = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                orderDetail = new OrderDetail(
                        resultSet.getString("ID"),
                        resultSet.getString("code"),
                        resultSet.getString("inventoryId"),
                        resultSet.getBigDecimal("total"),
                        resultSet.getDate("createDate"),
                        resultSet.getDate("updateDate"),
                        resultSet.getInt("inventoryStatus")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetail;
    }
}
