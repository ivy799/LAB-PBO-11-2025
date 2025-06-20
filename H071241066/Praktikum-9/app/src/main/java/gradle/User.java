package gradle;

public class User {
    private String nickName;
    private String fullName;
    private String profileImage;

    public User() {
    }

    public User(String nickName, String fullName, String profileImage) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.profileImage = profileImage;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}