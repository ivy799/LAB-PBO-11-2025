package tp9.model;

import javafx.scene.image.Image;

/**
 * Model class untuk User
 */
public class User {
    private String nickName;
    private String fullName;
    private Image profileImage;
    
    // Constructor default
    public User() {}
    
    // Constructor dengan parameter
    public User(String nickName, String fullName, Image profileImage) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.profileImage = profileImage;
    }
    
    // Getter dan Setter untuk nickName
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    // Getter dan Setter untuk fullName
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    // Getter dan Setter untuk profileImage
    public Image getProfileImage() {
        return profileImage;
    }
    
    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", profileImage=" + (profileImage != null ? "ada" : "tidak ada") +
                '}';
    }
}