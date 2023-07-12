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
        String query = "INSERT INTO sanPham (id, ma, ten, nguonGoc, giaGoc, ngaySx, hanSD, idDanhMuc, ngayTao, ngaySua, trangThai) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getId());
            statement.setString(2, product.getMa());
            statement.setString(3, product.getName());
            statement.setString(4, product.getNguonGoc());
            statement.setDouble(5, product.getGiaGoc());
            statement.setDate(6, new java.sql.Date(product.getNgaySx().getTime()));
            statement.setDate(7, new java.sql.Date(product.getHsd().getTime()));
            statement.setString(8, product.getIdDanhMuc());
            statement.setDate(9, new java.sql.Date(product.getNgayTao().getTime()));
            statement.setDate(10, new java.sql.Date(product.getNgaySua().getTime()));
            statement.setBoolean(11, product.isStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public Product getProductById(String id) {
        String query = "SELECT * FROM sanPham WHERE id = ?";
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
        String query = "SELECT * FROM sanPham";
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
        String query = "UPDATE sanPham SET ma = ?, ten =? nguonGoc = ?, giaGoc = ?, ngaySx = ?, hanSD = ?, " +
                "idDanhMuc = ?, ngayTao = ?, ngaySua = ?, trangThai = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getMa());
            statement.setString(2, product.getName());
            statement.setString(3, product.getNguonGoc());
            statement.setDouble(4, product.getGiaGoc());
            statement.setDate(5, new java.sql.Date(product.getNgaySx().getTime()));
            statement.setDate(6, new java.sql.Date(product.getHsd().getTime()));
            statement.setString(7, product.getIdDanhMuc());
            statement.setDate(8, new java.sql.Date(product.getNgayTao().getTime()));
            statement.setDate(9, new java.sql.Date(product.getNgaySua().getTime()));
            statement.setBoolean(10, product.isStatus());
            statement.setString(11, product.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(String id) {
        String query = "UPDATE sanPham WHERE id = ? SET trangThai=0";
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
        String ten = resultSet.getString("ten");
        String nguonGoc = resultSet.getString("nguonGoc");
        double giaGoc = resultSet.getDouble("giaGoc");
        Date ngaySx = resultSet.getDate("ngaySx");
        Date hsd = resultSet.getDate("hanSD");
        String idDanhMuc = resultSet.getString("idDanhMuc");
        Date ngayTao = resultSet.getDate("ngayTao");
        Date ngaySua = resultSet.getDate("ngaySua");
        boolean status = resultSet.getBoolean("trangThai");

        return new Product(id, ma, ten, nguonGoc, giaGoc, ngaySx, hsd, idDanhMuc, ngayTao, ngaySua, status);
    }
    public Product findById(String id) {
    String query = "SELECT * FROM sanPham WHERE id = ?";
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
