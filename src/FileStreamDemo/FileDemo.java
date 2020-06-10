package FileStreamDemo;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;

public class FileDemo {

	public static void main(String[] args) {
		JFileChooser filechooser = new JFileChooser(new File("."));//����Ŀ¼����Ϊ��ǰѡ���ļ���
		filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//�趨����ѡ���ģʽ
		filechooser.showOpenDialog(null);//���ļ�ѡ����棬null��ʾ�޸�����
		File file = filechooser.getSelectedFile();
		if(file == null) {
			//����û�û��ѡ���ļ�����ǿ���˳�
			System.out.println("�û�δѡ���ļ���ϵͳ�˳���");
			System.exit(0);
		}
		
		System.out.println("�û�ѡ����ļ�����" + file.getName());
		System.out.println("�û�ѡ����ļ�·����" + file.getPath());
		if(file.isDirectory()) {
			//����û�ѡ�����һ���ļ��У����ӡ�ļ����������ļ���
			System.out.println(file.getAbsolutePath() + "·���������ļ�Ϊ:");
			String[] filenames = file.list(new DirFilter());
			for (int i = 0; i < filenames.length; i++) {
				System.out.println(filenames[i]);
			}
		}
	}
	/**
	 * ʵ���ļ�����
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
