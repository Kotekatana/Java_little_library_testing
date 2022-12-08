package ru.inno.ec.services;
import ru.inno.ec.dto.OrderForm;
import ru.inno.ec.models.Order;

import java.util.List;

public interface OrdersService {
    List<Order> getAllOrders();
    void addOrder(OrderForm order);
    void deleteOrder(Long id);
}
