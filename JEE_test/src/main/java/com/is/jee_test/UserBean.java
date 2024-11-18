package com.is.jee_test;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

@Named
@RequestScoped
@Data
public class UserBean {

    @Inject
    private OrderService orderService;

    private String username;
    private Order order;

    public void getLastOrder() {
        order = orderService.getLastOrderByUser(username);
    }

}
