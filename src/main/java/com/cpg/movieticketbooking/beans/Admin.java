package com.cpg.movieticketbooking.beans;

import java.time.LocalDate;

	public class Admin {
		private String adminName;
		private String adminPassword;
		private String adminContact;
		private LocalDate dateOfBirth;
		private Integer  adminId ;
		
		
		public Admin(String adminName, String adminPassword, String adminContact, LocalDate dateOfBirth,
				Integer adminId) {
			
			
			this.adminName = adminName;
			this.adminPassword = adminPassword;
			this.adminContact = adminContact;
			this.dateOfBirth = dateOfBirth;
			this.adminId = adminId;
			
		}
		

		
		public String getAdminName() {
			return adminName;
		}


		public String getAdminPassword() {
			return adminPassword;
		}


		public String getAdminContact() {
			return adminContact;
		}


		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}


		public Integer getAdminId() {
			return adminId;
		}


		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}


		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}


		public void setAdminContact(String adminContact) {
			this.adminContact = adminContact;
		}


		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}


		public void setAdminId(Integer adminId) {
			this.adminId = adminId;
		}
	}

	

