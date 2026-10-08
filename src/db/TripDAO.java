/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import model.Trip;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Danils.Silovs
 */
public class TripDAO {
    public List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();
        String sql = "SELECT * FROM TRIP ORDER BY start_date ASC";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                trips.add(new Trip(
                    rs.getInt("trip_id"),
                    rs.getString("title"),
                    rs.getString("destination"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getInt("available_seats")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }

    public boolean addTrip(Trip trip) {
        String sql = "INSERT INTO TRIP (title, destination, description, price, start_date, end_date, available_seats) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, trip.getTitle());
            pstmt.setString(2, trip.getDestination());
            pstmt.setString(3, trip.getDescription());
            pstmt.setDouble(4, trip.getPrice());
            pstmt.setDate(5, trip.getStartDate());
            pstmt.setDate(6, trip.getEndDate());
            pstmt.setInt(7, trip.getAvailableSeats());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTrip(int tripId) {
        String sql = "DELETE FROM TRIP WHERE trip_id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tripId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
