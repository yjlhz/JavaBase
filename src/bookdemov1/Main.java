package bookdemov1;

public class Main {

	public static void main(String[] args) {
		//new BookView();
		//new BookViewConsoleIplm();
		AbstractBookView bookView = new BookViewConsoleIplm();	//使用对话框实现的图书管理系统界面

		bookView.doMainView();
		FileUtil.saveBooks(BookDates.bookStore);
	}

}
