package com.cpg.movieticketbooking.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.cpg.movieticketbooking.beans.User;
import com.cpg.movieticketbooking.dao.InputSystem;
import com.cpg.movieticketbooking.exception.NoSuchUserException;
import com.cpg.movieticketbooking.exception.SignInException;
import com.cpg.movieticketbooking.exception.SignOutException;



public class UserServiceImpl implements UserService{

	private User user=new User();
	private File file=new File("ValidationList.txt");
	private  boolean isSignedIn=false;
	
	public User registerNewUser() {
		
		System.out.println("ENTER USER_TYPE");
		user.setUserType(InputSystem.getInput());
		System.out.println("ENTER YOUR USER-NAME");
		user.setUserName(InputSystem.getInput());
		System.out.println("ENTER YOUR PASSWORD");
		user.setPassword(InputSystem.getInput());
		
		
		if(user.getUserName().equals("") || user.getPassword().equals("") || !(user.getUserType().equalsIgnoreCase("admin")) && !(user.getUserType().equalsIgnoreCase("customer")) ) {
		
			try {
				throw new NoSuchUserException("\t\t\t\"You need to fill all the fields correctly for completing registration successfully!!\"");
			}catch(NoSuchUserException e) {
				System.out.println(e.getMessage());
			}
		}else {
			
			if(user.getUserType().equalsIgnoreCase("admin")) {
				
				 user.setUserId(1000+new Random().nextInt(1000));
				
			}else if(user.getUserType().equalsIgnoreCase("customer")) {
				
				user.setUserId(100000+new Random().nextInt(1000000));
				
			}
			
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
			
			  try( BufferedWriter bw=new BufferedWriter(new FileWriter(file,true))){
				  
				  bw.write(user.getUserId()+","+user.getUserType()+","+user.getUserName()+","+user.getPassword());
				  bw.newLine();
				  
			  } catch (IOException e) {
				
				e.printStackTrace();
			}
			  return user;
		}
		
		
		  return null;
		  
		  
	}

	public Boolean signIn(String userName, String password) {
		
		
		if(!userName.equals("") && !password.equals("")) {
			
			if(!isSignedIn) {
				 try(BufferedReader br=new BufferedReader(new FileReader(file))){
						
						String input;
						
						while((input=br.readLine())!=null) {
							
							String[] str_array=input.split(",");
							
							if(userName.equals(str_array[2]) && password.equals(str_array[3])) {
								
								user.setUserName(userName);
								user.setPassword(password);
								user.setUserId(Integer.parseInt(str_array[0]));
								user.setUserType(str_array[1]);
								isSignedIn=true;		
								return isSignedIn;
							}
							
						}
					
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}catch(ArrayIndexOutOfBoundsException e) {
						e.getMessage();
					}
				 
				 
				 System.out.println("\t\t\t<Incorrect USERNAME & PASSWORD>\n\t\t\t\tTRY AGAIN!!\n");
					
			}	else {
				try {
					throw new SignInException("\t\t\t\"You Haven't Logged Out from previous session \"");
				}catch(SignInException e) {
					System.out.println(e.getMessage());
				}
			}
			return isSignedIn;
			
		}
		
		System.out.println("\t\t\t\"You need to fill all the details CORRECTLY \"");
		return false;
		
	}

	public Boolean signOut(User user) {
		
		if(isSignedIn) {
			user=new User();
			isSignedIn=false;
			return !isSignedIn;
		}
		else {
			try {
			throw new SignOutException("\t\t\t\"You Haven't Logged In Yet\"");
			}catch(SignOutException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return isSignedIn;
	}
	
	public User getUser() {
		return user;
	}

	
}
