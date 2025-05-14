package test;

import org.example.igrapogadjanjabrojeva.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GameTest {
    private Game game;

    @BeforeEach
    void setUp(){
        game = new Game();
        game.generateSeceretNumber();
    }

    @Test
    void testSecretNumberInRange(){
        int secretNumber = game.getSecretNumber();
        assertTrue(secretNumber >= 1 && secretNumber <= 100, "Tajni broj mora biti između 1 i 100.");
    }

    @Test
    void testIncrementAttempts(){
        game.incrementAttepmts();
        assertEquals(1, game.getAttempts(), "Broj pokusaja treba da bude 1.");
    }

    @Test
    void testResetGame(){
        game.incrementAttepmts();
        game.resetGame();
        assertEquals(0, game.getAttempts(), "Broj pokusaja nakon resetovanja treba da bude 0.");
    }
}
