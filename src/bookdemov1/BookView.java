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
		System.out.println("\n傻x图书管理系统 >> 主菜单");
		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询\t5、入库\t6、出库\t7、退出");
		System.out.print("请选择：");
		int choice = input.nextInt();
		switch (choice) {
		case 1: 
			showAddNewBookView();
			showBooks(BookDates.bookStore);
			break;
		case 2: 
			showDelBookView();
			showBooks(BookDates.bookStore);
			break;
		case 3: 
			showBooks(BookDates.bookStore);
			break;
		case 4: 
			showFindById();
			break;
		case 5: 
			showInStoreById();
			showBooks(BookDates.bookStore);
			break;
		case 6: 
			showOutStoreById();
			showBooks(BookDates.bookStore);
			break;
		case 7: 
			return;
		default:
			break;
		}
		showMainView();
	}
	/**
	 * 新增图书的界面
	 */
	public void showAddNewBookView() {
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
			showAddNewBookView();
		}
	}
	/**
	 * 删除图书的主界面
	 */
	public void showDelBookView() {
		System.out.println("\n傻x管理系统 >> 删除图书");
		System.out.println("请输入要删除的图书编号:");
		String bookId = input.next();
		Book delbook = bookBiz.findById(bookId);
		if(!(delbook == null)) {
			bookBiz.delBook(delbook);
		}else {
			System.out.println("库存内没有此图书,请重新输入！");
			showDelBookView();
		}
		
	}
	/**
	 * 按编号查询主界面
	 */
	public void showFindById() {
		System.out.println("请输入要查找的图书编号:");
		String bookId = input.next();
		Book Findbook = bookBiz.findById(bookId);
		if(Findbook == null) {
			System.out.println("你所查找的图书不存在,请重新输入!");
			showFindById();
		}else {
			showBooks(Findbook);
		}
	}
	/**
	 * 按图书的编号入库
	 */
	public void showInStoreById() {
		System.out.println("请输入要入库的图书编号:");
		String bookId = input.next();
		System.out.println("请输入要入库的图书数量:");
		int count = input.nextInt();
		if(bookBiz.inStore(bookId, count)) {
			System.out.println("入库成功！");
		}else {
			System.out.println("入库失败,请重新输入！");
			showInStoreById();
		}
	}
	/**
	 * 实现按编号出库
	 */
	public void showOutStoreById() {
		System.out.println("请输入要出库的图书编号:");
		String bookId = input.next();
		System.out.println("请输入要出库的图书数量:");
		int count = input.nextInt();
		if(bookBiz.outStore(bookId, count)) {
			System.out.println("出库成功！");
		}else {
			System.out.println("出库失败,请重新输入！");
			showInStoreById();
		}
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
