package com.groceryservice.controller;

import com.groceryservice.model.GroceryItem;
import com.groceryservice.model.User;
import com.groceryservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vipul.singh
 */
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // Add a new grocery item
    @PostMapping("/add-item")
    public GroceryItem addItem(@RequestBody GroceryItem item) {
        return adminService.addItem(item);
    }

    // View existing grocery items
    @GetMapping("/grocery-items")
    public List<GroceryItem> getAllGroceryItems() {
        return adminService.getAllGroceryItems();
    }

    // Remove a grocery item
    @DeleteMapping("/remove-item/{itemId}")
    public void removeItem(@PathVariable Long itemId) {
        adminService.removeItem(itemId);
    }

    // Update details of an existing grocery item
    @PutMapping("/update-item/{itemId}")
    public GroceryItem updateItem(@PathVariable Long itemId, @RequestBody GroceryItem item) {
        return adminService.updateItem(itemId, item);
    }

    // Manage inventory levels of grocery items
    @PutMapping("/manage-inventory/{itemId}")
    public GroceryItem manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        return adminService.manageInventory(itemId, quantity);
    }


    // Admin registration
    @PostMapping("/register")
    public User registerAdmin(@RequestBody User user) {
        return adminService.registerAdmin(user);
    }
}
