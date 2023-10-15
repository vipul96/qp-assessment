package com.groceryservice.service.impl;

import com.groceryservice.model.GroceryItem;
import com.groceryservice.model.User;
import com.groceryservice.repository.GroceryItemRepository;
import com.groceryservice.repository.UserRepository;
import com.groceryservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author vipul.singh
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public GroceryItem addItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public void removeItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    @Override
    public GroceryItem updateItem(Long itemId, GroceryItem newItem) {
        Optional<GroceryItem> existingItem = groceryItemRepository.findById(itemId);

        if (existingItem.isPresent()) {
            GroceryItem updatedItem = existingItem.get();
            updatedItem.setName(newItem.getName());
            updatedItem.setPrice(newItem.getPrice());
            return groceryItemRepository.save(updatedItem);
        } else {
            // Handle not found
            return null;
        }
    }

    @Override
    public GroceryItem manageInventory(Long itemId, int quantity) {
        Optional<GroceryItem> existingItem = groceryItemRepository.findById(itemId);

        if (existingItem.isPresent()) {
            GroceryItem item = existingItem.get();
            int newInventory = item.getInventory() + quantity;
            item.setInventory(newInventory);
            return groceryItemRepository.save(item);
        } else {
            // Handle not found
            return null;
        }
    }

    @Override
    public User registerAdmin(User user) {
        // Set the user role to admin
        user.setAdmin(true);
        return userRepository.save(user);
    }
}
