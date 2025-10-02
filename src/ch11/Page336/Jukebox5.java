package ch11.Page336;

import java.util.*;

public class Jukebox5 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

    public void go() {
        List<SongV3> songList = MockSongs.getSongsV3(); //returns a list of SongV3 objects (each has a title, artist, and bpm).
        System.out.println("Original List: " + songList); //Shows the songs in the order they were added.

        //Creates a TitleCompare object and uses it to sort the list alphabetically by song title.
        TitleCompare titleCompare = new TitleCompare();
        songList.sort(titleCompare);
        System.out.println("Sorted by Title: " + songList);

        //Creates a ArtistCompare object and uses it to sort the list alphabetically by song artist.
        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);
        System.out.println("Sorted by Artist: " + songList);

        //Creates a BpmCompare object and uses it to sort the list alphabetically by song bpm.
        BpmCompare bpmCompare = new BpmCompare();
        songList.sort(bpmCompare);
        System.out.println("Sorted by Bpm: " + songList);
    }
}

class TitleCompare implements Comparator<SongV3> {
    public int compare(SongV3 one, SongV3 two) {
        return one.getTitle().compareTo(two.getTitle());
    }
}

class ArtistCompare implements Comparator<SongV3> {
    public int compare(SongV3 one, SongV3 two) {
        return one.getArtist().compareTo(two.getArtist());
    }
}

class BpmCompare implements Comparator<SongV3> {
    public int compare(SongV3 one, SongV3 two) {
        return Integer.compare(one.getBpm(), two.getBpm());
    }
}

