package com.B.week11.MVC.service;

import java.util.List;

import com.B.week11.MVC.model.Hotels;
import com.B.week11.MVC.model.Login;
import com.B.week11.MVC.model.Reservation;
import com.B.week11.MVC.model.User;

public interface ReservationService {

	List<Hotels> getHotels();

	void addReservation(Reservation reservation);

	/*
	 * int register(User user);
	 * 
	 * User validateUser(Login login);
	 */
}