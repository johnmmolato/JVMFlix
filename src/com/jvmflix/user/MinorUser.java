package com.jvmflix.user;

import com.jvmflix.movie.Genre;
import com.jvmflix.movie.Interest;
import com.jvmflix.movie.Movie;
import com.jvmflix.movie.Rating;

import java.util.ArrayList;
import java.util.List;

public class MinorUser extends User {

    public MinorUser(String name, int age, Genre genre) {
        super(name, age, genre);
    }

    @Override
    public List<Movie> suggestedList(Interest interest) {
        List<Movie> suggested = new ArrayList<>();
        List<Movie> database = videoList();

        for (Movie movie : database) {
            if ((movie.getInterest() == interest || movie.getGenre() == getGenre()) && movie.getRating() != Rating.R) {
                suggested.add(movie);
            }
        }

        setInterest(interest);

        return suggested;
    }

    @Override
    public List<Movie> videoList() {
        List<Movie> minorList = new ArrayList<>();
        List<Movie> regularList = super.videoList();
        for (Movie movie: regularList){
            if(movie.getRating() != Rating.R){
                minorList.add(movie);
            }
        }

        return minorList;
    }
}