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
    private Repository repository;

    private String username;
    private User user;
    private Order order;

    public void getLastOrder() {
        user = repository.findUser(username);
        order = repository.findLastOrder(user);
    }

}
