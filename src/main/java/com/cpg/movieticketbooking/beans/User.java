package com.cpg.movieticketbooking.beans;

public class User {

	private Integer userId;
	private String userName;
	private String password;
	private String userType;
	private  boolean signInStatus=false;
	
	


	public String getUserType() {
		
		return userType;
	}


	public Integer getUserId() {
		return userId;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public boolean isSignInStatus() {
		return signInStatus;
	}


	public void setSignInStatus(boolean signInStatus) {
		this.signInStatus = signInStatus;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
