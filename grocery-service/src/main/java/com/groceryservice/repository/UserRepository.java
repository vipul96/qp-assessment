package com.groceryservice.repository;

import com.groceryservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vipul.singh
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
