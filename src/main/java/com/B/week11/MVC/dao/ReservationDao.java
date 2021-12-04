package com.B.week11.MVC.dao;

import java.util.List;

import com.B.week11.MVC.model.Hotels;
import com.B.week11.MVC.model.Login;
import com.B.week11.MVC.model.Reservation;
import com.B.week11.MVC.model.User;

public interface ReservationDao {

//	int register(User user);
//
//	User validateUser(Login login);

	List<Hotels> getHotels();

	void addReservation(Reservation reservation);
}
