import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamEfficentDemo {
	private static String filepath1 = "G:/�����˶���������֮һ�������պգ�ȴΪ����ͻ�.mp4";
	private static String filepath2 = "G:/���Ƶ���Ƶ.mp4";
	
	public static void main(String[] args) {
		long time = FileStreamEfficent();
		System.out.println("���û��渴����ʱ:" + time + "����");
	}
	
	private static long FileStreamEfficent() {
		long starttime = System.currentTimeMillis();
		File file = new File(filepath1);
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(filepath2);
			int  i = -1;
			while((i = input.read()) != -1) {
				output.write(i);
			}
			System.out.println("�ļ�������ɣ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				output.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endtime = System.currentTimeMillis();
		return endtime - starttime;
	} 

}
