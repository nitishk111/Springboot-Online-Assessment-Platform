package com.nitish.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nitish.users.entities.User;

/**
 * 
 * User Repository Interface
 *
 */
public interface UserRepository extends JpaRepository<User,Integer> {
	


}
