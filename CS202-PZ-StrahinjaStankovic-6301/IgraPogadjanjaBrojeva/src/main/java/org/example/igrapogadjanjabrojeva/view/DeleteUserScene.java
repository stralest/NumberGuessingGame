package org.example.igrapogadjanjabrojeva.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.igrapogadjanjabrojeva.database.DeleteUser;

import java.util.Objects;

/**
 * Klasa za prikaz scene za brisanje igrača.
 * Omogućava korisniku da unese id igrača i obriše ga iz baze podataka.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class DeleteUserScene {
    private Scene scene;

    /**
     * Prikazuje scenu za brisanje igrača.
     *
     * @param window - Glavni prozor aplikacije.
     * @param goBackCallback - Funkcija za povratak na prethodnu scenu.
     */
    public DeleteUserScene(Stage window, Runnable goBackCallback){
        Label idLabel = new Label("Unesite id igrača!");
        TextField playerId = new TextField();

        Label messageLabel = new Label();

        Button deletePlayerButton = new Button("Izbriši igrača!");


        /** Postavljanje akcije za brisanje igrača iz baze podataka.*/
        deletePlayerButton.setOnAction(e->{
            String id = playerId.getText();

            if(id.isEmpty()){
                messageLabel.setText("Polje ne može biti prazno!");
            }
            else{
                DeleteUser.deleteUser(id, messageLabel);
            }
        });

        Button backButton = new Button("Nazad");
        backButton.setOnAction(e-> goBackCallback.run());

        VBox layout = new VBox(10, idLabel, playerId, messageLabel, deletePlayerButton, backButton);
        scene = new Scene(layout, 500, 500);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());
    }

    /**
     * Vraća scenu za brisanje igrača.
     *
     * @return Scene - DeleteUserScene scena.
     */
    public Scene getScene(){
        return this.scene;
    }
}
