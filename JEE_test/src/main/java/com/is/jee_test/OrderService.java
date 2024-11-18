package com.is.jee_test;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService {

    @Inject
    private UserRepository userRepository;
    @Inject
    private OrderRepository orderRepository;

    public Order getLastOrderByUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) return null;
        List<Order> orders = orderRepository.findTopByUserOrderByDateDesc(user.get());
        if (orders.isEmpty()) return null;
        return orders.get(0);
    }

}
