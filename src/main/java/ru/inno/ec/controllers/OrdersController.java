package ru.inno.ec.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inno.ec.dto.OrderForm;
import ru.inno.ec.models.Order;
import ru.inno.ec.services.BooksService;
import ru.inno.ec.services.OrdersService;
import ru.inno.ec.services.UsersService;


@Controller
@RequiredArgsConstructor
public class OrdersController {
    private final BooksService booksService;

    private final OrdersService ordersService;
    private final UsersService usersService;

    @GetMapping("/orders")
    public String getOrdersPage(Model model){
        model.addAttribute("books",booksService.getAllBooks());
        model.addAttribute("users",usersService.getAllUsers());
        model.addAttribute("orders",ordersService.getAllOrders());
        return "orders/orders_page";
    }
    @PostMapping("/orders")
    public String addOrder(OrderForm order){
        ordersService.addOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders/{orderId}/delete")
    public String deleteOrder(@PathVariable Long orderId){
        ordersService.deleteOrder(orderId);
        return "redirect:/orders";
    }
}
