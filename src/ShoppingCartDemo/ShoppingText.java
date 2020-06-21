package ShoppingCartDemo;

import java.math.BigDecimal;

/**
 * 购物车测试
 */
public class ShoppingText {
    public static void main(String[] args){
        Products apple = new Products(1001,"apple", BigDecimal.valueOf(22));
        Products banana = new Products(1002,"banana", BigDecimal.valueOf(33));
        ShopCart shopCart = new ShopCart();
        shopCart.add(apple,50);
        shopCart.add(banana,10);
        shopCart.delete(apple,4);
        shopCart.clear();
        shopCart.show();
    }
}
