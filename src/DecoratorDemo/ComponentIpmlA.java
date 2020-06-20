package DecoratorDemo;
/**
 * ????????????????
 * @author Lenovo
 *
 */
public class ComponentIpmlA extends Decorator{

	public ComponentIpmlA(Component component) {
		super(component);
	}
	
	@Override
	public void read() {
		this.extendsReadA();
		super.read();
		this.extendsReadB();
	}
	
	private void extendsReadA() {
		System.out.println("???????A");
	}
	
	private void extendsReadB() {
		System.out.println("???????B");
	}
	
}
