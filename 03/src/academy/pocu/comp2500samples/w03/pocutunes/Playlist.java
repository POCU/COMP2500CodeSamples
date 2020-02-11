package academy.pocu.comp2500samples.w03.pocutunes;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public boolean removeSong(String songName) {
        Song song = findSongOrNull(songName);

        if (song == null) {
            return false;
        }

        this.songs.remove(song);
        return true;
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
