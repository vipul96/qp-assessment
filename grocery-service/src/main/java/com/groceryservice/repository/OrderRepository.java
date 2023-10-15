package com.groceryservice.repository;

import com.groceryservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vipul.singh
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
