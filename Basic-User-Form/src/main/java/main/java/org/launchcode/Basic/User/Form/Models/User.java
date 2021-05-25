package main.java.org.launchcode.Basic.User.Form.Models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    private Long userId;
    @Column(nullable=true, length= 64)
    private String photo;

    private String username;
    private String email;
    private String password;
    private String userInfo;
    private String musicPreference;


    public User(Long userId, String photo, String username, String email, String password, String userInfo, String musicPreference) {
        this.userId=userId;
        this.photo=photo;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.musicPreference=musicPreference;

    }

    public User(){

    }

    @Transient
    public String getPhotosImagePath() {
        if (photo == null || userId == null) return null;

        return "/user-photos/" + userId + "/" + photo;
    }
    @Id
    @GeneratedValue
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMusicPreference() {
        return musicPreference;
    }

    public void setMusicPreference(String musicPreference) {
        this.musicPreference = musicPreference;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\''+
                "photo='" + photo + '\'' +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", musicPreference'" + musicPreference + '\''+
                '}';
    }
}


