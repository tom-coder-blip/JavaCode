package ch12.SongListActivity;

import java.util.*;
import java.util.stream.Collectors; //provides ready-made methods for collecting, grouping, or summarizing data from a stream.

public class JukeboxAnalysis {
    public static void main(String[] args) {

        // Create a Songs object and get the list of Song objects
        Songs songsData = new Songs();
        List<Song> songs = songsData.getSongs();

        // Print all songs in the list
        System.out.println("🎵 All Songs:");
        songs.forEach(System.out::println);

        // Display the top 5 most-played songs
        System.out.println("\n🎧 Top 5 Most Played Songs:");
        songs.stream()
                .sorted(Comparator.comparingInt(Song::getTimesPlayed).reversed()) // sort songs by play count (descending)
                .limit(5) // take only the first 5 songs
                .forEach(System.out::println); // print each song

        // Display all unique music genres in alphabetical order
        System.out.println("\n🎶 Unique Genres:");
        songs.stream()
                .map(Song::getGenre) // extract only the genre field
                .distinct() // remove duplicates
                .sorted() // sort genres alphabetically
                .forEach(System.out::println); // print each unique genre

        // Find and display songs with the same title by different artists
        System.out.println("\n🎤 Songs with the Same Title by Different Artists:");
        songs.stream()
                .collect(Collectors.groupingBy(Song::getTitle)) // group songs by title
                .entrySet().stream() // convert the map to a stream of entries
                .filter(entry -> entry.getValue().size() > 1) // keep only titles that appear more than once
                .forEach(entry -> {
                    System.out.println("Title: " + entry.getKey()); // print the song title
                    entry.getValue().forEach(song ->
                            System.out.println("   -> " + song.getArtist() + " (" + song.getYear() + ")")); // print artist and year for each version
                });
    }
}