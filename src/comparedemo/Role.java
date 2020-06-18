package comparedemo;

public class Role implements Comparable<Role>{
	private String name;
	private int level;
	private int attack;
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Role)) {
			return false;
		}
		Role role = (Role)obj;
		return name.equals(role.getName());
	}
	
	public Role(String name, int level, int attack) {
		super();
		this.name = name;
		this.level = level;
		this.attack = attack;
	}



	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public int compareTo(Role role) {
		if(level > role.getLevel()) return 1;
		if(level < role.getLevel()) return -1;
		return 0;
	}

	
}
