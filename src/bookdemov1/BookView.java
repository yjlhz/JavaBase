package bookdemov1;

import java.util.Scanner;

/**
 * ͼ�����ϵͳ����ͼ��
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
		System.out.println("��ӭʹ��ɵxͼ�����ϵͳ:");
		System.out.println("1����¼ϵͳ\t\t2���˳�ϵͳ");
		System.out.println("*********************************************");
		int choice = input.nextInt();
		if(choice == 1) {
			//��¼�ɹ���ʾ���˵�
			showMainView();
		}
		System.out.println("�ɹ��˳�����ӭ�´�ʹ��!");
	}
	/**
	 * ��ʾ���˵�
	 */
	public void showMainView() {
		System.out.println("\nX9ͼ�����ϵͳ >> ���˵�");
		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������Ų�ѯ\t5�����\t6������\t7���˳�");
		System.out.print("��ѡ��");
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
	 * ����ͼ��Ľ���
	 */
	public Book showAddNewBookView() {
		System.out.println("\nɵx����ϵͳ >> ����ͼ��");
		System.out.println("������ͼ����:");
		String bookId = input.next();
		Book newBook = bookBiz.findById(bookId);
		//�ж�һ��ͼ���Ƿ��Ѵ���
		if(newBook == null) {
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.println("�������������:");
			newBook.setBookName(input.next());
			System.out.println("����������ͼ��Ŀ��:");
			newBook.setCount(input.nextInt());
			bookBiz.addBook(newBook);//����ͼ�鵽�����
		}else {
			//���ͼ���Ѵ��� - ��ʾ�û���Ȼ��ݹ���ñ�����
			System.out.println("ͼ���Ѵ��ڣ�����������!");
			newBook = showAddNewBookView();
		}
		return newBook;
	}
	/**
	 * ��ʾ���е�ͼ����Ϣ
	 * @param bookArray
	 */
	public void showBooks(Book ...bookArray) {
		System.out.println("ͼ����\tͼ������\t\tͼ����");
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
