package program_javafx.model;


public class User {
    private String nickName;
    private String fullName;
    private String bio;

    private String profileImage;
    
    public User() {}
    
    public User(String nickName, String fullName, String bio, String profileImage) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.bio = bio;
        this.profileImage = profileImage;
    }
    
    // Getters
    public String getNickName() {
        return nickName;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getProfileImage() {
        return profileImage;
    }

    public String getBio() {
        return bio;
    }
    
    // Setters
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
