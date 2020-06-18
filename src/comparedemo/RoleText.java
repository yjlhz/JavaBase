package comparedemo;

public class RoleText {

	public static void main(String[] args) {
		RoleBiz rolebiz = new RoleBiz();
		rolebiz.add(new Role("role1", 12, 456));
		rolebiz.add(new Role("role2", 45, 221));
		rolebiz.add(new Role("role3", 66, 974));
		rolebiz.show();
		//Role role2 = new Role("role2", 45, 221);
		//rolebiz.delete(role2);
		//rolebiz.show();
		rolebiz.sort();
		rolebiz.show();

	}

}
