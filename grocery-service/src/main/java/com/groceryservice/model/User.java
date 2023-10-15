package com.groceryservice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author vipul.singh
 */
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean isAdmin;
}
