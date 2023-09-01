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
    
    public static Connection conn = JdbcHelper.getConnection();



    public static void create(AccountRole accountRole) {
        String sql = "INSERT INTO roles_acc (idAcc, idRole) VALUES (?, ?)";

        try  {
             PreparedStatement ps = conn.prepareStatement(sql);
          
            ResultSet rs = ps.executeQuery();
            ps.setString(1, accountRole.getIdAccount());
            ps.setString(2, accountRole.getIdRole());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AccountRole getById(String idAccount) {
        AccountRole accountRole = null;
                    String sql = "SELECT * FROM roles_acc WHERE idAcc = ?";

        try {
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
                    String sql = "SELECT * FROM roles_acc";

        try  {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

           while (resultSet.next()) {
                String idAccount = resultSet.getString("idAcc");
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
