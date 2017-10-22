package src.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    private Game game;
    private ChessView aView;

    public void start(Stage primaryStage){
        GridPane aPane = new GridPane();

        game = new Game();
        aView = new ChessView(game);
        //aPane.getChildren().add(aView);

        /*
        Adding a stylesheet to control how to Application looks.

        I feel that having a stylesheet is better than declaring all the styling in the code.
        This will make the code look cleaner, and will have all control over the style centralized.

        Also, using a stylesheet will be good if we ever want to have multiple styles for the view.
        We can have multiple stylesheets and change this one line,
        rather than going through all the code and changing each elements .setStyle() method.
        */
        //Scene aScene = ;
        //aScene.getStylesheets().add("/resources/style.css");

        primaryStage.setTitle("Chess App");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(aView, 800, 600));
        primaryStage.show();
        // primaryStage must be shown before update so that the style can load
        aView.update();


    }
    public static void main(String[] args){
        launch(args);
    }
}
