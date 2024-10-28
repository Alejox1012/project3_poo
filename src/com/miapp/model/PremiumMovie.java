package com.miapp.model;

public class PremiumMovie extends Movie {
    private double rentalPrice;
    private double premiumFee;

    public PremiumMovie(String title, String genre, int releaseYear, double rentalPrice, double premiumFee) {
        super(title, genre, releaseYear);
        this.rentalPrice = rentalPrice;
        this.premiumFee = premiumFee;
    }

    @Override
    public String getDetails() {
        return "Premium Movie: " + getTitle() + " (" + getReleaseYear() + "), Genre: " + getGenre() + 
               ", Rental Price: $" + rentalPrice + ", Premium Fee: $" + premiumFee;
    }

    public double getTotalPrice() {
        return rentalPrice + premiumFee;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }
    
    @Override
    public String getMovieCode() {
        return "prm" + super.getMovieCode(); // Prefijo "prm" seguido del código
    }
}

