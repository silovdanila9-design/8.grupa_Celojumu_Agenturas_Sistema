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
}
