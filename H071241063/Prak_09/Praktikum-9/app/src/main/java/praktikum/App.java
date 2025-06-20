package praktikum;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Separator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Duration;

import praktikum.model.*;

public class App extends Application {
    private String profileImagePath = null;

    public void start(Stage primaryStage) {

        Label titleLabel = new Label("Input User Account");
        Label nicknameLabel = new Label("Nick Name");
        TextField nicknameTextField = new TextField();
        nicknameTextField.setPromptText("Masukkan nama pendek");
        nicknameTextField.setPrefWidth(200);

        Label fullNameLabel = new Label("Full Name");
        TextField fullNameTextField = new TextField();
        fullNameTextField.setPromptText("Masukkan nama lengkap");
        fullNameTextField.setPrefWidth(200);

        Button uploadPhotoButton = new Button("Upload foto profil");
        Button submitButton = new Button("Submit");

        ImageView profileImageView = new ImageView();
        profileImageView.setFitWidth(150);
        profileImageView.setFitHeight(150);
        profileImageView.setPreserveRatio(false);

        Circle profileImageClip = new Circle(75, 75, 75);
        profileImageView.setClip(profileImageClip);

        uploadPhotoButton.setOnAction(uploadEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Foto Profil");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Gambar", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                profileImagePath = selectedFile.getAbsolutePath();
                Image selectedImage = new Image(selectedFile.toURI().toString());
                profileImageView.setImage(selectedImage);
            }
        });

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);

        mainLayout.getChildren().addAll(titleLabel, nicknameLabel, nicknameTextField, fullNameLabel, fullNameTextField,
                uploadPhotoButton, profileImageView, submitButton);

        Scene loginScene = new Scene(mainLayout, 400, 500);

        submitButton.setOnAction(submitEvent -> {
            String fullName = fullNameTextField.getText();
            String nickname = nicknameTextField.getText();

            if (profileImagePath == null || fullName.isEmpty() || nickname.isEmpty()) {
                System.out.println("Lengkapi semua data dan unggah foto terlebih dahulu.");
                return;
            }

            User currentUser = new User(nickname, fullName, profileImagePath);

            ImageView userProfileImageView = new ImageView(new Image(new File(profileImagePath).toURI().toString()));
            userProfileImageView.setFitWidth(100);
            userProfileImageView.setFitHeight(100);
            Circle userProfileClip = new Circle(50, 50, 50);
            userProfileImageView.setClip(userProfileClip);

            Label userNicknameLabel = new Label(currentUser.getNickName());
            Label userFullNameLabel = new Label(currentUser.getFullName());

            Button addPostButton = new Button("Add Post");

            VBox userInfoLayout = new VBox(5, userNicknameLabel, userFullNameLabel);
            userInfoLayout.setAlignment(Pos.CENTER_LEFT);

            HBox profileHeaderLayout = new HBox(20, userProfileImageView, userInfoLayout, addPostButton);
            profileHeaderLayout.setPadding(new Insets(20));
            profileHeaderLayout.setAlignment(Pos.CENTER_LEFT);

            List<Post> userPosts = new ArrayList<>();

            GridPane postsGridPane = new GridPane();
            postsGridPane.setHgap(10);
            postsGridPane.setVgap(10);
            postsGridPane.setPadding(new Insets(10));

            ScrollPane postsScrollPane = new ScrollPane();
            postsScrollPane.setContent(postsGridPane);
            postsScrollPane.setFitToWidth(true);
            postsScrollPane.setPrefHeight(400);

            VBox profilePageLayout = new VBox(profileHeaderLayout, new Separator(), postsScrollPane);

            Scene profileScene = new Scene(profilePageLayout, 580, 600);

            primaryStage.setScene(profileScene);
            primaryStage.setResizable(false);

            addPostButton.setOnAction(addPostEvent -> {
                Stage addPostStage = new Stage();
                addPostStage.setResizable(false);

                VBox addPostLayout = new VBox(10);
                addPostLayout.setPadding(new Insets(20));
                addPostLayout.setAlignment(Pos.CENTER);

                ImageView postImagePreview = new ImageView();
                postImagePreview.setFitWidth(200);
                postImagePreview.setFitHeight(200);
                postImagePreview.setPreserveRatio(true);

                Button uploadImageButton = new Button("Upload Image");
                final String[] selectedPostImagePath = { null };

                uploadImageButton.setOnAction(uploadImageEvent -> {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Pilih foto postingan");
                    fileChooser.getExtensionFilters().addAll(
                            new FileChooser.ExtensionFilter("Gambar", "*.png", "*.jpg", "*.jpeg", "*.gif"));

                    File selectedFile = fileChooser.showOpenDialog(addPostStage);
                    if (selectedFile != null) {
                        selectedPostImagePath[0] = selectedFile.getAbsolutePath();
                        Image postImage = new Image(selectedFile.toURI().toString());
                        postImagePreview.setImage(postImage);
                    }
                });

                Label captionLabel = new Label("Masukkan Caption");
                TextField captionTextField = new TextField();
                captionTextField.setPromptText("Masukkan Caption");
                Button submitPostButton = new Button("Submit");

                addPostLayout.getChildren().addAll(uploadImageButton, postImagePreview, captionLabel, captionTextField,
                        submitPostButton);

                Scene addPostScene = new Scene(addPostLayout, 300, 400);
                addPostStage.setScene(addPostScene);
                addPostStage.setTitle("Upload Post");
                addPostStage.show();

                submitPostButton.setOnAction(submitPostEvent -> {
                    String captionText = captionTextField.getText();

                    if (selectedPostImagePath[0] != null && !captionText.isEmpty()) {
                        Post newPost = new Post(currentUser, captionText, selectedPostImagePath[0]);
                        userPosts.add(newPost);

                        ImageView gridPostImageView = new ImageView(
                                new Image(new File(selectedPostImagePath[0]).toURI().toString()));
                        gridPostImageView.setFitWidth(180);
                        gridPostImageView.setFitHeight(180);
                        gridPostImageView.setPreserveRatio(true);

                        int columnIndex = (userPosts.size() - 1) % 3;
                        int rowIndex = (userPosts.size() - 1) / 3;

                        StackPane interactiveImageContainer = createInteractiveImage(gridPostImageView,
                                captionText,
                                selectedPostImagePath[0]);

                        postsGridPane.add(interactiveImageContainer, columnIndex, rowIndex);

                        addPostStage.close();

                        System.out.println("Post berhasil ditambahkan!");
                    } else {
                        System.out.println("Harap pilih gambar dan masukkan caption!");
                    }
                });
            });
        });

        primaryStage.setTitle("MyMoment");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private StackPane createInteractiveImage(ImageView imageView, String caption, String imagePath) {
        imageView.setCursor(Cursor.HAND);
        imageView.setStyle("-fx-background-radius: 15; -fx-border-radius: 15;");

        javafx.scene.shape.Rectangle imageClip = new javafx.scene.shape.Rectangle(180, 180);
        imageClip.setArcWidth(30);
        imageClip.setArcHeight(30);
        imageView.setClip(imageClip);

        Text captionText = new Text(caption);
        captionText.setFill(Color.WHITE);
        captionText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        captionText.setOpacity(0);
        captionText.setWrappingWidth(150);
        captionText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        DropShadow textShadow = new DropShadow();
        textShadow.setColor(Color.BLACK);
        textShadow.setOffsetX(1);
        textShadow.setOffsetY(1);
        captionText.setEffect(textShadow);

        StackPane hoverOverlay = new StackPane();
        hoverOverlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-background-radius: 15;");
        hoverOverlay.setPrefSize(180, 180);
        hoverOverlay.setOpacity(0);

        javafx.scene.shape.Rectangle overlayClip = new javafx.scene.shape.Rectangle(180, 180);
        overlayClip.setArcWidth(30);
        overlayClip.setArcHeight(30);
        hoverOverlay.setClip(overlayClip);

        StackPane imageContainer = new StackPane();
        imageContainer.getChildren().addAll(imageView, hoverOverlay, captionText);
        imageContainer.setAlignment(Pos.CENTER);
        imageContainer.setPrefSize(180, 180);

        DropShadow containerShadow = new DropShadow();
        containerShadow.setColor(Color.rgb(0, 0, 0, 0.2));
        containerShadow.setOffsetX(2);
        containerShadow.setOffsetY(2);
        containerShadow.setRadius(8);
        containerShadow.setSpread(0.2);
        imageContainer.setEffect(containerShadow);

        imageContainer.setOnMouseEntered(mouseEnterEvent -> {
            ScaleTransition scaleImageTransition = new ScaleTransition(Duration.millis(200), imageView);
            scaleImageTransition.setToX(1.1);
            scaleImageTransition.setToY(1.1);

            ScaleTransition scaleOverlayTransition = new ScaleTransition(Duration.millis(200), hoverOverlay);
            scaleOverlayTransition.setToX(1.1);
            scaleOverlayTransition.setToY(1.1);

            FadeTransition fadeOverlayTransition = new FadeTransition(Duration.millis(200), hoverOverlay);
            fadeOverlayTransition.setToValue(1.0);

            FadeTransition fadeCaptionTransition = new FadeTransition(Duration.millis(300), captionText);
            fadeCaptionTransition.setToValue(1.0);
            fadeCaptionTransition.setDelay(Duration.millis(100));

            ParallelTransition hoverInTransition = new ParallelTransition(scaleImageTransition,
                    scaleOverlayTransition,
                    fadeOverlayTransition,
                    fadeCaptionTransition);
            hoverInTransition.play();
        });

        imageContainer.setOnMouseExited(mouseExitEvent -> {
            ScaleTransition scaleImageOutTransition = new ScaleTransition(Duration.millis(200), imageView);
            scaleImageOutTransition.setToX(1.0);
            scaleImageOutTransition.setToY(1.0);

            ScaleTransition scaleOverlayOutTransition = new ScaleTransition(Duration.millis(200), hoverOverlay);
            scaleOverlayOutTransition.setToX(1.0);
            scaleOverlayOutTransition.setToY(1.0);

            FadeTransition fadeOverlayOutTransition = new FadeTransition(Duration.millis(200), hoverOverlay);
            fadeOverlayOutTransition.setToValue(0.0);

            FadeTransition fadeCaptionOutTransition = new FadeTransition(Duration.millis(150), captionText);
            fadeCaptionOutTransition.setToValue(0.0);

            ParallelTransition hoverOutTransition = new ParallelTransition(scaleImageOutTransition,
                    scaleOverlayOutTransition, fadeOverlayOutTransition, fadeCaptionOutTransition);
            hoverOutTransition.play();
        });

        imageContainer.setOnMouseClicked(clickEvent -> {
            showFullSizeImage(imagePath, caption);
        });

        return imageContainer;
    }

    private void showFullSizeImage(String imagePath, String caption) {
        Stage fullImageStage = new Stage();
        fullImageStage.setTitle("View Image");

        ImageView fullSizeImageView = new ImageView(new Image(new File(imagePath).toURI().toString()));
        fullSizeImageView.setPreserveRatio(true);
        fullSizeImageView.setFitWidth(500);
        fullSizeImageView.setFitHeight(500);

        VBox fullImageLayout = new VBox(10);
        fullImageLayout.setAlignment(Pos.CENTER);
        fullImageLayout.setPadding(new Insets(20));
        fullImageLayout.getChildren().addAll(fullSizeImageView);

        Scene fullImageScene = new Scene(fullImageLayout);
        fullImageStage.setScene(fullImageScene);
        fullImageStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}