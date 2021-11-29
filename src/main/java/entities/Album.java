package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private int id;
    private String albumName;
    private String artistName;
    private int songAmount;
    private int albumLengthInMin;
    private double ratingOutOfTen;

    public Album(String albumName, String artistName, int songAmount, int albumLengthInMin, double ratingOutOfTen) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songAmount = songAmount;
        this.albumLengthInMin = albumLengthInMin;
        this.ratingOutOfTen = ratingOutOfTen;
    }

    public Album() {
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getSongAmount() {
        return songAmount;
    }

    public void setSongAmount(int songAmount) {
        this.songAmount = songAmount;
    }

    public int getAlbumLengthInMin() {
        return albumLengthInMin;
    }

    public void setAlbumLengthInMin(int albumLengthInMin) {
        this.albumLengthInMin = albumLengthInMin;
    }

    public double getRatingOutOfTen() {
        return ratingOutOfTen;
    }

    public void setRatingOutOfTen(double ratingOutOfTen) {
        this.ratingOutOfTen = ratingOutOfTen;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", songAmount=" + songAmount +
                ", albumLengthInMin=" + albumLengthInMin +
                ", ratingOutOfTen=" + ratingOutOfTen;
    }
}
