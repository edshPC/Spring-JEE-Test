package com.is.springtest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @GetMapping("/input-user")
    public String inputUser() {
        return "inputUser"; // имя представления
    }

    @GetMapping("/last-order")
    public String getLastOrder(@RequestParam String username, Model model) {
        Order lastOrder = orderService.getLastOrderByUser(username);
        model.addAttribute("lastOrder", lastOrder);
        return "lastOrder"; // имя представления
    }

    int user_id = 0;

    @GetMapping("/new")
    public String getLastOrder(@RequestParam String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) user = new User();
        user.setUsername(username);
        Category category = new Category();
        category.setName("cat" + user_id);
        Product product = new Product();
        product.setName("prod" + user_id);
        product.setCategory(category);
        product.setPrice(user_id);
        Order order = new Order();
        order.setUser(user);
        order.setDate(LocalDateTime.now());
        order.setProducts(new ArrayList<Product>());
        order.getProducts().add(product);
        orderRepository.save(order);
        return "lastOrder"; // имя представления
    }
}
