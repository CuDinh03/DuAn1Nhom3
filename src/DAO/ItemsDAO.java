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
        String sql = "INSERT INTO items ( idCart, idInventory, codeProducts, nameProducs, quantity, price, createDate, updateDate, itemsStatus) "
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getIdCart());
            preparedStatement.setString(2, item.getIdInventory());
            preparedStatement.setString(3, item.getCodeProducts());
            preparedStatement.setString(4, item.getNameProducs());
            preparedStatement.setInt(5, item.getQuantity());
            preparedStatement.setBigDecimal(6, item.getPrice());
            preparedStatement.setDate(7, new java.sql.Date(item.getCreateDate().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(item.getUpdateDate().getTime()));
            preparedStatement.setInt(9, item.getItemsStatus());
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
                            resultSet.getString("idInventory"),
                            resultSet.getString("codeProducts"),
                            resultSet.getString("nameProducs"),
                            resultSet.getInt("quantity"),
                            resultSet.getBigDecimal("price"),
                            resultSet.getDate("createDate"),
                            resultSet.getDate("updateDate"),
                            resultSet.getInt("itemsStatus")
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
        String sql = "UPDATE items SET idCart = ?, idInventory = ?, codeProducts = ?, nameProducs = ?, quantity = ?, price = ?, "
                + "createDate = ?, updateDate = ?, itemsStatus = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getIdCart());
            preparedStatement.setString(2, item.getIdInventory());
            preparedStatement.setString(3, item.getCodeProducts());
            preparedStatement.setString(4, item.getNameProducs());
            preparedStatement.setInt(5, item.getQuantity());
            preparedStatement.setBigDecimal(6, item.getPrice());
            preparedStatement.setDate(7, new java.sql.Date(item.getCreateDate().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(item.getUpdateDate().getTime()));
            preparedStatement.setInt(9, item.getItemsStatus());
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
                        resultSet.getString("idInventory"),
                        resultSet.getString("codeProducts"),
                        resultSet.getString("nameProducs"),
                        resultSet.getInt("quantity"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getDate("createDate"),
                        resultSet.getDate("updateDate"),
                        resultSet.getInt("itemsStatus")
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
        String sql = "SELECT * FROM items WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Items item = new Items(
                        resultSet.getString("id"),
                        resultSet.getString("idCart"),
                        resultSet.getString("idInventory"),
                        resultSet.getString("codeProducts"),
                        resultSet.getString("nameProducs"),
                        resultSet.getInt("quantity"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getDate("createDate"),
                        resultSet.getDate("updateDate"),
                        resultSet.getInt("itemsStatus")
                );
                itemsList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsList;
    }
}
