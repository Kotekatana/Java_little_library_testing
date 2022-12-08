package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Order;
import ru.inno.ec.models.User;
import ru.inno.ec.repositories.OrdersRepository;
import ru.inno.ec.repositories.UsersRepository;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.ProfileService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final UsersRepository usersRepository;
    private final OrdersRepository ordersRepository;

    @Override
    public User getCurrentUser(CustomUserDetails userDetails) {
        return usersRepository.findById(userDetails.getUser().getId()).orElseThrow();
    }

    @Override
    public List<Order> getCurrentOrders(CustomUserDetails userDetails) {
        return ordersRepository.findAllByUserId(userDetails.getUser().getId());
    }
}
