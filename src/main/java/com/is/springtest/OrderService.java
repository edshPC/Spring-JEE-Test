package com.is.springtest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public Order getLastOrderByUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            List<Order> orders = orderRepository.findTopByUserOrderByDateDesc(user);
            return orders.isEmpty() ? null : orders.get(0);
        }
        return null;
    }

}
