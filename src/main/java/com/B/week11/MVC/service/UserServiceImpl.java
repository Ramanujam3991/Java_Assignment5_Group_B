package com.B.week11.MVC.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.B.week11.MVC.dao.UserDao;
import com.B.week11.MVC.model.*;

public class UserServiceImpl implements UserService {

	  @Autowired
	  public UserDao userDao;

	  public int register(User user) {
	    return userDao.register(user);
	  }

	  public User validateUser(Login login) {
	    return userDao.validateUser(login);
	  }


	}
