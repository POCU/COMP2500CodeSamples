package academy.pocu.comp2500samples.w03.pocutunes;

public class Song {
    private String artist;
    private String name;
    private int playTimeInMilliSeconds;

    public Song(String artist, String name, int playTimeInMilliSeconds) {
        this.artist = artist;
        this.name = name;
        this.playTimeInMilliSeconds = playTimeInMilliSeconds;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getName() {
        return this.name;
    }

    public int getPlaytimeInMilliSeconds() {
        return this.playTimeInMilliSeconds;
    }

    public void play() {
        System.out.printf("Playing %s by %s. Duration is %d milliseconds%s",
                this.name,
                this.artist,
                this.playTimeInMilliSeconds,
                System.lineSeparator());
    }
}
