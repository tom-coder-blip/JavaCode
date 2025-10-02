package ch11.Page350_352;

import java.util.ArrayList;
import java.util.List;

// Utility class to generate mock song data
class MockMoreSongs {
    public static List<String> getSongStrings() {
        return new ArrayList<>(); // Placeholder method (not used here)
    }

    public static List<SongV4> getSongsV4() {
        List<SongV4> songs = new ArrayList<>();

        // Add sample songs to the list
        songs.add(new SongV4("somersault", "zero 7", 147));
        songs.add(new SongV4("cassidy", "grateful dead", 158));
        songs.add(new SongV4("$10", "hitchhiker", 140));
        songs.add(new SongV4("havana", "cabello", 105));

        // Add duplicate songs to test TreeSet behavior
        songs.add(new SongV4("$10", "hitchhiker", 140)); // Exact duplicate
        songs.add(new SongV4("cassidy", "grateful dead", 158)); // Same title, same artist, same bpm
        songs.add(new SongV4("50 ways", "simon", 102));

        return songs;
    }
}