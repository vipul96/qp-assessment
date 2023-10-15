package com.groceryservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vipul.singh
 */

@Entity
@Data
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @JsonProperty("customer_name")
//    private String customerName;
//
//    @JsonProperty("transaction_id")
//    private String transactionId;

    @ManyToMany
    @JoinTable(
            name = "order_grocery_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_item_id")
    )
    private List<GroceryItem> items = new ArrayList<>();
}
