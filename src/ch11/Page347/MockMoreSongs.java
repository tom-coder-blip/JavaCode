package ch11.Page347;

import java.util.ArrayList;
import java.util.List;

// Utility class to generate mock song data
class MockMoreSongs {
    public static List<String> getSongStrings() {
        return new ArrayList<>(); // Placeholder method (not used here)
    }

    public static List<SongV3> getSongsV3() {
        List<SongV3> songs = new ArrayList<>();

        // Add sample songs to the list
        songs.add(new SongV3("somersault", "zero 7", 147));
        songs.add(new SongV3("cassidy", "grateful dead", 158));
        songs.add(new SongV3("$10", "hitchhiker", 140));
        songs.add(new SongV3("havana", "cabello", 105));

        // Add duplicate songs to test HashSet behavior
        songs.add(new SongV3("$10", "hitchhiker", 140)); // Exact duplicate
        songs.add(new SongV3("cassidy", "grateful dead", 158)); // Same title, same artist, same bpm
        songs.add(new SongV3("50 ways", "simon", 102));

        return songs;
    }
}