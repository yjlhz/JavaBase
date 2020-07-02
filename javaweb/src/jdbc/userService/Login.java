package jdbc.userService;

import jdbc.User.User;

import java.util.Scanner;

public class Login {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入账号：");
        String username = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        UserService us = new UserService();
        User user = us.selectByNameAndPassword(username,password);

        if (user == null){
            System.out.println("账号或密码错误，请重新登录！");
        }else {
            System.out.println("登录成功！");

        }

    }
}
