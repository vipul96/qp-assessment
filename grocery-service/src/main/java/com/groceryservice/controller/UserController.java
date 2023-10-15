package com.groceryservice.controller;

import com.groceryservice.model.GroceryItem;
import com.groceryservice.model.Order;
import com.groceryservice.model.User;
import com.groceryservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vipul.singh
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/grocery-items")
    public List<GroceryItem> getAvailableGroceryItems() {
        return userService.getAvailableGroceryItems();
    }

    @PostMapping("/create-order")
    public Order createOrder(@RequestBody List<Long> itemIds, @RequestParam(name = "customer_name") String customerName,
                             @RequestParam(name = "txn_id") String txnId) {
        return userService.createOrder(customerName, txnId, itemIds);
    }


    // User registration
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
