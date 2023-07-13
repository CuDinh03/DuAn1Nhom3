package DAO;

import model.AccountRole;
import Utilities.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRoleDAO {

    public static void create(AccountRole accountRole) {
        try (Connection conn = JdbcHelper.getConnection()) {
            String sql = "INSERT INTO taiKhoanVaiTro (idTaiKhoan, idVaiTro) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, accountRole.getIdAccount());
            statement.setString(2, accountRole.getIdRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AccountRole getById(String idAccount) {
        AccountRole accountRole = null;
        try (Connection conn = JdbcHelper.getConnection()) {
            String sql = "SELECT * FROM taiKhoanVaiTro WHERE idTaiKhoan = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idAccount);
   
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                accountRole = new AccountRole(resultSet.getString("idTaiKhoan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountRole;
    }

    public static List<AccountRole> getAll() {
        List<AccountRole> accountRoles = new ArrayList<>();
        try (Connection conn = JdbcHelper.getConnection()) {
            String sql = "SELECT * FROM taiKhoanVaiTro";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

           while (resultSet.next()) {
                String idAccount = resultSet.getString("idAccount");
                String idRole = resultSet.getString("idRole");

                AccountRole accountRole = new AccountRole(idAccount, idRole);
                accountRoles.add(accountRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountRoles;
    }
}
