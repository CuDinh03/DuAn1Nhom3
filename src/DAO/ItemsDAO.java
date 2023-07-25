package DAO;

import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Items;

public class ItemsDAO {

    private final Connection connection = JdbcHelper.getConnection();

    // Create (Insert) Operation
    public void insertItem(Items item) {
        String sql = "INSERT INTO items ( idCart, idOrder, maSP, tenSp, soLuong, giaban, ngayTao, ngaySua, status) "
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getIdCart());
            preparedStatement.setString(2, item.getIdOrder());
            preparedStatement.setString(3, item.getMaSP());
            preparedStatement.setString(4, item.getTenSp());
            preparedStatement.setInt(5, item.getSoLuong());
            preparedStatement.setDouble(6, item.getGiaban());
            preparedStatement.setDate(7, new java.sql.Date(item.getNgayTao().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(item.getNgaySua().getTime()));
            preparedStatement.setInt(9, item.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Retrieve) Operation
    public Items getItemById(String id) {
        String sql = "SELECT * FROM items WHERE id = ?";
        Items item = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Items(
                            resultSet.getString("id"),
                            resultSet.getString("idCart"),
                            resultSet.getString("idOrder"),
                            resultSet.getString("maSP"),
                            resultSet.getString("tenSp"),
                            resultSet.getInt("soLuong"),
                            resultSet.getDouble("giaban"),
                            resultSet.getDate("ngayTao"),
                            resultSet.getDate("ngaySua"),
                            resultSet.getInt("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    // Update Operation
    public void updateItem(Items item) {
        String sql = "UPDATE items SET idCart = ?, idOrder = ?, maSP = ?, tenSp = ?, soLuong = ?, giaban = ?, "
                + "ngayTao = ?, ngaySua = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getIdCart());
            preparedStatement.setString(2, item.getIdOrder());
            preparedStatement.setString(3, item.getMaSP());
            preparedStatement.setString(4, item.getTenSp());
            preparedStatement.setInt(5, item.getSoLuong());
            preparedStatement.setDouble(6, item.getGiaban());
            preparedStatement.setDate(7, new java.sql.Date(item.getNgayTao().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(item.getNgaySua().getTime()));
            preparedStatement.setInt(9, item.getStatus());
            preparedStatement.setString(10, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Operation
    public void deleteItem(String id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
               
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional method to retrieve all items
    public List<Items> getAllItems() {
        String sql = "SELECT * FROM items";
        List<Items> itemsList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Items item = new Items(
                        resultSet.getString("id"),
                        resultSet.getString("idCart"),
                        resultSet.getString("idOrder"),
                        resultSet.getString("maSP"),
                        resultSet.getString("tenSp"),
                        resultSet.getInt("soLuong"),
                        resultSet.getDouble("giaban"),
                        resultSet.getDate("ngayTao"),
                        resultSet.getDate("ngaySua"),
                        resultSet.getInt("status")
                );
                itemsList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemsList;
    }
    public List<Items> getAllItemsByOrderId(String orderId) {
        List<Items> itemsList = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE idOrder = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Items item = new Items(
                        resultSet.getString("id"),
                        resultSet.getString("idCart"),
                        resultSet.getString("idOrder"),
                        resultSet.getString("maSP"),
                        resultSet.getString("tenSp"),
                        resultSet.getInt("soLuong"),
                        resultSet.getDouble("giaban"),
                        resultSet.getDate("ngayTao"),
                        resultSet.getDate("ngaySua"),
                        resultSet.getInt("status")
                );
                itemsList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsList;
    }
}
