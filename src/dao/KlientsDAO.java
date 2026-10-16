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
    public boolean pievienotKlientu(Klients k) {
        String sql = "INSERT INTO KLIENTS (vards, uzvards, epasts, lietotajvards, paroles_jaucenkods) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, k.getVards());
            pstmt.setString(2, k.getUzvards());
            pstmt.setString(3, k.getEpasts());
            pstmt.setString(4, k.getLietotajvards());
            pstmt.setString(5, k.getParolesJaucenkods());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String lietotajvards, String parole) {
        String sql = "SELECT paroles_jaucenkods FROM KLIENTS WHERE lietotajvards = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, lietotajvards);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dbPassword = rs.getString("paroles_jaucenkods");
                    return dbPassword.equals(parole);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
