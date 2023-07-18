package DAO;

import model.Product;
import Utilities.JdbcHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection = JdbcHelper.getConnection();

    // Create
    public void addProduct(Product product) {
        String query = "INSERT INTO sanPham ( ma, ten, nguonGoc, giaGoc, ngaySx, hanSD, idDanhMuc, ngayTao, ngaySua, trangThai) "
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            statement.setDate(9, new java.sql.Date(product.getNgaySua().getTime()));
            statement.setInt(10, product.getStatus());

            statement.executeUpdate();
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
        String query = "UPDATE sanPham SET ma = ?, ten =? nguonGoc = ?, giaGoc = ?, ngaySx = ?, hanSD = ?, "
                + "idDanhMuc = ?, ngayTao = ?, ngaySua = ?, trangThai = ? WHERE id = ?";
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
        try {
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

    public void importProductsFromExcel(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }

                String ma = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                String nguonGoc = row.getCell(2).getStringCellValue();
                double giaGoc = row.getCell(3).getNumericCellValue();
                Date ngaySx = (Date) row.getCell(4).getDateCellValue();
                Date hsd = (Date) row.getCell(5).getDateCellValue();
                String idDanhMuc = row.getCell(6).getStringCellValue();
                Date ngayTao = (Date) row.getCell(7).getDateCellValue();
                Date ngaySua = (Date) row.getCell(8).getDateCellValue();
                int status = (int) row.getCell(9).getNumericCellValue();

                Product product = new Product(ma, name, nguonGoc, giaGoc, ngaySx, hsd, idDanhMuc, ngayTao, ngaySua, status);
                addProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportProductsToExcel(String filePath) {
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {

            Sheet sheet = workbook.createSheet("Products");
            List<Product> products = getAllProducts();

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Code");
            headerRow.createCell(2).setCellValue("Name");
            headerRow.createCell(3).setCellValue("Origin");
            headerRow.createCell(4).setCellValue("Original Price");
            headerRow.createCell(5).setCellValue("Manufacturing Date");
            headerRow.createCell(6).setCellValue("Expiration Date");
            headerRow.createCell(7).setCellValue("Category ID");
            headerRow.createCell(8).setCellValue("Created Date");
            headerRow.createCell(9).setCellValue("Modified Date");
            headerRow.createCell(10).setCellValue("Status");

            int rowIndex = 1;
            for (Product product : products) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(product.getId());
                dataRow.createCell(1).setCellValue(product.getMa());
                dataRow.createCell(2).setCellValue(product.getName());
                dataRow.createCell(3).setCellValue(product.getNguonGoc());
                dataRow.createCell(4).setCellValue(product.getGiaGoc());
                dataRow.createCell(5).setCellValue(product.getNgaySx());
                dataRow.createCell(6).setCellValue(product.getHsd());
                dataRow.createCell(7).setCellValue(product.getIdDanhMuc());
                dataRow.createCell(8).setCellValue(product.getNgayTao());
                dataRow.createCell(9).setCellValue(product.getNgaySua());
                dataRow.createCell(10).setCellValue(product.getStatus());
            }

            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static java.util.Date convertSqlDateToUtilDate(java.sql.Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }

        long milliseconds = sqlDate.getTime();
        return new java.util.Date(milliseconds);
    }

}
