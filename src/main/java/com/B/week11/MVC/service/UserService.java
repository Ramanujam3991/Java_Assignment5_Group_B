package com.B.week11.MVC.service;

import com.B.week11.MVC.model.Login;
import com.B.week11.MVC.model.User;

public interface UserService {

	  int register(User user);

	  User validateUser(Login login);
}