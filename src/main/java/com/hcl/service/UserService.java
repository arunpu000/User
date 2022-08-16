package com.hcl.service;

import java.util.List;


import com.hcl.entity.User;

public interface UserService {
	
	public List<User> getAllUser();
	
	public List<User> getUser(long userId);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(long parseLong);

	

}
