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

        String sql = "INSERT INTO report ( code, reportDESCRIPTION, namerp, idnv,income,createDate, updateDate, rpStatus) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, report.getCode());
            statement.setString(2, report.getReportDESCRIPTION());
            statement.setString(3, report.getNamerp());
            statement.setDate(4, new java.sql.Date(report.getCreateDate().getTime()));
            statement.setDate(5, new java.sql.Date(report.getUpdateDate().getTime()));
            statement.setInt(6, report.getRpStatus());
            statement.setString(7, report.getIdnv());
            statement.setString(8, report.getIncome());
            
            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Report> getAllStores() {
        List<Report> reports = new ArrayList<>();
        String sql = "SELECT * FROM report";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Report report = new Report();
                
                report.setId(resultSet.getString("id"));
                report.setCode(resultSet.getString("code"));
                report.setReportDESCRIPTION(resultSet.getString("reportDESCRIPTION"));
                report.setNamerp(resultSet.getString("namerp"));
                report.setCreateDate(resultSet.getDate("createDate"));
                report.setUpdateDate(resultSet.getDate("updateDate"));
                report.setRpStatus(resultSet.getInt("rpStatus"));
                report.setIdnv(resultSet.getString("idnv"));
                report.setIncome(resultSet.getString("income"));

                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }

    public void updateReport(Report report) {
        String sql = "UPDATE report SET code=?, reportDESCRIPTION=?, namerp=?, createDate=?, updateDate=?, rpStatus=?, idnv=? , income=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, report.getCode());
            statement.setString(2, report.getReportDESCRIPTION());
            statement.setString(3, report.getNamerp());
            statement.setDate(4, new java.sql.Date(report.getCreateDate().getTime()));
            report.setUpdateDate(new java.util.Date());
            statement.setDate(5, new java.sql.Date(report.getUpdateDate().getTime()));
            statement.setInt(6, report.getRpStatus());
            statement.setString(7, report.getIdnv());
            statement.setString(8, report.getIncome());
            
            statement.setString(10, report.getId());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteReportById(String id) {
        String sql = "UPDATE report SET rpStatus = 0  WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
            Report report = new Report();
            report.setUpdateDate(new java.util.Date());

            statement.setDate(6, new java.sql.Date(report.getUpdateDate().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Report findById(String id) {
        String sql = "SELECT * FROM report WHERE id = ?";
        Report report = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                report = new Report();
                report.setId(resultSet.getString("id"));
                report.setCode(resultSet.getString("code"));
                report.setReportDESCRIPTION(resultSet.getString("reportDESCRIPTION"));
                report.setNamerp(resultSet.getString("namerp"));
                report.setCreateDate(resultSet.getDate("createDate"));
                report.setUpdateDate(resultSet.getDate("updateDate"));
                report.setRpStatus(resultSet.getInt("rpStatus"));
                report.setIdnv(resultSet.getString("idnv"));
                report.setIncome(resultSet.getString("income"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return report;
    }
    
}
