package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NguyenTheAnh
 */
public class DBContext {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=VNH2";
        return DriverManager.getConnection(URL, "sa", "12345");
    }

    public static void main(String[] args) {
        try {
            DBContext conn = new DBContext();
            System.out.println(conn.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}