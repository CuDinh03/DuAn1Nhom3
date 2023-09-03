package DAO;

import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ShoppingCart;

public class ShoppingCartDAO {

    private final Connection connection = JdbcHelper.getConnection();

    // Create (Insert) Operation
    public void insertShoppingCart(ShoppingCart shoppingCart) {
        String sql = "INSERT INTO shopping_cart ( ma, nameKh, nameNv, ngayTao, ngaySua, status) "
                + "VALUES ( ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shoppingCart.getMa());
            preparedStatement.setString(3, shoppingCart.getNameKh());
            preparedStatement.setString(4, shoppingCart.getNameNv());
            preparedStatement.setDate(5, new java.sql.Date(shoppingCart.getNgayTao().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(shoppingCart.getNgaySua().getTime()));
            preparedStatement.setInt(7, shoppingCart.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Retrieve) Operation
    public ShoppingCart getShoppingCartById(String id) {
        String sql = "SELECT * FROM shopping_cart WHERE id = ?";
        ShoppingCart shoppingCart = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    shoppingCart = new ShoppingCart(
                            resultSet.getString("id"),
                            resultSet.getString("ma"),
                            null,
                            resultSet.getString("nameKh"),
                            resultSet.getString("nameNv"),
                            resultSet.getDate("ngayTao"),
                            resultSet.getDate("ngaySua"),
                            resultSet.getInt("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCart;
    }

    // Update Operation
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        String sql = "UPDATE shopping_cart SET ma = ?, nameKh = ?, nameNv = ?, "
                + "ngayTao = ?, ngaySua = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shoppingCart.getMa());
            preparedStatement.setString(2, shoppingCart.getNameKh());
            preparedStatement.setString(3, shoppingCart.getNameNv());
            preparedStatement.setDate(4, new java.sql.Date(shoppingCart.getNgayTao().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(shoppingCart.getNgaySua().getTime()));
            preparedStatement.setInt(6, shoppingCart.getStatus());
            preparedStatement.setString(7, shoppingCart.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Operation
    public void deleteShoppingCart(String id) {
        String sql = "DELETE FROM shopping_cart WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional method to retrieve all shopping carts
    public List<ShoppingCart> getAllShoppingCarts() {
        String sql = "SELECT * FROM shopping_cart";
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ShoppingCart shoppingCart = new ShoppingCart(
                        resultSet.getString("id"),
                        resultSet.getString("ma"),
                        null, // Assuming itemsList is not loaded during retrieval
                        resultSet.getString("nameKh"),
                        resultSet.getString("nameNv"),
                        resultSet.getDate("ngayTao"),
                        resultSet.getDate("ngaySua"),
                        resultSet.getInt("status")
                );
                shoppingCartList.add(shoppingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCartList;
    }
    public ShoppingCart getShoppingCartByMa(String ma) {
        String sql = "SELECT * FROM shopping_cart WHERE ma = ?";
        ShoppingCart shoppingCart = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ma);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    shoppingCart = new ShoppingCart(
                        resultSet.getString("id"),
                        resultSet.getString("ma"),
                        null, // Assuming itemsList is not loaded during retrieval
                        resultSet.getString("nameKh"),
                        resultSet.getString("nameNv"),
                        resultSet.getDate("ngayTao"),
                        resultSet.getDate("ngaySua"),
                        resultSet.getInt("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCart;
    }
}
