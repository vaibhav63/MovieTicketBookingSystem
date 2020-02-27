package com.cpg.movieticketbooking.dao;

import java.util.List;

import com.cpg.movieticketbooking.beans.Seat;
import com.cpg.movieticketbooking.beans.Ticket;



public interface BookingDao {

	List<Seat> chooseSeats();
	 
	 PaymentMethod choosePaymentMethod();
	 
	 Boolean makePayment(PaymentMethod paymentMethod,Double cost);
	 
	 Boolean cancelBookings(Ticket ticket);
	 
	 void setTicket();
	
	 Double getTotalCost();
	
}
