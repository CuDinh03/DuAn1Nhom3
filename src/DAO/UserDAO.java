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
        String sql = "INSERT INTO USERs (userName, phone, userAddress, idAcc, createDate, updateDate, userStatus) "
                + "VALUES (?, ?, ?, ?, ?, ?, 1)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getUserAddress());
            statement.setString(4, user.getIdAcc());
            
            statement.setDate(5, new java.sql.Date(user.getCreateDate().getTime()));
            statement.setDate(6, new java.sql.Date(user.getUpdateDate().getTime()));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing user record in the database
    public static void updateUser(User user) {
        String sql = "UPDATE USERs SET userName=?, phone=?, userAddress=?, idAcc=?, createDate=?, updateDate=?, userStatus=? "
                + "WHERE id=?";
        try { PreparedStatement statement = connection.prepareStatement(sql);
                

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getUserAddress());
            statement.setString(4, user.getIdAcc());
           
            statement.setDate(5, new java.sql.Date(user.getCreateDate().getTime()));
            statement.setDate(6, new java.sql.Date(user.getUpdateDate().getTime()));
            statement.setInt(7, user.getUserStatus());
            statement.setString(8, user.getId());

           statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a user record from the database
    public static void deleteUser(String userId) {
        String sql = "UPDATE USERs SET userStatus = 0 WHERE id=?";
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
        String sql = "SELECT * FROM USERs WHERE id=?";
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
        String sql = "SELECT * FROM USERs";
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
        String userName = resultSet.getString("userName");
        String phone = resultSet.getString("phone");        
        String userAddress = resultSet.getString("userAddress");
        String idAcc = resultSet.getString("idAcc");
        Date createDate = resultSet.getDate("createDate");
        Date updateDate = resultSet.getDate("updateDate");
        int userStatus = resultSet.getInt("userStatus");

        return new User(id, userName, phone, userAddress, idAcc, createDate, updateDate, userStatus);
    }
}
