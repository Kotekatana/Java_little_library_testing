package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.OrderForm;
import ru.inno.ec.models.Book;
import ru.inno.ec.models.Order;
import ru.inno.ec.repositories.BooksRepository;
import ru.inno.ec.repositories.OrdersRepository;
import ru.inno.ec.repositories.UsersRepository;
import ru.inno.ec.services.OrdersService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    private final UsersRepository usersRepository;
    private final BooksRepository booksRepository;
    @Override
    public List<Order> getAllOrders() {
        return ordersRepository.findAllByState(Order.State.NOT_CONFIRMED);
    }

    @Override
    public void addOrder(OrderForm order) {
        Order newOrder = Order.builder()
                .book(booksRepository.findById(Long.parseLong(order.getBookId())).orElseThrow())
                .user(usersRepository.findById(Long.parseLong(order.getUserId())).orElseThrow())
                .state(Order.State.NOT_CONFIRMED)
                .build();
        ordersRepository.save(newOrder);
        Book reservedBook = booksRepository.findById(newOrder.getBook().getId()).orElseThrow();
        reservedBook.setState(Book.State.RESERVED);
        booksRepository.save(reservedBook);
    }

    @Override
    public void deleteOrder(Long id) {
        Order deletedOrder = ordersRepository.findById(id).orElseThrow();
        deletedOrder.setState(Order.State.CONFIRMED);
        ordersRepository.save(deletedOrder);
        Book freeBook = booksRepository.findById(deletedOrder.getBook().getId()).orElseThrow();
        freeBook.setState(Book.State.FREE);
        booksRepository.save(freeBook);
    }
}
