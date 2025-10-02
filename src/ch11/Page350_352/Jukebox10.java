package ch11.Page350_352;

import java.util.*;

public class Jukebox10 {
    public static void main(String[] args) {
        new Jukebox10().go(); // Start the app by calling go()
    }

    public void go() {
        // Get a list of SongV4 objects from the mock data
        List<SongV4> songList = MockMoreSongs.getSongsV4();
        System.out.println("Original List: " + songList);

        // Sort the list by song title using a lambda expression
        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println("Sorted by Title: " + songList);

        // Use TreeSet to remove duplicates and keep songs sorted by title
        Set<SongV4> songSet = new TreeSet<>(songList);
        System.out.println("TreeSet: " + songSet);

        // Use TreeSet with custom Comparator to sort songs by bpm
        Set<SongV4> songSetByBpm = new TreeSet<>((o1, o2) -> o1.getBpm() - o2.getBpm());
        songSetByBpm.addAll(songList); // Add all songs to the bpm-sorted TreeSet
        System.out.println("Sorted by Bpm : " + songSetByBpm);
    }
}
