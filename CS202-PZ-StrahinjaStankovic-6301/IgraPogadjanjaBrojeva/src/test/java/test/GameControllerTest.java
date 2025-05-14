package test;

import org.example.igrapogadjanjabrojeva.controller.GameController;
import org.example.igrapogadjanjabrojeva.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {
    private Game game;
    private GameController controller;

    @BeforeEach
    void setUp(){
        game = new Game();
        controller = new GameController(game, "Test igrac");
        controller.generateSecretNumber();
    }

    @Test
    void lowerNumberTest(){
        int secretNumber = controller.getSecretNumber();
        String guess = controller.checkGuess(secretNumber - 1);
        assertEquals(guess, "Broj je veći!");
    }

    @Test
    void higherNumberTest(){
        int secretNumber = controller.getSecretNumber();
        String guess = controller.checkGuess(secretNumber + 1);
        assertEquals(guess, "Broj je manji!");
    }

    @Test
    void correctNumberTest(){
        int secretNumber = controller.getSecretNumber();
        String guess = controller.checkGuess(secretNumber);
        assertEquals(guess, "Pogodili ste broj!");
    }




}
