package bookdemov1;

/**
 * �淶�̶���ʵ���߼�
 * @author yjlhz
 *
 * 2020��6��16��
 */
public abstract class AbstractBookView {
	public AbstractBookView(){
	
	}
	/**
	 * ʵ�̶ֹ��ĳ����߼�
	 */
	public void doMainView() {
		String choice = showMainView();
		switch (choice) {
		case "1": 
			showAddNewBookView();
			showBooks(BookDates.bookStore);
			break;
		case "2": 
			showDelBookView();
			showBooks(BookDates.bookStore);
			break;
		case "3": 
			showBooks(BookDates.bookStore);
			break;
		case "4": 
			showFindById();
			break;
		case "5": 
			showInStoreById();
			showBooks(BookDates.bookStore);
			break;
		case "6": 
			showOutStoreById();
			showBooks(BookDates.bookStore);
			break;
		case "7": 
			return;
		default:
			break;
		}
		doMainView();
	}
	/**
	 * ��ʾ���˵�
	 * @return �����û�ѡ��Ĺ�������(1-7)
	 */
	public abstract String showMainView();
	/**
	 * ����ͼ��Ľ���
	 */
	public abstract void showAddNewBookView();
	/**
	 * ɾ��ͼ���������
	 */
	public abstract void showDelBookView();
	/**
	 * ����Ų�ѯ������
	 */
	public abstract void showFindById();

	/**
	 * 解释
	 */

	public abstract void showInStoreById();
	/**
	 * ʵ�ְ���ų���
	 */
	public abstract void showOutStoreById();

	/**
	 * ��ʾ���е�ͼ����Ϣ
	 * @param bookArray
	 */
	public abstract void showBooks(Book ...bookArray);

}
