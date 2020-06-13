package RandomAccessFileDemo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
	private static final String StrUrl = "http://zhiyinqiniu.tangdou.com/hello.mp4";//Ҫ���ص���Ƶ�ļ�
	private static final int Max_Buff_Size = 10240;//����Ĭ�ϻ���
	public static void main(String[] args) {
		HttpURLConnection connection = null;
		int filesize = Integer.MIN_VALUE;
		BufferedInputStream binput = null;
		int downloaded = 0;//������¼�����صĳ���
		String fileName = null;
		try {
			URL url = new URL(StrUrl);//����url����
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Range", "bytes=0-");//�����������ԣ�Range��ʾ�ֽڷ�Χ��0-��ʾ��0����ȡ�ļ��ĳ���
			connection.connect();//ʵ�������������
			//��һ���Ƿ����ӳɹ����ж�
			if(connection.getResponseCode() / 100 != 2) {
				System.out.println("���ӷ�����Ϣ����200��Χ�ڣ����Ӵ��������ԣ�");
				return;
			}
			filesize = connection.getContentLength();//������������ļ��ĳ���
			binput = new BufferedInputStream(connection.getInputStream(), Max_Buff_Size);
			fileName = url.getFile();//������ص��ļ���
			System.out.println(fileName);
			RandomAccessFile file = new RandomAccessFile("E:/eclipse-workspace/JavaBase/src/RandomAccessFileDemo" + fileName, "rw");
			file.setLength(0);
			file.seek(0);
			while(downloaded < filesize) {
				byte[] buffer = null;
				//�Д�ʣ�N���ֹ����ͻ���Ĵ�С���Ա��½��ֽ�����ĳ���ȷ��
				if((filesize - downloaded) < Max_Buff_Size) {
					buffer = new byte[Max_Buff_Size];
				}else {
					buffer = new byte[filesize - downloaded];
				}
				int read = binput.read(buffer);//��ȡ���������
				if(read == -1) break;//��������-1��֤���������
				file.seek(downloaded);
				file.write(buffer, 0 , read);
				downloaded +=read;
				System.out.println("��ǰ���ؽ��ȣ�" + downloaded * 1.0 / filesize * 10000 / 100 + "%");
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			connection.disconnect();//�Ͽ�����
		}
	}

}
