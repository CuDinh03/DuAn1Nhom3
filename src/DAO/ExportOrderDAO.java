/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JdbcHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ExportOrder;

/**
 *
 * @author trung
 */
public class ExportOrderDAO {
    
    private final Connection connection = JdbcHelper.getConnection();
    
    public List <ExportOrder> findAll() {
        List<ExportOrder> exportOrders = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM phieuXuat WHERE trangThai = 1 ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
        while (resultSet.next()) {
                String id = resultSet.getString("id");
                String ma = resultSet.getString("ma");               
                Date ngayTao = resultSet.getDate("ngayTao");
                Date ngaySua = resultSet.getDate("ngaySua");
                String donViTinh = resultSet.getString("donViTinh");
                int status = resultSet.getInt("trangThai");
                String idKho = resultSet.getString("idKho");

                ExportOrder exportOrder = new ExportOrder(id, ma, ngayTao, ngaySua, donViTinh, status, idKho);
                exportOrders.add(exportOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exportOrders; 
    }
    
    
    public boolean createExport(ExportOrder exportOrder){
        
    try  {
            String query = "INSERT INTO phieuXuat ( ma, ngayTao, ngaySua, DonViTinh, trangThai, idKho) VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, exportOrder.getMa());
            preparedStatement.setDate(2, new java.sql.Date(exportOrder.getNgayTao().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(exportOrder.getNgaySua().getTime()));
            preparedStatement.setString(4, exportOrder.getDonViTinh());
            preparedStatement.setInt(5, exportOrder.getTrangThai());
            preparedStatement.setString(6, exportOrder.getIdKho());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
   public ExportOrder getExportById(String exportID) {
         String query = "SELECT * FROM phieuXuat WHERE id = ? and trangThai = 1 ";
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, exportID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String ma = resultSet.getString("ma");                
                Date ngayTao = resultSet.getDate("ngayTao");
                Date ngaySua = resultSet.getDate("ngaySua");
                String donViTinh = resultSet.getString("DonViTinh");
                int status = resultSet.getInt("trangThai");
                String idKho = resultSet.getString("idKho");

                return new ExportOrder(id, ma, ngayTao, ngaySua, donViTinh, status, idKho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
   
   public boolean updateOrder(ExportOrder exportOrder) {
        try  {
            String query = "UPDATE phieuXuat SET ma = ?, ten = ?, ngayTao = ?, ngaySua = ?, DonViTinh = ?, trangThai = ?, idKho = ?  WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, exportOrder.getMa());
            preparedStatement.setDate(2, new java.sql.Date(exportOrder.getNgayTao().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(exportOrder.getNgaySua().getTime()));
            preparedStatement.setString(4, exportOrder.getDonViTinh());
            preparedStatement.setInt(5, exportOrder.getTrangThai());
            preparedStatement.setString(6, exportOrder.getIdKho());
            preparedStatement.setString(7, exportOrder.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteExport(String exportID) {
        try {
            String query = "UPDATE phieuXuat SET trangThai = 0 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, exportID);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    
}    
    

