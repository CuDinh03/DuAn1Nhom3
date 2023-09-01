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

    private final Connection connection ;

    public AccountDAO() {
        this.connection = JdbcHelper.getConnection();
    }

    // Create
    public void addAccount(Account account) {
        String query = "INSERT INTO account (id, username, pass, createDate, updateDate, accStatus) "
                + "VALUES (?, ?, ?, ?, ?, 1)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getId());

            statement.setDate(2, new java.sql.Date(account.getCreateDate().getTime()));
            statement.setDate(3, new java.sql.Date(account.getUpdateDate().getTime()));
            statement.setString(4, account.getUsername());
            statement.setString(5, account.getPass());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public Account getAccountById(String id) {
        String query = "SELECT * FROM account WHERE id = ?";
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
        String query = "SELECT * FROM account WHERE accStatus = 1 ";
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
        String query = "UPDATE account SET createDate = ?, updateDate = ?, username = ?, pass = ?, "
                + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
      
            statement.setDate(1, new java.sql.Date(account.getCreateDate().getTime()));
            statement.setDate(2, new java.sql.Date(account.getUpdateDate().getTime()));
            statement.setString(3, account.getUsername());
            statement.setString(4, account.getPass());
            statement.setString(5, account.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteAccount(String id) {
        String query = "UPDATE account WHERE id = ? SET accStatus = 0 ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Account extractAccountFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        Date createDate = resultSet.getDate("createDate");
        Date updateDate = resultSet.getDate("updateDate");
        String username = resultSet.getString("username");
        String pass = resultSet.getString("pass");
        int accStatus = resultSet.getInt("accStatus");

        return new Account(id, username, pass, createDate, updateDate, accStatus);
    }

    public Account getAccountByUsername(String username) throws SQLException {

        Account account = null;

        String query = "SELECT * FROM account WHERE username = ?";
        try  {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String password = resultSet.getString("username");
                int status = resultSet.getInt("username");

                account = new Account(id, username, password, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
