package org.example.igrapogadjanjabrojeva.model;

/**
 * Klasa za čuvanje rezultata igre.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class GameResult {
    private int id;
    private String playerName;
    private int attempts;
    private String date;

    /**
     * Konstruktor klase GameResuklt.
     *
     * @param id - id igrača.
     * @param playerName - ime igrača.
     * @param attempts - broj pokušaja.
     * @param date - datum.
     */
    public GameResult(int id, String playerName, int attempts, String date) {
        this.id = id;
        this.playerName = playerName;
        this.attempts = attempts;
        this.date = date;
    }

    /**
     * Vraća id igrača.
     *
     * @return int - id igrača.
     */
    public int getId(){return id;}


    /**
     * Vraća ime igrača.
     *
     * @return String - ime igrača.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Vraća broj pokušaja.
     *
     * @return int - broj pokušaja.
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * Vraća vreme pogotka.
     *
     * @return String - vreme pogotka.
     */
    public String getDate() {
        return date;
    }
}
