package com.groceryservice.service;

import com.groceryservice.model.GroceryItem;
import com.groceryservice.model.User;

import java.util.List;

/**
 * @author vipul.singh
 */
public interface AdminService {
    GroceryItem addItem(GroceryItem item);

    List<GroceryItem> getAllGroceryItems();

    void removeItem(Long itemId);

    GroceryItem updateItem(Long itemId, GroceryItem newItem);

    GroceryItem manageInventory(Long itemId, int quantity);

    User registerAdmin(User user);
}
