package com.is.jee_test;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BasicRepository<User, String> {
    @Find
    Optional<User> findByUsername(String username);
}
