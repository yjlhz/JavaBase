package jdbc.been;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    private static String driverclass;
    private static String url;
    private static String username;
    private static String password;

    static {
        ResourceBundle rs = ResourceBundle.getBundle("db");
        driverclass = rs.getString("driverClass");
        url = rs.getString("url");
        username = rs.getString("username");
        password = rs.getString("password");
        try {
            //注册MySQL驱动
            Class.forName(driverclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
