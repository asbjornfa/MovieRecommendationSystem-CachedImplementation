package dk.easv.entities;

public class TMDBMovie {
    private String original_title;
    private String poster_path;

    public TMDBMovie(String original_title, String poster_path) {
        this.original_title = original_title;
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getPoster_path() {return poster_path;}
}

