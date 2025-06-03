package program_javafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import program_javafx.model.*;

public class RegisterScene {
    private Scene scene;
    private TextField nickNameField, fullNameField, bioField;
    private String selectedImagePath;
    private ImageView profileImageView;
    private Label imageLabel;
    
    public RegisterScene(Stage primaryStage) {
        createScene(primaryStage);
    }
    
    private void createScene(Stage primaryStage) {
        // Main container
        VBox mainContainer = new VBox(20);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(30));
        mainContainer.setStyle("-fx-background-color: #f0f0f0;");
        
        // Title
        Label titleLabel = new Label("Register Account");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: normal; -fx-text-fill: #666;");
        
        // Form container
        VBox formContainer = new VBox(15);
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setPadding(new Insets(0));
        formContainer.setMaxWidth(400);
        
        // Nickname field
        Label nickLabel = new Label("Nick Name");
        nickLabel.setStyle("-fx-font-weight: normal; -fx-font-size: 16px; -fx-text-fill: #666;");
        nickNameField = new TextField();
        nickNameField.setPromptText("Write your nickname here");
        nickNameField.setStyle("-fx-padding: 12; -fx-border-color:rgb(168, 174, 179); -fx-border-width: 2; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-size: 14px;");
        nickNameField.setPrefWidth(400);
        
        // Full name field
        Label fullNameLabel = new Label("Full Name");
        fullNameLabel.setStyle("-fx-font-weight: normal; -fx-font-size: 16px; -fx-text-fill: #666;");
        fullNameField = new TextField();
        fullNameField.setPromptText("Write your full name here");
        fullNameField.setStyle("-fx-padding: 12; -fx-border-color:rgb(168, 174, 179); -fx-border-width: 1; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-size: 14px;");
        fullNameField.setPrefWidth(400);
        
        // Bio name field
        Label bioLabel = new Label("Bio");
        bioLabel.setStyle("-fx-font-weight: normal; -fx-font-size: 16px; -fx-text-fill: #666;");
        bioField = new TextField();
        bioField.setPromptText("Write your bio here");
        bioField.setStyle("-fx-padding: 12; -fx-border-color:rgb(168, 174, 179); -fx-border-width: 1; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-size: 14px;");
        bioField.setPrefWidth(600);

        // Profile image section
        VBox imageSection = new VBox(15);
        imageSection.setAlignment(Pos.CENTER);
        
        Button uploadButton = new Button("Upload Foto Profil");
        uploadButton.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #666; -fx-padding: 10 20; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-size: 14px;");
        uploadButton.setOnMouseEntered(e -> uploadButton.setStyle("-fx-background-color: #d0d0d0; -fx-text-fill: #666; -fx-padding: 10 20; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-size: 14px;"));
        uploadButton.setOnMouseExited(e -> uploadButton.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #666; -fx-padding: 10 20; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-size: 14px;"));
        
        double radius = 75;

        profileImageView = new ImageView();
        profileImageView.setFitWidth(radius * 2);
        profileImageView.setFitHeight(radius * 2);
        profileImageView.setPreserveRatio(false); // Isi lingkaran penuh

        Circle clip = new Circle(radius);
        clip.centerXProperty().bind(profileImageView.fitWidthProperty().divide(2));
        clip.centerYProperty().bind(profileImageView.fitHeightProperty().divide(2));
        profileImageView.setClip(clip);

        // Bungkus dalam StackPane agar bisa kasih border bundar
        StackPane profileWrapper = new StackPane(profileImageView);
        profileWrapper.setPrefSize(radius * 2, radius * 2);
        profileWrapper.setMaxSize(radius * 2, radius * 2);
        profileWrapper.setStyle(
            "-fx-background-radius: 100; " +
            "-fx-border-radius: 100; " +
            "-fx-border-color: #cccccc; " +
            "-fx-border-width: 2px;"
        );

        
        imageLabel = new Label("");
        imageLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");
        
        uploadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Profile Image");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                selectedImagePath = selectedFile.toURI().toString();
                Image image = new Image(selectedImagePath);
                profileImageView.setImage(image);
                
                // Re-apply circular clipping after setting new image
                Circle imageClip = new Circle(75);
                imageClip.centerXProperty().bind(profileImageView.fitWidthProperty().divide(2));
                imageClip.centerYProperty().bind(profileImageView.fitHeightProperty().divide(2));
                profileImageView.setClip(imageClip);

                
                imageLabel.setText(selectedFile.getName());
            }
        });
                
        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #666; -fx-padding: 12 30; -fx-font-size: 16px; -fx-border-radius: 5; -fx-background-radius: 5;");
        submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: #d0d0d0; -fx-text-fill: #666; -fx-padding: 12 30; -fx-font-size: 16px; -fx-border-radius: 5; -fx-background-radius: 5;"));
        submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #666; -fx-padding: 12 30; -fx-font-size: 16px; -fx-border-radius: 5; -fx-background-radius: 5;"));
        
        submitButton.setOnAction(e -> {
            if (validateInput()) {
                User user = new User(nickNameField.getText(), fullNameField.getText(), bioField.getText() ,selectedImagePath);
                HomeScene homeScene = new HomeScene(primaryStage, user);
                primaryStage.setScene(homeScene.getScene());
                primaryStage.setTitle("MyMoment");
            }
        });
        
        imageSection.getChildren().addAll(uploadButton, profileWrapper, imageLabel);
        formContainer.getChildren().addAll(nickLabel, nickNameField, fullNameLabel, fullNameField, bioLabel, bioField, imageSection, submitButton);
        mainContainer.getChildren().addAll(titleLabel, formContainer);
        
        scene = new Scene(mainContainer, 900, 700);
    }
    
    private boolean validateInput() {
        if (nickNameField.getText().trim().isEmpty()) {
            showAlert("Please enter a nickname");
            return false;
        }
        if (fullNameField.getText().trim().isEmpty()) {
            showAlert("Please enter your full name");
            return false;
        }
        return true;
    }
    
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public Scene getScene() {
        return scene;
    }
}