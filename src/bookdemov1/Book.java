package bookdemov1;
/**
 * ͼ�����ϵͳ��ģ�Ͳ�
 * @author Lenovo
 *
 */
public class Book {
	private String bookId;		//ͼ��ı��
	private String bookName;	//ͼ�������
	private String isbn;		//ͼ��汾��
	private String author;		//ͼ�������
	private String type;		//ͼ�������
	private String publisher;	//ͼ��ĳ�����
	private double price;		//ͼ��ļ۸�
	private int count;			//ͼ��Ŀ������
	
	public Book() {
		
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
