package FileStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStreamDemo {
	private static final String filepath = "F:\\Éç»áÊµ¼ù.doc";

	public static void main(String[] args) throws IOException {
		File file = new File(filepath);
		System.out.println(file.exists());
		InputStream inputstream = new FileInputStream(file);
		byte[] bytes = new byte[20000];
		int count = 0;
		while((bytes[count] = (byte) inputstream.read()) != -1) {
			count++;
		}
		String content = new String(bytes);
		System.out.println(content);

	}

}