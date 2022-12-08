package ru.inno.ec.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Order;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByState(Order.State state);
    List<Order> findAllByUserId(Long id);
}
