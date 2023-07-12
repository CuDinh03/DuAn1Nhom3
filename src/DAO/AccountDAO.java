package DAO;

import model.Account;
import Utilities.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDAO {
    private Connection connection;

    public AccountDAO() {
        connection = JdbcHelper.getConnection();
    }

    // Create
    public void addAccount(Account account) {
        String query = "INSERT INTO taiKhoan (id, ma, ngayTao, ngaySua, taiKhoan, matKhau, trangThai) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getId());
            statement.setString(2, account.getMaTk());
            statement.setDate(3, new java.sql.Date(account.getNgayTao().getTime()));
            statement.setDate(4, new java.sql.Date(account.getNgaySua().getTime()));
            statement.setString(5, account.getUsername());
            statement.setString(6, account.getPassWord());
            statement.setInt(7, account.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public Account getAccountById(String id) {
        String query = "SELECT * FROM taiKhoan WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractAccountFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        String query = "SELECT * FROM taiKhoan";
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Account account = extractAccountFromResultSet(resultSet);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // Update
    public void updateAccount(Account account) {
        String query = "UPDATE taiKhoan SET ma = ?, ngayTao = ?, ngaySua = ?, taiKhoan = ?, matKhau = ?, " +
                "trangThai = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getMaTk());
            statement.setDate(2, new java.sql.Date(account.getNgayTao().getTime()));
            statement.setDate(3, new java.sql.Date(account.getNgaySua().getTime()));
            statement.setString(4, account.getUsername());
            statement.setString(5, account.getPassWord());
            statement.setInt(6, account.getStatus());
            statement.setString(7, account.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteAccount(String id) {
        String query = "UPDATE taiKhoan WHERE id = ? SET trangThai = 0 ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Account extractAccountFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String maTk = resultSet.getString("ma");
        Date ngayTao = resultSet.getDate("ngayTao");
        Date ngaySua = resultSet.getDate("ngaySua");
        String username = resultSet.getString("taiKhoan");
        String passWord = resultSet.getString("matKhau");
        int status = resultSet.getInt("trangThai");

        return new Account(id, maTk, ngayTao, ngaySua, username, passWord, status);
    }
}
