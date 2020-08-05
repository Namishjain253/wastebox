package com.skillassure.wastebox.businesslayer.userimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillassure.wastebox.businesslayer.user.IUserService;
import com.skillassure.wastebox.model.user.User;
import com.skillassure.wastebox.repository.user.UserRepository;

public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	/**
	 * existsByUsername will return boolean value based on whether user is existed in DB or not.
	 */
	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
	
	/**
	 * existsByEmail will return boolean value based on whether user is existed or not with email id in DB.
	 */

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	/**
	 * Save method will return user object after saving into database.
	 */
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
