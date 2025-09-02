package ch2.ExercisePg42;

public class EpisodeTestDrive {
    public static void main(String[] args) {

        Episode episode = new Episode();
        episode.seriesName = "Night Agent";
        episode.episodeNumber = 2;
        episode.previousEpisodeRecap();
        episode.play();
        episode.skipIntro();
        episode.play();
        episode.ending();
        episode.credits();
        episode.nextEpisode();
    }
}


