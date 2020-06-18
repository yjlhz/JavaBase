package comparedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * ҵ���߼���
 * @author yjlhz
 *
 * 2020��6��19��
 */

public class RoleBiz {
	List<Role> Rolelist = null;
	
	public RoleBiz() {
		Rolelist = new ArrayList<Role>();
	}
	
	/**
	 * ���Ӷ���ķ���
	 * @param role
	 */
	public void add(Role role) {
		if(role != null) {
			Rolelist.add(role);
		}
	}
	/**
	 * ɾ������ķ���
	 * @param role
	 */
	public void delete(Role role) {
		int Index = Rolelist.indexOf(role);
		if(Index != -1) {
			Rolelist.remove(Index);
		}
	}
	/**
	 * �޸ļ�����Ԫ�صķ���
	 * @param role
	 */
	public void update(Role role) {
		int Index = Rolelist.indexOf(role);
		if(Index != -1) {
			Rolelist.set(Index, role);
		}
	}
	/**
	 * �Լ�������
	 */
	public void sort() {
		Collections.sort(Rolelist);
		Collections.sort(Rolelist, new compared_Attack());
	}
	
	/**
	 * ��ӡ���ϵ�Ԫ�أ�ʹ���˵�������
	 */
	public void show() {
		System.out.println("����\t�ȼ�\t������\t");
		System.out.println("**************************");
		Iterator<Role> roleIt= Rolelist.iterator();
		while(roleIt.hasNext()) {
			Role role = roleIt.next();
			System.out.println(role.getName() + "\t" + role.getLevel() + "\t" + role.getAttack());
		}
	}
	
	
}


class compared_Attack implements Comparator<Role>{

	@Override
	public int compare(Role role1, Role role2) {
		if(role1.getAttack() > role2.getAttack()) return 1;
		if(role1.getAttack() < role2.getAttack()) return -1;
		return 0;
	}
	
}
















