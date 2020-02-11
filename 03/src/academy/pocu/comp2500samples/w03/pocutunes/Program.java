package academy.pocu.comp2500samples.w03.pocutunes;

public class Program {
    public static void main(String[] args) {
        Song song1 = new Song("Eagles", "Hotel California", 180100);
        Song song2 = new Song("Led Zeppelin", "Stairway to Heaven", 172100);
        Song song3 = new Song("Camila Cabello", "Havana", 182200);
        Song song4 = new Song("Ariana Grade", "Santa Baby", 166220);
        Song song5 = new Song("Elvis Presley", "Hound Dog", 175220);
        Song song6 = new Song("Green Day", "Basket Case", 193000);
        Song song7 = new Song("Mariah Carey", "All I Want For Christmas Is You", 18301);

        System.out.println(String.format("%s by %s. Playtime is %d.", song1.getName(), song1.getArtist(), song1.getPlayTimeInMilliSeconds()));

        Playlist playlist1 = new Playlist("Classic Rock");
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        playlist1.addSong(song5);

        Playlist playlist2 = new Playlist("Millenial");
        playlist2.addSong(song3);
        playlist2.addSong((song4));

        PocuTunes tunes = new PocuTunes();

        tunes.addSong(song1);
        tunes.addSong(song2);
        tunes.addSong(song3);
        tunes.addSong(song4);
        tunes.addSong(song5);
        tunes.addSong(song6);
        tunes.addSong(song7);

        System.out.println(String.format("Song count %d", tunes.getSongCount()));

        tunes.addPlaylist(playlist1);
        tunes.addPlaylist(playlist2);

        tunes.playSong("Basket Case");
        tunes.playSong("Hound Dog");

        tunes.playSong("Escape");

        tunes.playPlaylist("Classic Rock");
        tunes.playPlaylist("Millenial");

        playlist2.setName("Christmas Music");
        playlist2.removeSong("Havana");
        playlist2.addSong(song7);

        tunes.playPlaylist("Christmas Music");

        tunes.removeSong("Santa Baby");
        tunes.playPlaylist("Christmas Music");
        tunes.playSong("Santa Baby");

        tunes.removePlaylist("Christmas Music");

        System.out.println(String.format("Song count %d.", tunes.getSongCount()));
        tunes.playPlaylist("Christmas Music");
    }
}
