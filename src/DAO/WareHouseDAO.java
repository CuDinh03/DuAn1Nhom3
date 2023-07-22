/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.WareHouse;

/**
 *
 * @author trung
 */
public class WareHouseDAO {
    
    private Connection conn = JdbcHelper.getConnection();

    public void insertStore(WareHouse wareHouse) {

        String sql = "INSERT INTO kho ( ma, tenKho, ngayTao, ngaySua,diaChi, trangThai, idPhieuNhap) VALUES ( ?, ?, ?, ?, ?, ?,?)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, wareHouse.getMa());
            statement.setString(2, wareHouse.getTenKho());
            statement.setString(3, wareHouse.getDiaChi());
            statement.setDate(4, new java.sql.Date(wareHouse.getNgayTao().getTime()));
            statement.setDate(5, new java.sql.Date(wareHouse.getNgaySua().getTime()));
            statement.setInt(6, wareHouse.getStatus());
            statement.setString(7, wareHouse.getIdPhieuNhap());
            
            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<WareHouse> getAllStores() {
        List<WareHouse> wareHouses = new ArrayList<>();
        String sql = "SELECT * FROM kho";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                WareHouse wareHouse = new WareHouse();
                
                wareHouse.setId(resultSet.getString("id"));
                wareHouse.setMa(resultSet.getString("ma"));
                wareHouse.setTenKho(resultSet.getString("tenKho"));
                wareHouse.setNgayTao(resultSet.getDate("ngayTao"));
                wareHouse.setNgaySua(resultSet.getDate("ngaySua"));
                wareHouse.setDiaChi(resultSet.getString("diaChi"));
                wareHouse.setStatus(resultSet.getInt("trangThai"));
                wareHouse.setIdPhieuNhap(resultSet.getString("idPhieuNhap"));

                wareHouses.add(wareHouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wareHouses;
    }

    public void updateStore(WareHouse wareHouse) {
        String sql = "UPDATE kho SET ma=?, tenKho=?, ngayTao=?, ngaySua=?, diaChi=? ,idPhieuNhap, trangThai=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, wareHouse.getMa());
            statement.setString(2, wareHouse.getTenKho());
            statement.setDate(3, new java.sql.Date(wareHouse.getNgayTao().getTime()));

            wareHouse.setNgaySua(new java.util.Date());
            statement.setDate(4, new java.sql.Date(wareHouse.getNgaySua().getTime()));
            statement.setString(5, wareHouse.getDiaChi());
            statement.setInt(7, wareHouse.getStatus());
            statement.setString(8, wareHouse.getId());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteStoreById(String id) {
        String sql = "UPDATE kho SET trangThai = 0  WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
            WareHouse wareHouse = new WareHouse();
            wareHouse.setNgaySua(new java.util.Date());

            statement.setDate(5, new java.sql.Date(wareHouse.getNgaySua().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public WareHouse findById(String id) {
        String sql = "SELECT * FROM cuaHang WHERE id = ?";
        WareHouse wareHouse = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                wareHouse = new WareHouse();
                wareHouse.setId(resultSet.getString("id"));
                wareHouse.setMa(resultSet.getString("ma"));
                wareHouse.setTenKho(resultSet.getString("tenKho"));
                wareHouse.setNgayTao(resultSet.getDate("ngayTao"));
                wareHouse.setNgaySua(resultSet.getDate("ngaySua"));
                wareHouse.setDiaChi(resultSet.getString("diaChi"));
                wareHouse.setStatus(resultSet.getInt("trangThai"));
                wareHouse.setIdPhieuNhap(resultSet.getString("idPhieuNhap"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wareHouse;
    }
    
}
