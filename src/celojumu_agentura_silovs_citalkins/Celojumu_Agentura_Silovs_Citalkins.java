/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package celojumu_agentura_silovs_citalkins;
import db.DatabaseManager;
import gui.LoginDialog;

/**
 *
 * @author Danils.Silovs
 */

public class Celojumu_Agentura_Silovs_Citalkins {

    public static void main(String[] args) {
        // 1. Inicializē datubāzi
        DatabaseManager.testConnection();

        // 2. Palaid GUI
        java.awt.EventQueue.invokeLater(() -> {
            new LoginDialog().setVisible(true);
        });
    }
}
