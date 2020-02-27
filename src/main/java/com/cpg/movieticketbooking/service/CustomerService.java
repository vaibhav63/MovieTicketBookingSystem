package com.cpg.movieticketbooking.service;

import java.util.ArrayList;

import com.cpg.movieticketbooking.beans.Customer;
import com.cpg.movieticketbooking.beans.Show;
import com.cpg.movieticketbooking.beans.Theater;
import com.cpg.movieticketbooking.beans.Ticket;



public interface CustomerService {

ArrayList<Theater> chooseCity(String city);
	
	Boolean bookMovieTicket(Show show);
	
	Boolean cancelMovieTicket(Ticket ticket);
	
	Customer getCustomer();
	
	BookingService getBookingService();
}
