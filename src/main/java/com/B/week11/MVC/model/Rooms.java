package com.B.week11.MVC.model;

public class Rooms {
	private int roomId;
	private String roomType;
	private double rates;
	private String roomLocation;
	private int noOfBeds;
	private Customer customer;
	private Hotels hotels;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRates() {
		return rates;
	}
	public void setRates(double rates) {
		this.rates = rates;
	}
	public String getRoomLocation() {
		return roomLocation;
	}
	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Hotels getHotels() {
		return hotels;
	}
	public void setHotels(Hotels hotels) {
		this.hotels = hotels;
	}
	

}
