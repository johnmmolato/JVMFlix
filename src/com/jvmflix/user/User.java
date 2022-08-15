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

public class User {

    //PROPERTIES
    private String name;
    private int age;
    private Genre genre;

    //CONSTRUCTORS

    public User(String name, int age, Genre genre) {
        setName(name);
        setAge(age);
        setGenre(genre);

    }

    //BUSINESS METH0DS
    public void toSelect() {

    }

    public void watch() {

    }

    public void saveForLater() {

    }

    public void download() {

    }

    public List<Movie> videoList( ) throws IOException {

        /* Pulling array of recommended movies here.
        Scanner is going to read the list of movies text file, filtering by interest and
        *Or statement*
         */
        List<String> lines =Files.readAllLines(Path.of("conf/moviesListDemo.csv"));
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

    @Override
    public String toString() {
        return String.format("%s: name=%s, age=%s, genre=%s",
                getClass().getSimpleName(), getName(), getAge(), getGenre());
    }
}