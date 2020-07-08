package jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertDemo {

    public void testInsert(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1","root","WYKYQSPSN@12138");
            Statement statement = conn.createStatement();
            int flag = statement.executeUpdate("insert into t_user(name,password,email,birthday) value ('cat','123456','cat@163.com','1999-05-02')");
            if (flag > 0){
                System.out.println("chengg");
            }
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1","root","WYKYQSPSN@12138");
            Statement statement = conn.createStatement();
            int flag = statement.executeUpdate("update t_user set password='123' where name='cat'");
            if (flag > 0){
                System.out.println("chengg");
            }
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void testdelete(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1","root","WYKYQSPSN@12138");
            Statement statement = conn.createStatement();
            int flag = statement.executeUpdate("DELETE FROM t_user WHERE name='cat'");
            if (flag > 0){
                System.out.println("chengg");
            }
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
