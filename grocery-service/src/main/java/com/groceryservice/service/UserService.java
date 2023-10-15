package com.groceryservice.service;

import com.groceryservice.model.GroceryItem;
import com.groceryservice.model.Order;
import com.groceryservice.model.User;

import java.util.List;

/**
 * @author vipul.singh
 */
public interface UserService {
    List<GroceryItem> getAvailableGroceryItems();

    User registerUser(User user);


    Order createOrder(String customerName, String transactionId, List<Long> groceryItemIds);
}
