package com.jvmflix.movie;

public class Movie {

    private int id;
    private String title;
    private Genre genre;
    private int releaseDate;
    private Rating rating;
    private Interest interest;

    //PROPERTIES

    public Movie(int id, String title, Genre genre, int releaseDate, Rating rating, Interest interest) {
        setId(id);
        setTitle(title);
        setGenre(genre);
        setDate(releaseDate);
        setRating(rating);
       setInterest(interest);
    }

    //ACCESSOR METHODS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    @Override
    public String toString(){
        return (String.format("%s: id=%s, title=%s, genre=%s, release date=%s, rating=%s, interest=%s",
                getClass().getSimpleName(), getId(), getTitle(), getGenre(), getReleaseDate(), getRating(), getInterest()));
    }
}