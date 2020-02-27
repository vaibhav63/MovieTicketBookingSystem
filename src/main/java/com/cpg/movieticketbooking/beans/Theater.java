package com.cpg.movieticketbooking.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class Theater {

	private String managerName;
	private String managerContact;
	private String theaterName;
	private String theaterCity;
	private Integer theaterId;
	private List<Movie> movies =new CopyOnWriteArrayList<Movie>();
	private List<Screen> listOfScreens=new ArrayList<Screen>();
	
	
  

public Theater(String managerName, String managerContact, String theaterName, String theaterCity) {
		
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.theaterId = theaterIdGenerator();
	}

	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	
	
	public List<Screen> getListOfScreens() {
		return listOfScreens;
     }

	
    public void setListOfScreens(Screen screen) {
		listOfScreens.add(screen);
     }
    

    public List<Movie> getMovies() {
		return movies;
     }

     public void setMovies(Movie movie) {
		movies.add(movie);
     }
	
     public  Integer theaterIdGenerator() {
 		
 		
 		return 2000+new Random().nextInt(1000);
 		
 	}
	
}
