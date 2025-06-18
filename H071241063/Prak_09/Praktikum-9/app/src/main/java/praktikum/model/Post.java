package praktikum.model;

public class Post {
    private User user;
    private String caption;
    private String postImagePath;

    public Post(User user, String caption, String postImagePath) {
        this.user = user;
        this.caption = caption;
        this.postImagePath = postImagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPostImagePath() {
        return postImagePath;
    }

    public void setPostImagePath(String postImagePath) {
        this.postImagePath = postImagePath;
    }
}