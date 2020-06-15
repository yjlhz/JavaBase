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
		System.out.println("\nɵxͼ�����ϵͳ >> ���˵�");
		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������Ų�ѯ\t5�����\t6������\t7���˳�");
		System.out.print("��ѡ��");
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
	 * ����ͼ��Ľ���
	 */
	public void showAddNewBookView() {
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
			showAddNewBookView();
		}
	}
	/**
	 * ɾ��ͼ���������
	 */
	public void showDelBookView() {
		System.out.println("\nɵx����ϵͳ >> ɾ��ͼ��");
		System.out.println("������Ҫɾ����ͼ����:");
		String bookId = input.next();
		Book delbook = bookBiz.findById(bookId);
		if(!(delbook == null)) {
			bookBiz.delBook(delbook);
		}else {
			System.out.println("�����û�д�ͼ��,���������룡");
			showDelBookView();
		}
		
	}
	/**
	 * ����Ų�ѯ������
	 */
	public void showFindById() {
		System.out.println("������Ҫ���ҵ�ͼ����:");
		String bookId = input.next();
		Book Findbook = bookBiz.findById(bookId);
		if(Findbook == null) {
			System.out.println("�������ҵ�ͼ�鲻����,����������!");
			showFindById();
		}else {
			showBooks(Findbook);
		}
	}
	/**
	 * ��ͼ��ı�����
	 */
	public void showInStoreById() {
		System.out.println("������Ҫ����ͼ����:");
		String bookId = input.next();
		System.out.println("������Ҫ����ͼ������:");
		int count = input.nextInt();
		if(bookBiz.inStore(bookId, count)) {
			System.out.println("���ɹ���");
		}else {
			System.out.println("���ʧ��,���������룡");
			showInStoreById();
		}
	}
	/**
	 * ʵ�ְ���ų���
	 */
	public void showOutStoreById() {
		System.out.println("������Ҫ�����ͼ����:");
		String bookId = input.next();
		System.out.println("������Ҫ�����ͼ������:");
		int count = input.nextInt();
		if(bookBiz.outStore(bookId, count)) {
			System.out.println("����ɹ���");
		}else {
			System.out.println("����ʧ��,���������룡");
			showInStoreById();
		}
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
