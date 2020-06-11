package DecoratorDemo;
/**
 * װ������һ�����෽��
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
		System.out.println("��չ����A");
	}
	
	private void extendsReadB() {
		System.out.println("��չ����B");
	}
	
}
