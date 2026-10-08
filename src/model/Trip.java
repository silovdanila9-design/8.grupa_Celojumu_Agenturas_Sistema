/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
/**
 *
 * @author Danils.Silovs
 */
public class Trip {
    private int tripId;
    private String title;
    private String destination;
    private String description;
    private double price;
    private Date startDate;
    private Date endDate;
    private int availableSeats;

    public Trip(int tripId, String title, String destination, String description, double price, Date startDate, Date endDate, int availableSeats) {
        this.tripId = tripId;
        this.title = title;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.availableSeats = availableSeats;
    }

    public int getTripId() { return tripId; }
    public String getTitle() { return title; }
    public String getDestination() { return destination; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public int getAvailableSeats() { return availableSeats; }
}
