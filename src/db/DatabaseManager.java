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
    private static final String URL = "jdbc:derby://localhost:1527/celojums_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.apache.derby.client.ClientAutoloadedDriver");
        } catch (ClassNotFoundException e) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            } catch (ClassNotFoundException ex) {
                throw new SQLException("Derby JDBC draiveris nav atrasts!", ex);
            }
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
