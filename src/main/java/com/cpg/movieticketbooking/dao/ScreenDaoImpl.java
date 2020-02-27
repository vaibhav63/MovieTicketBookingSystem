package com.cpg.movieticketbooking.dao;

import com.cpg.movieticketbooking.beans.Screen;
import com.cpg.movieticketbooking.beans.Show;

public class ScreenDaoImpl implements ScreenDao{

private Screen screen ;
	
	public  ScreenDaoImpl(Screen screen) {
		
		this.screen=screen;
	}

	public Show searchShow(String movie) {
		
       for(Show show:screen.showShows()) {
			
			if(show.getMovieDetail().getMovieName().equalsIgnoreCase(movie)) {
				
	             return show;
			}
		}
		
		return null;
	}
	
	
	public void removeShow(Show show) {
		
		screen.showShows().remove(show);
	}
	
}
