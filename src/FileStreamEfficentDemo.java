import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamEfficentDemo {
	private static String filepath1 = "G:/洋务运动的主导人之一，功绩赫赫，却为大清和皇.mp4";
	private static String filepath2 = "G:/复制的视频.mp4";
	
	public static void main(String[] args) {
		long time = FileStreamEfficent();
		System.out.println("不用缓存复制用时:" + time + "毫秒");
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
			System.out.println("文件复制完成！");
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
