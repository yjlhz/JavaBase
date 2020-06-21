package ShoppingCartDemo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 商品类
 */
public class Products {
    //商品编号
    private long id;
    //商品的名称
    private String name;
    //商品的价格
    private BigDecimal price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Products{id=%d, name='%s', price=%s}", id, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id &&
                Objects.equals(name, products.name) &&
                Objects.equals(price, products.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    public Products(long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
