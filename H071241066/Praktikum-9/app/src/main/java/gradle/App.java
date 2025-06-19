package gradle;

import javafx.application.Application;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private User currentUser;
    private List<Post> posts;
    private Stage primaryStage;
    private FlowPane postsContainer;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.posts = new ArrayList<>();

        primaryStage.setTitle("Photo Storage App");
        primaryStage.setResizable(false);

        showRegisterScene();

        primaryStage.show();
    }

    private void showRegisterScene() {
        VBox mainContainer = new VBox(20);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(30));
        mainContainer.setStyle("-fx-background-color: pink;");

        Label titleLabel = new Label("Register");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        titleLabel.setTextFill(Color.BLACK);

        VBox imageContainer = new VBox(10);
        imageContainer.setAlignment(Pos.CENTER);

        ImageView profileImageView = new ImageView();
        profileImageView.setFitWidth(120);
        profileImageView.setFitHeight(120);
        profileImageView.setPreserveRatio(false);
        profileImageView.setStyle("-fx-border-color: #cccccc; -fx-border-width: 2;");

        profileImageView.setImage(createPlaceholderImage());

        Button uploadProfileBtn = new Button("Upload Profile Image");
        uploadProfileBtn.setStyle(
                "-fx-background-color: #f0f0f0; -fx-text-fill: black; -fx-border-color: #cccccc; -fx-border-width: 1; -fx-padding: 8 16;");

        imageContainer.getChildren().addAll(profileImageView, uploadProfileBtn);

        VBox formContainer = new VBox(15);
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setMaxWidth(300);

        TextField nickNameField = new TextField();
        nickNameField.setPromptText("Nick Name");
        nickNameField.setStyle(
                "-fx-font-size: 14; -fx-padding: 10; -fx-border-color: #cccccc; -fx-border-width: 1; -fx-background-color: white;");

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");
        fullNameField.setStyle(
                "-fx-font-size: 14; -fx-padding: 10; -fx-border-color: #cccccc; -fx-border-width: 1; -fx-background-color: white;");

        Button registerBtn = new Button("Register");
        registerBtn.setStyle(
                "-fx-background-color: #e0e0e0; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 16; -fx-padding: 12 30; -fx-border-color: #cccccc; -fx-border-width: 1;");
        registerBtn.setPrefWidth(200);

        formContainer.getChildren().addAll(nickNameField, fullNameField, registerBtn);

        mainContainer.getChildren().addAll(titleLabel, imageContainer, formContainer);

        final String[] profileImagePath = { null };

        uploadProfileBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Profile Image");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedFile));
                    profileImageView.setImage(image);
                    profileImagePath[0] = selectedFile.getAbsolutePath();
                } catch (FileNotFoundException ex) {
                    showAlert("Error", "Could not load the selected image.");
                }
            }
        });

        registerBtn.setOnAction(e -> {
            String nickName = nickNameField.getText().trim();
            String fullName = fullNameField.getText().trim();

            if (nickName.isEmpty() || fullName.isEmpty()) {
                showAlert("Error", "Please fill in all required fields (Nick Name and Full Name).");
                return;
            }

            if (profileImagePath[0] == null) {
                showAlert("Error", "Please select a profile image. Profile image is required.");
                return;
            }

            currentUser = new User(nickName, fullName, profileImagePath[0]);
            showHomeScene();
        });

        Scene registerScene = new Scene(mainContainer, 400, 650);
        primaryStage.setScene(registerScene);
    }

    private void showHomeScene() {
        BorderPane mainContainer = new BorderPane();
        mainContainer.setStyle("-fx-background-color: pink;");

        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: pink; -fx-border-color: #cccccc; -fx-border-width: 0 0 1 0;");

        ImageView headerProfileImage = new ImageView();
        headerProfileImage.setFitWidth(60);
        headerProfileImage.setFitHeight(60);
        headerProfileImage.setPreserveRatio(false);
        headerProfileImage.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1;");

        if (currentUser.getProfileImage() != null) {
            try {
                Image image = new Image(new FileInputStream(currentUser.getProfileImage()));
                headerProfileImage.setImage(image);
            } catch (FileNotFoundException e) {
                headerProfileImage.setImage(createPlaceholderImage());
            }
        } else {
            headerProfileImage.setImage(createPlaceholderImage());
        }

        VBox userInfo = new VBox(5);
        Label nickNameLabel = new Label(currentUser.getNickName());
        nickNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        nickNameLabel.setTextFill(Color.BLACK);

        Label fullNameLabel = new Label(currentUser.getFullName());
        fullNameLabel.setFont(Font.font("Arial", 14));
        fullNameLabel.setTextFill(Color.web("#666666"));

        userInfo.getChildren().addAll(nickNameLabel, fullNameLabel);

        Button addPostBtn = new Button("Add New Post");
        addPostBtn.setStyle(
                "-fx-background-color: #e0e0e0; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 10 20; -fx-border-color: #cccccc; -fx-border-width: 1;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        header.getChildren().addAll(headerProfileImage, userInfo, spacer, addPostBtn);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: pink;");

        postsContainer = new FlowPane();
        postsContainer.setHgap(20);
        postsContainer.setVgap(20);
        postsContainer.setPadding(new Insets(20));
        postsContainer.setAlignment(Pos.CENTER);

        scrollPane.setContent(postsContainer);

        mainContainer.setTop(header);
        mainContainer.setCenter(scrollPane);

        addPostBtn.setOnAction(e -> showAddPostDialog());

        Scene homeScene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(homeScene);
    }

    private void showAddPostDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("Add New Post");
        dialog.setResizable(false);

        VBox dialogContainer = new VBox(20);
        dialogContainer.setPadding(new Insets(20));
        dialogContainer.setAlignment(Pos.CENTER);
        dialogContainer.setStyle("-fx-background-color: pink;");

        Label titleLabel = new Label("Create New Post");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        titleLabel.setTextFill(Color.BLACK);

        ImageView imagePreview = new ImageView();
        imagePreview.setFitWidth(200);
        imagePreview.setFitHeight(200);
        imagePreview.setPreserveRatio(true);
        imagePreview.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1;");
        imagePreview.setImage(createPlaceholderImage());

        Button selectImageBtn = new Button("Select Image");
        selectImageBtn.setStyle(
                "-fx-background-color: #f0f0f0; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 8 16; -fx-border-color: #cccccc; -fx-border-width: 1;");

        VBox imageContainer = new VBox(5);
        imageContainer.setAlignment(Pos.CENTER);
        imageContainer.getChildren().addAll(imagePreview, selectImageBtn);

        TextArea captionArea = new TextArea();
        captionArea.setPromptText("Enter caption...");
        captionArea.setPrefRowCount(3);
        captionArea.setMaxWidth(300);
        captionArea.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1; -fx-background-color: white;");

        VBox captionContainer = new VBox(5);
        captionContainer.setAlignment(Pos.CENTER);
        captionContainer.getChildren().addAll(captionArea);

        HBox buttonContainer = new HBox(10);
        buttonContainer.setAlignment(Pos.CENTER);

        Button postBtn = new Button("Post");
        postBtn.setStyle(
                "-fx-background-color: #e0e0e0; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 8 20; -fx-border-color: #cccccc; -fx-border-width: 1;");

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setStyle(
                "-fx-background-color: #f0f0f0; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 8 20; -fx-border-color: #cccccc; -fx-border-width: 1;");

        buttonContainer.getChildren().addAll(postBtn, cancelBtn);

        dialogContainer.getChildren().addAll(titleLabel, imageContainer, captionContainer, buttonContainer);

        final String[] selectedImagePath = { null };

        selectImageBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Post Image");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            File selectedFile = fileChooser.showOpenDialog(dialog);
            if (selectedFile != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedFile));
                    imagePreview.setImage(image);
                    selectedImagePath[0] = selectedFile.getAbsolutePath();
                } catch (FileNotFoundException ex) {
                    showAlert("Error", "Could not load the selected image.");
                }
            }
        });

        postBtn.setOnAction(e -> {
            String caption = captionArea.getText().trim();

            if (selectedImagePath[0] == null) {
                showAlert("Error", "Please select an image. Image is required for posting.");
                return;
            }

            if (caption.isEmpty()) {
                showAlert("Error", "Please enter a caption. Caption is required for posting.");
                return;
            }

            Post newPost = new Post(caption, selectedImagePath[0]);
            posts.add(newPost);
            addPostToContainer(newPost);

            dialog.close();
        });

        cancelBtn.setOnAction(e -> dialog.close());

        Scene dialogScene = new Scene(dialogContainer, 380, 450);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }

    private void addPostToContainer(Post post) {
        VBox postContainer = new VBox(10);
        postContainer.setStyle(
                "-fx-background-color: white; -fx-padding: 15; -fx-border-color: #cccccc; -fx-border-width: 1;");
        postContainer.setMaxWidth(250);

        ImageView postImageView = new ImageView();
        postImageView.setFitWidth(220);
        postImageView.setFitHeight(220);
        postImageView.setPreserveRatio(true);

        try {
            Image image = new Image(new FileInputStream(post.getPostImage()));
            postImageView.setImage(image);
        } catch (FileNotFoundException e) {
            postImageView.setImage(createPlaceholderImage());
        }

        Tooltip tooltip = new Tooltip(post.getCaption());
        tooltip.setStyle(
                "-fx-font-size: 12; -fx-background-color: #f0f0f0; -fx-text-fill: black; -fx-border-color: #cccccc;");
        Tooltip.install(postImageView, tooltip);

        postContainer.getChildren().add(postImageView);
        postsContainer.getChildren().add(postContainer);
    }

    private Image createPlaceholderImage() {
        return new Image(
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNkYPhfDwAChwGA60e6kgAAAABJRU5ErkJggg==");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}