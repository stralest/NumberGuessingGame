package org.example.igrapogadjanjabrojeva.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Klasa za upisivanje igrača u bazu podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class SaveUser {
    /**
     * Upisuje igrača u bazu podataka.
     *
     * @param playerName Ime igrača.
     * @param attempts broj pokušaja.
     * @param gameResult rezultat igre.
     */
    public static void saveGameResult(String playerName, int attempts, String gameResult) {
        String query = "INSERT INTO results (player_name, attempts, game_result) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, playerName);
            stmt.setInt(2, attempts);
            stmt.setString(3, gameResult);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Greška pri čuvanju rezultata: " + e.getMessage());
        }
    }
}
