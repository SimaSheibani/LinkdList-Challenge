package com.timbuchalk;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {


        Album album = new Album("Rock");

        album.newSong("number 1", 3.5);
        album.newSong("number 2", 3.8);
        album.newSong("number 3", 3.3);
        album.newSong("number 4", 4.5);
        album.newSong("number 5", 4.1);
        album.newSong("number 6", 5.1);
        album.newSong("number 7", 3.4);
        albums.add(album);


        album = new Album("Jazz");
        album.newSong("number 8", 3.3);
        album.newSong("number 9", 2.5);
        album.newSong("number 10", 3.6);
        album.newSong("number 11", 4.0);
        album.newSong("number 12", 3.9);
        albums.add(album);


        LinkedList<Song> playList = new LinkedList<Song>();

        albums.get(0).addToPlayList("number 1", playList);
        albums.get(0).addToPlayList("number 3", playList);
        albums.get(1).addToPlayList("number 8", playList);
        albums.get(1).addToPlayList("number 9", playList);
        albums.get(1).addToPlayList("number 10", playList);
        albums.get(1).addToPlayList("number 11", playList);

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("No Song in the play list.");
            return;
        } else {
            System.out.println("Now play " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {

                case 0:
                    System.out.println("playlist complete.");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else {
                            System.out.println("We have reached the end of the playlist.");
                            forward = false;
                        }

                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                            forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }
                    else {
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if ( forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list.");
                        }
                    }
                        else {
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                            }
                            else {
                                System.out.println(" We are at the end of the lsit.");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if ( playList.size()>0){
                        listIterator.remove();
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing next song " + listIterator.next());
                    }
                    else if ( listIterator.hasPrevious()){
                        System.out.println("Now playing previous song " + listIterator.previous());
                    }
                    break;
            }
        }
    }

    private static void printMenu() {

        System.out.println("Available action: \n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to play the current song\n" +
                "4 - list songs in the play list\n" +
                "5 - print available actions\n" +
                "6 - to delete the current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("*****************************");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            System.out.println("*****************************");


        }
    }
}