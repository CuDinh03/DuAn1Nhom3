package DAO;

import  Utilities.JdbcHelper;
import model.Product;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final Connection connection = JdbcHelper.getConnection();


    // Create
    public void addProduct(Product product) {
        String query = "INSERT INTO sanPham ( ma, ten, nguonGoc, giaGoc, ngaySx, hanSD, idDanhMuc, ngayTao, ngaySua, trangThai) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try  {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getMa());
            statement.setString(2, product.getName());
            statement.setString(3, product.getNguonGoc());
            statement.setDouble(4, product.getGiaGoc());
            statement.setDate(5, new java.sql.Date(product.getNgaySx().getTime()));
            statement.setDate(6, new java.sql.Date(product.getHsd().getTime()));
            statement.setString(7, product.getIdDanhMuc());
            statement.setDate(8, new java.sql.Date(product.getNgayTao().getTime()));
            statement.setDate(9, new java.sql.Date(product.getNgaySua().getTime()));
            statement.setInt(10, product.getStatus());

            statement.executeUpdate();
            statement.clearParameters();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public Product getProductById(String id) {
        String query = "SELECT * FROM sanPham WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
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
        try {
            PreparedStatement statement = connection.prepareStatement(query);
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
        try  {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getMa());
            statement.setString(2, product.getName());
            statement.setString(3, product.getNguonGoc());
            statement.setDouble(4, product.getGiaGoc());
            statement.setDate(5, new java.sql.Date(product.getNgaySx().getTime()));
            statement.setDate(6, new java.sql.Date(product.getHsd().getTime()));
            statement.setString(7, product.getIdDanhMuc());
            statement.setDate(8, new java.sql.Date(product.getNgayTao().getTime()));
            statement.setDate(9, new java.sql.Date(product.getNgaySua().getTime()));
            statement.setInt(10, product.getStatus());
            statement.setString(11, product.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(String id) {
        String query = "UPDATE sanPham WHERE id = ? SET trangThai=0";
        try  {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException {
        String ma = resultSet.getString("ma");
        String ten = resultSet.getString("ten");
        String nguonGoc = resultSet.getString("nguonGoc");
        BigDecimal giaGoc = resultSet.getBigDecimal("giaGoc");
        double giaGocdb = giaGoc.doubleValue();
        Date ngaySx = resultSet.getDate("ngaySx");
        java.util.Date ngaySx1 = convertSqlDateToUtilDate(ngaySx);
        Date hsd = resultSet.getDate("hanSD");
        java.util.Date hsd1 = convertSqlDateToUtilDate(hsd);
        String idDanhMuc = resultSet.getString("idDanhMuc");
        Date ngayTao = resultSet.getDate("ngayTao");
        java.util.Date ngayTao1 = convertSqlDateToUtilDate(ngayTao);
        Date ngaySua = resultSet.getDate("ngaySua");
        java.util.Date ngaySua1 = convertSqlDateToUtilDate(ngaySua);

        int status = resultSet.getInt("trangThai");

        return new Product(ma, ten, nguonGoc, giaGocdb, ngaySx1, hsd1, idDanhMuc, ngayTao1, ngaySua1, status);

    }

    public Product findById(String id) {
    String query = "SELECT * FROM sanPham WHERE id = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
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
public static java.util.Date convertSqlDateToUtilDate(java.sql.Date sqlDate) {
    if (sqlDate == null) {
        return null;
    }

    long milliseconds = sqlDate.getTime();
    return new java.util.Date(milliseconds);
}

    

}
