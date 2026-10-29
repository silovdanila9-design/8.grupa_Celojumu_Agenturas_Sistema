/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DatabaseManager;
import model.Klients;
import java.sql.*;
/**
 *
 * @author Danils.Silovs
 */
public class KlientsDAO {

    public Klients login(String lietotajvards, String parole) {
    String sql = "SELECT * FROM KLIENTS WHERE LIETOTAJVARDS = ? AND PAROLE = ?";
    try (Connection conn = DatabaseManager.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        String hashedPassword = util.PasswordUtil.hashPassword(parole);
        
        pstmt.setString(1, lietotajvards);
        pstmt.setString(2, hashedPassword);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return new Klients(
                    rs.getInt("ID"),
                    rs.getString("VARDS"),
                    rs.getString("UZVARDS"),
                    rs.getString("E_PASTS"),
                    rs.getString("LIETOTAJVARDS"),
                    rs.getString("PAROLE")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

  public boolean register(Klients klients) {
    String sql = "INSERT INTO KLIENTS (VARDS, UZVARDS, E_PASTS, LIETOTAJVARDS, PAROLE) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = DatabaseManager.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, klients.getVards());
        pstmt.setString(2, klients.getUzvards());
        pstmt.setString(3, klients.getEpasts());
        pstmt.setString(4, klients.getLietotajvards());
        pstmt.setString(5, klients.getParole());
        
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}