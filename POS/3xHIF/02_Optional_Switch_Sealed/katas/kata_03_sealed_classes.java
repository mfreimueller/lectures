public class SealedClasses {
    public static void main(String[] args) {
        var items = java.util.List.of(
            new Movie("Inception", 148),
            new Song("Bohemian Rhapsody", 355),
            new Podcast("Tech Talks", 45)
        );

        for (var item : items) {
            System.out.println(play(item));
        }
    }

    static String play(MediaItem item) {
        return switch (item) {
            case Movie m -> "Playing movie: " + m.title() + " (" + m.durationMin() + " min)";
            case Song s -> "Playing song: " + s.title() + " (" + (s.durationSec() / 60) + ":" + String.format("%02d", s.durationSec() % 60) + ")";
            case Podcast p -> "Playing podcast: " + p.title() + " (" + p.durationMin() + ":00)";
        };
    }
}
