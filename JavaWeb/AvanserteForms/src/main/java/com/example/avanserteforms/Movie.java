package com.example.avanserteforms;


public class Movie {
    private static Movie selectedMovie;
    private String title;
    private String director;
    private boolean forChildren;
    private movieGenre genre;


    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public static Movie getSelectedMovie() {
        return selectedMovie;
    }

    public static void setSelectedMovie(Movie selectedMovie) {
        Movie.selectedMovie = selectedMovie;
    }

    public boolean isForChildren() {
        return forChildren;
    }

    public void setForChildren(boolean forChildren) {
        this.forChildren = forChildren;
    }

    public movieGenre getGenre() {
        return genre;
    }

    public void setGenre(movieGenre genre) {
        this.genre = genre;
    }
}
