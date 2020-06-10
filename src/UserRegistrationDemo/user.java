package UserRegistrationDemo;

public class user {
	private static String userName;
	private static String password;
	private static String email;
	
	public user(String userName, String password, String email) {
		setUserName(userName);
		setEmail(email);
		setPassword(password);
	}
	
	
	public user() {
		super();
	}

	public static String getUserName() {
		return userName;
	}
	
	public static void setUserName(String userName) {
		user.userName = userName;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static void setPassword(String password) {
		user.password = password;
	}
	
	public static String getEmail() {
		return email;
	}
	
	public static void setEmail(String email) {
		user.email = email;
	}

}
