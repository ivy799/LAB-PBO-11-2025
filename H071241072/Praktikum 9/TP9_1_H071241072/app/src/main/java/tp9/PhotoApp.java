package tp9;

import tp9.contoller.RegisterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Application Class untuk Photo App
 */
public class PhotoApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set title aplikasi
        primaryStage.setTitle("Photo App - Penyimpan Foto Sementara");
        
        // Buat controller untuk scene register
        RegisterController registerController = new RegisterController(primaryStage);
        
        // Buat scene register
        Scene registerScene = registerController.createRegisterScene();
        
        // Set scene dan tampilkan stage
        primaryStage.setScene(registerScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}