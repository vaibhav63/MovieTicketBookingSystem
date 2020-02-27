package com.cpg.movieticketbooking.ui;


import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.cpg.movieticketbooking.beans.Booking;
import com.cpg.movieticketbooking.beans.Movie;
import com.cpg.movieticketbooking.beans.Screen;
import com.cpg.movieticketbooking.beans.Show;
import com.cpg.movieticketbooking.beans.Theater;
import com.cpg.movieticketbooking.beans.Ticket;
import com.cpg.movieticketbooking.beans.User;
import com.cpg.movieticketbooking.dao.Database;
import com.cpg.movieticketbooking.dao.InputSystem;
import com.cpg.movieticketbooking.dao.LocalDateTimeConverter;
import com.cpg.movieticketbooking.dao.ScreenDao;
import com.cpg.movieticketbooking.dao.ScreenDaoImpl;
import com.cpg.movieticketbooking.service.AdminService;
import com.cpg.movieticketbooking.service.AdminServiceImpl;
import com.cpg.movieticketbooking.service.CustomerService;
import com.cpg.movieticketbooking.service.CustomerServiceImpl;
import com.cpg.movieticketbooking.service.ShowService;
import com.cpg.movieticketbooking.service.ShowServiceImpl;
import com.cpg.movieticketbooking.service.UserService;
import com.cpg.movieticketbooking.service.UserServiceImpl;



public class Main {

	 
	
		
	public static void main(String[] args) {
		
		Main main=new Main();
		Database.getInstance().populateDatabse(new AdminServiceImpl());
		main.handleAccess();
	}
	
	/* Handles Access of Services corresponding to user type*/
	
	public void handleAccess() {
		
        UserService userService = new UserServiceImpl();
        User user = null;
		while(true) {
			
		System.out.println("\n\n\t\t\t\t*****WELCOME TO ONLINE MOVIE TICKET BOOKING SYSTEM*****\n"
				+ "Select Operation: \n 1.REGISTER \n 2.LOGIN \n 3.LOGOUT \n 4.EXIT" );
		String choice=InputSystem.getInput();
		
		switch(choice) {
		
		case "1":
		        user=userService.registerNewUser();
		         break;
		         
		case "2":
			      System.out.println("Enter your USERNAME");
			      String username=InputSystem.getInput();
			      System.out.println("Enter your PASSWORD");
			      String password=InputSystem.getInput();
			      if(userService.signIn(username, password)) {
			        
			    	  user=userService.getUser();
			    	  
			    	  if(user.getUserType().equalsIgnoreCase("admin")) {
			    		 AdminService adminService=new AdminServiceImpl(user.getUserName(),user.getPassword(), "7011683242", LocalDate.now(), user.getUserId());
			    		  adminUserInterface(adminService);
			    	  }
			    	  else if(user.getUserType().equalsIgnoreCase("customer")) {
			    		 CustomerService customerService=new CustomerServiceImpl(user.getUserName(),user.getPassword(), "7011682342", LocalDate.now(), user.getUserId());
			    		  customerUserInterface(customerService);
			    	  }
			    	  
	               }
			        break;
			      
			      
			      
		case "3":   if(userService.signOut(user)) {
			
			       System.out.println("Successfully Logged out\n\n");
	              	}
		
			     break;
			     
		case "4": System.out.println("EXIT!! \n");
		          return;
		          
		default:  System.out.println("\t\t\t INVALID OPERATION");         
		   }
	   }
		
	}	
		
	/* It is user interface for admin*/
		
		public  void adminUserInterface(AdminService adminService) {
			
			 Integer theaterId;
			 Integer movieId;
			 Integer screenId;
			 Long showId;
		     Statement statement=Database.getInstance().getStatement();
			
			System.out.println("\t\t\t\t\t\"HELLO ADMIN !!\"");
			

			while(true) {
				System.out.println("\n\t\t\t<Which Operation Do You Want To Perform Today?> \n 1.ADD THEATER \n 2.DELETE THEATER \n "
						+ "3.ADD MOVIE \n 4.DELETE MOVIE \n 5.ADD SCREEN \n 6.DELETE SCREEN \n 7.ADD SHOW \n 8.DELETE SHOW \n 9.PRINT DETAILS \n "
						+ "10.EXIT");
				String choice=InputSystem.getInput();
				switch(choice) {
				case "1": 
					      System.out.println("\t\t\t[ENTER MANAGER NAME]");
				          String managerName=InputSystem.getInput();
				          System.out.println("\t\t\t[ENTER MANAGER CONTACT INFO]");
				          String managerContact=InputSystem.getInput();
				          System.out.println("\t\t\t[ENTER THEATER NAME]");
				          String theaterName=InputSystem.getInput();
				          System.out.println("\t\t\t[ENTER THEATER CITY]");
				          String theaterCity=InputSystem.getInput();
					      Theater theater=new Theater(managerName, managerContact, theaterName, theaterCity);
					      try {
					    	 
								statement.execute("insert into THEATER03 values('"+theater.getTheaterId()+"','"+managerName+"','"+managerContact+"','"+theaterName+"','"+theaterCity+"')");
					      } catch (SQLException e) {
								e.printStackTrace();
							}
					      adminService.addTheater(theater);
					      break;
				case "2":
					     System.out.println("\t\t\t[ENTER ID OF THEATER FOR SUCCESSFULL DELETION]");
					     Database.getInstance().displayIds();
					     theaterId=Integer.parseInt(InputSystem.getInput());
					     adminService.deleteTheater(theaterId);
					try {
						statement.execute("delete from THEATER03 where theaterId="+theaterId);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					     break;
					 
				case "3":
					  System.out.println("\t\t\t[ENTER MOVIE NAME]");
					  String movieName=InputSystem.getInput();
					  System.out.println("\t\t\t[ENTER MOVIE DIRECTOR]");
					  String movieDirector=InputSystem.getInput();
					  System.out.println("\t\t\t[ENTER MOVIE GENRE]");
					  String movieGenre=InputSystem.getInput();
			          System.out.println("\t\t\t[ENTER MOVIE LENGTH]");
			          Integer movieLength=Integer.parseInt(InputSystem.getInput());
			          System.out.println("\t\t\t[ENTER MOVIE RELEASE DATE]");
			          LocalDate movieReleaseDate=LocalDateTimeConverter.getLocalDate(InputSystem.getInput());
			          System.out.println("\t\t\t[ENTER LANGUAGES OF MOVIE]");
			          String language=InputSystem.getInput();
			          String[] languages=language.split(",");
			          System.out.println("\t\t\t[ENTER THEATER ID]");
			          Database.getInstance().displayIds();
			          theaterId=Integer.parseInt(InputSystem.getInput());
			          Movie movie=new Movie(theaterId, movieLength, movieName, movieDirector, movieGenre, movieReleaseDate, languages);
			         try {
						statement.execute("insert into MOVIE03 values("+movie.getMovieId()+","+theaterId+","+movieLength+
								 ",'"+movieName+"','"+movieDirector+"','"+movieGenre+"','"+movieReleaseDate.toString()
								 +"','"+language+"')");
					} catch (SQLException e) {
						e.printStackTrace();
					}
			          adminService.addMovie(movie);
				      break;
				case "4":
					 System.out.println("\t\t\t[ENTER ID OF MOVIE FOR SUCCESSFULL DELETION]");
					 Database.getInstance().displayIds();
				     movieId=Integer.parseInt(InputSystem.getInput());
				     adminService.deleteMovie(movieId);
				     try {
						statement.execute("delete from MOVIE03 where movieId="+movieId);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				     break;
				case "5":
					  System.out.println("\t\t\t[ENTER SCREEN NAME]");
					  String screenName=InputSystem.getInput();
			          System.out.println("\t\t\t[ENTER THEATER ID]");
			          Database.getInstance().displayIds();
			          theaterId=Integer.parseInt(InputSystem.getInput());
			          Screen screen=new Screen(theaterId, screenName);
				       try {
							statement.execute("insert into SCREEN03 values('"+screen.getScreenId()+"','"+theaterId+"','"+screenName+"')");
				      } catch (SQLException e) {
							e.printStackTrace();
						}
				      adminService.addScreen(screen);
				      break;
				case "6":
					 System.out.println("\t\t\t[ENTER ID OF SCREEN FOR SUCCESSFULL DELETION]");
					 Database.getInstance().displayIds();
				     screenId=Integer.parseInt(InputSystem.getInput());
				     adminService.deleteScreen(screenId);
				     try {
							statement.execute("delete from SCREEN03 where screenId="+screenId);
						} catch (SQLException e) {
							e.printStackTrace();
						}
				     break;
				case "7":
					  System.out.println("\t\t\t[ENTER SHOW NAME]");
			          String showName=InputSystem.getInput();
			          LocalDateTime showStartTime=LocalDateTime.now();
			          LocalDateTime showEndTime=LocalDateTime.now();
			          Database.getInstance().displayIds();
			          System.out.println("\t\t\t[ENTER THEATER ID]");
			          theaterId=Integer.parseInt(InputSystem.getInput());
			          System.out.println("\t\t\t[ENTER SCREEN ID]");
			          screenId=Integer.parseInt(InputSystem.getInput());
			          System.out.println("\t\t\t[ENTER MOVIE ID]");
			          movieId=Integer.parseInt(InputSystem.getInput());
				      Show show=new Show(screenId,theaterId, movieId, showName, showStartTime, showEndTime);
				      try {
							statement.execute("insert into SHOW03 values('"+show.getShowId()+"','"+screenId+"','"+theaterId+"','"+movieId+"','"
				      +showName+"','"+"1:00"+"','"+"3:00"+"')");
				      } catch (SQLException e) {
							e.printStackTrace();
						}
				      adminService.addShow(show);
				      break;
				case "8":
					 System.out.println("\t\t\t[ENTER ID OF SHOW FOR SUCCESSFULL DELETION]");
					 Database.getInstance().displayIds();
				     showId=Long.parseLong(InputSystem.getInput());
				     adminService.deleteShow(showId);
				     try {
							statement.execute("delete from SHOW03 where showId="+showId);
						} catch (SQLException e) {
							e.printStackTrace();
						}
				     break;
				case "9":
					Database.getInstance().printDetails();
					break;
					
				case "10":
					System.out.println("\t\t\t\t\t\t\"FINISH\"");
					return;
				
				default:  System.out.println("\t\t\t INVALID OPERATION");	
				}
			}
		
	}
		
		/*It is user Interface for customer*/
		
		public void customerUserInterface(CustomerService customerService) {
			
			List<Theater> theaterList = null;
			Booking booking = null;
		
			
			String choice;
			System.out.println("\t\t\t\t\t\"HELLO CUSTOMER  !!\"");
			
			
			while(true) {
			try {
				
					System.out.println("\n\t\t\t<Which Operation Do You Want To Perform ?> \n 1.CHOOSE CITY \n 2.BOOK MOVIE TICKET \n "
							+ "3.CANCEL MOVIE TICKET \n 4.SHOW TICKETS \n 5.SHOW SEATS STATUS \n 6.EXIT");
					 choice=InputSystem.getInput();
					switch(choice) {
					case "1":
						
						System.out.println("\t\t\t[ENTER YOUR CURRENT CITY:] ");
						System.out.println("\t\t\t--------------------------");
					    theaterList=customerService.chooseCity(InputSystem.getInput());
						for(Theater theater:theaterList) {
							System.out.println(theater.getTheaterName()+"->");
							for(Movie movie:theater.getMovies()) {
								System.out.println("\t"+movie.getMovieName());
							}
							
							
						}
						break;
					case "2":
							List<Show> resultForShows=new ArrayList<Show>();
							if(theaterList!=null) {
							System.out.println("\t\t\t[ENTER MOVIE YOU WANNA WATCH:] ");
							System.out.println("\t\t\t------------------------------");
							String input=InputSystem.getInput();				                 
							for(Theater theater:theaterList) {
								for(Screen screen:theater.getListOfScreens()) {
									
									ScreenDao screenDao=new ScreenDaoImpl(screen);
									Show show=screenDao.searchShow(input);
									if(show!=null) {
										resultForShows.add(show);
										}	
								}
							 }
							if(resultForShows.isEmpty()) {
								System.out.println("\t\t\t+NO INFORMATION REGARDING THIS MOVIE+\n");
							}
							else {
								System.out.println("\t\t\t<Results for Shows are as follows:>\n");
								System.out.println("  |^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|");
								int s_no=1;
								for(Show show:resultForShows) {
									System.out.println(s_no+".|^showId:"+show.getShowId()+"  :  showName:"+show.getShowName()+"  :    movieName:"+show.getMovieDetail().getMovieName()+"\t\t\t\t^|\n"
											+"  |^showStartTime:"+show.getShowStartTime()+"  :  showEndTime:"+show.getShowEndTime()+"\t^|");
									System.out.println("  |^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|");
								    s_no++;
								}
								
								System.out.println("\n\t\t\t[ENTER SERIAL NO. OF SHOW FOR BOOKING?]");
							    choice=InputSystem.getInput();
								s_no=1;
								for(Show show:resultForShows) {
									if(choice.equals(Integer.toString(s_no))) {
										if(customerService.bookMovieTicket(show)) {
											System.out.println("\t\t\t\"BOOKING SUCCESSFULLY DONE\"\n");
										}
									}
									s_no++;
								}
							  }
							}
						
							
						
						break;
					case "3":
						        customerService.getBookingService().showTicket();
								System.out.println("\t\t\t[ENTER SERIAL NO OF TICKET YOU WANT TO CANCEL]");
								int input=Integer.parseInt(InputSystem.getInput());
								int s_no=1;
								booking=customerService.getCustomer().getBooking();
								for(Ticket ticket:booking.getMyTickets()) {
									if(s_no==input) {
									customerService.cancelMovieTicket(ticket);
									}
								s_no++;
								}
						break;
					case "4":
						customerService.getBookingService().showTicket();
						break;
					case "5":
						
						booking=customerService.getCustomer().getBooking();
						Show show=booking.getShowRef();
						ShowService showService=new ShowServiceImpl(show);
						showService.showSeatStatus();
						break;
					case "6":
						System.out.println("\t\t\t\t\t\"EXIT\"");
						return;
						
					default:  System.out.println("\t\t\t INVALID OPERATION");
					}
				}catch(NullPointerException e) {
					System.out.println("\t\t\t\"INVALID FLOW OF PROCEEDING\"");
				}
			}
			
		}
	
}
