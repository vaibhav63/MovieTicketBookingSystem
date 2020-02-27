package com.cpg.movieticketbooking.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class LocalDateTimeConverter {

public static LocalDate getLocalDate(String day) {
		
		SimpleDateFormat sdf=null;
		Date date=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
		try {
			date=sdf.parse(day);
	     }catch(ParseException e) {
	    	 e.printStackTrace();
	     }
		ZoneId defaultId=ZoneId.systemDefault();
		Instant instant=date.toInstant();
		LocalDate localDate=instant.atZone(defaultId).toLocalDate();
		return localDate;
	}
	
}
