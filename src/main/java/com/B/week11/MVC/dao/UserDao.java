package com.B.week11.MVC.dao;

import com.B.week11.MVC.model.Login;
import com.B.week11.MVC.model.User;

public interface UserDao {

	int register(User user);

	User validateUser(Login login);
}
