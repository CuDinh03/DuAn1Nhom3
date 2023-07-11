package DAO;

import model.Product;
import Utilities.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        connection = JdbcHelper.getConnection();
    }

    // Create
    public void addProduct(Product product) {
        String query = "INSERT INTO Product (id, ma, nguonGoc, giaGoc, ngaySx, hsd, idDanhMuc, ngayTao, ngaySua, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getId());
            statement.setString(2, product.getMa());
            statement.setString(3, product.getNguonGoc());
            statement.setDouble(4, product.getGiaGoc());
            statement.setDate(5, new java.sql.Date(product.getNgaySx().getTime()));
            statement.setDate(6, new java.sql.Date(product.getHsd().getTime()));
            statement.setString(7, product.getIdDanhMuc());
            statement.setDate(8, new java.sql.Date(product.getNgayTao().getTime()));
            statement.setDate(9, new java.sql.Date(product.getNgaySua().getTime()));
            statement.setBoolean(10, product.isStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public Product getProductById(String id) {
        String query = "SELECT * FROM Product WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractProductFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProducts() {
        String query = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Update
    public void updateProduct(Product product) {
        String query = "UPDATE Product SET ma = ?, nguonGoc = ?, giaGoc = ?, ngaySx = ?, hsd = ?, " +
                "idDanhMuc = ?, ngayTao = ?, ngaySua = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getMa());
            statement.setString(2, product.getNguonGoc());
            statement.setDouble(3, product.getGiaGoc());
            statement.setDate(4, new java.sql.Date(product.getNgaySx().getTime()));
            statement.setDate(5, new java.sql.Date(product.getHsd().getTime()));
            statement.setString(6, product.getIdDanhMuc());
            statement.setDate(7, new java.sql.Date(product.getNgayTao().getTime()));
            statement.setDate(8, new java.sql.Date(product.getNgaySua().getTime()));
            statement.setBoolean(9, product.isStatus());
            statement.setString(10, product.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(String id) {
        String query = "DELETE FROM Product WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String ma = resultSet.getString("ma");
        String nguonGoc = resultSet.getString("nguonGoc");
        double giaGoc = resultSet.getDouble("giaGoc");
        Date ngaySx = resultSet.getDate("ngaySx");
        Date hsd = resultSet.getDate("hsd");
        String idDanhMuc = resultSet.getString("idDanhMuc");
        Date ngayTao = resultSet.getDate("ngayTao");
        Date ngaySua = resultSet.getDate("ngaySua");
        boolean status = resultSet.getBoolean("status");

        return new Product(id, ma, nguonGoc, giaGoc, ngaySx, hsd, idDanhMuc, ngayTao, ngaySua, status);
    }
    public Product findById(String id) {
    String query = "SELECT * FROM Product WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return extractProductFromResultSet(resultSet);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

}
