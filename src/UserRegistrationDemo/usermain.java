package UserRegistrationDemo;

import java.util.*;

public class usermain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String userName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		System.out.println("请输入邮箱：");
		String email = input.next();
		if(!(userutil.isCorrectuserName(userName) && userutil.isCorrectemail(email))) {

			System.out.println("请输入合法的用户名和邮箱");
		}
		System.out.println("密码强度：" + userutil.validdatepassword(password));
		user user1 = new user(userName, password, email);
		System.out.println(user1.getUserName() + user1.getPassword() + user1.getEmail());
			
	}

}
