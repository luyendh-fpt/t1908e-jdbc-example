package t1908e.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    private static Connection connection;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/t1908e_jdbc?useUnicode=true&serverTimezone=Asia/Bangkok&characterEncoding=utf-8";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "abcD1234";

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            System.err.println("Khởi tạo kết nối đến database.");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PWD);
        }
        return connection;
    }
}
