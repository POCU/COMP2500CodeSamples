package academy.pocu.comp2500samples.w03.pocutunes;

public class Program {
    public static void main(String[] args) {
        Song hotelCalifornia = new Song("Eagles",
                "Hotel California",
                180100);

        Song heaven = new Song("Led Zeppelin",
                "Stairway to Heaven",
                172100);

        Song havana = new Song("Camila Cabello",
                "Havana",
                182200);

        Song santaBaby = new Song("Ariana Grade",
                "Santa Baby",
                166220);

        Song houndDog = new Song("Elvis Presley",
                "Hound Dog",
                175220);

        Song basketCase = new Song("Green Day",
                "Basket Case",
                193000);

        Song christmas = new Song("Mariah Carey",
                "All I Want For Christmas Is You",
                18301);

        System.out.printf("%s by %s. Playtime is %d.\n",
                hotelCalifornia.getName(),
                hotelCalifornia.getArtist(),
                hotelCalifornia.getPlaytimeInMilliSeconds());

        Playlist playlist1 = new Playlist("Classic Rock");
        playlist1.addSong(hotelCalifornia);
        playlist1.addSong(heaven);
        playlist1.addSong(houndDog);

        Playlist playlist2 = new Playlist("Millenial");
        playlist2.addSong(havana);
        playlist2.addSong((santaBaby));

        PocuTunes tunes = new PocuTunes();

        tunes.addSong(hotelCalifornia);
        tunes.addSong(heaven);
        tunes.addSong(havana);
        tunes.addSong(santaBaby);
        tunes.addSong(houndDog);
        tunes.addSong(basketCase);
        tunes.addSong(christmas);

        System.out.printf("Song count %d\n",
                tunes.getSongCount());

        tunes.addPlaylist(playlist1);
        tunes.addPlaylist(playlist2);

        tunes.playSong("Basket Case");
        tunes.playSong("Hound Dog");

        tunes.playSong("Escape");

        tunes.playPlaylist("Classic Rock");
        tunes.playPlaylist("Millenial");

        playlist2.setName("Christmas Music");
        playlist2.removeSong("Havana");
        playlist2.addSong(christmas);

        tunes.playPlaylist("Christmas Music");

        tunes.removeSong("Santa Baby");
        tunes.playPlaylist("Christmas Music");
        tunes.playSong("Santa Baby");

        tunes.removePlaylist("Christmas Music");

        System.out.printf("Song count %d.\n",
                tunes.getSongCount());
        tunes.playPlaylist("Christmas Music");
    }
}
