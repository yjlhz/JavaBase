package bookdemov1;
/**
 * ͼ�����ϵͳ��ҵ���߼���
 * @author Lenovo
 *
 */
public class BookBiz {
	/**
	 * ���ͼ�����ĸ���
	 * @return
	 */
	public int getBookCount() {
		int count = 0;
		for(Book book : BookDates.bookStore) {
			if(book == null) {
				break;
			}
			count++;
		}
		return count;
	}
	/**
	 * ���ͼ���������ط���
	 * @param Array һ��Book���͵�����
	 * @return
	 */
	public int getBookCount(Book[] bookArray) {
		int count = 0;
		for(Book book : bookArray) {
			if(book == null) {
				break;
			}
			count++;
		}
		return count;
	}
	/**
	 * ����ͼ��ķ���
	 * @param book
	 * @return ����һ���Ƿ�ɹ�������Ϣ
	 */
	public boolean addBook(Book book) {
		int count = getBookCount();
		if(BookDates.bookStore.length == count) {
			return false;
		}
		//��������ͼ�����ͼ������ĵ�һ��nullԪ����
		BookDates.bookStore[count] = book;
		return true;
	}
	/**
	 * ɾ��ͼ��ķ���
	 * @param book
	 * @return ����һ���Ƿ�ɾ���ɹ����߼�ֵ
	 */
	public boolean delBook(Book book) {
		//ʵ�ֲ���Ҫɾ����ͼ��
		int delIndex = -1;
		int bookCount = getBookCount();
		for (int i = 0; i < bookCount; i++) {
			if(book.equals(BookDates.bookStore[i])){
				delIndex = i;
				break;
			}
		}
		//���û���ҵ�ͼ�飬�򷵻�false
		if(delIndex == -1) {
			return false;
		}
		//ʵ��ɾ���û������ͼ��
		for(int i = delIndex; i < bookCount - 1; i++) {
			//�ú�һ��Ԫ�ظ���ǰһ��Ԫ��ʵ��ɾ��
			BookDates.bookStore[i] = BookDates.bookStore[i + 1];
		}
		BookDates.bookStore[bookCount - 1] = null;//�����һ��Ԫ���ÿ�
		return true;
		
	}
	/**
	 * ʵ����Id����ͼ��
	 * @param bookId
	 * @return
	 */
	public Book findById(String bookId) {
		int bookCount = getBookCount();
		for (int i = 0; i < bookCount; i++) {
			if(bookId.equals(BookDates.bookStore[i].getBookId())) {
				return BookDates.bookStore[i];
			}
		}
		return null;
	}
	/**
	 * ʵ��ͼ�����ⷽ��
	 * @param bookId Ҫ����ͼ��Id
	 * @param count ����ͼ������
	 * @return
	 */
	public boolean inStore(String bookId, int count) {
		Book book = findById(bookId);//Ѱ���Ȿ��
		if(book == null) {//��Ϊ����֤��û�ҵ�������false
			return false;
		}
		//���ҵ��˾ͻ�ȡ�Ȿ��Ŀ������Ȼ������û�������������
		book.setCount(book.getCount() + count);
		return true;
	}
	/**
	 * ʵ��ͼ��ĳ��ⷽ��
	 * @param bookId ��Ҫ�����ͼ��Id
	 * @param count ��Ҫ���������
	 * @return
	 */
	public boolean outStore(String bookId, int count) {
		Book book = findById(bookId);//Ѱ���Ȿ��
		if(book == null) {//�������û���Ȿ�飬�ͷ���false
			return false;
		}
		//�����������ڿ����������ʧ�ܣ�����false
		if(count > book.getCount()) {
			return false;
		}
	    //�������
		book.setCount(book.getCount() - count);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
