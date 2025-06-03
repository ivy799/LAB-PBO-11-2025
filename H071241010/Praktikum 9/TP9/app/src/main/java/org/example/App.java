package org.example;

import org.example.Post;
import org.example.User;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class App extends Application {
    private TextField nicknameTextField = new TextField();
    private TextField fullnameTextField = new TextField();
    public User user;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Moment");
        showInputUserAccount(primaryStage);
        primaryStage.show();
    }

    private void showInputUserAccount(Stage stage) {
        Label label = new Label("Input User Account");
        label.setStyle("-fx-font-weight: bold;");

        ImageView profileImage = new ImageView();
        profileImage.setFitHeight(100);
        profileImage.setFitWidth(100);

        Circle clip = new Circle(50, 50, 50);
        profileImage.setClip(clip);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));
        profileImage.setEffect(dropShadow);

        Label nicknameLabel = new Label("NickName");
        nicknameTextField.setPromptText("Insert nickname here . . .");
        nicknameTextField.setMaxWidth(300);

        Label fullnameLabel = new Label("FullName");
        fullnameTextField.setPromptText("Insert fullname here . . .");
        fullnameTextField.setMaxWidth(300);

        Button uploadFotoProfilButton = new Button("Upload profile picture");
        uploadFotoProfilButton.setOnAction(e -> {
            File file = chooseFile(stage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                profileImage.setImage(image);
            }
        });

        Button submitButton = new Button("Submit");

        submitButton.setOnAction(event -> {
            if (nicknameTextField.getText().isEmpty() || fullnameTextField.getText().isEmpty()) {
                showError("Nickname or Fullname cant be empty");
            } else {
                this.user = new User(nicknameTextField.getText(), fullnameTextField.getText(), profileImage);
                showProfileScene(stage);
            }
        });

        VBox root = new VBox(15);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                label,
                nicknameLabel,
                nicknameTextField,
                fullnameLabel,
                fullnameTextField,
                uploadFotoProfilButton,
                profileImage,
                submitButton
        );

        Scene scene = new Scene(root, 500, 600);
        stage.setScene(scene);
    }

    private void showProfileScene(Stage stage) {
        Label nickNameLabel = new Label(user.nickName);
        nickNameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        Label fullNameLabel = new Label(user.fullName);
        Button addPostButton = new Button("Add Post");
        addPostButton.setOnAction(event -> {
            showAddPostScene(stage);
        });

        VBox nameBox = new VBox(10, nickNameLabel, fullNameLabel, addPostButton);
        nameBox.setAlignment(Pos.CENTER);

        HBox heroBox = new HBox(10, user.profileImage, nameBox);
        heroBox.setAlignment(Pos.CENTER);

        GridPane postGrid = new GridPane();
        postGrid.setHgap(10);
        postGrid.setVgap(10);
        postGrid.setPadding(new Insets(10));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33.33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33.33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33.33);
        postGrid.getColumnConstraints().addAll(col1, col2, col3);

        int row = 0;
        int col = 0;
        for (Post post : user.posts) {
            ImageView postImage = new ImageView(post.postImage.getImage());
            postImage.setFitHeight(100);
            postImage.setFitWidth(100);
            postImage.setPreserveRatio(true);

            Label captionLabel = new Label(post.caption);
            captionLabel.setWrapText(true);
            captionLabel.setMaxWidth(100);
            captionLabel.setStyle("-fx-background-color: rgba(0, 0, 0, 0.41); -fx-text-fill: white; -fx-padding: 10px;");
            captionLabel.setOpacity(0);

            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(postImage, captionLabel);
            stackPane.setAlignment(Pos.CENTER);

            postImage.setOnMouseEntered(e -> {
                postImage.setScaleX(1.5);
                postImage.setScaleY(1.5);
                captionLabel.setOpacity(1);
            });

            postImage.setOnMouseExited(e -> {
                postImage.setScaleX(1);
                postImage.setScaleY(1);
                captionLabel.setOpacity(0);
            });

            postImage.setOnMouseClicked(e -> {
                showFullScreenImage(postImage.getImage());
            });

            postGrid.add(stackPane, col, row);
            GridPane.setHalignment(stackPane, HPos.CENTER);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
    }

    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(postGrid);
    scrollPane.setFitToWidth(true);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    VBox root = new VBox(15, heroBox, scrollPane);
    root.setAlignment(Pos.TOP_CENTER);
    root.setPadding(new Insets(20));

    Scene scene = new Scene(root, 500, 600);
    stage.setScene(scene);
}

private void showFullScreenImage(Image image) {
    Stage fullScreenStage = new Stage();
    fullScreenStage.initStyle(javafx.stage.StageStyle.UTILITY);
    fullScreenStage.setTitle("Full Screen Image");

    ImageView imageView = new ImageView(image);
    imageView.setFitHeight(600);
    imageView.setFitWidth(800);
    imageView.setPreserveRatio(true);

    VBox vbox = new VBox(imageView);
    vbox.setAlignment(Pos.CENTER);

    Scene scene = new Scene(vbox);
    fullScreenStage.setScene(scene);

    fullScreenStage.show();
}

    private void showAddPostScene(Stage stage) {
        ImageView postImage = new ImageView();
        postImage.setFitHeight(100);
        postImage.setFitWidth(100);

        Button uploadImageButton = new Button("Upload Image");
        uploadImageButton.setOnAction(e -> {
            File file = chooseFile(stage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                postImage.setImage(image);
            }
        });

        Label label = new Label("Caption");
        TextField captionTextField = new TextField();
        captionTextField.setPromptText("Masukkan caption . . .");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            if (postImage.getImage() == null) {
                showError("Please select an image");
            } else if (captionTextField.getText().isEmpty()) {
                showError("Caption cannot be empty");
            } else {
                Post post = new Post(captionTextField.getText(), postImage);
                user.addPost(post);
                showProfileScene(stage);
            }
        });

        VBox box = new VBox(15, uploadImageButton, postImage, label, captionTextField, submitButton);
        box.setAlignment(Pos.TOP_CENTER);
        box.setPadding(new Insets(20));

        Scene scene = new Scene(box, 500, 600);
        stage.setScene(scene);
    }

    private File chooseFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Foto Profil");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Gambar (*.jpg, *.png, *.jpeg)", "*.jpg", "*.png", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser.showOpenDialog(primaryStage);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}