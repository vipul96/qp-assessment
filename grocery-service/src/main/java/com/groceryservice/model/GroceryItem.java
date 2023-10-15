package com.groceryservice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author vipul.singh
 */

@Data
@Entity
@Table(name = "grocery_items")
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int inventory;
}
