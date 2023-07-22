
package DAO;

import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetail;

public class OrderDetailDAO {

    private final Connection connection = JdbcHelper.getConnection();

    // Create a new OrderDetail record in the database
    public void addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO HoaDonChiTiet ( ma, idHoaDon, tongTien, ngayTao, ngaySua, trangThai) VALUES ( ?, ?, ?, ?, ?, ?)";
        try{ 
             PreparedStatement statement = connection.prepareStatement(sql); 

            statement.setString(1, orderDetail.getMa());
            statement.setString(2, orderDetail.getIdHD());
            statement.setDouble(3, orderDetail.getTongTien());
            statement.setDate(4, new java.sql.Date(orderDetail.getNgayTao().getTime()));
            statement.setDate(5, new java.sql.Date(orderDetail.getNgaySua().getTime()));
            statement.setInt(6, orderDetail.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read an OrderDetail record by ID
    public OrderDetail getOrderDetailById(String id) {
        String sql ="SELECT * FROM HoaDonChiTiet WHERE idHoaDon = ?";
        OrderDetail orderDetail = null;

        try {
             PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                orderDetail = new OrderDetail(
                        resultSet.getString("id"),
                        resultSet.getString("ma"),
                        resultSet.getString("idHoaDon"),
                        Double.parseDouble(String.valueOf( resultSet.getBigDecimal("tongTien"))),
                        resultSet.getDate("ngayTao"),
                        resultSet.getDate("ngaySua"),
                        resultSet.getInt("trangThai")
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
        String sql = "UPDATE HoaDonChiTiet SET ma = ?, idHoaDon = ?, tongTien = ?, ngayTao = ?, ngaySua = ?, trangThai = ? WHERE id = ?";
        try {
             PreparedStatement statement = connection.prepareStatement(
                     sql);

            statement.setString(1, orderDetail.getMa());
            statement.setString(2, orderDetail.getIdHD());
            statement.setDouble(3, orderDetail.getTongTien());
            statement.setDate(4, new java.sql.Date(orderDetail.getNgayTao().getTime()));
            statement.setDate(5, new java.sql.Date(orderDetail.getNgaySua().getTime()));
            statement.setInt(6, orderDetail.getStatus());
            statement.setString(7, orderDetail.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an OrderDetail record by ID
    public void deleteOrderDetailById(String id) {
        String sql = "DELETE FROM HoaDonChiTiet WHERE id = ?";
        try {
             PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all OrderDetail records from the database
    public List<OrderDetail> getAllOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String sql = "SELECT * FROM HoaDonChiTiet";

        try{
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery(); 

            while (resultSet.next()) {
                // Create the OrderDetail object from the retrieved data and add it to the list
                OrderDetail orderDetail = new OrderDetail(
                        resultSet.getString("id"),
                        resultSet.getString("ma"),
                        resultSet.getString("idHoaDon"),
                        resultSet.getDouble("tongTien"),
                        resultSet.getDate("ngayTao"),
                        resultSet.getDate("ngaySua"),
                        resultSet.getInt("trangThai")
                );
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetails;
    }
}

