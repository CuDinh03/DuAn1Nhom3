/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ImportOrder;


/**
 *
 * @author trung
 */
public class ImportOrderDAO {
    
        
    private Connection conn = JdbcHelper.getConnection();

    public void insertImportOrder(ImportOrder importOrder) {

        String sql = "INSERT INTO phieuNhap ( ma, ngayTao, ngaySua,DonViTinh,giaNhap, trangThai) VALUES ( ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, importOrder.getMa());
            statement.setDate(2, new java.sql.Date(importOrder.getNgayTao().getTime()));
            statement.setDate(3, new java.sql.Date(importOrder.getNgaySua().getTime()));
            statement.setString(4, importOrder.getDonViTinh());
            statement.setDouble(5, importOrder.getGiaNhap());
            statement.setInt(6, importOrder.getStatus());
            
            
            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ImportOrder> getAllStores() {
        List<ImportOrder> importOrders = new ArrayList<>();
        String sql = "SELECT * FROM phieuNhap";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ImportOrder importOrder = new ImportOrder();
                
                importOrder.setId(resultSet.getString("id"));
                importOrder.setMa(resultSet.getString("ma"));
                importOrder.setNgayTao(resultSet.getDate("ngayTao"));
                importOrder.setNgaySua(resultSet.getDate("ngaySua"));
                importOrder.setGiaNhap(resultSet.getDouble("giaNhap"));
                importOrder.setDonViTinh(resultSet.getString("DonViTinh"));
                importOrder.setStatus(resultSet.getInt("trangThai"));

                importOrders.add(importOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return importOrders;
    }

    public void updateImportOrder(ImportOrder importOrder) {
        String sql = "UPDATE phieuNhap SET ma=?, ngayTao=?, ngaySua=?,DonViTinh=?,giaNhap=?, trangThai=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, importOrder.getMa());
            statement.setDate(2, new java.sql.Date(importOrder.getNgayTao().getTime()));

            importOrder.setNgaySua(new java.util.Date());
            statement.setDate(3, new java.sql.Date(importOrder.getNgaySua().getTime()));
            statement.setString(4, importOrder.getDonViTinh());
            statement.setDouble(5, importOrder.getGiaNhap());
            statement.setInt(6, importOrder.getStatus());
            statement.setString(7, importOrder.getId());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteImportOrderById(String id) {
        String sql = "UPDATE kho SET trangThai = 0  WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
            ImportOrder importOrder = new ImportOrder();
            importOrder.setNgaySua(new java.util.Date());

            statement.setDate(4, new java.sql.Date(importOrder.getNgaySua().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public ImportOrder findById(String id) {
        String sql = "SELECT * FROM cuaHang WHERE id = ?";
        ImportOrder importOrder = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                importOrder = new ImportOrder();
                
                importOrder.setId(resultSet.getString("id"));
                importOrder.setMa(resultSet.getString("ma"));
                importOrder.setNgayTao(resultSet.getDate("ngayTao"));
                importOrder.setNgaySua(resultSet.getDate("ngaySua"));
                importOrder.setGiaNhap(resultSet.getDouble("giaNhap"));
                importOrder.setDonViTinh(resultSet.getString("DonViTinh"));
                importOrder.setStatus(resultSet.getInt("trangThai"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return importOrder;
    }
    
    
}
