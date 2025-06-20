package tp9.contoller;

import tp9.model.Post;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Controller untuk Scene Home
 */
public class HomeController {
    private Stage primaryStage;
    private User currentUser;
    private List<Post> posts;
    private FlowPane postsContainer;
    
    public HomeController(Stage primaryStage, User user) {
        this.primaryStage = primaryStage;
        this.currentUser = user;
        this.posts = new ArrayList<>();
    }
    
    public Scene createHomeScene() {
        // Main container
        BorderPane mainContainer = new BorderPane();
        mainContainer.setStyle("-fx-background-color: #f5f5f5;");
        
        // Header
        VBox header = createHeader();
        mainContainer.setTop(header);
        
        // Content area
        ScrollPane scrollPane = createContentArea();
        mainContainer.setCenter(scrollPane);
        
        return new Scene(mainContainer, 800, 600);
    }
    
    private VBox createHeader() {
        VBox header = new VBox(15);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: white; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);");
        
        // User info section
        HBox userInfo = new HBox(15);
        userInfo.setAlignment(Pos.CENTER_LEFT);
        
        // Profile image
        ImageView profileImageView = new ImageView(currentUser.getProfileImage());
        profileImageView.setFitWidth(60);
        profileImageView.setFitHeight(60);
        profileImageView.setStyle("-fx-background-radius: 30;");
        
        // User details
        VBox userDetails = new VBox(2);
        Label welcomeLabel = new Label("Selamat Datang!");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        welcomeLabel.setTextFill(Color.GRAY);
        
        Label nickNameLabel = new Label(currentUser.getNickName());
        nickNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        Label fullNameLabel = new Label(currentUser.getFullName());
        fullNameLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        fullNameLabel.setTextFill(Color.DARKGRAY);
        
        userDetails.getChildren().addAll(welcomeLabel, nickNameLabel, fullNameLabel);
        
        // Add post button
        Button addPostButton = new Button("+ Tambah Foto");
        addPostButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-padding: 10 20;");
        addPostButton.setOnAction(e -> showAddPostDialog());
        
        userInfo.getChildren().addAll(profileImageView, userDetails);
        
        // Header layout
        HBox headerLayout = new HBox();
        headerLayout.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(userInfo, Priority.ALWAYS);
        headerLayout.getChildren().addAll(userInfo, addPostButton);
        
        header.getChildren().add(headerLayout);
        
        return header;
    }
    
    private ScrollPane createContentArea() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        
        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        
        // Posts title
        Label postsTitle = new Label("Foto-Foto Saya");
        postsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        
        // Posts container
        postsContainer = new FlowPane();
        postsContainer.setHgap(15);
        postsContainer.setVgap(15);
        postsContainer.setPadding(new Insets(10));
        postsContainer.setStyle("-fx-background-color: white; -fx-background-radius: 10;");
        
        // Initially show empty state
        updatePostsDisplay();
        
        content.getChildren().addAll(postsTitle, postsContainer);
        scrollPane.setContent(content);
        
        return scrollPane;
    }
    
    private void showAddPostDialog() {
        Stage dialog = new Stage();
        dialog.setTitle("Tambah Foto Baru");
        dialog.setResizable(false);
        
        VBox dialogContent = new VBox(20);
        dialogContent.setPadding(new Insets(20));
        dialogContent.setAlignment(Pos.CENTER);
        
        // Image preview
        ImageView imagePreview = new ImageView();
        imagePreview.setFitWidth(200);
        imagePreview.setFitHeight(200);
        imagePreview.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ddd; -fx-border-style: dashed; -fx-border-width: 2;");
        
        // Upload button
        Button uploadImageButton = new Button("Pilih Gambar");
        uploadImageButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 8 16;");
        
        // Caption field
        Label captionLabel = new Label("Caption:");
        captionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        TextArea captionArea = new TextArea();
        captionArea.setPromptText("Tulis caption untuk foto Anda...");
        captionArea.setPrefRowCount(3);
        captionArea.setMaxWidth(300);
        
        // Buttons
        HBox buttonContainer = new HBox(10);
        buttonContainer.setAlignment(Pos.CENTER);
        
        Button cancelButton = new Button("Batal");
        cancelButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 8 16;");
        cancelButton.setOnAction(e -> dialog.close());
        
        Button saveButton = new Button("Simpan");
        saveButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 8 16;");
        saveButton.setDisable(true);
        
        buttonContainer.getChildren().addAll(cancelButton, saveButton);
        
        // Variables to hold selected image
        final Image[] selectedImage = {null};
        
        uploadImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Gambar");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp")
            );
            
            File selectedFile = fileChooser.showOpenDialog(dialog);
            if (selectedFile != null) {
                try {
                    selectedImage[0] = new Image(selectedFile.toURI().toString());
                    imagePreview.setImage(selectedImage[0]);
                    saveButton.setDisable(false);
                } catch (Exception ex) {
                    showAlert("Error", "Gagal memuat gambar: " + ex.getMessage());
                }
            }
        });
        
        saveButton.setOnAction(e -> {
            String caption = captionArea.getText().trim();
            if (selectedImage[0] != null) {
                Post newPost = new Post(caption.isEmpty() ? "" : caption, selectedImage[0]);
                posts.add(newPost);
                updatePostsDisplay();
                dialog.close();
            }
        });
        
        dialogContent.getChildren().addAll(
            imagePreview, 
            uploadImageButton, 
            captionLabel, 
            captionArea, 
            buttonContainer
        );
        
        Scene dialogScene = new Scene(dialogContent, 350, 450);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }
    
    private void updatePostsDisplay() {
        postsContainer.getChildren().clear();
        
        if (posts.isEmpty()) {
            Label emptyLabel = new Label("Belum ada foto yang ditambahkan.\nKlik 'Tambah Foto' untuk memulai!");
            emptyLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
            emptyLabel.setTextFill(Color.GRAY);
            emptyLabel.setStyle("-fx-text-alignment: center;");
            postsContainer.getChildren().add(emptyLabel);
        } else {
            for (Post post : posts) {
                VBox postContainer = createPostCard(post);
                postsContainer.getChildren().add(postContainer);
            }
        }
    }
    
    private VBox createPostCard(Post post) {
        VBox postCard = new VBox(10);
        postCard.setAlignment(Pos.CENTER);
        postCard.setPadding(new Insets(10));
        postCard.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);");
        postCard.setMaxWidth(200);
        
        // Image
        ImageView postImageView = new ImageView(post.getPostImage());
        postImageView.setFitWidth(180);
        postImageView.setFitHeight(180);
        postImageView.setPreserveRatio(true);
        postImageView.setStyle("-fx-background-radius: 5;");
        
        // Tooltip untuk caption
        Tooltip tooltip = new Tooltip(post.getCaption());
        tooltip.setStyle("-fx-background-color: rgba(0,0,0,0.8); -fx-text-fill: white; -fx-background-radius: 5; -fx-padding: 5;");
        Tooltip.install(postImageView, tooltip);
        
        // Caption preview (terpotong jika terlalu panjang)
        String captionPreview = post.getCaption().length() > 30 
            ? post.getCaption().substring(0, 30) + "..." 
            : post.getCaption();
        
        Label captionLabel = new Label(captionPreview);
        captionLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        captionLabel.setTextFill(Color.DARKGRAY);
        captionLabel.setStyle("-fx-text-alignment: center;");
        captionLabel.setWrapText(true);
        
        postCard.getChildren().addAll(postImageView, captionLabel);
        
        return postCard;
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}