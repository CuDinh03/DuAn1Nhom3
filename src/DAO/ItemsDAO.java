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
    String sqlCheckIfExists = "SELECT quantity FROM items WHERE idCart = ? AND codeProducts = ?";
    String sqlUpdate = "UPDATE items SET quantity = ? WHERE idCart = ? AND codeProducts = ?";
    String sqlInsert = "INSERT INTO items (idCart, idInventory, codeProducts, idProducs, quantity, price, createDate, updateDate, itemsStatus) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement checkIfExistsStatement = connection.prepareStatement(sqlCheckIfExists);
        checkIfExistsStatement.setString(1, item.getIdCart());
        checkIfExistsStatement.setString(2, item.getCodeProducts());
        ResultSet resultSet = checkIfExistsStatement.executeQuery();

        if (resultSet.next()) {
            // Sản phẩm đã tồn tại, cập nhật số lượng
            int currentQuantity = resultSet.getInt("quantity");
            int newQuantity = currentQuantity + item.getQuantity()-currentQuantity;

            PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
            updateStatement.setInt(1, newQuantity);
            updateStatement.setString(2, item.getIdCart());
            updateStatement.setString(3, item.getCodeProducts());
            updateStatement.executeUpdate();
        } else {
            // Sản phẩm không tồn tại, thêm mới
            PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
            insertStatement.setString(1, item.getIdCart());
            insertStatement.setString(2, item.getIdInventory());
            insertStatement.setString(3, item.getCodeProducts());
            insertStatement.setString(4, item.getNameProducs());
            insertStatement.setInt(5, item.getQuantity());
            insertStatement.setBigDecimal(6, item.getPrice());
            insertStatement.setDate(7, new java.sql.Date(item.getCreateDate().getTime()));
            insertStatement.setDate(8, new java.sql.Date(item.getUpdateDate().getTime()));
            insertStatement.setInt(9, item.getItemsStatus());
            insertStatement.executeUpdate();
        }
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
                            resultSet.getString("idProducs"),
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
        String sql = "UPDATE items SET idCart = ?, idInventory = ?, codeProducts = ?, idProducs = ?, quantity = ?, price = ?, "
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
                        resultSet.getString("idProducs"),
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
        String sql = "SELECT * FROM items WHERE idInventory = ?";

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
                        resultSet.getString("idProducs"),
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
