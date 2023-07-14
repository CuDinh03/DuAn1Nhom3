package Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JdbcHelper {

    public static Connection getConnection() {
//        try {
//
//            if (conn == null || conn.isClosed()) {
//                String user = "sa", pwd = "Password.1",
//                        url = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1";
//
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//                conn = DriverManager.getConnection(url, user, pwd);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1";
            String username = "sa";
            String pass = "Password.1";
            return DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
