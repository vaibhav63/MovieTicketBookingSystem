package com.cpg.movieticketbooking.service;

import com.cpg.movieticketbooking.beans.Seat;
import com.cpg.movieticketbooking.beans.Show;

public class ShowServiceImpl implements ShowService {

	private Show show;
	
	 public ShowServiceImpl(Show show) {
	
		 this.show=show;
		 
	}
	
	public void showSeatStatus() {
		
       for(Seat seat:show.getSeats()) {
			
			if(seat.getColumn().equals(0)) {
				System.out.println("\n");
			}
			System.out.print(seat.getSeatStatus()+" ");
		}
		System.out.println("\n");
	  }
	
}
