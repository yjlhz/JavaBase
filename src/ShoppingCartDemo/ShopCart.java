package ShoppingCartDemo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车类
 */
public class ShopCart {
    //用于存放商品信息
    Map<Products, Integer> productMap;
    BigDecimal totalPrice = BigDecimal.valueOf(0.0);//总价
    public ShopCart(){
        productMap = new HashMap<>();
    }

    /**
     * 添加商品
     * @param product 添加的商品
     * @param num 添加的商品数量
     */
    public void add(Products product, int num){
        //判断原商品是否存在
        if(!productMap.containsKey(product)){
            productMap.put(product, num);//若不存在，则向map中添加用户选择的商品和数量
        }else {
            //若存在，则取出原有数量和用户输入的数量相加
            int count = productMap.get(product);
            num = count + num;
            productMap.put(product, num);

        }
        //计算添加后的总价
        totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(num)));

    }

    /**
     * 删除商品
     * @param product 删除的商品
     * @param num 删除的商品数量
     */
    public void delete(Products product, int num){
        //判断输入的数量是否大于购物车的数量，若大于则去除商品
        if (num >= productMap.get(product)){
            productMap.remove(product);
            //总价减去删除商品的总价格
            totalPrice = totalPrice.subtract(product.getPrice().multiply(BigDecimal.valueOf(productMap.get(product))));
        }else {
            //若删除的数量小于购物车的数量，先获取购物车的商品数量，再减去用户输入的数量
            int count = productMap.get(product);
            int afterNum = count - num;
            productMap.put(product, afterNum);

            //总价减去用户输入的商品总价
            totalPrice = totalPrice.subtract(product.getPrice().multiply(BigDecimal.valueOf(num)));
        }

    }

    /**
     * 清空购物车方法
     */
    public void clear(){
        productMap.clear();
        totalPrice = BigDecimal.valueOf(0.0);
    }

    /**
     * 显示所有商品
     */
    public void show(){
        System.out.println("商品清单:");
        for (Products products : productMap.keySet()){
            Products p = products;
            int i = productMap.get(products);
            System.out.println(i + "个  " + p + products.getPrice().multiply(BigDecimal.valueOf(i)));
        }
        System.out.println("总价：" + totalPrice);
    }

}
