/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import db.DatabaseManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Danils.Silovs
 */
public class MaksajumsDAO {
    public List<String> getVisiMaksajumi() {
        List<String> saraksts = new ArrayList<>();
        String sql = "SELECT * FROM MAKSAJUMS";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String info = "ID: " + rs.getInt("id") + 
                              ", Rezervācija ID: " + rs.getInt("rezervacija_id") + 
                              ", Summa: " + rs.getDouble("summa") + " EUR" +
                              ", Statuss: " + rs.getString("statuss");
                saraksts.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saraksts;
    }
}
