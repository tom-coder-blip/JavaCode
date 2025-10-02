package ch11.Page311;

import java.util.*;

public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go(); //Make a new Jukebox1 object and it calls its go method
    }

    //the main job of go() is: get the song list and print it.
    public void go() {
        List<String> songList = MockSongs.getSongStrings();
        System.out.println(songList);
    }
}

