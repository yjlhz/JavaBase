package DecoratorDemo;
/**
 * װ�����࣬ʵ����չ�ķ���
 * @author Lenovo
 *
 */
public class Decorator extends Component{
	private Component component;
	/**
	 * ���췽��
	 * @param component
	 */
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void read() {
		component.read();
	}
}
