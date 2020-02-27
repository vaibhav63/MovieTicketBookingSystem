package com.cpg.movieticketbooking.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cpg.movieticketbooking.beans.Admin;
import com.cpg.movieticketbooking.beans.Movie;
import com.cpg.movieticketbooking.beans.Screen;
import com.cpg.movieticketbooking.beans.Show;
import com.cpg.movieticketbooking.beans.Theater;



public class AdminDaoImpl implements AdminDao {

	private Admin admin;
	private  Map<String, ArrayList<Theater>> theaterMap=Database.getInstance().getTheaterMap();
	

	public AdminDaoImpl(String adminName, String adminPassword, String adminContact, LocalDate dateOfBirth, Integer adminId) {
		
		admin=new Admin(adminName, adminPassword, adminContact, dateOfBirth, adminId);
	
		
	}
	
	public  AdminDaoImpl() {

	}

	public void addTheater(Theater theater) {
		
	
		
			Set<String> set=theaterMap.keySet();
			Iterator<String> iter=set.iterator();
			while(iter.hasNext()) {
				String key=iter.next();
			
			  
				if(key.equals(theater.getTheaterCity())) {
					theaterMap.get(key).add(theater);
					
					return;
				}
			
		}
		ArrayList<Theater> list=new ArrayList<Theater>();
		list.add(theater);
		theaterMap.put(theater.getTheaterCity(),list );
		
	}

	public Boolean deleteTheater(Integer theaterId) {
		
		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		
		while(iter.hasNext()) {
			String key=iter.next();
			for(Theater theater:theaterMap.get(key)) {
				
				if(theater.getTheaterId().equals(theaterId)) {
					theaterMap.get(key).remove(theater);
					return true;
				}
			}
		}
		return false;
	}

	public void addMovie(Movie movie) {
		
		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String key=iter.next();
			for(Theater theater:theaterMap.get(key)) {
				
				if(movie.getTheaterId().equals(theater.getTheaterId())) {
					
					theater.setMovies(movie);
				
				}
				
			}
		}
		
	}

	public Boolean deleteMovie(Integer movieId) {
		
		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String key=iter.next();
			for(Theater theater:theaterMap.get(key)) {
				for(Movie movie:theater.getMovies()) {
					if(movieId.equals(movie.getMovieId())) {
						TheaterDao theaterDao=new TheaterDaoImpl(theater);
						theaterDao.removeMovie(movie);
					}
				}
			}
		}
		return true;
	}

	public void addScreen(Screen screen) {
	
		
		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			
			String key=iter.next();
			for(Theater theater:theaterMap.get(key)) {
				
				
				if(screen.getTheaterId().equals(theater.getTheaterId())) {
					
					theater.setListOfScreens(screen);
					
				}
				
			}
			
		}
		
	}

	public Boolean deleteScreen(Integer screenId) {
		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			
			String key=iter.next();
			for(Theater theater:theaterMap.get(key)) {
				
				for(Screen screen:theater.getListOfScreens()) {
					
					if(screen.getScreenId().equals(screenId)){
						
						TheaterDao theaterDao=new TheaterDaoImpl(theater);
						theaterDao.removeScreen(screen);
						return true;
						
					}
					
				}
		    }
			
		}
		return false;
	}

	public void addShow(Show show) {

		Set<String> set=theaterMap.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			
			String key=iter.next();
			for(Theater theater:theaterMap.get(key)) {
				
				
				if((show.getTheaterId()).equals( theater.getTheaterId())) {
					
					
					for(Movie movie:theater.getMovies()) {
						
						if(show.getMovieId().equals(movie.getMovieId())) {
							
							
							 show.setMovieDetail(movie);
						
							
						}
					}
					
					for(Screen screen:theater.getListOfScreens()) {
						
						if(screen.getScreenId().equals(show.getScreenId())) {
						
							screen.setShowList(show);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		
	}

	public Boolean deleteShow(Long showId) {
		   String showID=showId.toString();
					Set<String> set=theaterMap.keySet();
					Iterator<String> iter=set.iterator();
					while(iter.hasNext()) {
						
						String key=iter.next();
						for(Theater theater:theaterMap.get(key)) {
							
							String theaterID=theater.getTheaterId().toString();
							
							if(showID.substring(0,4).equalsIgnoreCase(theaterID)) {
								
								for(Screen screen:theater.getListOfScreens()) {
									
									String screenID=screen.getScreenId().toString();
									
									if(showID.substring(8,showID.length()).equalsIgnoreCase(screenID)) {
										
										for(Show show:screen.showShows()) {
											
											if(show.getShowId().equals(showId)) {
												
												ScreenDao screenDao=new ScreenDaoImpl(screen);
												screenDao.removeShow(show);
											   return true;
											}
											
										}
										
									}
									
								}
								
							}
							
					    }
						
					}
					return false;
	}

		
	
}
