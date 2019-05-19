package com.timbuchalk;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

   public boolean newSong ( String titleSong, double durationSong){

        if ( findSong (titleSong) == null){

            this.songs.add(new Song(titleSong, durationSong));
            return true;
        }
        return false;
   }

   private Song findSong ( String titileSong){
        for ( Song checkSong : this.songs){
            if ( checkSong.getTitleSong().equals(titileSong)){
                return checkSong;
            }
        }return null;
   }

   public boolean addToPlayList ( String titleSong, LinkedList<Song> playList){

        Song checkList = findSong(titleSong);

        if ( checkList != null){

            playList.add(checkList);
            return true;
        }
        System.out.println("The Song " + titleSong + " is not in this album.");
        return  false;
   }
}
