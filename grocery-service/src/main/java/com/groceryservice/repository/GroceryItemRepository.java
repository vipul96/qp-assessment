package com.groceryservice.repository;

import com.groceryservice.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vipul.singh
 */
@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}
