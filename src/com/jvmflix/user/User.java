package com.jvmflix.user;

import com.jvmflix.movie.Genre;
import com.jvmflix.movie.Interest;
import com.jvmflix.movie.Movie;
import com.jvmflix.movie.Rating;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;



public class User {

    //PROPERTIES
    private String name;
    private int age;
    private Genre genre;
    private Interest interest;
    private Movie selectedMovie;

    //CONSTRUCTORS

    public User(String name, int age, Genre genre) {
        setName(name);
        setAge(age);
        setGenre(genre);

    }

    //BUSINESS METH0DS
    public Movie toSelect( String title) throws IOException {
        List<Movie> selectedMovie = new ArrayList<>();

        List<Movie> suggestedMovies = suggestedList(getInterest());
        for(Movie movie:suggestedMovies){
            if(title.equals(movie.getTitle())){
            selectedMovie.add(movie);
            }
        }
        setSelectedMovie(selectedMovie.get(0));

        return selectedMovie.get(0);
    }

    public void watch() {
        Movie movie = getSelectedMovie();
        movie.play();


    }

    }

    public List<Movie> videoList( ) throws IOException {

        /* Pulling array of recommended movies here.
        Scanner is going to read the list of movies text file, filtering by interest and
        *Or statement*
         */
        List<String> lines =Files.readAllLines(Path.of("movieCollectionNew.csv"));
        List<Movie> entireDatabase = new ArrayList<>();

        for(String line: lines){

            String [] properties = line.split(",");


            int id = Integer.parseInt(properties[0]);
            String title = properties[1];
            Genre genre = Genre.valueOf(properties[2]);
            int dateRelease = Integer.parseInt(properties[3]);
            Rating rating = Rating.valueOf(properties[4]);
            Interest interest = Interest.valueOf(properties[5]);

            Movie movie = new Movie(id, title, genre, dateRelease, rating, interest);
            entireDatabase.add(movie);


        }

            return entireDatabase;

    }

    public List<Movie> suggestedList(Interest interest) throws IOException{
        List<Movie> suggested = new ArrayList<>();
        List<Movie> database = videoList();

        for(Movie movie: database){
            if(movie.getInterest() == interest || movie.getGenre() == getGenre()){
                suggested.add(movie);

            }
        }

        setInterest(interest);

        return suggested;
    }


    //ACCESSOR METHODS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    @Override
    public String toString() {
        return String.format("%s: name=%s, age=%s, genre=%s",
                getClass().getSimpleName(), getName(), getAge(), getGenre());
    }
}