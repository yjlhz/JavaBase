package UserRegistrationDemo;

import java.lang.*;

public class userutil {
	/**
	 * �����ж��û������ܶ���25���ַ����Ҳ��ܰ�����˫���ţ��ո��ʺŵ��������
	 * @param userName ������û���
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
	 * �ж������Ƿ�Ϸ�
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
	 * �ж������Ƿ�Ϸ�
	 * @return ����һ������ǿ�ȣ�Ϊ����֤�����Ϸ�
	 */
	public static String validdatepassword(String Password) {
		String power = "";//����ǿ��Ϊ��
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
		//����Ϸ��������ж�����ǿ�� 
		if(isletter(Password) || isdigit(Password) || isspecialvalue(Password)) {
			power = "*";
		}else if(isletterAndspecialpart(Password) || isdigitAndspecialpart(Password) || isdigitAndletter(Password)) {
			power = "**";
		}else power = "***";
		return power;
	}
	/**
	 * �ж��ַ����Ƿ�Ϊ��ĸ��������ŵĻ��
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
	 * �ж��ַ����Ƿ�Ϊ���ֺ�������ŵĻ��
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
	 * �ж��ַ����Ƿ�Ϊ���ֺ���ĸ
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
	 * �ж�������ַ����Ƿ�Ϊ����ĸ
	 * @param value ������ַ��������룩
	 * @return ����һ���߼�ֵ
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
	 * �ж��ַ����Ƿ�Ϊ������
	 * @param value ������ַ���
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
	 * �ж��ַ����Ƿ�Ϊ�����������
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
