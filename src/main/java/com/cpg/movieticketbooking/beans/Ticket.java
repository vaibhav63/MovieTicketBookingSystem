package com.cpg.movieticketbooking.beans;



public class Ticket {

	private Integer noOfSeats;
	private String screenName,ticketId;
	private Boolean ticketStatus;
	private Booking bookingRef;
	private String seatName;
	
	public Ticket(String ticketId, Integer noOfSeats, String screenName, Boolean ticketStatus, Booking bookingRef,
			String seatName) {
		
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.screenName = screenName;
		this.ticketStatus = ticketStatus;
		this.bookingRef = bookingRef;
		this.seatName = seatName;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public void setTicketStatus(Boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public void setBookingRef(Booking bookingRef) {
		this.bookingRef = bookingRef;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public String getTicketId() {
		return ticketId;
	}
	public Boolean getTicketStatus() {
		return ticketStatus;
	}
	public Booking getBookingRef() {
		return bookingRef;
	}
	public String getSeatName() {
		return seatName;
	}
}
