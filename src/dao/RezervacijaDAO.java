/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import db.DatabaseManager;
import model.Rezervacija;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Danils.Silovs
 */
public class RezervacijaDAO {
    public boolean pievienotRezervaciju(Rezervacija r) {
        String sql = "INSERT INTO REZERVACIJA (celojums_id, lietotajvards) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, r.getCelojumsId());
            pstmt.setString(2, r.getLietotajvards());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
