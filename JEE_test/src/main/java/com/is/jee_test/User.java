package com.is.jee_test;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "test_users")
public class User {
    @Id
    private String username;
    private String password;

}