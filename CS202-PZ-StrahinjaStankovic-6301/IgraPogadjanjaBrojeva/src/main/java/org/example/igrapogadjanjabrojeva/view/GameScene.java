package org.example.igrapogadjanjabrojeva.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.igrapogadjanjabrojeva.MainApp;
import org.example.igrapogadjanjabrojeva.controller.GameController;
import org.example.igrapogadjanjabrojeva.utils.FunFactScraper;

/**
 * Klasa za prikaz scene igre.
 * Omogućava korisniku da pogodi skriven broj.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class GameScene {
    private Scene scene;
    private Label messageLabel;
    private Label attemptLabel;
    private TextField inputField;
    private Label Successlabel;

    /**
     * Prazan konstruktor klase GameScene.
     */
    public GameScene(){}

    /**
     * Konstruktor klase GameScene koji prikazuje scenu igre i omogućava korisniku da pogodi skriven broj.
     *
     * @param controller upravlja logikom igre.
     * @param goBackCallback - funkcija za povratak na prethodnu scenu, početnu scenu.
     */
    public GameScene(GameController controller, Runnable goBackCallback){

        inputField = new TextField();
        inputField.setPromptText("Unesite broj");

        Successlabel = new Label();
        Successlabel.setAlignment(Pos.CENTER);

        messageLabel = new Label("Pogodite broj između 1 i 100.");
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(400);
        messageLabel.setAlignment(Pos.CENTER);
        attemptLabel = new Label("Broj pokušaja: 0");

        controller.generateSecretNumber();
        System.out.println(controller.getSecretNumber());


        Button backButton = new Button("Nazad");
        /**
         * Postavljanje akcije za vraćanje na prethodnu scenu. Početnu scenu.
         */
        backButton.setOnAction(e -> {
                goBackCallback.run();
            }
        );



        Button checkButton = new Button("Proveri broj!");

        /**
         * Postavljanje akcije za poredjenje igračevog i skrivenog broja.
         */
        checkButton.setOnAction(e->{
            try{
                String emptyField = inputField.getText();

                if(emptyField.isEmpty()){
                    throw new IllegalArgumentException();
                }

                int guess = Integer.parseInt(inputField.getText());
                String funFact = FunFactScraper.getRandomFact();
                String result = controller.checkGuess(guess);
                messageLabel.setText(result);
                attemptLabel.setText("Broj pokušaja: " + controller.getAttempts());
                if(result.equals("Pogodili ste broj!")){
                    inputField.setDisable(true);
                    checkButton.setDisable(true);
                    Successlabel.setText("Pogodili ste broj!");
                    messageLabel.setText(funFact);
                }
            }
            catch(NumberFormatException ex){
                messageLabel.setText("Unesite broj!");
            }
            catch (IndexOutOfBoundsException ex){
                messageLabel.setText("Unesite broj između 0 i 100!");
            }
            catch (IllegalArgumentException ex){
                messageLabel.setText("Polje ne može biti prazno!");
            }
        });

        Button resetButton = new Button("Započni novu igru!");

        /**
         * Postavljanje akcije za resetovanje igre. Generiše se novi broj i broj pokušaja se vraća na 0.
         */
        resetButton.setOnAction(e->{
            controller.resetGame();
            inputField.setText("");
            messageLabel.setText("Pogodite broj između 1 i 100.");
            attemptLabel.setText("Broj pokušaja: 0");
            inputField.setDisable(false);
            checkButton.setDisable(false);
        });

        VBox layout = new VBox(10, Successlabel ,messageLabel, attemptLabel, inputField, checkButton, resetButton, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefWidth(400);

        scene = new Scene(layout, 700, 500);
    }

    /**
     * Vraća trenutnu scenu.
     *
     * @return Scene - GameScene scena.
     */
    public Scene getScene() {
        return scene;
    }
}
