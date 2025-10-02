package ch11.Page347;

import java.util.*;

public class Jukebox8 {
    public static void main(String[] args) {
        new Jukebox8().go(); // Start the app by calling go()
    }

    public void go() {
        // Get a list of SongV3 objects from the mock data
        List<SongV3> songList = MockMoreSongs.getSongsV3();
        System.out.println("Original List: " + songList);

        // Sort the list by song title using a lambda expression
        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println("Sorted by Title: " + songList);

        // Convert the list to a HashSet to remove duplicates
        Set<SongV3> songSet = new HashSet<>(songList);
        System.out.println("HashSet: " + songSet); // May still show duplicates unless equals/hashCode are overridden
    }
}