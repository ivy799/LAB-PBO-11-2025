package praktikum.model;

public class User {
    private String nickName;
    private String fullName;
    private String profileImagePath;

    public User(String nickName, String fullName, String profileImagePath) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.profileImagePath = profileImagePath;
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

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

}