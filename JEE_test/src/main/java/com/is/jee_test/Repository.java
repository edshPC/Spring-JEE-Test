package com.is.jee_test;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    // Метод для получения последнего заказа пользователя
    @Transactional
    public Order findLastOrder(User user) {
        TypedQuery<Order> query = entityManager.createQuery(
                "SELECT o FROM Order o WHERE o.user = :user ORDER BY o.date DESC", Order.class);
        query.setParameter("user", user);
        query.setMaxResults(1); // Получаем только последний заказ
        var list = query.getResultList();
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    public User findUser(String username) {
        return entityManager.find(User.class, username);
    }

}
