package DecoratorDemo;

public class DecoratorTest {

	public static void main(String[] args) {
		Component component = new TrueComponent();
		
		ComponentIpmlA componentA = new ComponentIpmlA(component);
		
		componentA.read();
	}

}
