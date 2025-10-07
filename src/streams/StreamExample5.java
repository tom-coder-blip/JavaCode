//package streams;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class StreamExample5 {
//    public static void main(String[] args) {
//        List<Song> songs = new Songs().getSongs();
//
//        List<Song> sortedSongs = songs.stream()
//                .sorted(Comparator.comparing(Song::getTitle)) //Sorts the elements (alphabetically, numerically,
//                .collect(Collectors.toList());
//
//        System.out.println(sortedSongs);
//    }
//}
