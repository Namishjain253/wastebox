package com.skillassure.wastebox.businesslayer.user;

import com.skillassure.wastebox.model.user.User;

public interface IUserService {
	
	public boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	User save(User user);


}
