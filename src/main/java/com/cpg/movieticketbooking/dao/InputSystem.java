package com.cpg.movieticketbooking.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputSystem {

	public static String getInput() {
		
		String input=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			input=br.readLine();
			return input;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return input;
	}
	
}
