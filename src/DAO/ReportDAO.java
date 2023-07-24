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
import model.Report;


/**
 *
 * @author trung
 */
public class ReportDAO {
    private Connection conn = JdbcHelper.getConnection();

    public void insertReport(Report report) {

        String sql = "INSERT INTO baoCao ( maBC, noiDung, ten, ngayTao, ngaySua,doanhThu,trangThai, idNV, idCuaHang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, report.getMaBC());
            statement.setString(2, report.getNoiDung());
            statement.setString(3, report.getTen());
            statement.setDate(4, new java.sql.Date(report.getNgayTao().getTime()));
            statement.setDate(5, new java.sql.Date(report.getNgaySua().getTime()));
            statement.setBigDecimal(6,report.getDoanhThu() );
            statement.setInt(7, report.getTrangThai());
            statement.setString(8, report.getIdNV());
            statement.setString(9, report.getIdCH());
            
            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Report> getAllStores() {
        List<Report> reports = new ArrayList<>();
        String sql = "SELECT * FROM baoCao";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Report report = new Report();
                
                report.setId(resultSet.getString("id"));
                report.setMaBC(resultSet.getString("maBC"));
                report.setNoiDung(resultSet.getString("noiDung"));
                report.setTen(resultSet.getString("ten"));
                report.setNgayTao(resultSet.getDate("ngayTao"));
                report.setNgayTao(resultSet.getDate("ngaySua"));
                report.setDoanhThu(resultSet.getBigDecimal("doanhThu"));
                report.setTrangThai(resultSet.getInt("trangThai"));
                report.setIdNV(resultSet.getString("idNV"));
                report.setIdCH(resultSet.getString("idCuaHang"));

                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }

    public void updateReport(Report report) {
        String sql = "UPDATE baoCao SET maBC=?, noiDung=?, ten=?, ngayTao=?, ngaySua=?, doanhThu=? , trangThai=?, idNV=? , idCuaHang=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, report.getMaBC());
            statement.setString(2, report.getNoiDung());
            statement.setString(3, report.getTen());
            statement.setDate(4, new java.sql.Date(report.getNgayTao().getTime()));
            report.setNgaySua(new java.util.Date());
            statement.setDate(5, new java.sql.Date(report.getNgaySua().getTime()));
            statement.setBigDecimal(6, report.getDoanhThu());
            statement.setInt(7, report.getTrangThai());
            statement.setString(8, report.getIdNV());
            statement.setString(9, report.getIdCH());
            
            statement.setString(10, report.getId());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteReportById(String id) {
        String sql = "UPDATE baoCao SET trangThai = 0  WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
            Report report = new Report();
            report.setNgaySua(new java.util.Date());

            statement.setDate(6, new java.sql.Date(report.getNgaySua().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Report findById(String id) {
        String sql = "SELECT * FROM baoCao WHERE id = ?";
        Report report = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                report = new Report();
                report.setId(resultSet.getString("id"));
                report.setMaBC(resultSet.getString("maBC"));
                report.setNoiDung(resultSet.getString("noiDung"));
                report.setTen(resultSet.getString("ten"));
                report.setNgayTao(resultSet.getDate("ngayTao"));
                report.setNgayTao(resultSet.getDate("ngaySua"));
                report.setDoanhThu(resultSet.getBigDecimal("doanhThu"));
                report.setTrangThai(resultSet.getInt("trangThai"));
                report.setIdNV(resultSet.getString("idNV"));
                report.setIdCH(resultSet.getString("idCuaHang"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return report;
    }
    
}
