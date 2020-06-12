package RandomAccessFileDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	private static String filepath = "E:/eclipse-workspace/JavaBase/src/RandomAccessFileDemo/save.txt";//�����ļ�·��
	
	public static void main(String[] args) {
		File file = new File(filepath);
		try (RandomAccessFile randfile = new RandomAccessFile(file, "rw");){
			if(!file.exists()) {
				file.createNewFile();//�������·���ļ������ڣ��򴴽�һ��
			}
			randfile.setLength(0);//���ļ�����ǿ������
			for(int i = 0; i < 2000; i++) {
				//д��2000������
				randfile.writeInt(i + 2000);
			}
			randfile.seek(4 * 8);//�ƶ��ļ�ָ�뵽�ڰ˸�����λ�ã�ÿ������ռ4���ֽ�
			System.out.println(randfile.readInt());
			randfile.seek(4 * 8);
			randfile.writeInt(32);//�ڵڰ˸������ĵط�д��32
			randfile.seek(4 * 8);
			System.out.println(randfile.readInt());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
