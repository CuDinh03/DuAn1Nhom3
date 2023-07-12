package Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


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

     public static void closeJDBC(Connection cone, PreparedStatement stm, ResultSet rs) {
           if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                   
                }
            }
            if (cone != null) {
                try {
                    cone.close();
                } catch (SQLException ex) {
                   
                }
            }
    }


}
