package com.cpg.movieticketbooking.dao;

import com.cpg.movieticketbooking.beans.Movie;
import com.cpg.movieticketbooking.beans.Screen;

public interface TheaterDao {

	Movie searchMovie(String movie);
	 
	 Screen searchScreen(Integer screen);
	 
	 void removeMovie(Movie movie);
	 
	 void removeScreen(Screen screen);
	
}
