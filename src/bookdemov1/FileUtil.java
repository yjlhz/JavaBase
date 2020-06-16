package bookdemov1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 读写文件
 * @author Lenovo
 *
 */
public class FileUtil {
	/** 用来进行读写操作的图书信息文件路径 */
	private static final String BookFile = "E:/eclipse-workspace/JavaBase/src/bookdemov1/BookInfo.txt";
	/** 用来分割属性的分隔符，默认是英文逗号 */
	private static final String SepAttr = ",";
	/** 默认的行的分隔符 */
	private static final String SepLine = System.getProperty("line.separator");
	
	/**
	 * 将库存中的书籍写入文件中
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
			int bookCount = bookBiz.getBookCount(bookArray);//获得传入图书数组中的图书对象个数（不为null的）
			for(int i = 0; i < bookCount; i++){//这里暂时实现的是简单的属性拼接
				content.append(bookArray[i].getBookId());	content.append(SepAttr);
				content.append(bookArray[i].getBookName());	content.append(SepAttr);
				content.append(bookArray[i].getCount());	content.append(SepLine);//一行结束，就拼接行的分隔符
			}
			//将字符串写入到文件
			out.write(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 从文件中读取内容，将内容逐行拆解，重新整合成对象、对象数组并返回
	 * @return
	 */
	public static Book[] LoadBooks(){
		File bookFile = new File(BookFile);
		if(!bookFile.exists()){
			return null;
		}
		Book[] bookArray = new Book[999];//注意：读取的时候，最多只能读取999个图书对象
		try(FileReader fReader = new FileReader(bookFile);
			BufferedReader reader = new BufferedReader(fReader);
		){
			String line = null;
			int count = 0;
			while((line = reader.readLine()) != null){//读取文件的套路
				Book currBook = new Book();
				String[] attrs = line.split(SepAttr);//将读取出的一行以属性分隔符进行分隔，返回分隔后的字符串数组
				currBook.setBookId(attrs[0].trim());
				currBook.setBookName(attrs[1].trim());
				currBook.setCount(Integer.parseInt(attrs[2].trim()));
				//将构建成功的图书对象添加到图书数组中，以便返回
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
