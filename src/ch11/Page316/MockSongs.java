package ch11.Page316;

import java.util.ArrayList;
import java.util.List;

public class MockSongs {

    //returns an empty ArrayList<String>
    public static List<String> getSongStrings() {
        return new ArrayList<>();
    }

    //creates an ArrayList<SongV2> and populates it with SongV2 objects
    public static List<SongV2> getSongsV2() {
        List<SongV2> songs = new ArrayList<>();
        songs.add(new SongV2("somersault", "zero 7", 147));
        songs.add(new SongV2("cassidy", "grateful dead", 158));
        songs.add(new SongV2("$10", "hitchhiker", 140));
        songs.add(new SongV2("havana", "cabello", 105));
        songs.add(new SongV2("Cassidy", "grateful dead", 158));
        songs.add(new SongV2("50 ways", "simon", 102));
        return songs;
    }
}
