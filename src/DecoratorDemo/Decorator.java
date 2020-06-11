package DecoratorDemo;
/**
 * 装饰器类，实现扩展的方法
 * @author Lenovo
 *
 */
public class Decorator extends Component{
	private Component component;
	/**
	 * 构造方法
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
