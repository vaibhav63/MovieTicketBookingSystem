package com.cpg.movieticketbooking.beans;

import com.cpg.movieticketbooking.dao.BookingState.BookingStatus;

public class Seat {


	private BookingStatus seatStatus;
	private Integer row;
	private Integer column;
	private Long seatId;
	private Double seatPrice;
	private String seatName;
	
	
	
	
	
	public Seat(BookingStatus seatStatus, Long seatId,Integer row,Integer  column) {
		
		this.seatStatus = seatStatus;
		this.seatId = seatId;
		this.row=row;
		this.column=column;
		this.seatName="[R="+row.toString()+":"+"C="+column.toString()+"]";
		setPrice();
	}


	
	public String getSeatName() {
		return seatName;
	}



	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}



	public void setSeatStatus(BookingStatus seatStatus) {
		this.seatStatus = seatStatus;
	}



	public void setRow(Integer row) {
		this.row = row;
	}



	public void setColumn(Integer column) {
		this.column = column;
	}



	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}



	public void setSeatPrice(Double seatPrice) {
		this.seatPrice = seatPrice;
	}



	public void setPrice() {
		
		if(row<2) {
			this.seatPrice=(double) 200;
		}else if(row<4) {
			this.seatPrice=(double) 400;
		}else {
			this.seatPrice=(double) 500;
		}
	}

	public BookingStatus getSeatStatus() {
		return seatStatus;
	}

	public Long getSeatId() {
		return seatId;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}

	public Double getSeatPrice() {
		return seatPrice;
	}
	
}
