package com.cpg.movieticketbooking.service;
import com.cpg.movieticketbooking.beans.Movie;
	import com.cpg.movieticketbooking.beans.Screen;
	import com.cpg.movieticketbooking.beans.Show;
	import com.cpg.movieticketbooking.beans.Theater;

	public interface AdminService {

		void addTheater(Theater theater) ;
		
		 Boolean deleteTheater(Integer theaterId);
		 
		 void addMovie(Movie movie);
		 
		 Boolean deleteMovie(Integer movieId);
		 
		 void addScreen(Screen screen);
		 
		 Boolean deleteScreen(Integer screenId) ;
		 
		 void addShow(Show show);
		 
		 Boolean deleteShow(Long showId);
		
	}


