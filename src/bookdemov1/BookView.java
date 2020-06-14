package bookdemov1;

import java.util.Scanner;

/**
 * 图书管理系统的视图层
 * @author Lenovo
 *
 */
public class BookView {
	private Scanner input = null;
	private BookBiz bookBiz = null;
	public BookView(){
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		System.out.println("*********************************************");
		System.out.println("欢迎使用傻x图书管理系统:");
		System.out.println("1、登录系统\t\t2、退出系统");
		System.out.println("*********************************************");
		int choice = input.nextInt();
		if(choice == 1) {
			//登录成功显示主菜单
			showMainView();
		}
		System.out.println("成功退出，欢迎下次使用!");
	}
	/**
	 * 显示主菜单
	 */
	public void showMainView() {
		System.out.println("\nX9图书管理系统 >> 主菜单");
		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询\t5、入库\t6、出库\t7、退出");
		System.out.print("请选择：");
		int choice = input.nextInt();
		switch (choice) {
		case 1: 
			showAddNewBookView();
			showBooks(BookDates.bookStore);
			break;
		case 2: 
			break;
		case 3: 
			break;
		case 4: 
			break;
		case 5: 
			break;
		case 6: 
			break;
		case 7: 
			break;
		default:
			break;
		}
	}
	/**
	 * 新增图书的界面
	 */
	public Book showAddNewBookView() {
		System.out.println("\n傻x管理系统 >> 增加图书");
		System.out.println("请输入图书编号:");
		String bookId = input.next();
		Book newBook = bookBiz.findById(bookId);
		//判断一下图书是否已存在
		if(newBook == null) {
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.println("请输入书的名称:");
			newBook.setBookName(input.next());
			System.out.println("请输入新增图书的库存:");
			newBook.setCount(input.nextInt());
			bookBiz.addBook(newBook);//新增图书到库存里
		}else {
			//如果图书已存在 - 提示用户，然后递归调用本方法
			System.out.println("图书已存在，请重新输入!");
			newBook = showAddNewBookView();
		}
		return newBook;
	}
	/**
	 * 显示所有的图书信息
	 * @param bookArray
	 */
	public void showBooks(Book ...bookArray) {
		System.out.println("图书编号\t图书名称\t\t图书库存");
		if(bookArray == null) {
			bookArray = BookDates.bookStore;
		}
		int bookCount = bookBiz.getBookCount(bookArray);
		for (int i = 0; i < bookCount; i++) {
			System.out.printf("%s\t%s\t\t%d\n",
					bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
