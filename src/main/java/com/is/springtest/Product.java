package com.is.springtest;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "test_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

}