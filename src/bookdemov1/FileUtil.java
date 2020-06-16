package bookdemov1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ��д�ļ�
 * @author Lenovo
 *
 */
public class FileUtil {
	/** �������ж�д������ͼ����Ϣ�ļ�·�� */
	private static final String BookFile = "E:/eclipse-workspace/JavaBase/src/bookdemov1/BookInfo.txt";
	/** �����ָ����Եķָ�����Ĭ����Ӣ�Ķ��� */
	private static final String SepAttr = ",";
	/** Ĭ�ϵ��еķָ��� */
	private static final String SepLine = System.getProperty("line.separator");
	
	/**
	 * ������е��鼮д���ļ���
	 */
	public static void saveBooks(Book ...bookArray) {
		if(bookArray == null) return;
		BookBiz bookBiz = new BookBiz();
		File bookFile = new File(BookFile);
		if(!bookFile.exists()) {
			try {
				bookFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try ( FileWriter out = new FileWriter(bookFile);
			  BufferedWriter fout = new BufferedWriter(out);
				) {
			StringBuffer content = new StringBuffer();
			int bookCount = bookBiz.getBookCount(bookArray);//��ô���ͼ�������е�ͼ������������Ϊnull�ģ�
			for(int i = 0; i < bookCount; i++){//������ʱʵ�ֵ��Ǽ򵥵�����ƴ��
				content.append(bookArray[i].getBookId());	content.append(SepAttr);
				content.append(bookArray[i].getBookName());	content.append(SepAttr);
				content.append(bookArray[i].getCount());	content.append(SepLine);//һ�н�������ƴ���еķָ���
			}
			//���ַ���д�뵽�ļ�
			out.write(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ���ļ��ж�ȡ���ݣ����������в�⣬�������ϳɶ��󡢶������鲢����
	 * @return
	 */
	public static Book[] LoadBooks(){
		File bookFile = new File(BookFile);
		if(!bookFile.exists()){
			return null;
		}
		Book[] bookArray = new Book[999];//ע�⣺��ȡ��ʱ�����ֻ�ܶ�ȡ999��ͼ�����
		try(FileReader fReader = new FileReader(bookFile);
			BufferedReader reader = new BufferedReader(fReader);
		){
			String line = null;
			int count = 0;
			while((line = reader.readLine()) != null){//��ȡ�ļ�����·
				Book currBook = new Book();
				String[] attrs = line.split(SepAttr);//����ȡ����һ�������Էָ������зָ������طָ�����ַ�������
				currBook.setBookId(attrs[0].trim());
				currBook.setBookName(attrs[1].trim());
				currBook.setCount(Integer.parseInt(attrs[2].trim()));
				//�������ɹ���ͼ�������ӵ�ͼ�������У��Ա㷵��
				bookArray[count] = currBook;
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookArray;

	}
}
