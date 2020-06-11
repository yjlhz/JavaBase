package ReplacelyricsDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReplacelyricsDemo {
	private static String filepath = "E:/eclipse-workspace/JavaBase/src/ReplacelyricsDemo/lyrics.sav";
	
	private static String newfilepath = "E:/eclipse-workspace/JavaBase/src/ReplacelyricsDemo/newlyrics.sav";

	public static void main(String[] args) {
		//使用字符流操作
		File file = new File(filepath);
		File newfile = new File(newfilepath);
		Reader reader = null;
		BufferedReader breader = null;
		StringBuffer lyrics = new StringBuffer();
		Writer writer = null;
		BufferedWriter bwriter = null;
		try {
			reader = new FileReader(file);
			breader = new BufferedReader(reader);
			String line = new String();
			while((line = breader.readLine()) != null) {
				lyrics.append(line);
				lyrics.append(System.getProperty("line.separator"));//拼接默认分隔符
			}
			System.out.println(lyrics.toString());
			String newlyrics = lyrics.toString().replaceAll("大鱼", "大鲲");
			System.out.println(newlyrics);
			writer = new FileWriter(newfile);
			bwriter = new BufferedWriter(writer);
			bwriter.write(newlyrics);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				breader.close();
				reader.close();
				bwriter.flush();
				bwriter.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
