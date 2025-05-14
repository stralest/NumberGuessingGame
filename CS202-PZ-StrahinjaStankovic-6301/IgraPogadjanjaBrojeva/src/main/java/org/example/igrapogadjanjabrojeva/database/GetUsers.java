package org.example.igrapogadjanjabrojeva.database;

import org.example.igrapogadjanjabrojeva.model.GameResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa za vraćanje svih igrača iz baze podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class GetUsers {
    /**
     * Vraća sve igrače iz baze podataka.
     *
     * @return List - lista svih igrača
     */
    public List<GameResult> getAllResults() {
        List<GameResult> results = new ArrayList<>();
        String query = "SELECT * FROM results ORDER BY attempts ASC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String playerName = rs.getString("player_name");
                int attempts = rs.getInt("attempts");
                String timestamp = rs.getString("timestamp");

                results.add(new GameResult(id,playerName, attempts, timestamp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}