package org.example.igrapogadjanjabrojeva.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.igrapogadjanjabrojeva.database.UpdateUser;

import java.util.Objects;

/**
 * Klasa za prikazivanje scene za menjanje postojećeg igrača.
 * Omogućava korisniku da unese id i novo ime igraču kome želi da promeni ime iz baze podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 *
 */
public class UpdateUserScene {
    private Scene scene;

    /**
     * Konstruktor klase UpdateUserScene koji prikazuje scenu za menjanje igrača.
     *
     * @param window - glavni Stage.
     * @param goBackCallBack - funckija za vraćanje na prethodnu scenu. Početnu scenu.
     */
    public UpdateUserScene(Stage window, Runnable goBackCallBack){
        Label idLabel = new Label("Unesite ID igrača:");
        TextField idInput = new TextField();

        Label nameLabel = new Label("Unesite novo ime:");
        TextField nameInput = new TextField();

        Button updateButton = new Button("Sačuvaj promene");
        Label messageLabel = new Label();

        Button backButton = new Button("Nazad");
        backButton.setOnAction(e-> goBackCallBack.run());

        /**
         * Postavljanje akcije za promenu igrača iz baze podataka.
         */
        updateButton.setOnAction(e -> {
            String playerId = idInput.getText();
            String newName = nameInput.getText();

            if (playerId.isEmpty() || newName.isEmpty()) {
                messageLabel.setText("Polja ne mogu biti prazna!");
                return;
            }
            if(newName.length() < 3){
                messageLabel.setText("Dužina imena mora biti minimum 3 karaktera!");
                return;
            }

            UpdateUser.updatePlayerNameById(playerId, newName, messageLabel);
        });

        VBox layout = new VBox(10, idLabel, idInput, nameLabel, nameInput, updateButton, messageLabel, backButton);
        scene = new Scene(layout, 500, 500);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());
    }


    /**
     * Vraća UpdateUserScene scenu.
     *
     * @return Scene - UpdateUserScene scena.
     */
    public Scene getScene(){
        return this.scene;
    }
}
