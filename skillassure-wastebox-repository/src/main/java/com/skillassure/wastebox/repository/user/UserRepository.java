package com.skillassure.wastebox.repository.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillassure.wastebox.model.user.User;

/**
 *User Repository for fetching all user details
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
 Optional<User> findByusername(String username);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
