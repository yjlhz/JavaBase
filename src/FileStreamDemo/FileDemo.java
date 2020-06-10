package FileStreamDemo;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;

public class FileDemo {

	public static void main(String[] args) {
		JFileChooser filechooser = new JFileChooser(new File("."));//将根目录设置为当前选择文件夹
		filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//设定可以选择的模式
		filechooser.showOpenDialog(null);//打开文件选择界面，null表示无父窗体
		File file = filechooser.getSelectedFile();
		if(file == null) {
			//如果用户没有选择文件，则强制退出
			System.out.println("用户未选择文件，系统退出！");
			System.exit(0);
		}
		
		System.out.println("用户选择的文件名：" + file.getName());
		System.out.println("用户选择的文件路径：" + file.getPath());
		if(file.isDirectory()) {
			//如果用户选择的是一个文件夹，则打印文件夹下所有文件名
			System.out.println(file.getAbsolutePath() + "路径下所有文件为:");
			String[] filenames = file.list(new DirFilter());
			for (int i = 0; i < filenames.length; i++) {
				System.out.println(filenames[i]);
			}
		}
	}
	/**
	 * 实现文件过滤
	 * @author Lenovo
	 *
	 */
	static class DirFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			if(name.endsWith("git")) {
				return true;
			}
			return false;
		}
		
	}

}
