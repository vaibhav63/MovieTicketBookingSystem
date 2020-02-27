package com.cpg.movieticketbooking.service;

import com.cpg.movieticketbooking.beans.User;

public interface UserService {

    User registerNewUser();
	
	Boolean signIn(String userName,String password);
	
	Boolean signOut(User user);
	
	User getUser();
	
}
