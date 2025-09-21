package com.nitish.users.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.nitish.users.entities.User;
import com.nitish.users.exception.UserIdNotFoundException;
import com.nitish.users.exception.UserNotAddedException;
import com.nitish.users.repository.UserRepository;

import javax.validation.Valid;

/**
 * 
 * User Service Class
 * 
 */
@Service
@Valid
public class UserService {

//Loggers
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

//	fetch all user method
	public List<User> getAllUsers() {
		List<User> user = (List<User>) userRepository.findAll();
		return user;
	}

//	fetch all user method through ID
	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			logger.error("UserIdNotFoundExceptionoccurred");
			throw new UserIdNotFoundException("User id not found" + id);
		}
	}

//	add user method
	public String addUser(User user) throws UserNotAddedException {
		String message = "User inserted successfully!";
		logger.info("Inside the method [addUser] of service" + message);
		userRepository.save(user);
		return "User inserted successfully!";
	}

//	update user method
	public String updateUserById(User user, int id) {
		User updatedUser = null;
		user.setId(id);
		updatedUser = userRepository.save(user);
		return "User updated successfully!!!";

	}

//	delete user method
	public String deleteUserById(int userId) {
		Optional<User> deleteUser = userRepository.findById(userId);
		if (deleteUser.isPresent()) {
			userRepository.deleteById(userId);
			return "deleted succefully";
		} else {
			logger.error("SubjectNotFoundExceptionoccurred");
			throw new UserIdNotFoundException("No record found this the id: " + userId);

		}
	}
}
