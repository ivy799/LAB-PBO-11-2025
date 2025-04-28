package Praktikum_4.TP_1_H071241090.models;

public class User {
   private String username;
   private String password;
   private Profile profile;

   public String getUsername() {
    return username;
   }
   public void setUsername(String username) {
    this.username = username;
   }
   public String getPassword() {
    return password;
   }
   public void setPassword(String password) {
    this.password = password;
   }
   public Profile getProfile() {
    return profile;
   }
   public void setProfile(Profile profile) {
    this.profile = profile;
   }
   public User(String username, String password) {
    this.username = username;
    this.password = password;
   }


}