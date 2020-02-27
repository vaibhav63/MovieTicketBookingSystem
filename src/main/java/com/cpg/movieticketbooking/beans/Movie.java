package com.cpg.movieticketbooking.beans;

import java.time.LocalDate;
import java.util.Random;

public class Movie {

	private Integer movieId;
	private Integer movieLength;
	private Integer theaterId;
	private String movieName;
	private String movieDirector;
	private String movieGenre;
	private LocalDate movieReleaseDate;
	private String[] languages;
	
	public Movie( Integer theaterId,Integer movieLength, String movieName, String movieDirector, String movieGenre,
			LocalDate movieReleaseDate, String[] languages) {
		
		this.theaterId=theaterId;
		this.movieId = movieIdGenerator();
		this.movieLength = movieLength;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.languages = languages;
	}
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}
	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	public Integer movieIdGenerator() {
		return 3000+new Random().nextInt(1000);
	}
	
}
