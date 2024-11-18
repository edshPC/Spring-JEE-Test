package com.is.jee_test;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BasicRepository<Order, Long> {
    @Find
    @OrderBy(value = "date", descending = true)
    List<Order> findTopByUser(User user);
}
