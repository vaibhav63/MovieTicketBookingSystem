package com.cpg.movieticketbooking.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cpg.movieticketbooking.dao.BookingState.BookingStatus;



public class Show {


	private Integer screenId;
	private Integer theaterId;
	private Integer movieId;
	private Long showId;
	private Movie movieDetail;
	private String showName;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	private List<Seat> seats=new ArrayList<Seat>();
	
	public Show( Integer screenId, Integer theaterId,Integer movieId, String showName,
			LocalDateTime showStartTime, LocalDateTime showEndTime) {
		
		
		this.screenId = screenId;
		this.theaterId = theaterId;
		this.movieId=movieId;
		this.showId = showIdGenerator();
		this.showName = showName;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		populateSeats();
	}
	
	public Integer getScreenId() {
		return screenId;
	}
	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}
	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public Movie getMovieDetail() {
		return movieDetail;
	}
	public void setMovieDetail(Movie movieDetail) {
		this.movieDetail = movieDetail;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	public Long showIdGenerator() {
		
		return Long.parseLong(theaterId.toString()+movieId.toString()+screenId.toString());
		
	}
	
     public void populateSeats() {
		
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<4;j++) {
				
				seats.add(new Seat(BookingStatus.AVAILABLE,Long.parseLong(theaterId.toString()+screenId.toString()),i,j));
			}	
		}
		
	}
	
	
}
