package program_javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import program_javafx.view.*;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Set up the primary stage
            primaryStage.setTitle("Photo Gallery - Register");
            primaryStage.setResizable(true);
            primaryStage.setMinWidth(500);
            primaryStage.setMinHeight(600);
            
            // Create and show register scene
            RegisterScene registerScene = new RegisterScene(primaryStage);
            primaryStage.setScene(registerScene.getScene());
            
            // Center the window on screen
            primaryStage.centerOnScreen();
            
            // Show the application
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}