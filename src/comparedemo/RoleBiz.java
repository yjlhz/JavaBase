package comparedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 业务逻辑层
 * @author yjlhz
 *
 * 2020年6月19日
 */

public class RoleBiz {
	List<Role> Rolelist = null;
	
	public RoleBiz() {
		Rolelist = new ArrayList<Role>();
	}
	
	/**
	 * 增加对象的方法
	 * @param role
	 */
	public void add(Role role) {
		if(role != null) {
			Rolelist.add(role);
		}
	}
	/**
	 * 删除对象的方法
	 * @param role
	 */
	public void delete(Role role) {
		int Index = Rolelist.indexOf(role);
		if(Index != -1) {
			Rolelist.remove(Index);
		}
	}
	/**
	 * 修改集合中元素的方法
	 * @param role
	 */
	public void update(Role role) {
		int Index = Rolelist.indexOf(role);
		if(Index != -1) {
			Rolelist.set(Index, role);
		}
	}
	/**
	 * 对集合排序
	 */
	public void sort() {
		Collections.sort(Rolelist);
		Collections.sort(Rolelist, new compared_Attack());
	}
	
	/**
	 * 打印集合的元素（使用了迭代器）
	 */
	public void show() {
		System.out.println("名称\t等级\t攻击力\t");
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
















