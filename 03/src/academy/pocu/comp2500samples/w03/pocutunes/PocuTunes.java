package academy.pocu.comp2500samples.w03.pocutunes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PocuTunes {
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlists;

    public PocuTunes() {
        this(new ArrayList<Song>(), new ArrayList<Playlist>());
    }

    public PocuTunes(ArrayList<Song> songs, ArrayList<Playlist> playlists) {
        this.songs = songs;
        this.playlists = playlists;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public boolean removeSong(String songName) {
        for (Playlist playlist : this.playlists) {
            playlist.removeSong(songName);
        }

        Song songOrNull = findSongOrNull(songName);

        if (songOrNull == null) {
            return false;
        }

        this.songs.remove(songOrNull);
        return true;
    }

    public void addPlaylists(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public boolean removePlaylist(String playlistName) {
        for (Playlist playlist : this.playlists) {
            if (playlistName.equals(playlist.getName())) {
                this.playlists.remove(playlist);
                return true;
            }
        }

        return false;
    }

    public void playSong(String songName) {
        Song songOrNull = findSongOrNull(songName);

        if (songOrNull == null) {
            System.out.println(String.format("\"%s\" not found!", songName));
            return;
        }

        songOrNull.play();
    }

    public void playPlaylist(String playlistName) {
        for (Playlist playlist : this.playlists) {
            if (playlistName.equals(playlist.getName())) {
                ArrayList<Song> songs = playlist.getSongs();

                for (Song song : songs) {
                    song.play();
                }
            }
        }
    }

    private Song findSongOrNull(String songName) {
        for (Song song : this.songs) {
            if (songName.equals(song.getName())) {
                return song;
            }
        }

        return null;
    }
}
