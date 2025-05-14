package org.example.igrapogadjanjabrojeva.controller;

import org.example.igrapogadjanjabrojeva.model.Game;
import org.example.igrapogadjanjabrojeva.database.SaveUser;

/**
 * Kontroler igre koji upravlja logikom igre, validacijom unosa i komunikacijom sa bazom podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class GameController  {
    private Game game;
    private String playerName;

    /**
     *
     * @param game Instanca igre.
     * @param playerName Ime igrača.
     */
    public GameController(Game game, String playerName) {
        this.game = game;
        this.playerName = playerName;
        this.game.generateSeceretNumber();
    }

    /**
     *
     * @param guess Broj koji je korisnik uneo.
     * @return String - poruka sa rezultatom provere.
     * @throws IndexOutOfBoundsException ako broj nije u opsegu od 0 do 100.
     */
    public String checkGuess(int guess) throws  IndexOutOfBoundsException{
        incrementAttepmts();

        if(guess < game.getSecretNumber() && guess >= 0 && guess <= 100){
            return "Broj je veći!";
        }
        else if(guess > game.getSecretNumber() && guess >= 0 && guess <= 100){
            return "Broj je manji!";
        }
        else if(guess == game.getSecretNumber() && guess >= 0 && guess <= 100){
            saveResult(playerName ,game.getAttempts(), "Pogodio broj!");
            return "Pogodili ste broj!";
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     *
     * @param playerName Ime igrača.
     * @param attempts broj pokušaja.
     * @param gameResult rezultat igre.
     */
    public void saveResult(String playerName, int attempts, String gameResult) {
        SaveUser.saveGameResult(playerName, attempts, gameResult);
    }

    /**
     * Resetuje igru.
     */
    public void resetGame() {
        game.resetGame();

    }

    /**
     * Generiše novi tajni broj.
     */
    public void generateSecretNumber(){
        game.generateSeceretNumber();
    }

    /**
     * Vraća tajni broj.
     *
     * @return int - tajni broj.
     */
    public int getSecretNumber(){
        return game.getSecretNumber();
    }

    /**
     * Povećava broj pokušaja za 1;
     */
    public void incrementAttepmts(){
        game.incrementAttepmts();
    }

    /**
     * Vraća broj pokušaja.
     *
     * @return - int Broj pokušaja.
     */
    public int getAttempts(){
        return game.getAttempts();
    }
}
