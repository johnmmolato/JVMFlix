package com.jvmflix.movie;

import javax.swing.*;

public class Movie {

    private int id;
    private String title;
    private Genre genre;
    private int releaseDate;// Local Date or to release year
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

    public Movie(String users, String titles) {

    }
	//BUSINESS METHODS

    public void play() {
        System.out.println("Playing " + getTitle() + "...");
        getVideo();
    }

    public void download() {
        System.out.println("Downloading " + getTitle() + "...");

    }

    public void getVideo(){
        String displayMessage = "Playing " + getTitle() + "...";
        JFrame frame = new JFrame(displayMessage);

        frame.setSize(500, 400);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("images/Screen.png");
        //JOptionPane.showMessageDialog(null, icon, "Playing...", JOptionPane.INFORMATION_MESSAGE);
        frame.add(new JLabel(icon));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

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
    public String toString() {
        return (String.format("%s: id=%s, title=%s, genre=%s, release date=%s, rating=%s, interest=%s",
                getClass().getSimpleName(), getId(), getTitle(), getGenre(), getReleaseDate(), getRating(), getInterest()));
    }
}