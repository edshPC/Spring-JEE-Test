package com.is.jee_test;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "test_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}

