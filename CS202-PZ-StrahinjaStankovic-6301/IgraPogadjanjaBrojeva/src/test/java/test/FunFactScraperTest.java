package test;

import org.example.igrapogadjanjabrojeva.utils.FunFactScraper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class FunFactScraperTest {

    @Test
    void testFetchFunFact() {
        String fact = FunFactScraper.getRandomFact();
        assertNotNull(fact, "Fun fact ne bi smeo biti null!");
        assertFalse(fact.isEmpty(), "Fun fact ne bi smeo biti prazan!");
    }
}
