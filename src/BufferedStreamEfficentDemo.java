import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStreamEfficentDemo {
	private static String filepath1 = "G:/洋务运动的主导人之一，功绩赫赫，却为大清和皇.mp4";
	private static String filepath2 = "G:/复制的视频.mp4";

	public static void main(String[] args) {
		long time = CopyEfficent();
		System.out.println("复制用时:" + time + "毫秒");

	}
	/**
	 * 用来测试用缓存复制文件的效率
	 * @return 复制一个文件所需要的毫秒数
	 */
	private static long CopyEfficent() {
		long starttime = System.currentTimeMillis();
		File file = new File(filepath1);//实例化要复制的对象
		if(!file.exists()) {
			System.out.println("复制的文件不存在！");
			return 0;
		}
		InputStream input = null;
		BufferedInputStream binput = null;
		OutputStream output = null;
		BufferedOutputStream boutput = null;//给予初值
		try {
			input = new FileInputStream(file);
			binput = new BufferedInputStream(input);
			output = new FileOutputStream(filepath2);
			boutput = new BufferedOutputStream(output);//使用了装饰器原理
			int i = -1;
			while((i = binput.read()) != -1) {
				boutput.write(i);//读一个写一个
			}
			System.out.println("文件复制完成！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				boutput.close();
				output.close();
				binput.close();
				input.close();//关闭资源
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endtime = System.currentTimeMillis();
		return endtime - starttime;
	}

}
