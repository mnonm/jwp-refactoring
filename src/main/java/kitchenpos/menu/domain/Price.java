package kitchenpos.menu.domain;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Price {

    private BigDecimal price;

    protected Price() {
    }

    public Price(BigDecimal price) {
        validation(price);
        if (Objects.isNull(price)) {
            this.price = BigDecimal.ZERO;
        }
        this.price = price;
    }

    private void validation(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("금액이 잘못되었습니다");
        }
    }

    public boolean lt(BigDecimal price) {
        return Objects.isNull(price) || this.price.compareTo(price) < 0;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}