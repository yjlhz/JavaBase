package RandomAccessFileDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	private static String filepath = "E:/eclipse-workspace/JavaBase/src/RandomAccessFileDemo/save.txt";//设置文件路径
	
	public static void main(String[] args) {
		File file = new File(filepath);
		try (RandomAccessFile randfile = new RandomAccessFile(file, "rw");){
			if(!file.exists()) {
				file.createNewFile();//如果所给路径文件不存在，则创建一个
			}
			randfile.setLength(0);//将文件内容强制清零
			for(int i = 0; i < 2000; i++) {
				//写入2000个整数
				randfile.writeInt(i + 2000);
			}
			randfile.seek(4 * 8);//移动文件指针到第八个整数位置，每个整数占4个字节
			System.out.println(randfile.readInt());
			randfile.seek(4 * 8);
			randfile.writeInt(32);//在第八个整数的地方写入32
			randfile.seek(4 * 8);
			System.out.println(randfile.readInt());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
