package com.groceryservice.service.impl;

import com.groceryservice.model.GroceryItem;
import com.groceryservice.model.Order;
import com.groceryservice.model.User;
import com.groceryservice.repository.GroceryItemRepository;
import com.groceryservice.repository.OrderRepository;
import com.groceryservice.repository.UserRepository;
import com.groceryservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vipul.singh
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<GroceryItem> getAvailableGroceryItems() {
        return groceryItemRepository.findAll();
    }


    @Override
    public User registerUser(User user) {
        // Set the user role to regular user
        user.setAdmin(false);
        return userRepository.save(user);
    }

    @Override
    public Order createOrder(String customerName, String transactionId, List<Long> groceryItemIds) {
        Order order = new Order();
//        order.setCustomerName(customerName);
//        order.setTransactionId(transactionId);

        for (Long itemId : groceryItemIds) {
            GroceryItem item = groceryItemRepository.findById(itemId).orElse(null);
            if (item != null) {
                order.getItems().add(item);
            }
        }

        return orderRepository.save(order);
    }
}
