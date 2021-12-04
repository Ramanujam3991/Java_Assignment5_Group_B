package com.B.week11.MVC.model;

import java.util.List;

public class Reservation {
	private int reservationId;
	private Customer customer;
	private String checkin;
	private String checkout;
	private String status;
	private int noOfGuests;
	private String reservationDate;
	private Rooms rooms;
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkOut) {
		this.checkout = checkOut;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNoOfGuests() {
		return noOfGuests;
	}
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Rooms getRooms() {
		return rooms;
	}
	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}
	
	

}
