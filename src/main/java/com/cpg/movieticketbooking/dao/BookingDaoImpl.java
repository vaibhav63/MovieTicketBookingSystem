package com.cpg.movieticketbooking.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cpg.movieticketbooking.beans.Booking;
import com.cpg.movieticketbooking.beans.Screen;
import com.cpg.movieticketbooking.beans.Seat;
import com.cpg.movieticketbooking.beans.Theater;
import com.cpg.movieticketbooking.beans.Ticket;
import com.cpg.movieticketbooking.dao.BookingState.BookingStatus;
import com.cpg.movieticketbooking.exception.BookingException;



public class BookingDaoImpl implements BookingDao {

	private Booking booking;
	private Map<String, ArrayList<Theater>> theaterMap=Database.getInstance().getTheaterMap();
	
	 public BookingDaoImpl(Booking booking) {
		this.booking=booking;
	}
	
	public List<Seat> chooseSeats() {
		
		while(true) {
			  
			int flag=0;
			System.out.println("\t\t\t<Do you want to book a seat? [Y/N]>");
			String choice =InputSystem.getInput().toUpperCase();
			
			switch(choice) {
			
			case "Y":
				     
				
				     System.out.println("\t\t\t<Which row & column do you want?>");
			         String[] index=InputSystem.getInput().split(",");
			         for(Seat seat:booking.getShowRef().getSeats()) {
			        	 
			        	 if(seat.getRow()==Integer.parseInt(index[0]) && seat.getColumn()==Integer.parseInt(index[1])) {
			        		  
			        		
			        		  if(seat.getSeatStatus()==BookingStatus.AVAILABLE) {
			        			  
			        			     SeatDao seatDao=new SeatDaoImpl(seat);
			        			     seatDao.blockSeat();
			        			     if(seatDao.getSeat().getSeatStatus()==BookingStatus.BLOCKED) {
			        			    	 seatDao.bookSeat();
						        		 booking.getSelectedSeats().add(seat);
			        			     }
		                             
			        		  }else {
			        			 try {
			        				 throw new BookingException("\t\t\t+Sorry,Already booked+\n");
			        			 }catch(BookingException e) {
			        				 System.out.println(e.getMessage());
			        			 }
			        			  
			        		  }
			        	flag=1;
			        	 }
			         }
			         
			         if(flag==0) {
			        	 
				         System.out.println("\t\t\t+NO SUCH ROW AND COLUMN+\n");
			        	 
			         }

			         break;
			         
			case "N":System.out.println("\t\t\t\"THANKS FOR COMING\"\n");
			         return booking.getSelectedSeats();
			}
			
		}
	}

	public PaymentMethod choosePaymentMethod() {
		
		PaymentMethod payment=new PaymentMethod();
		return payment;
	}

	public Boolean makePayment(PaymentMethod paymentMethod, Double cost) {
		
		if(paymentMethod!=null && cost!=0) {
			return true;
		}
		return false;
	}

	public Boolean cancelBookings(Ticket ticket) {
		 
		  booking.getMyTickets().remove(ticket);
			
			for(Seat seat:booking.getSelectedSeats()) {
				
				if(ticket.getSeatName().equalsIgnoreCase(seat.getSeatName())) {
					SeatDao seatDao=new SeatDaoImpl(seat);
					seatDao.cancelSeat();
					booking.getSelectedSeats().remove(seat);
				}
				
			}
			return false;
	}

	public void setTicket() {
		
		String screenName = null;
		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			
			String key=iter.next();
			for(Theater theater:theaterMap.get(key)) {
				
				if(theater.getTheaterId()==booking.getShowRef().getTheaterId()) {
					
					for(Screen screen:theater.getListOfScreens()) {
						
						if(screen.getScreenId()==booking.getShowRef().getScreenId()) {
							screenName=screen.getScreenName();
						}
						
					}
				}
				
			}
			
		}
		
		for(Seat seat:booking.getSelectedSeats()) {
			
			Ticket ticket = new Ticket(booking.getBookingId()+booking.getTransactionId(), booking.getSelectedSeats().size(),screenName,true, booking, seat.getSeatName());
			booking.setTicket(ticket);
			booking.getMyTickets().add(ticket);
			
		}
		
	}

	public Double getTotalCost() {
		
		Double totalCost = (double) 0;
		for(Seat seat:booking.getSelectedSeats()) {
			
			totalCost+=seat.getSeatPrice();
		}
		booking.setTotalCost(totalCost);
		return totalCost;
		
	}
	
}
