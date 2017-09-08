package com.beingjavaguys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beingjavaguys.dao.UserDao;
import com.beingjavaguys.domain.User;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDaoImpl;

	@Override
	public void insertData(User user) {
		userDaoImpl.insertData(user);
	}

	@Override
	public List<User> getUserList() {
		return userDaoImpl.getUserList();
	}

	@Override
	public void deleteData(String id) {
		userDaoImpl.deleteData(id);
		
	}

	@Override
	public User getUser(String id) {
		return userDaoImpl.getUser(id);
	}

	@Override
	public void updateData(User user) {
		userDaoImpl.updateData(user);
		
	}


	
}
