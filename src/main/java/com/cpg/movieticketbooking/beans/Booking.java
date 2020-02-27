package com.cpg.movieticketbooking.beans;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;



public class Booking {

	private Integer movieId;
	private Integer transactionId;
	private Integer customerId;
	private Long showId;
	private String bookingId;
	private LocalDate bookingDate;
	private Double totalCost=(double) 0;
	private Ticket ticket;
	private Show showRef;
	private List<Seat> selectedSeats=new CopyOnWriteArrayList<Seat>();
	private List<Ticket> myTickets=new CopyOnWriteArrayList<Ticket>();
	
	

	public Booking( Integer customerId,Long showId, Integer movieId, LocalDate bookingDate,
			Show showRef) {
		
		this.customerId=customerId;
		this.showId = showId;
		this.movieId = movieId;
		this.bookingId = bookingIdGenerator();
		this.transactionId = transactionIdGenerator();
		this.bookingDate = bookingDate;
		this.showRef = showRef;
	}
	
	
	public Ticket getTicket() {
		return ticket;
	}





	public Double getTotalCost() {
		return totalCost;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}





	public List<Seat> getSelectedSeats() {
		return selectedSeats;
	}





	public void setSelectedSeats(List<Seat> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}





	public List<Ticket> getMyTickets() {
		return myTickets;
	}





	public void setMyTickets(List<Ticket> myTickets) {
		this.myTickets = myTickets;
	}




	public Integer getMovieId() {
		return movieId;
	}





	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}





	public Integer getTransactionId() {
		return transactionId;
	}





	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}





	public Integer getCustomerId() {
		return customerId;
	}





	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}





	public Long getShowId() {
		return showId;
	}





	public void setShowId(Long showId) {
		this.showId = showId;
	}





	public String getBookingId() {
		return bookingId;
	}





	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}





	public LocalDate getBookingDate() {
		return bookingDate;
	}





	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}





	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}





	public Show getShowRef() {
		return showRef;
	}





	public void setShowRef(Show showRef) {
		this.showRef = showRef;
	}

	


	public String bookingIdGenerator() {
		return customerId.toString()+showId.toString().substring(0,4)+movieId.toString()+showId.toString();
	}

	private Integer transactionIdGenerator() {
		
		return new Random().nextInt(100)+1;
	}

	
}
