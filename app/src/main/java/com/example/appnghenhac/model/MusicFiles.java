package com.example.appnghenhac.model;

public class MusicFiles {
    private int path;
    private String title;
    private String artist;
    private int coverArt;
//    private String album;
//    private String duration;

//    public MusicFiles(String path, String title, String artist, String album, String duration) {
//        this.path = path;
//        this.title = title;
//        this.artist = artist;
//        this.album = album;
//        this.duration = duration;
//    }
    public MusicFiles(int path, String title, String artist,int coverArt) {
        this.path = path;
        this.title = title;
        this.artist = artist;
        this.coverArt =coverArt;
//        this.album = album;
//        this.duration = duration;
    }

    public int getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(int coverArt) {
        this.coverArt = coverArt;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }}
//
//    public String getAlbum() {
//        return album;
//    }
//
//    public void setAlbum(String album) {
//        this.album = album;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//}
