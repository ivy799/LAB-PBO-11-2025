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
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import program_javafx.model.*;

public class HomeScene {
    private Scene scene;
    private ImageView profileImageView;
    private User currentUser;
    private List<Post> posts;
    private GridPane postsContainer;
    
    public HomeScene(Stage primaryStage, User user) {
        this.currentUser = user;
        this.posts = new ArrayList<>();
        createScene(primaryStage);
    }
    
    private void createScene(Stage primaryStage) {
        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color: #f0f0f0;");
        
        // Header
        VBox header = createHeader(primaryStage);
        mainLayout.setTop(header);
        
        // Content area with posts
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        postsContainer = new GridPane();
        postsContainer.setHgap(15);
        postsContainer.setVgap(15);
        postsContainer.setPadding(new Insets(30, 30, 30, 30));
        postsContainer.setAlignment(Pos.CENTER);
        
        scrollPane.setContent(postsContainer);
        mainLayout.setCenter(scrollPane);
        
        scene = new Scene(mainLayout, 900, 700);
    }
    
    private VBox createHeader(Stage primaryStage) {
        VBox header = new VBox();
        header.setPadding(new Insets(20, 30, 20, 30));
        header.setStyle("-fx-background-color: white; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;");
        
        // User info section
        HBox userInfo = new HBox(20);
        userInfo.setAlignment(Pos.CENTER_LEFT);
        
        double radius = 75;

        profileImageView = new ImageView();
        profileImageView.setFitWidth(radius * 2);
        profileImageView.setFitHeight(radius * 2);
        profileImageView.setPreserveRatio(false); // Isi lingkaran penuh

        Circle clip = new Circle(radius);
        clip.centerXProperty().bind(profileImageView.fitWidthProperty().divide(2));
        clip.centerYProperty().bind(profileImageView.fitHeightProperty().divide(2));
        profileImageView.setClip(clip);

        StackPane profileWrapper = new StackPane(profileImageView);
        profileWrapper.setPrefSize(radius * 2, radius * 2);
        profileWrapper.setMaxSize(radius * 2, radius * 2);
        profileWrapper.setStyle(
            "-fx-background-radius: 100; " +
            "-fx-border-radius: 100; " +
            "-fx-border-color: #cccccc; " +
            "-fx-border-width: 2px;"
        );
        
        if (currentUser.getProfileImage() != null) {
            try {
                Image profileImage = new Image(currentUser.getProfileImage());
                profileImageView.setImage(profileImage);
            } catch (Exception e) {
                profileImageView.setStyle("-fx-background-color: #ddd;");
            }
        } else {
            profileImageView.setStyle("-fx-background-color: #ddd;");
        }
        
        // User details
        VBox userDetails = new VBox(12);
        userDetails.setPadding(new Insets(20, 10, 10, 10));
        Label nicknameLabel = new Label(currentUser.getNickName());
        nicknameLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #333;");

        Label fullNameLabel = new Label(currentUser.getFullName());
        fullNameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: semi-bold; -fx-text-fill: #666;");

        Label bioLabel = new Label(currentUser.getBio());
        bioLabel.setStyle("-fx-font-size: 14px; -fx-font-style: italic; -fx-text-fill: #666;");

        userDetails.getChildren().addAll(nicknameLabel, fullNameLabel, bioLabel);
        
        // Add post button
        Button addPostButton = new Button("Add Post");
        addPostButton.setStyle("-fx-background-color: #4da6ff; -fx-text-fill: white; -fx-padding: 8 20; -fx-font-size: 14px; -fx-border-radius: 5; -fx-background-radius: 5;");
        addPostButton.setOnMouseEntered(e -> addPostButton.setStyle("-fx-background-color: #3d96ff; -fx-text-fill: white; -fx-padding: 8 20; -fx-font-size: 14px; -fx-border-radius: 5; -fx-background-radius: 5;"));
        addPostButton.setOnMouseExited(e -> addPostButton.setStyle("-fx-background-color: #4da6ff; -fx-text-fill: white; -fx-padding: 8 20; -fx-font-size: 14px; -fx-border-radius: 5; -fx-background-radius: 5;"));
        
        addPostButton.setOnAction(e -> showAddPostDialog(primaryStage));
        
        userInfo.getChildren().addAll(profileImageView, userDetails);
        
        HBox headerContent = new HBox();
        headerContent.setAlignment(Pos.CENTER_LEFT);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        headerContent.getChildren().addAll(userInfo, spacer, addPostButton);
        
        header.getChildren().add(headerContent);
        return header;
    }
    
    private void showAddPostDialog(Stage primaryStage) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("Add New Post");
        dialog.setResizable(false);
        
        VBox dialogLayout = new VBox(15);
        dialogLayout.setPadding(new Insets(20));
        dialogLayout.setAlignment(Pos.CENTER);
        dialogLayout.setStyle("-fx-background-color: white;");
        
        Label titleLabel = new Label("Create New Post");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        // Image section
        VBox imageSection = new VBox(10);
        imageSection.setAlignment(Pos.CENTER);
        
        ImageView postImageView = new ImageView();
        postImageView.setFitWidth(200);
        postImageView.setFitHeight(200);
        postImageView.setPreserveRatio(true);
        postImageView.setStyle("-fx-border-color: #ddd; -fx-border-width: 2; -fx-border-style: dashed;");
        
        Button selectImageButton = new Button("Select Image");
        selectImageButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 8 16; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        Label selectedImageLabel = new Label("No image selected");
        selectedImageLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");
        
        final String[] selectedImagePath = {null};
        
        selectImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Post Image");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            
            File selectedFile = fileChooser.showOpenDialog(dialog);
            if (selectedFile != null) {
                selectedImagePath[0] = selectedFile.toURI().toString();
                Image image = new Image(selectedImagePath[0]);
                postImageView.setImage(image);
                selectedImageLabel.setText(selectedFile.getName());
            }
        });
        
        imageSection.getChildren().addAll(postImageView, selectImageButton, selectedImageLabel);
        
        // Caption section
        Label captionLabel = new Label("Caption:");
        captionLabel.setStyle("-fx-font-weight: bold;");
        
        TextArea captionArea = new TextArea();
        captionArea.setPromptText("Write a caption for your post...");
        captionArea.setPrefRowCount(3);
        captionArea.setMaxWidth(300);
        captionArea.setStyle("-fx-border-radius: 5; -fx-background-radius: 5;");
        
        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button postButton = new Button("Post");
        postButton.setStyle("-fx-background-color: #FF6B6B; -fx-text-fill: white; -fx-padding: 10 20; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-weight: bold;");
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #999; -fx-text-fill: white; -fx-padding: 10 20; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        postButton.setOnAction(e -> {
            if (selectedImagePath[0] != null && !captionArea.getText().trim().isEmpty()) {
                Post newPost = new Post(captionArea.getText().trim(), selectedImagePath[0]);
                posts.add(newPost);
                refreshPostsDisplay();
                dialog.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText(null);
                alert.setContentText("Please select an image and enter a caption.");
                alert.showAndWait();
            }
        });
        
        cancelButton.setOnAction(e -> dialog.close());
        
        buttonBox.getChildren().addAll(postButton, cancelButton);
        
        dialogLayout.getChildren().addAll(titleLabel, imageSection, captionLabel, captionArea, buttonBox);
        
        Scene dialogScene = new Scene(dialogLayout, 400, 500);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }
    
    private void refreshPostsDisplay() {
        postsContainer.getChildren().clear();
        
        int columns = 3;
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            StackPane postCard = createPostCard(post);
            
            int row = i / columns;
            int col = i % columns;
            
            postsContainer.add(postCard, col, row);
        }
    }
    
    private StackPane createPostCard(Post post) {
        StackPane postCard = new StackPane();
        postCard.setPrefSize(250, 200);
        postCard.setStyle("-fx-cursor: hand;"); // Menunjukkan bahwa ini bisa diklik
        
        ImageView postImageView = new ImageView();
        postImageView.setFitWidth(250);
        postImageView.setFitHeight(200);
        postImageView.setPreserveRatio(false);
        postImageView.setStyle("-fx-background-color: #f0f0f0;");
        
        try {
            Image postImage = new Image(post.getPostImage());
            postImageView.setImage(postImage);
        } catch (Exception e) {
            postImageView.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ddd; -fx-border-width: 1;");
        }
        
        // Caption overlay (initially hidden)
        Label captionOverlay = new Label(post.getCaption());
        captionOverlay.setStyle("-fx-background-color: rgba(90, 89, 89, 0.7); -fx-text-fill: white; -fx-padding: 10; -fx-font-size: 14px; -fx-wrap-text: true; -fx-alignment: center;");
        captionOverlay.setMaxWidth(250);
        captionOverlay.setMaxHeight(200);
        captionOverlay.setVisible(false);
        
        postCard.getChildren().addAll(postImageView, captionOverlay);
        
        // HOVER EFFECT dengan ZOOM dan FADE
        postCard.setOnMouseEntered(e -> {
            // Zoom effect dengan scale transform
            postCard.setScaleX(1.1); // Zoom 5%
            postCard.setScaleY(1.1);
            
            // Fade effect
            captionOverlay.setVisible(true);
            postImageView.setOpacity(0.8);
            
            // Smooth transition effect (opsional)
            postCard.setStyle("-fx-cursor: hand; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0.5, 0, 2);");
        });
        
        postCard.setOnMouseExited(e -> {
            // Kembalikan ke ukuran normal
            postCard.setScaleX(1.0);
            postCard.setScaleY(1.0);
            
            // Hilangkan overlay
            captionOverlay.setVisible(false);
            postImageView.setOpacity(1.0);
            
            // Hilangkan shadow
            postCard.setStyle("-fx-cursor: hand;");
        });
        
        // CLICK EVENT untuk membuka detail view
        postCard.setOnMouseClicked(e -> {
            showPostDetailDialog(post);
        });
        
        return postCard;
    }

    private void showPostDetailDialog(Post post) {
        Stage detailStage = new Stage();

        detailStage.initModality(Modality.APPLICATION_MODAL);
        detailStage.setTitle("Post Detail");
        detailStage.setResizable(true);
            
        // Main image container
        VBox imageContainer = new VBox(10); // Kurangi spacing
        imageContainer.setPadding(new Insets(20));
        imageContainer.setAlignment(Pos.CENTER);
        imageContainer.setFillWidth(false); // Jangan isi lebar penuh
        imageContainer.setStyle("-fx-background-color: rgba(222, 226, 230, 0.19); -fx-border-color:rgba(222, 226, 230, 0.19); -fx-border-width: 1; -fx-border-radius: 8; -fx-background-radius: 8;");
        
        ImageView detailImageView = new ImageView();
        detailImageView.setPreserveRatio(true);
        detailImageView.setSmooth(true);
        detailImageView.setCache(true);
        
        try {
            Image postImage = new Image(post.getPostImage());
            detailImageView.setImage(postImage);
            
            double maxSize = 500; // Ukuran maksimal untuk gambar
            double imgWidth = postImage.getWidth();
            double imgHeight = postImage.getHeight();
            
            // Jika gambar lebih besar dari batas maksimal, resize
            if (imgWidth > maxSize || imgHeight > maxSize) {
                if (imgWidth > imgHeight) {
                    detailImageView.setFitWidth(maxSize);
                } else {
                    detailImageView.setFitHeight(maxSize);
                }
            }
            
        } catch (Exception e) {
            detailImageView.setStyle("-fx-background-color: #rgba(222, 226, 230, 0.19);");
            Label errorLabel = new Label("Image not available");
            errorLabel.setStyle("-fx-text-fill: #6c757d;");
            imageContainer.getChildren().add(errorLabel);
        }
                
        // Close button
        Button closeButton = new Button("Close");
        closeButton.setStyle(
            "-fx-background-color:rgb(165, 166, 167); " +
            "-fx-text-fill: white; " +
            "-fx-padding: 10 20; " +
            "-fx-font-size: 14px; " +
            "-fx-border-radius: 6; " +
            "-fx-background-radius: 6;"
        );
        
        closeButton.setOnMouseEntered(e -> closeButton.setStyle(
            "-fx-background-color:rgb(175, 175, 175); " +
            "-fx-text-fill: white; " +
            "-fx-padding: 10 20; " +
            "-fx-font-size: 14px; " +
            "-fx-border-radius: 6; " +
            "-fx-background-radius: 6;"
        ));
        
        closeButton.setOnMouseExited(e -> closeButton.setStyle(
            "-fx-background-color:rgb(132, 140, 144); " +
            "-fx-text-fill: white; " +
            "-fx-padding: 10 20; " +
            "-fx-font-size: 14px; " +
            "-fx-border-radius: 6; " +
            "-fx-background-radius: 6;"
        ));
        
        closeButton.setOnAction(e -> detailStage.close());
        
        // Assemble everything
        imageContainer.getChildren().addAll(detailImageView, closeButton);
        
        // Create scene dengan ukuran yang menyesuaikan konten
        ScrollPane scrollPane = new ScrollPane(imageContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color:rgba(72, 72, 72, 0.33);");
        
        // Hitung ukuran scene berdasarkan ukuran gambar aktual
        double sceneWidth = 600;
        double sceneHeight;
        
        try {
            Image postImage = new Image(post.getPostImage());
            double imgWidth = postImage.getWidth();
            double imgHeight = postImage.getHeight();
            double maxSize = 500;
            
            // Hitung tinggi gambar yang akan ditampilkan
            double displayHeight;
            if (imgWidth > maxSize || imgHeight > maxSize) {
                if (imgWidth > imgHeight) {
                    displayHeight = (imgHeight * maxSize) / imgWidth;
                } else {
                    displayHeight = maxSize;
                }
            } else {
                displayHeight = imgHeight;
            }
            
            // Tambahkan padding dan ruang untuk button (20 + 20 + button height + spacing)
            sceneHeight = displayHeight + 120;
            
            // Batasi tinggi maksimal agar tidak melebihi layar
            double maxSceneHeight = Screen.getPrimary().getBounds().getHeight() * 0.9;
            sceneHeight = Math.min(sceneHeight, maxSceneHeight);
            
        } catch (Exception e) {
            sceneHeight = 300; // Fallback height jika ada error
        }
        
        Scene detailScene = new Scene(scrollPane, sceneWidth, sceneHeight);
        detailStage.setScene(detailScene);
        
        // Center the window
        detailStage.centerOnScreen();
        
        // Show the dialog
        detailStage.show();
    }

    public Scene getScene() {
        return scene;
    }
}