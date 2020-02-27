package com.cpg.movieticketbooking.beans;

import java.time.LocalDate;


public class Customer {

	private String customerName;
	private String customerPassword;
	private String customerContact;
	private LocalDate dateOfBirth;
	private Integer customerId;
	private Booking booking;
	
	public Customer(String customerName,String customerPassword, String customerContact,LocalDate dateOfBirth,
			Integer customerId ) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
	
}
