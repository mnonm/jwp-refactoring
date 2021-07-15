package kitchenpos.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByIdIn(List<Long> id);

    List<Product> findAllByIdIn(List<Long> productIds);
}
