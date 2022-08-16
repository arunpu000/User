package com.hcl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.entity.User;
import com.hcl.repostory.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> getAllUser() {
		
		return userDao.findAll();
	}

	@Override
	public List<User> getUser(long userId) {
		
		//return userDao.getOne(userId);
		List<User> user=new ArrayList<>();
		userDao.findAllByID(userId).forEach(user::add);
		return user;
	}
	
	
	
	
	@Override
	public User addUser(User user) {
		
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(long parseLong) {
		
    User user=userDao.findById(parseLong).get();
     userDao.delete(user);
	}

}
