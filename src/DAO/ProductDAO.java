package DAO;

import model.Product;
import Erro.InsufficientProductQuantityException;

import Utilities.JdbcHelper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.List;

public class ProductDAO {

    private final Connection connection = JdbcHelper.getConnection();

    // Create
    public void addProduct(Product product) {
        String productCode = product.getMa();

        if (productExists(productCode)) {
            // neu ton tai code san pham nay r 
            String quantityQuery = "SELECT prQuantity FROM products WHERE code = ?";
            String updateQuery = "UPDATE products SET prQuantity = ?, updateDate = ? WHERE code = ?";

            try {
                PreparedStatement quantityStatement = connection.prepareStatement(quantityQuery);
                quantityStatement.setString(1, productCode);
                ResultSet resultSet = quantityStatement.executeQuery();

                int currentQuantity = 0;
                if (resultSet.next()) {
                    currentQuantity = resultSet.getInt("prQuantity");
                }
                quantityStatement.close();

                // tinh so luong moi
                int newQuantity = currentQuantity + product.getQuantity();

                // cap nhat lai so luong 
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, newQuantity);
                updateStatement.setTimestamp(2, new java.sql.Timestamp(getCurrentDateTime().getTime()));
                updateStatement.setString(3, productCode);
                updateStatement.executeUpdate();
                updateStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
// neu chua ton tai thi them moi san pham
            String insertQuery = "INSERT INTO products (code, prName, prQuantity, original, cost, MFG, expiry, idType, createDate, updateDate, prStatus) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setString(1, product.getMa());
                insertStatement.setString(2, product.getName());
                insertStatement.setInt(3, product.getQuantity());
                insertStatement.setString(4, product.getNguonGoc());
                insertStatement.setDouble(5, product.getGiaGoc());
                insertStatement.setDate(6, new java.sql.Date(product.getNgaySx().getTime()));
                insertStatement.setDate(7, new java.sql.Date(product.getHsd().getTime()));
                insertStatement.setString(8, product.getIdDanhMuc());
                insertStatement.setDate(9, new java.sql.Date(product.getNgayTao().getTime()));
                insertStatement.setDate(10, new java.sql.Date(product.getNgaySua().getTime()));
                insertStatement.setInt(11, product.getStatus());
                insertStatement.executeUpdate();
                insertStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Read
    public Product getProductById(String id) {
        String query = "SELECT * FROM products WHERE id = ?";
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
    //show toan bo san pham

    public List<Product> getAllProducts() {
        String query = "SELECT * FROM products WHERE prStatus = 1 AND prQuantity > 0 AND hanSD >= GETDATE()";
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
        String query = "UPDATE products SET code = ?, prName = ?, original = ?, cost = ?, MFG = ?, hanSD = ?, "
                + "idType = ?, createDate = ?, updateDate = ?, prStatus = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getMa());
            statement.setString(2, product.getName());
            statement.setString(3, product.getNguonGoc());
            statement.setDouble(4, product.getGiaGoc());
            statement.setDate(5, new java.sql.Date(product.getNgaySx().getTime()));
            statement.setDate(6, new java.sql.Date(product.getHsd().getTime()));
            statement.setString(7, product.getIdDanhMuc());
            statement.setDate(8, new java.sql.Date(product.getNgayTao().getTime()));
            statement.setTimestamp(9, new java.sql.Timestamp(getCurrentDateTime().getTime()));
            statement.setInt(10, product.getStatus());
            statement.setString(11, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(String id) {
        String query = "UPDATE products SET prStatus = 0, updateDate = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setTimestamp(2, new java.sql.Timestamp(getCurrentDateTime().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //lay du lieu tu db len java
    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String code = resultSet.getString("code");
        String prName = resultSet.getString("prName");
        int prQuantity = resultSet.getInt("prQuantity");
        String original = resultSet.getString("original");
        BigDecimal cost = resultSet.getBigDecimal("cost");
        double costdb = cost.doubleValue();
        Date MFG = resultSet.getDate("MFG");
        Date hsd = resultSet.getDate("hanSD");
        String idType = resultSet.getString("idType");
        Date createDate = resultSet.getDate("createDate");
        Date updateDate = resultSet.getDate("updateDate");

        int status = resultSet.getInt("prStatus");

        return new Product(id, code, prName, prQuantity, original, costdb, MFG, hsd, idType, createDate, updateDate, status);
    }
    //tim kiem theo id

    public Product findById(String id) {
        String query = "SELECT * FROM products WHERE id = ?";
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
    //truong hop ban het hang

    public void updateStatusForZeroQuantityProducts() {
        String updateQuery = "UPDATE products SET prStatus = 0 WHERE prQuantity = 0";
        try {
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // thuc hien sau khi thanh toan 
    public void updateProductQuantityAfterPayment(String productId, int quantityToReduce) throws InsufficientProductQuantityException {
        String updateQuery = "UPDATE products SET prQuantity = prQuantity - ?, updateDate = ? WHERE id = ? AND prQuantity >= ?";
        try {
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setInt(1, quantityToReduce);
            updateStatement.setTimestamp(2, new java.sql.Timestamp(getCurrentDateTime().getTime()));

            updateStatement.setString(3, productId);
            updateStatement.setInt(4, quantityToReduce);
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated == 0) {

                throw new InsufficientProductQuantityException("Không đủ số lượng cho sản phẩm có ID: " + productId);

            }
            updateStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Date getCurrentDateTime() {
        return new Date();
    }

    // neu san pham ton tai
    private boolean productExists(String productCode) {
        String query = "SELECT COUNT(*) FROM products WHERE code = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, productCode);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //tim theo code
    public Product getProductByCode(String productCode) {
        String query = "SELECT * FROM products WHERE code = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, productCode);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractProductFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // lay list san pham co cung prName khac code 

    public List<Product> getProductsByNameAndExpiration(String productName, String productCode, Date expirationDateThreshold) {
        String query = "SELECT * FROM products WHERE prName = ? AND code <> ? AND prStatus = 1 AND prQuantity > 0 AND hanSD > ?";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, productName);
            statement.setString(2, productCode);
            statement.setDate(3, new java.sql.Date(expirationDateThreshold.getTime()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Sort the products based on the expiration dates in ascending order
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getHsd().compareTo(product2.getHsd());
            }
        });

        return products;
    }

    public List<Product> getProductsByName(String name) {
        String query = "SELECT * FROM products WHERE prName = ? AND prStatus = 1";
        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, name);

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

}
