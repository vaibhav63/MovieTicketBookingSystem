package com.cpg.movieticketbooking.dao;

import com.cpg.movieticketbooking.beans.Movie;
import com.cpg.movieticketbooking.beans.Screen;
import com.cpg.movieticketbooking.beans.Theater;

public class TheaterDaoImpl implements TheaterDao {

private Theater theater;
	
	public TheaterDaoImpl(Theater theater) {
		
		this.theater=theater;
	}
	
	
	public Movie searchMovie(String movie) {
		
		for(Movie movie1:theater.getMovies()) {
			if(movie1.getMovieName().equalsIgnoreCase(movie)) {
				return movie1;
			}
		}
		return null;
	}
	
	public Screen searchScreen(Integer screen) {
		
		for(Screen screen1:theater.getListOfScreens()) {
			if(screen1.getScreenId().equals(screen)) {
				return screen1;
			}
		}
		return null;
	}
	
	public void removeMovie(Movie movie) {
		
		theater.getMovies().remove(movie);
		
	}
	
	public void removeScreen(Screen screen) {
		
		theater.getListOfScreens().remove(screen);
		
	}
	
}
