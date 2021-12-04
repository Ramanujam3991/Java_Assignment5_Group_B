package com.B.week11.MVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.B.week11.MVC.dao.ReservationDao;
import com.B.week11.MVC.model.*;

public class ReservationServiceImpl implements ReservationService {

	  @Autowired
	  public ReservationDao reservationDao;

	@Override
	public List<Hotels> getHotels() {
		// TODO Auto-generated method stub
		return reservationDao.getHotels();
	}

	@Override
	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.addReservation(reservation);
		
	}

//	  public int register(Reservation reservation) {
//	    return reservationDao.register(reservation);
//	  }
//
//	  public User validateUser(Reservation reservation) {
//	    return reservationDao.validateUser(reservation);
//	  }


	}
