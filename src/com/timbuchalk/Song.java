package com.timbuchalk;

public class Song {

    private String titleSong;
    private double durationSong;

    public Song(String titleSong, double durationSong) {
        this.titleSong = titleSong;
        this.durationSong = durationSong;
    }

    public String getTitleSong() {
        return titleSong;
    }

//    public double getDurationSong() {
//        return durationSong;
//    }


    @Override
    public String toString() {
        return this.titleSong + ": " + this.durationSong;
    }
}
