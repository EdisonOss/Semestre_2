package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Tablero;
import view.TableroView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Tablero tablero = new Tablero();
        TableroView tableroView = new TableroView(tablero);

        Scene scene = new Scene(tableroView, 700, 600);
        primaryStage.setTitle("Cuatro en Raya");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
