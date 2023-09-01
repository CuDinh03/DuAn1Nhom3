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

        String sql = "INSERT INTO income ( code,total ,createDate ,updateDate ) VALUES (?, ?, ?, ?)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, income.getCode());
            statement.setDate(2, new java.sql.Date(income.getCreateDate().getTime()));
            statement.setDate(3, new java.sql.Date(income.getUpdateDate().getTime()));
            statement.setBigDecimal(4, income.getTotal());
            
            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Income> getAllStores() {
        List<Income> incomes = new ArrayList<>();
        String sql = "SELECT * FROM total";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Income income = new Income();
                
                income.setIdCh(resultSet.getString("ID"));
                income.setCode(resultSet.getString("code"));
                income.setCreateDate(resultSet.getDate("createDate"));
                income.setUpdateDate(resultSet.getDate("updateDate"));
                income.setTotal(resultSet.getBigDecimal("total"));

                incomes.add(income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return incomes;
    }

    public void updateIncome(Income income) {
        String sql = "UPDATE total SET code=?, createDate=?, updateDate=?, total=? WHERE ID=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, income.getCode());
            statement.setDate(2, new java.sql.Date(income.getCreateDate().getTime()));

            income.setUpdateDate(new java.util.Date());
            statement.setDate(3, new java.sql.Date(income.getUpdateDate().getTime()));
            statement.setBigDecimal(4, income.getTotal());

            
            statement.setString(5, income.getIdCh());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     public void deleteInComeById(String idCH) {
        String sql = "UPDATE total SET incomeStatus = 0  WHERE ID=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,idCH);
            Income income = new Income();
            income.setUpdateDate(new java.util.Date());

            statement.setDate(5, new java.sql.Date(income.getUpdateDate().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Income findById(String id) {
        String sql = "SELECT * FROM total WHERE ID = ?";
        Income income = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                income = new Income();
                income.setIdCh(resultSet.getString("ID"));
                income.setCode(resultSet.getString("code"));
                income.setCreateDate(resultSet.getDate("createDate"));
                income.setUpdateDate(resultSet.getDate("updateDate"));
                income.setTotal(resultSet.getBigDecimal("total"));
 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return income;
    }
}
