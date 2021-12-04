package com.B.week11.MVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.B.week11.MVC.model.Hotels;
import com.B.week11.MVC.model.Login;
import com.B.week11.MVC.model.Reservation;
import com.B.week11.MVC.model.User;

public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Hotels> getHotels() {
		return jdbcTemplate.query("select hotel_id, zipcode, city, state,phone from hotels", new HotelsRowMapper());
	}

	class HotelsRowMapper implements RowMapper<Hotels> {

		public Hotels mapRow(ResultSet rs, int arg1) throws SQLException {
			Hotels hotels = new Hotels();

			hotels.setHotelId(rs.getInt("hotel_id"));
			hotels.setZipcode(rs.getString("zipcode"));
			hotels.setCity(rs.getString("city"));
			hotels.setState(rs.getString("state"));
			hotels.setPhone(rs.getString("phone"));

			return hotels;

		}

	}

	@Override
	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		System.out.println("Data:" + reservation);
		String sql = "insert into customer(last_name,phone,city,first_name,state,zipcode) values(?,?,?,?,?,?)";

		jdbcTemplate.update(sql,
				new Object[] { reservation.getCustomer().getLastname(), reservation.getCustomer().getPhone(),
						reservation.getCustomer().getCity(), reservation.getCustomer().getFirstname(),
						reservation.getCustomer().getState(), reservation.getCustomer().getZipcode() });
		
		jdbcTemplate.query("select max(customer_id) from customer ", new Object[0]);

		sql = "insert into rooms(room_type, rates,room_location,number_of_beds,customer_id) values(?,?,?,?,?)";

		jdbcTemplate.update(sql,
				new Object[] { reservation.getRooms().getRoomType(), reservation.getRooms().getRates(),
						reservation.getRooms().getRoomLocation(), reservation.getRooms().getNoOfBeds(),
						reservation.getCustomer().getCustomerId() });

		sql = "insert into reservation(customer_id,check_in,check_out,status,number_of_guests,reservation_date,room_id) values(?,STR_TO_DATE(?,'%d/%m/%Y'),STR_TO_DATE(?,'%d/%m/%Y'),?,?,STR_TO_DATE(?,'%d/%m/%Y'),?)";
		jdbcTemplate.update(sql, reservation.getCustomer().getCustomerId(), reservation.getCheckin(),
				reservation.getCheckout(), reservation.getStatus(), reservation.getNoOfGuests(),
				reservation.getReservationDate(), reservation.getRooms().getRoomId());
	}

}