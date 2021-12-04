package com.B.week11.MVC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.B.week11.MVC.model.Hotels;
import com.B.week11.MVC.model.Reservation;
import com.B.week11.MVC.model.Services;
import com.B.week11.MVC.model.User;
import com.B.week11.MVC.service.ReservationService;


@Controller
public class ReservationController {
	
	  @Autowired
	  ReservationService reservationService;
	  
	  @RequestMapping(value = "/bookreservation", method = RequestMethod.GET)
	  public ModelAndView bookReservation(HttpServletRequest request, HttpServletResponse response, Model m) {
	    ModelAndView mav = new ModelAndView("reservation");
	    System.out.println("Reservation Controller: Book Reservation");
	    List<Hotels> Hotellst = reservationService.getHotels();
	    m.addAttribute("Hotellst", Hotellst);
	    mav.addObject("reservation", new Reservation());

	    return mav;
	  }
	  
	  @RequestMapping(value = "/saveReservation", method = RequestMethod.POST)
	  public ModelAndView saveReservation(HttpServletRequest request, HttpServletResponse response, Model m,
	  @ModelAttribute("reservation") Reservation reservation){
		  System.out.println("reservation:"+reservation.getCheckin());
		  System.out.println("reservation:"+reservation.getCheckout());
		  reservationService.addReservation(reservation);
		  ModelAndView mav = new ModelAndView("addServices");
		  mav.addObject("services", new Services());
		  return new ModelAndView();
	  }

}
