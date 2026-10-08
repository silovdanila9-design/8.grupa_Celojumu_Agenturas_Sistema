/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Danils.Silovs
 */
public class DatabaseManager {
    private static final String URL = "jdbc:derby://localhost:1527/traveldb";
    private static final String USER = "traveldb";
    private static final String PASSWORD = "traveldb";
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Kļūda ielādējot Java DB Client draiveri: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Veiksmīgi izveidots savienojums ar Services datubāzi 'traveldb'!");
            }
        } catch (SQLException e) {
            System.err.println("Neizdevās savienoties ar datubāzi! Pārliecinieties, vai Java DB Serveris ir palaists Services cilnē.");
            e.printStackTrace();
        }
    }
}
