package UserRegistrationDemo;

import java.lang.*;

public class userutil {
	/**
	 * 用于判断用户名不能多于25个字符并且不能包含单双引号，空格，问号等特殊符号
	 * @param userName 输入的用户名
	 * @return 
	 */
	public static boolean isCorrectuserName(String userName) {
		boolean isCorrect = true;
		if(userName.length() > 25 || userName == null) {
			isCorrect = false;
		}
		String[] unvalidstring = {" ", "<", ">", "?", "'",""};
		for(String s : unvalidstring) {
			if(userName.contains(unvalidstring.toString())) {
				isCorrect = false;
				break;
			}
		}
		return isCorrect;
	}
	/**
	 * 判断邮箱是否合法
	 * @param value
	 * @return
	 */
	public static boolean isCorrectemail(String value) {
		boolean iscorrectemail = true;
		if(! value.contains("@")) {
			iscorrectemail = false;
		}
		if(!(value.indexOf("@") == value.lastIndexOf("@"))) {
			iscorrectemail = false;
		}
		return iscorrectemail;
	}
	/**
	 * 判断密码是否合法
	 * @return 返回一个密码强度，为空则证明不合法
	 */
	public static String validdatepassword(String Password) {
		String power = "";//密码强度为空
		String correctpart = "_$@#!";
		if(Password == null) return power;
		if(Password.length() < 6 || Password.length() > 18) return power;
		for(int i = 0;i < Password.length(); i++ ) {
			if(!Character.isLetterOrDigit(Password.charAt(i))) {
				if(!correctpart.contains(Character.toString(Password.charAt(i)))) {
					return power;
				}
			}
		}
		//如果合法，下面判断密码强度 
		if(isletter(Password) || isdigit(Password) || isspecialvalue(Password)) {
			power = "*";
		}else if(isletterAndspecialpart(Password) || isdigitAndspecialpart(Password) || isdigitAndletter(Password)) {
			power = "**";
		}else power = "***";
		return power;
	}
	/**
	 * 判断字符串是否为字母和特殊符号的混合
	 * @param value
	 * @return
	 */
	public static boolean isletterAndspecialpart(String value) {
		boolean isletterandspecial = true;
		String specialpart = "@!#$_";
		for(int i = 0; i < value.length(); i++) {
			if(!(Character.isLetter(value.charAt(i)) || specialpart.contains(Character.toString(value.charAt(i))))) {
				isletterandspecial = false;
			}
		}
		return isletterandspecial;
	}
	/**
	 * 判断字符串是否为数字和特殊符号的混合
	 * @param value
	 * @return
	 */
	public static boolean isdigitAndspecialpart(String value) {
		boolean isdigitandspecialpart = true;
		String specialpart = "@!#$_";
		for(int i = 0;i < value.length(); i++) {
			if(!(Character.isDigit(value.charAt(i)) || specialpart.contains(Character.toString(value.charAt(i))))) {
				isdigitandspecialpart = false;
			}
		}
		return isdigitandspecialpart;
	}
	/**
	 * 判断字符串是否为数字和字母
	 * @param value
	 * @return
	 */
	public static boolean isdigitAndletter(String value) {
		boolean isdigitandletter = true;
		for(int i = 0; i < value.length(); i++) {
			if(!Character.isLetterOrDigit(value.charAt(i))) {
				isdigitandletter = false;
			}
		}
		return isdigitandletter;
	}
	
	/**
	 * 判断输入的字符串是否为纯字母
	 * @param value 输入的字符串（密码）
	 * @return 返回一个逻辑值
	 */
	public static boolean isletter(String value) {
		boolean isLetter = true;
		for(int i = 0; i < value.length(); i++) {
			if(!Character.isLetter(value.charAt(i))) {
				isLetter = false;
			}
		}
		return isLetter;
	}
	/**
	 * 判断字符串是否为纯数字
	 * @param value 输入的字符串
	 * @return
	 */
	public static boolean isdigit(String value) {
		boolean isDigit = true;
		for(int i = 0; i < value.length(); i++) {
			if(!Character.isDigit(value.charAt(i))) {
				isDigit = false;
			}
		}
		return isDigit;
	}
	/**
	 * 判断字符串是否为纯的特殊符号
	 * @param value
	 * @return
	 */
	public static boolean isspecialvalue(String value) {
		boolean isSpecial = true;
		String specialpart = "@!#$_";
		for(int i = 0; i < value.length(); i++) {
			if(!specialpart.contains(Character.toString(value.charAt(i)))) {
				isSpecial = false;
			}
		}
		return isSpecial;
		
	}
	
}
