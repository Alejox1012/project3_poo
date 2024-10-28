package com.miapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Movie {
    private String title;
    private String genre; // Cambié "gender" a "genre"
    public int releaseYear;
    private boolean isAvailable;
    private static List<Movie> movieList = new ArrayList<>();
    private static int movieCodeCounter = 1000; // Starting code for movies
    private final String movieCode; // Unique code for each movie

    public Movie(String title, String genre, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.isAvailable = true; // By default, the movie is available
        this.movieCode = String.valueOf(movieCodeCounter++); // Convert int to String
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Método abstracto para obtener detalles de la película
    public abstract String getDetails();

    // Método abstracto para obtener el precio de renta
    public abstract double getRentalPrice();

    // Método para obtener el código de la película
    public String getMovieCode() {
        return movieCode; // Ahora retorna un String
    }
    
    

    public static void saveMovie(Movie movie) {
        movieList.add(movie);
        System.out.println("Movie saved: " + movie.title);
    }

    public static void deleteMovie(String movieCode) {
        movieList.removeIf(movie -> movie.getMovieCode().equals(movieCode)); // Comparar como String
        System.out.println("Movie deleted with code: " + movieCode);
    }

    public LocalDate reserveMovie() {
        if (isAvailable) {
            isAvailable = false; // Mark the movie as unavailable
            LocalDate today = LocalDate.now();
            LocalDate returnDate = today.plusDays(10); // Reserve for 10 business days
            System.out.println("Movie reserved: " + title + ", return by: " + returnDate);
            return returnDate;
        } else {
            System.out.println("Movie not available for reservation: " + title);
            return null;
        }
    }
    
    
    
    
}
