/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.*;
/**
 *
 * @author Danils.Silovs
 */
public class ReservationDAO {
    public boolean createReservation(int userId, int tripId, int seats, double totalPrice) {
        String insertSql = "INSERT INTO RESERVATION (user_id, trip_id, seats_booked, total_price) VALUES (?, ?, ?, ?)";
        String updateTripSql = "UPDATE TRIP SET available_seats = available_seats - ? WHERE trip_id = ?";

        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false); // Transakcijas sākums

            try (PreparedStatement pstmt1 = conn.prepareStatement(insertSql);
                 PreparedStatement pstmt2 = conn.prepareStatement(updateTripSql)) {

                pstmt1.setInt(1, userId);
                pstmt1.setInt(2, tripId);
                pstmt1.setInt(3, seats);
                pstmt1.setDouble(4, totalPrice);
                pstmt1.executeUpdate();

                pstmt2.setInt(1, seats);
                pstmt2.setInt(2, tripId);
                pstmt2.executeUpdate();

                conn.commit(); // Apstiprina izmaiņas
                return true;
            } catch (SQLException e) {
                conn.rollback(); // Atceļ, ja rodas kļūda
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
