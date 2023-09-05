
package DAO;
import java.sql.*;
import Utilities.JdbcHelper;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Role;


public class RoleDAO {
     private final Connection connection = JdbcHelper.getConnection();


    
    public List<Role> getAllRoles() {
        String query = "SELECT * FROM roles";
        List<Role> roles = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Role role = extractRoleFromResultSet(resultSet);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
    
    private Role extractRoleFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String ma = resultSet.getString("rolesName");
        Date ngayTao = resultSet.getDate("createDate");
        Date ngaySua = resultSet.getDate("updateDate");
        int status = resultSet.getInt("rolesStatus");

        return new Role(id, ma, ngayTao, ngaySua, status);
    }
    
}
