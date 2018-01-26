package app;

import app.chessboard.ChessView;
import game.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage){
        GridPane aPane = new GridPane();

        Game game = new Game();
        ChessView aView = new ChessView(game);
        aPane.getChildren().add(aView);
        Scene aScene = new Scene(aPane);
      
        aScene.getStylesheets().add("/resources/style.css");
        primaryStage.setScene(aScene);
        primaryStage.show();
        // primaryStage must be shown before update so that the style can load
        aView.update();


    }
    public static void main(String[] args){
        launch(args);
    }
}
