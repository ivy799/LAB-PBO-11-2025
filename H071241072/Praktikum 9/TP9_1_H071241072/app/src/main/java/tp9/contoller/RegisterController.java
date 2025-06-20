package tp9.contoller;

import tp9.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Controller untuk Scene Register
 */
public class RegisterController {
    private Stage primaryStage;
    private TextField nickNameField;
    private TextField fullNameField;
    private ImageView profileImageView;
    private Image selectedProfileImage;
    private Button uploadButton;
    private Button registerButton;
    
    public RegisterController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public Scene createRegisterScene() {
        // Main container
        VBox mainContainer = new VBox(20);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(30));
        mainContainer.setStyle("-fx-background-color: linear-gradient(to bottom, #667eea 0%, #764ba2 100%);");
        
        // Title
        Label titleLabel = new Label("LOGIN");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        titleLabel.setTextFill(Color.WHITE);
        
        // Card container
        VBox cardContainer = new VBox(15);
        cardContainer.setAlignment(Pos.CENTER);
        cardContainer.setPadding(new Insets(30));
        cardContainer.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 5);");
        cardContainer.setMaxWidth(400);
        
        // Profile image container
        VBox imageContainer = new VBox(10);
        imageContainer.setAlignment(Pos.CENTER);
        
        profileImageView = new ImageView();
        profileImageView.setFitWidth(120);
        profileImageView.setFitHeight(120);
        profileImageView.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 60;");
        
        // Default profile image placeholder
        profileImageView.setImage(createDefaultProfileImage());
        
        uploadButton = new Button("Upload Foto Profil");
        uploadButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 8 16;");
        uploadButton.setOnAction(e -> uploadProfileImage());
        
        imageContainer.getChildren().addAll(profileImageView, uploadButton);
        
        // Input fields
        VBox inputContainer = new VBox(15);
        inputContainer.setAlignment(Pos.CENTER);
        
        // Nick name field
        VBox nickNameContainer = new VBox(5);
        Label nickNameLabel = new Label("Nama Panggilan:");
        nickNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        nickNameField = new TextField();
        nickNameField.setPromptText("Masukkan nama panggilan...");
        nickNameField.setStyle("-fx-padding: 12; -fx-background-radius: 8; -fx-border-color: #ddd; -fx-border-radius: 8;");
        nickNameContainer.getChildren().addAll(nickNameLabel, nickNameField);
        
        // Full name field
        VBox fullNameContainer = new VBox(5);
        Label fullNameLabel = new Label("Nama Lengkap:");
        fullNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        fullNameField = new TextField();
        fullNameField.setPromptText("Masukkan nama lengkap...");
        fullNameField.setStyle("-fx-padding: 12; -fx-background-radius: 8; -fx-border-color: #ddd; -fx-border-radius: 8;");
        fullNameContainer.getChildren().addAll(fullNameLabel, fullNameField);
        
        inputContainer.getChildren().addAll(nickNameContainer, fullNameContainer);
        
        // Register button
        registerButton = new Button("MASUK");
        registerButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16; -fx-background-radius: 25; -fx-padding: 12 30;");
        registerButton.setOnAction(e -> handleRegister());
        
        cardContainer.getChildren().addAll(imageContainer, inputContainer, registerButton);
        mainContainer.getChildren().addAll(titleLabel, cardContainer);
        
        return new Scene(mainContainer, 500, 650);
    }
    
    private Image createDefaultProfileImage() {
        // Membuat image default sederhana (bisa diganti dengan gambar default yang sebenarnya)
        return new Image("data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTIwIiBoZWlnaHQ9IjEyMCIgdmlld0JveD0iMCAwIDEyMCAxMjAiIGZpbGw9Im5vbmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjxyZWN0IHdpZHRoPSIxMjAiIGhlaWdodD0iMTIwIiByeD0iNjAiIGZpbGw9IiNFNUU1RTUiLz4KPHN2ZyB4PSIzMCIgeT0iMjAiIHdpZHRoPSI2MCIgaGVpZ2h0PSI4MCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjOTk5OTk5Ij4KPHA+DQo8cGF0aCBkPSJNMTIgMTJjMi4yMSAwIDQtMS43OSA0LTRzLTEuNzktNC00LTQtNCAxLjc5LTQgNCAxLjc5IDQgNCA0em0wIDJjLTIuNjcgMC04IDEuMzQtOCA0djJoMTZ2LTJjMC0yLjY2LTUuMzMtNC04LTR6Ii8+CjwvcD4KPC9zdmc+Cjwvc3ZnPg==");
    }
    
    private void uploadProfileImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Foto Profil");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp")
        );
        
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            try {
                selectedProfileImage = new Image(selectedFile.toURI().toString());
                profileImageView.setImage(selectedProfileImage);
                profileImageView.setStyle("-fx-background-radius: 60; -fx-clip: circle(60);");
            } catch (Exception e) {
                showAlert("Error", "Gagal memuat gambar: " + e.getMessage());
            }
        }
    }
    
    private void handleRegister() {
        String nickName = nickNameField.getText().trim();
        String fullName = fullNameField.getText().trim();
        
        // Validasi input
        if (nickName.isEmpty()) {
            showAlert("Peringatan", "Nama panggilan tidak boleh kosong!");
            return;
        }
        
        if (fullName.isEmpty()) {
            showAlert("Peringatan", "Nama lengkap tidak boleh kosong!");
            return;
        }
        
        if (selectedProfileImage == null) {
            showAlert("Peringatan", "Silakan upload foto profil terlebih dahulu!");
            return;
        }
        
        // Buat user object
        User user = new User(nickName, fullName, selectedProfileImage);
        
        // Pindah ke home scene
        HomeController homeController = new HomeController(primaryStage, user);
        Scene homeScene = homeController.createHomeScene();
        primaryStage.setScene(homeScene);
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}