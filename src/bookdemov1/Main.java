package bookdemov1;

public class Main {

	public static void main(String[] args) {
		//new BookView();
		//new BookViewConsoleIplm();
		AbstractBookView bookView = new BookViewConsoleIplm();	//ʹ�öԻ���ʵ�ֵ�ͼ�����ϵͳ����

		bookView.doMainView();
		FileUtil.saveBooks(BookDates.bookStore);
	}

}