package com.cpg.movieticketbooking.dao;

import com.cpg.movieticketbooking.beans.Show;

public interface ScreenDao {

	  Show searchShow(String movie);
		 
		void removeShow(Show show);
	
}
