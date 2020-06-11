package FileStreamDemo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedStreamDemo {
	private static final String filepath = "E:\\eclipse-workspace\\JavaBase\\src\\FileStreamDemo\\FileDemo.java";

	public static void main(String[] args) {
		BufferedInputStream binputstream = null;
		try {
			binputstream = new BufferedInputStream(new FileInputStream(filepath));
			byte[] bytes = new byte[binputstream.available()];
			binputstream.read(bytes);
			String content = new String(bytes);
			System.out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				binputstream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
