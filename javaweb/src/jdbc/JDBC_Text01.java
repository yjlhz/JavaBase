package jdbc;

import java.sql.*;

/**
 * 简单的jdbc第一段代码
 */
public class JDBC_Text01 {
    public static void main(String[] args){
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1","root","WYKYQSPSN@12138");
            //得到执行sql语句的statement对象
            Statement stmt = conn.createStatement();
            //执行sql语句
            ResultSet rs = stmt.executeQuery("SELECT id,name,password,email,birthday from t_user");
            //处理结果
            while(rs.next()){
                System.out.println(rs.getObject("id"));
                System.out.println(rs.getObject("name"));
                System.out.println(rs.getObject("password"));
                System.out.println(rs.getObject("email"));
                System.out.println(rs.getObject("birthday"));
                System.out.println("------------------------");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
