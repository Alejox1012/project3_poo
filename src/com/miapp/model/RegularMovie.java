package com.miapp.model;

public class RegularMovie extends Movie {
    private double rentalPrice;

    public RegularMovie(String title, String genre, int releaseYear, double rentalPrice) {
        super(title, genre, releaseYear);
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String getDetails() {
        return "Regular Movie: " + getTitle() + " (" + getReleaseYear() + "), Genre: " + getGenre() + ", Rental Price: $" + rentalPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }
    
    public String getMovieCode() {
        return "reg" + super.getMovieCode(); // Prefijo "reg" seguido del código
    }
}
