class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public int compareTo(Song s){
        return title.compareTo(s.getTitle());
    }

    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
/*
    public boolean equals(Object asong){
        Song a = (Song) asong;
        return getTitle().equals(a.getTitle());
    }

    public int hashCode(){
        return title.hashCode();
    }
*/
    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public String getRating(){
        return rating;
    }

    public String getBpm(){
        return bpm;
    }

    public String toSong(){
        return title;
    }

    public String toString(){
        return title;
    }
}