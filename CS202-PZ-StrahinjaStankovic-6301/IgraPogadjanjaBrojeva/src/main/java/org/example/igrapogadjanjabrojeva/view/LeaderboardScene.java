package org.example.igrapogadjanjabrojeva.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.igrapogadjanjabrojeva.database.GetUsers;
import org.example.igrapogadjanjabrojeva.model.GameResult;
import java.util.List;

/**
 * Klasa za prikazivanje scene za prikaz svih igrača.
 *
 * @author StrahijnaStanković
 * @version 1.0
 */
public class LeaderboardScene {
    private Stage window;
    private Scene scene;

    /**
     * Konstuktor klase LeaderboardScene koji prikazuje scenu za prikaz svih igrača iz baze podataka.
     *
     * @param window - glavni stage.
     * @param goBackCallback - funkcija za vraćanje na prethodnu scenu. Početnu scenu.
     */
    public LeaderboardScene(Stage window, Runnable goBackCallback) {
        this.window = window;
        TableView<GameResult> table = new TableView<>();

        TableColumn<GameResult, Integer> idColumn = new TableColumn<>("Id igrača");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<GameResult, String> nameColumn = new TableColumn<>("Ime Igrača");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<GameResult, Integer> attemptsColumn = new TableColumn<>("Broj pokušaja");
        attemptsColumn.setCellValueFactory(new PropertyValueFactory<>("attempts"));

        TableColumn<GameResult, String> dateColumn = new TableColumn<>("Datum");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.getColumns().addAll(idColumn,nameColumn, attemptsColumn, dateColumn);
        table.setItems(loadResults());


        Button backButton = new Button("Nazad");
        /**
         * Postavljanje akcije za povratak na početnu scenu.
         */
        backButton.setOnAction(e -> goBackCallback.run());

        VBox layout = new VBox(10, table, backButton);
        scene = new Scene(layout, 500, 500);


    }

    /**
     * Vraća listu svih igraca.
     *
     * @return - ObservableList - lista svih igrača.
     */
    private ObservableList<GameResult> loadResults() {
        GetUsers dao = new GetUsers();
        List<GameResult> results = dao.getAllResults();
        return FXCollections.observableArrayList(results);
    }


    /**
     * Vraća LeaderboardScene scenu.
     *
     * @return Scene - LeaderboardScene scena.
     */
    public Scene getScene() {
        return scene;
    }
}