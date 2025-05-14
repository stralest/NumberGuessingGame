package org.example.igrapogadjanjabrojeva;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.igrapogadjanjabrojeva.controller.GameController;
import org.example.igrapogadjanjabrojeva.database.DatabaseConnection;
import org.example.igrapogadjanjabrojeva.model.Game;
import org.example.igrapogadjanjabrojeva.view.DeleteUserScene;
import org.example.igrapogadjanjabrojeva.view.GameScene;
import org.example.igrapogadjanjabrojeva.view.LeaderboardScene;
import org.example.igrapogadjanjabrojeva.view.UpdateUserScene;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Glavna klasa aplikacije za igru pogađanja brojeva.
 * Ova klasa inicijalizuje JavaFX aplikaciju i omogućava korisnicima da unesu svoje ime,
 * započnu igru, pregledaju listu najboljih rezultata, ažuriraju ime ili obrišu svoj nalog.
 *
 * @author StrahinjaStanković
 * @version 1.0
 */
public class MainApp extends Application {
    private Stage window;
    private Scene startScene;
    private String playerName;

    private Runnable goBackCallback;

    /**
     * Pokreće JavaFX aplikaciju i inicijalizuje početni prozor.
     *
     * @param primaryStage Glavni prozor aplikacije.
     * @throws IOException Ako dođe do greške pri učitavanju resursa.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;

        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Konekcija sa bazom uspesna!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Label nameLabel = new Label("Unesite svoje ime:");
        TextField nameInput = new TextField();

        Button startButton = new Button("Započni igru!");
        startButton.setOnAction(e->{
            playerName = nameInput.getText();
            if(playerName.isEmpty() ){
                nameLabel.setText("Polje ne moze biti prazno!");
            }
            else if(playerName.length() < 3){
                nameLabel.setText("Ime mora imati minimum 3 karaktera!");
            }
            else {
                startGame();
            }
        });

        Button leaderboardButton = new Button("Lista najboljih rezultata");
        leaderboardButton.setOnAction(e -> showLeaderboard());

        Button updateButton = new Button("Ažuriraj ime");
        updateButton.setOnAction(e -> showUpdateScene());

        Button deleteButton = new Button("Obriši igrača!");
        deleteButton.setOnAction(e-> showDeleteScene());

        VBox startLayout = new VBox(10, nameInput, nameLabel, startButton, leaderboardButton, updateButton, deleteButton);
        startScene = new Scene(startLayout, 350, 300);
        startScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());

        window.setTitle("Igra Pogađanja Brojeva");
        window.setScene(startScene);
        window.show();

    }

    private void startGame() {
        Game game = new Game();
        GameController controller = new GameController(game, playerName);

        System.out.println("Igrač: " + playerName);

        GameScene gameScene = new GameScene(controller, this::showStartScene);
        gameScene.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());
        window.setScene(gameScene.getScene());

    }

    private void showLeaderboard() {
        LeaderboardScene leaderboardScene = new LeaderboardScene(window, this::showStartScene);
        leaderboardScene.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());
        window.setScene(leaderboardScene.getScene());
    }

    private void showStartScene() {
        window.setScene(startScene);
    }

    private void showUpdateScene() {
        UpdateUserScene updateScene = new UpdateUserScene(window, this::showStartScene);
        window.setScene(updateScene.getScene());
    }

    public void showDeleteScene(){
        DeleteUserScene deleteScene = new DeleteUserScene(window, this::showStartScene);
        window.setScene(deleteScene.getScene());
    }


    /**
     * Glavna metoda koja pokreće JavaFX aplikaciju.
     *
     * @param args Argumenti komandne linije.
     */
    public static void main(String[] args) {
        launch();
    }
}