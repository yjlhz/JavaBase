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
	/**
	 * 获得图书对象的重载方法
	 * @param Array 一个Book类型的数组
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
	 * 增加图书的方法
	 * @param book
	 * @return 返回一个是否成功入库的信息
	 */
	public boolean addBook(Book book) {
		int count = getBookCount();
		if(BookDates.bookStore.length == count) {
			return false;
		}
		//将新增的图书放入图书数组的第一个null元素中
		BookDates.bookStore[count] = book;
		return true;
	}
	/**
	 * 删除图书的方法
	 * @param book
	 * @return 返回一个是否删除成功的逻辑值
	 */
	public boolean delBook(Book book) {
		//实现查找要删除的图书
		int delIndex = -1;
		int bookCount = getBookCount();
		for (int i = 0; i < bookCount; i++) {
			if(book.equals(BookDates.bookStore[i])){
				delIndex = i;
				break;
			}
		}
		//如果没有找到图书，则返回false
		if(delIndex == -1) {
			return false;
		}
		//实现删除用户输入的图书
		for(int i = delIndex; i < bookCount - 1; i++) {
			//用后一个元素覆盖前一个元素实现删除
			BookDates.bookStore[i] = BookDates.bookStore[i + 1];
		}
		BookDates.bookStore[bookCount - 1] = null;//将最后一个元素置空
		return true;
		
	}
	/**
	 * 实现用Id查找图书
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
	 * 实现图书的入库方法
	 * @param bookId 要入库的图书Id
	 * @param count 入库的图书数量
	 * @return
	 */
	public boolean inStore(String bookId, int count) {
		Book book = findById(bookId);//寻找这本书
		if(book == null) {//若为空则证明没找到，返回false
			return false;
		}
		//若找到了就获取这本书的库存数量然后加上用户输入的入库数量
		book.setCount(book.getCount() + count);
		return true;
	}
	/**
	 * 实现图书的出库方法
	 * @param bookId 需要出库的图书Id
	 * @param count 需要出库的数量
	 * @return
	 */
	public boolean outStore(String bookId, int count) {
		Book book = findById(bookId);//寻找这本书
		if(book == null) {//若库存中没有这本书，就返回false
			return false;
		}
		//若出库量大于库存量，出库失败，返回false
		if(count > book.getCount()) {
			return false;
		}
	    //出库操作
		book.setCount(book.getCount() - count);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
