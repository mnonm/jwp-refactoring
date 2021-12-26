package kitchenpos.domain;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import kitchenpos.menu.domain.Quantity;
import kitchenpos.product.domain.Product;

@Embeddable
public class Price {
    @Column(name = "price")
    private BigDecimal price;

    protected Price() {
    }

    private Price(BigDecimal price) {
        this.price = price;
    }

    public static Price of(Integer value) {
        validate(value);
        return new Price(BigDecimal.valueOf(value));
    }

    public static Price of(BigDecimal value) {
        return new Price(value);
    }

    public static Price zero() {
        return new Price(BigDecimal.ZERO);
    }

    public static void validate(Integer price) {
        if (price == null || price < 0) {
            throw new IllegalArgumentException("가격이 없거나 0보다 작습니다");
        }
    }

    public static Price multiply(Product product, Quantity quantity) {
        return Price.of(product.getPriceValue().multiply(BigDecimal.valueOf(quantity.getValue())));
    }

    public BigDecimal getValue() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Price{" +
            "price=" + price +
            '}';
    }

    public boolean isGreaterThan(Price other) {
        return this.price.compareTo(other.price) > 0;
    }

    public Price add(Price other) {
        return Price.of(this.price.add(other.price));
    }
}
