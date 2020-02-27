package com.cpg.movieticketbooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cpg.movieticketbooking.beans.Booking;
import com.cpg.movieticketbooking.beans.Customer;
import com.cpg.movieticketbooking.beans.Show;
import com.cpg.movieticketbooking.beans.Theater;
import com.cpg.movieticketbooking.beans.Ticket;
import com.cpg.movieticketbooking.dao.BookingDao;
import com.cpg.movieticketbooking.dao.BookingDaoImpl;
import com.cpg.movieticketbooking.dao.Database;



public class CustomerServiceImpl implements CustomerService {

	private Customer customer;
	private BookingDao bookingDao;
	private BookingService bookingService;
	private Map<String, ArrayList<Theater>> theaterMap=Database.getInstance().getTheaterMap();
	
	
	public  CustomerServiceImpl(String customerName,String customerPassword,String customerContact,LocalDate dateOfBirth,Integer customerId) {
		
		customer=new Customer(customerName, customerPassword, customerContact, dateOfBirth, customerId);
		
	}
	
	public ArrayList<Theater> chooseCity(String city) {
		
		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			
			String key=iter.next();
			if(key.equalsIgnoreCase(city)) {
				return theaterMap.get(key);
			}
			
		}
		
		System.out.println("\t\t\t+NO INFORMATION REGARDING THIS CITY+\n");
		return null;
	}

	public Boolean bookMovieTicket(Show show) {
		
		customer.setBooking(new Booking(customer.getCustomerId(), show.getShowId(), show.getMovieId(), LocalDate.now(), show));
		 bookingDao=new BookingDaoImpl(customer.getBooking());
		 bookingService=new BookingServiceImpl(customer.getBooking());
		bookingDao.chooseSeats();
		
		if(bookingDao.makePayment(bookingDao.choosePaymentMethod(),bookingDao.getTotalCost())) {
			bookingDao.setTicket();
			System.out.println("[Booking Date="+customer.getBooking().getBookingDate()+":Total Cost="+bookingDao.getTotalCost()+"]\n");
			bookingService.showTicket();
			return true;
		}
		
		return false;
	}

	public Boolean cancelMovieTicket(Ticket ticket) {
		
		return bookingDao.cancelBookings(ticket);
	}

	public Customer getCustomer() {
		
		return customer;
	}
	
	public BookingService getBookingService() {
		return bookingService;
	}
	
}
