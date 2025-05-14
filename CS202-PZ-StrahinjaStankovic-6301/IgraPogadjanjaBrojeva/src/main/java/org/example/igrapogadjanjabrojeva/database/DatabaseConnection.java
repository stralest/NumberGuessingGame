package org.example.igrapogadjanjabrojeva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klasa za uspostavljanje konekcije sa bazom podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class DatabaseConnection {
    /** URL baze podataka */
    private static final String URL = "jdbc:mysql://localhost:3306/igra_pogadjanja_brojeva";

    /**Korisničko ime za pristup bazi podataka.*/
    private static final String USER = "root";

    /**Šifra za pristup bazi podataka.*/
    private static final String PASSWORD = "lormdoep019";

    /**
     *
     * @return Connection - objekat konekcije sa bazom.
     * @throws SQLException ako ne uspe povezivanje sa bazom podataka.
     */
    public static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException ex) {
            System.out.println("Greška pri povezivanju sa bazom: " + ex.getMessage());
            throw ex;
        }
    }
}
