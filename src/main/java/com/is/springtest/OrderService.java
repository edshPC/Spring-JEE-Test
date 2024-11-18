package com.is.springtest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public Order getLastOrderByUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return orderRepository.findTopByUserOrderByDateDesc(user);
        }
        return null;
    }

}
