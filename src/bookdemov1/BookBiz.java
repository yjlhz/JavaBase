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
}
