package bookdemov1;
/**
 * 图书管理系统的业务逻辑层
 * @author Lenovo
 *
 */
public class BookBiz {
	/**
	 * 获得图书对象的个数
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
