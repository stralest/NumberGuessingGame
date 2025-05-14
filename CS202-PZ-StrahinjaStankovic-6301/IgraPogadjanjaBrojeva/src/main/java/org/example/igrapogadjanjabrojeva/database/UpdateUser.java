package org.example.igrapogadjanjabrojeva.database;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Klasa za menjanje postojećeg igrača iz baze podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class UpdateUser {

    /**
     * Menja postojećeg igrača iz baze podataka.
     *
     * @param playerId - id igrača
     * @param newName - novo ime
     * @param messageLabel - poruka za uspešnu/neušpenu promenu.
     */
    public static void updatePlayerNameById(String playerId, String newName, Label messageLabel) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String updateQuery = "UPDATE results SET player_name = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, newName);
            stmt.setString(2, playerId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                messageLabel.setText("Ime uspešno ažurirano!");
            } else {
                messageLabel.setText("Nema igrača sa tim ID-om!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Greška pri ažuriranju!");
        }
    }
}