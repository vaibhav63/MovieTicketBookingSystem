package com.cpg.movieticketbooking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cpg.movieticketbooking.beans.Movie;
import com.cpg.movieticketbooking.beans.Screen;
import com.cpg.movieticketbooking.beans.Show;
import com.cpg.movieticketbooking.beans.Theater;
import com.cpg.movieticketbooking.service.AdminServiceImpl;



public class Database {

	private static Database database=new Database();
	private  Connection con;
	private Statement statement;
	private ResultSet result;
	private  Map<String, ArrayList<Theater>> theaterMap=new HashMap<String, ArrayList<Theater>>() ;
     
	
	
	
	public  Map<String, ArrayList<Theater>> getTheaterMap(){
		   return theaterMap;
	 }
		
	public static Database getInstance() {
		return database;
	}
	
	public Statement getStatement() {
		return statement;
	}
	public  void populateDatabse(AdminServiceImpl adminServiceImpl) {
		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con = DriverManager.getConnection(
		                "jdbc:oracle:thin:@localhost:1521:xe", "Movie", "1234");
				  statement=con.createStatement();
				  

		
					
				  result=statement.executeQuery("select * from THEATER03");
					while(result.next()){
						Theater theater=new Theater( result.getString(2), result.getString(3), result.getString(4),result.getString(5));
						theater.setTheaterId(result.getInt(1));
						adminServiceImpl.addTheater(theater);
						
					}
					
					
					result=statement.executeQuery("select * from MOVIE03");
					while(result.next()) {
						Movie movie=new Movie( result.getInt(2),result.getInt(3), result.getString(4),result.getString(5), result.getString(6), LocalDateTimeConverter.getLocalDate(result.getString(7)),result.getString(8).split(","));
					    movie.setMovieId(result.getInt(1));
					    adminServiceImpl.addMovie(movie);
					}
					
					result=statement.executeQuery("select * from SCREEN03");
					while(result.next()) {
					 
						Screen screen=new Screen( result.getInt(2),result.getString(3));
						screen.setScreenId(result.getInt(1));
						adminServiceImpl.addScreen(screen);
					}
					
			
					
					result=statement.executeQuery("select * from SHOW03");
					while(result.next()) {
						
						Show show=new Show( result.getInt(2), result.getInt(3),result.getInt(4), result.getString(5), LocalDateTime.now(), LocalDateTime.now());
				        show.setShowId(result.getLong(1));
						adminServiceImpl.addShow(show);
					}
			
			}
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}  
			catch (SQLException e) {
			
			e.printStackTrace();
		  }	
	}

	      
	    
	public void printDetails() {
			
			Set<String> set=getTheaterMap().keySet();
			Iterator<String> iter=set.iterator();
				while(iter.hasNext()) {
				
				String key=iter.next();
				if(!(getTheaterMap().get(key).isEmpty())) {
				System.out.println("\t\t\t\t********["+key+"]**********\n");
				
				for(Theater theater:getTheaterMap().get(key)) {
					System.out.println(" ____________________________________________________________________________________________");
					System.out.println("|THEATER_NAME="+theater.getTheaterName()+" \t |\tMANAGER_NAME="+theater.getManagerName()+"\t|\tTHEATER_ID="+theater.getTheaterId()+"\t\t     |");
					System.out.println("|____________________________________________________________________________________________|");
					for(Screen screen:theater.getListOfScreens()) {
						
						System.out.println("|@screen_name="+screen.getScreenName()+"\t\t\t@screen_id="+screen.getScreenId()+"\t\t\t\t     |\n|@movie_end_date="+screen.getMovieEndDate()+"\t\t\t\t\t\t\t\t\t     |");
						System.out.println("|^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|");
						for(Show show:screen.showShows()) {
							
							System.out.println("|^showId:"+show.getShowId()+"  :  showName:"+show.getShowName()+"  :    movieName:"+show.getMovieDetail().getMovieName()+"\n"
									+"|^showStartTime:"+show.getShowStartTime()+"  :  showEndTime:"+show.getShowEndTime()+" ^|");
							System.out.println("|^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|");
						}
						
						System.out.println(" --------------------------------------------------------------------------------------------\n");
					}
					System.out.println("\n");
					
					
				}
			  }
				
			}

	   }



	public void displayIds() {
		Set<String> set=getTheaterMap().keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String key=iter.next();
			System.out.println(key+"->");
			for(Theater theater:getTheaterMap().get(key)) {
				System.out.println("\t"+theater.getTheaterName()+":"+theater.getTheaterId()+"->");
				for(Screen screen:theater.getListOfScreens()) {
					System.out.println("\t\t"+screen.getScreenName()+":"+screen.getScreenId()+"->");
					for(Show show:screen.showShows()) {
						System.out.println("\t\t\t"+show.getShowName()+":"+show.getShowId());
					}
				}
				for(Movie movie:theater.getMovies()) {
					System.out.println("\t\t"+movie.getMovieName()+":"+movie.getMovieId());
				}
			
		}
	}
	}
	
	
}
