package com.cpg.movieticketbooking.dao;

import com.cpg.movieticketbooking.beans.Seat;
import com.cpg.movieticketbooking.dao.BookingState.BookingStatus;

public class SeatDaoImpl implements SeatDao{
	private Seat seat;
	
	 public SeatDaoImpl(Seat seat) {
		this.seat=seat;
	}
	
	@Override
	public void blockSeat() {
		
		seat.setSeatStatus(BookingStatus.BLOCKED);
		
		
	}

	@Override
	public void bookSeat() {
		
		seat.setSeatStatus(BookingStatus.BOOKED);
		
	}

	@Override
	public void cancelSeat() {
		
		seat.setSeatStatus(BookingStatus.AVAILABLE);
		
	}
	@Override
	public Seat getSeat() {
		return seat;
		
	}
}
