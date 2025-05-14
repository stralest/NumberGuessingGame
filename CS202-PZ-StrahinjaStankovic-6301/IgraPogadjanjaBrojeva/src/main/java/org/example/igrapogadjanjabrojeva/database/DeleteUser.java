package org.example.igrapogadjanjabrojeva.database;

import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Klasa za brisanje igrača iz baze podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class DeleteUser {
    /**
     * Brise igrača iz baze podataka.
     *
     * @param playerId id igrača.
     * @param messageLabel poruka za uspešno/neuspešno brisanje igrača.
     */
    public static void deleteUser(String playerId, Label messageLabel){
        try(Connection conn = DatabaseConnection.getConnection()){
            String deleteQuery = "DELETE FROM results WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.setString(1, playerId);

            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                messageLabel.setText("Uspešno ste izbrisali korisnika!");
            }
            else {
                messageLabel.setText("Ne postoji igrač sa tim ID!");
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            messageLabel.setText("Greška pri ažuriranju!");
        }
    }
}
