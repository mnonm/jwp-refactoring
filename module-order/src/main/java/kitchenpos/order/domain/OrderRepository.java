package kitchenpos.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

  boolean existsByOrderTableIdAndOrderStatusIn(Long orderTableId, Iterable<OrderStatus> orderStatuses);
  boolean existsByOrderTableIdInAndOrderStatusIn(Iterable<Long> orderTableIds, Iterable<OrderStatus> orderStatuses);
}