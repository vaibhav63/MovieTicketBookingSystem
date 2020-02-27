package com.cpg.movieticketbooking.dao;

import com.cpg.movieticketbooking.beans.Seat;

public interface SeatDao {

void blockSeat();
	
	void bookSeat();
	
	void cancelSeat();
	
	Seat getSeat();
	
}
