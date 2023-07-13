package Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
<<<<<<< HEAD
=======

import java.sql.PreparedStatement;
import java.sql.ResultSet;

>>>>>>> 85af030e942fc82d64fcd49e7b4709f105861740

public class JdbcHelper {

    private static Connection conn;
    public static void main(String[] args) {
     getConnection();
    }
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

      return null;
    }
<<<<<<< HEAD
}
=======

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
>>>>>>> 85af030e942fc82d64fcd49e7b4709f105861740
