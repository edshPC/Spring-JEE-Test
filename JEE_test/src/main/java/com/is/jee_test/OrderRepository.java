package com.is.jee_test;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BasicRepository<Order, Long> {
    @Find
    List<Order> findTopByUserOrderByDateDesc(User user);
}
