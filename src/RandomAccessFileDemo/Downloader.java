package RandomAccessFileDemo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
	private static final String StrUrl = "http://zhiyinqiniu.tangdou.com/hello.mp4";//要下载的视频文件
	private static final int Max_Buff_Size = 10240;//设置默认缓存
	public static void main(String[] args) {
		HttpURLConnection connection = null;
		int filesize = Integer.MIN_VALUE;
		BufferedInputStream binput = null;
		int downloaded = 0;//用来记录已下载的长度
		String fileName = null;
		try {
			URL url = new URL(StrUrl);//创建url对象
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Range", "bytes=0-");//设置连接属性，Range表示字节范围，0-表示从0到读取文件的长度
			connection.connect();//实现与服务器连接
			//做一个是否连接成功的判断
			if(connection.getResponseCode() / 100 != 2) {
				System.out.println("连接返回信息不在200范围内，连接错误，请重试！");
				return;
			}
			filesize = connection.getContentLength();//获得所需下载文件的长度
			binput = new BufferedInputStream(connection.getInputStream(), Max_Buff_Size);
			fileName = url.getFile();//获得下载的文件名
			System.out.println(fileName);
			RandomAccessFile file = new RandomAccessFile("E:/eclipse-workspace/JavaBase/src/RandomAccessFileDemo" + fileName, "rw");
			file.setLength(0);
			file.seek(0);
			while(downloaded < filesize) {
				byte[] buffer = null;
				//判斷剩餘的字節數和缓存的大小，以便新建字节数组的长度确认
				if((filesize - downloaded) < Max_Buff_Size) {
					buffer = new byte[Max_Buff_Size];
				}else {
					buffer = new byte[filesize - downloaded];
				}
				int read = binput.read(buffer);//读取缓存的内容
				if(read == -1) break;//如果恒等于-1就证明下载完毕
				file.seek(downloaded);
				file.write(buffer, 0 , read);
				downloaded +=read;
				System.out.println("当前下载进度：" + downloaded * 1.0 / filesize * 10000 / 100 + "%");
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			connection.disconnect();//断开连接
		}
	}

}
