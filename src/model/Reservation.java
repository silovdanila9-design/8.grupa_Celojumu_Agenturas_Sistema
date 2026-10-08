/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Timestamp;
/**
 *
 * @author Danils.Silovs
 */
public class Reservation {
    private int reservationId;
    private int userId;
    private int tripId;
    private int seatsBooked;
    private double totalPrice;
    private String status;
    private Timestamp createdAt;

    public Reservation(int reservationId, int userId, int tripId, int seatsBooked, double totalPrice, String status, Timestamp createdAt) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.tripId = tripId;
        this.seatsBooked = seatsBooked;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getReservationId() { return reservationId; }
    public int getUserId() { return userId; }
    public int getTripId() { return tripId; }
    public int getSeatsBooked() { return seatsBooked; }
    public double getTotalPrice() { return totalPrice; }
    public String getStatus() { return status; }
    public Timestamp getCreatedAt() { return createdAt; }
}
