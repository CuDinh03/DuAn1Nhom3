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
import model.Income;


/**
 *
 * @author trung
 */
public class InComeDAO {
     private Connection conn = JdbcHelper.getConnection();

    public void insertIncome(Income income) {

        String sql = "INSERT INTO doanhThu ( ma, ngayTao, ngaySua, doanhThu) VALUES (?, ?, ?, ?)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, income.getMa());
            statement.setDate(2, new java.sql.Date(income.getNgayTao().getTime()));
            statement.setDate(3, new java.sql.Date(income.getNgaySua().getTime()));
            statement.setBigDecimal(4, income.getDoanhThu());
            
            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Income> getAllStores() {
        List<Income> incomes = new ArrayList<>();
        String sql = "SELECT * FROM doanhThu";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Income income = new Income();
                
                income.setIdCh(resultSet.getString("idCH"));
                income.setMa(resultSet.getString("ma"));
                income.setNgayTao(resultSet.getDate("ngayTao"));
                income.setNgaySua(resultSet.getDate("ngaySua"));
                income.setDoanhThu(resultSet.getBigDecimal("doanhThu"));

                incomes.add(income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return incomes;
    }

    public void updateIncome(Income income) {
        String sql = "UPDATE doanhThu SET ma=?, ngayTao=?, ngaySua=?, doanhThu=? WHERE idCH=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, income.getMa());
            statement.setDate(2, new java.sql.Date(income.getNgayTao().getTime()));

            income.setNgaySua(new java.util.Date());
            statement.setDate(3, new java.sql.Date(income.getNgaySua().getTime()));
            statement.setBigDecimal(4, income.getDoanhThu());

            
            statement.setString(6, income.getIdCh());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteInComeById(String idCH) {
        String sql = "UPDATE doanhThu SET trangThai = 0  WHERE idCH=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,idCH);
            Income income = new Income();
            income.setNgaySua(new java.util.Date());

            statement.setDate(4, new java.sql.Date(income.getNgaySua().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Income findById(String id) {
        String sql = "SELECT * FROM doanhThu WHERE idCH = ?";
        Income income = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                income = new Income();
                income.setIdCh(resultSet.getString("idCH"));
                income.setMa(resultSet.getString("ma"));
                income.setNgayTao(resultSet.getDate("ngayTao"));
                income.setNgaySua(resultSet.getDate("ngaySua"));
                income.setDoanhThu(resultSet.getBigDecimal("doanhThu"));
 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return income;
    }
}
