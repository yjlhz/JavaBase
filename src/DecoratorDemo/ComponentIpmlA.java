package DecoratorDemo;
/**
 * 装饰器的一个子类方法
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
		System.out.println("扩展方法A");
	}
	
	private void extendsReadB() {
		System.out.println("扩展方法B");
	}
	
}
