package UserRegistrationDemo;

import java.util.*;

public class usermain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������û�����");
		String userName = input.next();
		System.out.println("���������룺");
		String password = input.next();
		System.out.println("���������䣺");
		String email = input.next();
		if(!(userutil.isCorrectuserName(userName) && userutil.isCorrectemail(email))) {

			System.out.println("������Ϸ����û���������");
		}
		System.out.println("����ǿ�ȣ�" + userutil.validdatepassword(password));
		user user1 = new user(userName, password, email);
		System.out.println(user1.getUserName() + user1.getPassword() + user1.getEmail());
			
	}

}
