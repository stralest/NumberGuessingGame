package org.example.igrapogadjanjabrojeva.model;

import java.util.Random;

/**
 * Klasa predstavlja igru pogađanja brojeva.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class Game {
    private Random rand = new Random();
    private int secretNumber;
    private int attempts;

    /**Prazan konsturktor klase Game.*/
    public Game(){
    }

    /**
     * Vraca tajni broj.
     *
     * @return int - tajni broj.
     */
    public int getSecretNumber() {
        return secretNumber;
    }

    /**
     * Vraca broj pokušaja.
     *
     * @return - broj pokušaja.
     */
    public int getAttempts() {
        return this.attempts;
    }

    /** Povećava broj pokušaja za 1.*/
    public void incrementAttepmts(){
        this.attempts++;
    }

    /** Generiše tajni broj izmedju 0 i 100.*/
    public void generateSeceretNumber(){
        this.secretNumber = rand.nextInt(100) + 1;
    }

    /** Resetuje igru generisanjem novog tajnog broja i vraćanjem broja pokušaja na 0.*/
    public void resetGame(){
        secretNumber = rand.nextInt(100) + 1;
        System.out.println(secretNumber + " Reset metoda");
        attempts = 0;
    }
}
