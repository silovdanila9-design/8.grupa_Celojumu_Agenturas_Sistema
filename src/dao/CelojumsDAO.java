/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import db.DatabaseManager;
import model.Celojums;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Danils.Silovs
 */
public class CelojumsDAO {
    public List<Celojums> getAllCelojumi() {
        List<Celojums> saraksts = new ArrayList<>();
        String sql = "SELECT * FROM CELOJUMS";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                saraksts.add(new Celojums(
                    rs.getInt("id"),
                    rs.getString("nosaukums"),
                    rs.getString("apraksts"),
                    rs.getDouble("cena")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saraksts;
    }
    
    public boolean atjaunotCelojumu(Celojums c) {
    String sql = "UPDATE CELOJUMS SET nosaukums = ?, apraksts = ?, cena = ? WHERE id = ?";
    try (Connection conn = DatabaseManager.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, c.getNosaukums());
        pstmt.setString(2, c.getApraksts());
        pstmt.setDouble(3, c.getCena());
        pstmt.setInt(4, c.getId());
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
}
