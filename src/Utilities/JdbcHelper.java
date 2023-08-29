package Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JdbcHelper {

    public static Connection getConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=da1";
            String username = "sa";
            String pass = "Password.1";
            return DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
