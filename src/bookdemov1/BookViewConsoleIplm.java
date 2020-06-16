package bookdemov1;

import javax.swing.JOptionPane;

/**
 * 图书管理系统的控制台实现
 * @author Lenovo
 *
 */
public class BookViewConsoleIplm extends AbstractBookView {
	private BookBiz bookBiz = null;
	
	public BookViewConsoleIplm(){
		bookBiz = new BookBiz();
	}

	@Override
	public String showMainView() {		
		String strMenu = "\nX9图书管理系统 >> 主菜单\n";
		strMenu += "1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询\t5、入库\t6、出库\t7、退出\n";
		strMenu += "请选择：";
		String result = JOptionPane.showInputDialog(strMenu);//显示输入对话框
		if(result == null) result = "7";//用户点击了取消按钮
		return result;
	}

	@Override
	public void showAddNewBookView() {
		Book newBook = new Book();
		String bookId = null;
		String bookName = null;
		int count = -1;
		//注意：这里的三个变量输入时需要验证用户输入数据的合法性
		bookId = JOptionPane.showInputDialog("请输入图书编号：");
		bookName = JOptionPane.showInputDialog("图书名称：");
		count = Integer.parseInt(JOptionPane.showInputDialog("库存量："));
		newBook.setBookId(bookId);
		newBook.setBookName(bookName);
		newBook.setCount(count);
		if(bookBiz.addBook(newBook)){
			JOptionPane.showMessageDialog(null, "添加成功！");
		}else{
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
	}

	@Override
	public void showDelBookView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showFindById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showInStoreById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOutStoreById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showBooks(Book... bookArray) {
		// TODO Auto-generated method stub
		
	}
	
}
