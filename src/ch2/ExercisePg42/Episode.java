package ch2.ExercisePg42;

public class Episode {
    String seriesName;
    int episodeNumber;

    void skipIntro() {
        System.out.println("Skipping intro...");
    }

    void skipToNext() {
        System.out.println("Loading next episode...");
    }

    //added the play method
    void play() {
        System.out.println("Playing episode " + episodeNumber + " for " + seriesName);
    }

    void previousEpisodeRecap() {
        System.out.println("Previous episode " + episodeNumber + " recap");
    }

    void nextEpisode() {
        System.out.println("Next episode " + episodeNumber + " for " + seriesName);
    }

    void credits() {
        System.out.println("Credits for episode " + episodeNumber + " " + seriesName);
    }

    void ending() {
        System.out.println("Ending episode is " + episodeNumber + " for " + seriesName);
    }
}
