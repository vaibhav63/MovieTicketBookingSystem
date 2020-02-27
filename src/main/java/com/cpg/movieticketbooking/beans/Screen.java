package com.cpg.movieticketbooking.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Screen {

	

		private Integer screenId;
		private Integer theaterId;
		private Integer columns;
		private Integer rows;
		private LocalDate movieEndDate;
		private String screenName;
		private List<Show> showList=new ArrayList<Show>();
		
	    public Screen( Integer theaterId, String screenName) {
			
			this.theaterId = theaterId;
			this.screenId = screenIdGenerator();
			this.screenName = screenName;
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
		public Integer getColumns() {
			return columns;
		}
		public void setColumns(Integer columns) {
			this.columns = columns;
		}
		public Integer getRows() {
			return rows;
		}
		public void setRows(Integer rows) {
			this.rows = rows;
		}
		public LocalDate getMovieEndDate() {
			return movieEndDate;
		}
		public void setMovieEndDate(LocalDate movieEndDate) {
			this.movieEndDate = movieEndDate;
		}
		public String getScreenName() {
			return screenName;
		}
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}

		public List<Show> showShows() {
			return showList;
		}

		public void setShowList(Show show) {
			showList.add(show);
		}
		
	   public Integer screenIdGenerator() {
			
			return new Random().nextInt(100)*10000+theaterId;
			
		}
	
}
