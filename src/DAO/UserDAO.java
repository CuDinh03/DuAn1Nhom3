package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Utilities.JdbcHelper;
import model.User;

public class UserDAO {

    private static final Connection connection = JdbcHelper.getConnection();

    // Method to insert a new user record into the database
    public static void insertUser(User user) {
        String sql = "INSERT INTO NhanVien (maNv, tenNV, tuoi, diaChi, email, gioiTinh, soDienThoai, idKho, ngayTao, ngaySua, trangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getMaNv());
            statement.setString(2, user.getTenNV());
            statement.setInt(3, user.getTuoi());
            statement.setString(4, user.getDiaChi());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getGender());
            statement.setString(7, user.getSdt());
            statement.setString(8, user.getIdKho());
            statement.setDate(9, new java.sql.Date(user.getNgayTao().getTime()));
            statement.setDate(10, new java.sql.Date(user.getNgaySua().getTime()));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing user record in the database
    public static void updateUser(User user) {
        String sql = "UPDATE NhanVien SET maNv=?, tenNV=?, tuoi=?, diaChi=?, email=?, gioiTinh=?, soDienThoai=?, idKho=?, ngayTao=?, ngaySua=?, trangThai=? "
                + "WHERE id=?";
        try { PreparedStatement statement = connection.prepareStatement(sql);
                

            statement.setString(1, user.getMaNv());
            statement.setString(2, user.getTenNV());
            statement.setInt(3, user.getTuoi());
            statement.setString(4, user.getDiaChi());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getGender());
            statement.setString(7, user.getSdt());
            statement.setString(8, user.getIdKho());
            statement.setDate(9, new java.sql.Date(user.getNgayTao().getTime()));
            statement.setDate(10, new java.sql.Date(user.getNgaySua().getTime()));
            statement.setInt(11, user.getStatus());
            statement.setString(12, user.getId());

           statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a user record from the database
    public static void deleteUser(String userId) {
        String sql = "UPDATE NhanVien SET trangThai = 0 WHERE id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
                

            statement.setString(1, userId);

            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a user record from the database by its ID
    public static User getUserById(String userId) {
        String sql = "SELECT * FROM NhanVien WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to retrieve all user records from the database
    public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = mapResultSetToUser(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // Helper method to map a ResultSet to a User object
    private static User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String maNv = resultSet.getString("maNv");
        String tenNV = resultSet.getString("tenNV");
        int tuoi = resultSet.getInt("tuoi");
        String diaChi = resultSet.getString("diaChi");
        String email = resultSet.getString("email");
        int gender = resultSet.getInt("gioiTinh");
        String sdt = resultSet.getString("soDienThoai");
        String idKho = resultSet.getString("idKho");
        Date ngayTao = resultSet.getDate("ngayTao");
        Date ngaySua = resultSet.getDate("ngaySua");
        int status = resultSet.getInt("trangThai");

        return new User(id, maNv, tenNV, tuoi, diaChi, email, gender, sdt, idKho, ngayTao, ngaySua, status);
    }
}
