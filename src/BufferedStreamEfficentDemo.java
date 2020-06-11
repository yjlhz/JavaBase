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
	private static String filepath1 = "G:/�����˶���������֮һ�������պգ�ȴΪ����ͻ�.mp4";
	private static String filepath2 = "G:/���Ƶ���Ƶ.mp4";

	public static void main(String[] args) {
		long time = CopyEfficent();
		System.out.println("������ʱ:" + time + "����");

	}
	/**
	 * ���������û��渴���ļ���Ч��
	 * @return ����һ���ļ�����Ҫ�ĺ�����
	 */
	private static long CopyEfficent() {
		long starttime = System.currentTimeMillis();
		File file = new File(filepath1);//ʵ����Ҫ���ƵĶ���
		if(!file.exists()) {
			System.out.println("���Ƶ��ļ������ڣ�");
			return 0;
		}
		InputStream input = null;
		BufferedInputStream binput = null;
		OutputStream output = null;
		BufferedOutputStream boutput = null;//�����ֵ
		try {
			input = new FileInputStream(file);
			binput = new BufferedInputStream(input);
			output = new FileOutputStream(filepath2);
			boutput = new BufferedOutputStream(output);//ʹ����װ����ԭ��
			int i = -1;
			while((i = binput.read()) != -1) {
				boutput.write(i);//��һ��дһ��
			}
			System.out.println("�ļ�������ɣ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				boutput.close();
				output.close();
				binput.close();
				input.close();//�ر���Դ
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endtime = System.currentTimeMillis();
		return endtime - starttime;
	}

}
