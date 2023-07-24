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
import model.StoreOrderImport;


/**
 *
 * @author trung
 */
public class StoreOrderImportDAO {
    
        
    private Connection conn = JdbcHelper.getConnection();

    public void insertStoreOrder(StoreOrderImport storeOrderImport) {

        String sql = "INSERT INTO phieuNhanHang ( ma, ngayTao, ngaySua,donViTinh, trangThai) VALUES ( ?, ?, ?, ?, ?)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, storeOrderImport.getMa());
            statement.setDate(2, new java.sql.Date(storeOrderImport.getNgayTao().getTime()));
            statement.setDate(3, new java.sql.Date(storeOrderImport.getNgaySua().getTime()));
            statement.setString(4, storeOrderImport.getDonViTinh());
            statement.setInt(5, storeOrderImport.getStatus());

            
            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StoreOrderImport> getAllStores() {
        List<StoreOrderImport> storeOrderImports = new ArrayList<>();
        String sql = "SELECT * FROM phieuNhanHang";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                StoreOrderImport storeOrderImport = new StoreOrderImport();
                
                storeOrderImport.setId(resultSet.getString("id"));
                storeOrderImport.setMa(resultSet.getString("ma"));
                storeOrderImport.setNgayTao(resultSet.getDate("ngayTao"));
                storeOrderImport.setNgaySua(resultSet.getDate("ngaySua"));
                storeOrderImport.setDonViTinh(resultSet.getString("donViTinh"));
                storeOrderImport.setStatus(resultSet.getInt("trangThai"));


                storeOrderImports.add(storeOrderImport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return storeOrderImports;
    }

    public void updateStoreOrder(StoreOrderImport storeOrderImport) {
        String sql = "UPDATE phieuNhanHang SET ma=?, ngayTao=?, ngaySua=?, donViTinh=? , trangThai=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, storeOrderImport.getMa());
            statement.setDate(2, new java.sql.Date(storeOrderImport.getNgayTao().getTime()));

            storeOrderImport.setNgaySua(new java.util.Date());
            statement.setDate(3, new java.sql.Date(storeOrderImport.getNgaySua().getTime()));
            statement.setString(4, storeOrderImport.getDonViTinh());
            statement.setInt(5, storeOrderImport.getStatus());
            
            statement.setString(6, storeOrderImport.getId());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteStoreOrderById(String id) {
        String sql = "UPDATE phieuNhanHang SET trangThai = 0  WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
            StoreOrderImport storeOrderImport = new StoreOrderImport();
            storeOrderImport.setNgaySua(new java.util.Date());

            statement.setDate(4, new java.sql.Date(storeOrderImport.getNgaySua().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public StoreOrderImport findById(String id) {
        String sql = "SELECT * FROM phieuNhanHang WHERE id = ?";
        StoreOrderImport storeOrderImport = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                storeOrderImport = new StoreOrderImport();
                storeOrderImport.setId(resultSet.getString("id"));
                storeOrderImport.setMa(resultSet.getString("ma"));
                storeOrderImport.setNgayTao(resultSet.getDate("ngayTao"));
                storeOrderImport.setNgaySua(resultSet.getDate("ngaySua"));
                storeOrderImport.setDonViTinh(resultSet.getString("donViTinh"));
                storeOrderImport.setStatus(resultSet.getInt("trangThai"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return storeOrderImport;
    }
}
