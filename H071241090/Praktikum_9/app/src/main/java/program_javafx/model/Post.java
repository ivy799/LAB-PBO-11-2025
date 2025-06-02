package program_javafx.model;

public class Post {
    private String caption;
    private String postImage;
    
    public Post() {}
    
    public Post(String caption, String postImage) {
        this.caption = caption;
        this.postImage = postImage;
    }
    
    // Getters
    public String getCaption() {
        return caption;
    }
    
    public String getPostImage() {
        return postImage;
    }
    
    // Setters
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}
