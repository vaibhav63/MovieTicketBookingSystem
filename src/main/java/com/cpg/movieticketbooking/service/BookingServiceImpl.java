package com.cpg.movieticketbooking.service;

import com.cpg.movieticketbooking.beans.Booking;
import com.cpg.movieticketbooking.beans.Ticket;

public class BookingServiceImpl implements BookingService{

	private Booking booking;
	public BookingServiceImpl(Booking booking) {
		
		this.booking=booking;
	}
	
	@Override
	public void showTicket() {
		
		int s_no=1;
		System.out.println("\t\tMY TICKETS ");
		System.out.println("  -----------------------------------------");
		for(Ticket ticket:booking.getMyTickets()) {
			System.out.println(s_no+".|"+ticket.getTicketId()+":"+ticket.getSeatName()+"|");
		    s_no++;
		}
		System.out.println("  -----------------------------------------");
		
	}
	
}
