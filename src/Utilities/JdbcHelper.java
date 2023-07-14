package Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JdbcHelper {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                String user = "sa", pwd = "Password.1",
                        url = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1";

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                conn = DriverManager.getConnection(url, user, pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}