package bookdemov1;
/**
 * 图书管理系统的模型层
 * @author Lenovo
 *
 */
public class Book {
	private String bookId;		//图书的编号
	private String bookName;	//图书的名字
	private String isbn;		//图书版本号
	private String author;		//图书的作者
	private String type;		//图书的类型
	private String publisher;	//图书的出版社
	private double price;		//图书的价格
	private int count;			//图书的库存数量
	
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
