package main.java.org.launchcode.Basic.User.Form.Models;


import javax.persistence.Entity;

@Entity
public class Playlists {
    private Long id;
    private String artist;
    private String songTitle;
    private String genre;
    private String moodType;

    public Playlists(Long id, String artist, String songTitle, String genre, String moodType) {
        this.id = id;
        this.artist = artist;
        this.songTitle = songTitle;
        this.genre = genre;
        this.moodType = moodType;
    }

    public Playlists(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMoodType() {
        return moodType;
    }

    public void setMoodType(String moodType) {
        this.moodType = moodType;
    }

    @Override
    public String toString() {
        return "Playlists{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", moodType='" + moodType + '\'' +
                '}';
    }
}
