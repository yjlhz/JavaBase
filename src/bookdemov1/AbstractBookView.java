package bookdemov1;

/**
 * 规范固定的实现逻辑
 * @author Lenovo
 *
 */
public abstract class AbstractBookView {
	public AbstractBookView(){
	
	}
	/**
	 * 实现固定的程序逻辑
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
	 * 显示主菜单
	 * @return 返回用户选择的功能需求(1-7)
	 */
	public abstract String showMainView();
	/**
	 * 新增图书的界面
	 */
	public abstract void showAddNewBookView();
	/**
	 * 删除图书的主界面
	 */
	public abstract void showDelBookView();
	/**
	 * 按编号查询主界面
	 */
	public abstract void showFindById();
	/**
	 * 按图书的编号入库
	 */
	public abstract void showInStoreById();
	/**
	 * 实现按编号出库
	 */
	public abstract void showOutStoreById();

	/**
	 * 显示所有的图书信息
	 * @param bookArray
	 */
	public abstract void showBooks(Book ...bookArray);

}
