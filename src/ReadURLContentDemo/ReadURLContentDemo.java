package ReadURLContentDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;


public class ReadURLContentDemo {
	static final String filepath = "E:/eclipse-workspace/JavaBase/src/ReadURLContentDemo/»À√ÒÕ¯.html";
	public static void main(String[] args) throws IOException {
		StringBuffer content = new StringBuffer();
		URL url = new URL("http://www.people.com.cn/index.html");
		
		
		try (
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				Writer writer = new FileWriter(filepath);
				BufferedWriter bwriter = new BufferedWriter(writer);
				
				
			) {
			String line = null;
			while((line = reader.readLine()) != null) {
				content.append(line);
				content.append(System.getProperty("line.separator"));
			}
			System.out.println(content.toString());
			bwriter.write(content.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
