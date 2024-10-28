package com.miapp.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Represents a rental invoice for a client.
 */
public class Invoice {
   private String clientName;
    private Movie movie1, movie2, movie3;
    private LocalDate returnDate;
    private boolean hasMembership;
    private double totalPrice;

   public Invoice(LocalDate returnDate, String clientName, Movie movie1, Movie movie2, Movie movie3, boolean hasMembership) {
    this.clientName = clientName;
    this.movie1 = movie1;
    this.movie2 = movie2;
    this.movie3 = movie3;
    this.returnDate = returnDate;
    this.hasMembership = hasMembership; // Asegúrate de pasar este parámetro
    this.totalPrice = calculateTotalPrice(); // Calcula el precio total
}

    // Método que calcula el precio total de la factura
    private double calculateTotalPrice() {
        double price = 0;
        if (movie1 != null) price += movie1.getRentalPrice();
        if (movie2 != null) price += movie2.getRentalPrice();
        if (movie3 != null) price += movie3.getRentalPrice();
        
        if (hasMembership) {
            price *= 0.9; // Aplica descuento del 10% si el cliente tiene membresía
        }
        return price;
    }

    // Método para obtener el precio total
    public double getTotalPrice() {
        return totalPrice;
    }

    // Método para generar y guardar la factura en un archivo
    public String generateInvoiceFile() {
        String filePath = "Invoice_" + UUID.randomUUID() + ".txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Factura de Renta\n");
            writer.write("=================\n");
            writer.write("Nombre del Cliente: " + clientName + "\n");
            writer.write("Películas Rentadas:\n");

            if (movie1 != null) writer.write("- " + movie1.getTitle() + "\n");
            if (movie2 != null) writer.write("- " + movie2.getTitle() + "\n");
            if (movie3 != null) writer.write("- " + movie3.getTitle() + "\n");

            writer.write("Fecha de Devolución: " + returnDate.format(formatter) + "\n");
            writer.write("Precio Total: $" + totalPrice + "\n");

            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder invoiceDetails = new StringBuilder();
        invoiceDetails.append("Invoice Details:\n")
                      .append("Client: ").append(clientName).append("\n")
                      .append("Movies Rented:\n");

        // Add movie details to the invoice if they are selected
        appendMovieDetails(invoiceDetails, movie1);
        appendMovieDetails(invoiceDetails, movie2);
        appendMovieDetails(invoiceDetails, movie3);

        // Add total price and return date to the invoice
        invoiceDetails.append("Total Price: ").append(String.format("%.2f", totalPrice)).append(" COP\n")
                      .append("Return Date: ").append(returnDate).append("\n");

        return invoiceDetails.toString();
    }

    /**
     * Appends movie details to the invoice string.
     *
     * @param invoiceDetails The StringBuilder to append to.
     * @param movie         The movie to check.
     */
    private void appendMovieDetails(StringBuilder invoiceDetails, Movie movie) {
        if (movie != null) {
            invoiceDetails.append("- ").append(movie.getTitle()).append("\n");
        }
    }

    // Getters and Setters
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Movie getMovie1() {
        return movie1;
    }

    public void setMovie1(Movie movie1) {
        this.movie1 = movie1;
        this.totalPrice = calculateTotalPrice(); // Recalculate total price when movie1 changes
    }

    public Movie getMovie2() {
        return movie2;
    }

    public void setMovie2(Movie movie2) {
        this.movie2 = movie2;
        this.totalPrice = calculateTotalPrice(); // Recalculate total price when movie2 changes
    }

    public Movie getMovie3() {
        return movie3;
    }

    public void setMovie3(Movie movie3) {
        this.movie3 = movie3;
        this.totalPrice = calculateTotalPrice(); // Recalculate total price when movie3 changes
    }

    public double getRentalPrice() {
        return totalPrice;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
