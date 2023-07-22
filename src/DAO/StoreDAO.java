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
import model.Store;

/**
 *
 * @author trung
 */
public class StoreDAO {
    
    private Connection conn = JdbcHelper.getConnection();

    public void insertStore(Store store) {

        String sql = "INSERT INTO cuaHang ( ma, ten, diaChi, idPhieuNhanHang, ngayTao, ngaySua, trangThai) VALUES ( ?, ?, ?, ?, ?, ?, 1)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, store.getMa());
            statement.setString(2, store.getTen());
            statement.setString(3, store.getDiaChi());
            statement.setString(4, store.getIdPhieuNhanHang());
            statement.setDate(5, new java.sql.Date(store.getNgayTao().getTime()));
            statement.setDate(6, new java.sql.Date(store.getNgaySua().getTime()));

            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        String sql = "SELECT * FROM cuaHang where trangThai = 1";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Store store = new Store();
                store.setId(resultSet.getString("id"));
                store.setMa(resultSet.getString("ma"));
                store.setTen(resultSet.getString("ten"));
                store.setDiaChi(resultSet.getString("diaChi"));
                store.setIdPhieuNhanHang(resultSet.getString("idPhieuNhanHang"));
                store.setNgayTao(resultSet.getDate("ngayTao"));
                store.setNgaySua(resultSet.getDate("ngaySua"));
                store.setStatus(resultSet.getInt("trangThai"));

                stores.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stores;
    }

    public void updateStore(Store store) {
        String sql = "UPDATE cuaHang SET ma=?, ten=?, diaChi=?, idPhieuNhanHang=?, ngayTao=?, ngaySua=?, trangThai=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, store.getMa());
            statement.setString(2, store.getTen());
            statement.setString(3, store.getDiaChi());
            statement.setString(4, store.getIdPhieuNhanHang());
            statement.setDate(5, new java.sql.Date(store.getNgayTao().getTime()));
            store.setNgaySua(new java.util.Date());

            statement.setDate(6, new java.sql.Date(store.getNgaySua().getTime()));
            statement.setInt(7, store.getStatus());
            statement.setString(8, store.getId());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteStoreById(String id) {
        String sql = "UPDATE cuaHang SET trangThai = 0  WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
//            Store store = new Store();
//            store.setNgaySua(new java.util.Date());
//
//            statement.setDate(7, new java.sql.Date(store.getNgaySua().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Store findById(String id) {
        String sql = "SELECT * FROM cuaHang WHERE id = ?";
        Store store = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                store = new Store();
                store.setId(resultSet.getString("id"));
                store.setMa(resultSet.getString("ma"));
                store.setTen(resultSet.getString("ten"));
                store.setDiaChi(resultSet.getString("diaChi"));
                store.setIdPhieuNhanHang(resultSet.getString("idPhieuNhanHang"));
                store.setNgayTao(resultSet.getDate("ngayTao"));
                store.setNgaySua(resultSet.getDate("ngaySua"));
                store.setStatus(resultSet.getInt("trangThai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return store;
    }
}
