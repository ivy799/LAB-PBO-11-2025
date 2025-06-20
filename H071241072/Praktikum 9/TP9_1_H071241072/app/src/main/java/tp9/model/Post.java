package tp9.model;

import javafx.scene.image.Image;

/**
 * Model class untuk Post
 */
public class Post {
    private String caption;
    private Image postImage;
    
    // Constructor default
    public Post() {}
    
    // Constructor dengan parameter
    public Post(String caption, Image postImage) {
        this.caption = caption;
        this.postImage = postImage;
    }
    
    // Getter dan Setter untuk caption
    public String getCaption() {
        return caption;
    }
    
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    // Getter dan Setter untuk postImage
    public Image getPostImage() {
        return postImage;
    }
    
    public void setPostImage(Image postImage) {
        this.postImage = postImage;
    }
    
    @Override
    public String toString() {
        return "Post{" +
                "caption='" + caption + '\'' +
                ", postImage=" + (postImage != null ? "ada" : "tidak ada") +
                '}';
    }
}