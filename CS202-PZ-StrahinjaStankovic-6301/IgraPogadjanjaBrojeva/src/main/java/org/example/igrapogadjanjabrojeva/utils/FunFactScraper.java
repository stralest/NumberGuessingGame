package org.example.igrapogadjanjabrojeva.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Random;

/**
 * Klasa za skidanje podataka sa interneta koristeći Jsoup.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class FunFactScraper {
    /**
     * URL za skidanje podataka.
     */
    private static final String URL = "https://www.thefactsite.com/1000-interesting-facts/";

    /**
     * Vraća nasumićan fun fact sa URL.
     *
     * @return String - nasumičan fun fact.
     */
    public static String getRandomFact() {
        try {
            Document doc = Jsoup.connect(URL).get();

            Elements facts = doc.select(".list");

            if (!facts.isEmpty()) {
                Random rand = new Random();
                Element randomFact = facts.get(rand.nextInt(facts.size()));
                return randomFact.text();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Nije moguće pronaći fun fact. Pokušajte ponovo!";
    }
}