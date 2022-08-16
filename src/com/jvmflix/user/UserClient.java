package com.jvmflix.user;

import com.jvmflix.movie.Genre;
import com.jvmflix.movie.Interest;
import com.jvmflix.movie.Movie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserClient {
    public static void main(String[] args) {

        User user1 = new User("Miggie", 21, Genre.HORROR);
        MinorUser user2 = new MinorUser("Vanessa", 17, Genre.HORROR);
        try {
            List<Movie> movieListResult1 = user1.suggestedList(Interest.ANIMALS);
            for(Movie movie: movieListResult1){
                System.out.println(movie);
            }
            System.out.println(user1.toSelect("Dumb & Dumber"));
            user1.watch();
            System.out.println();

            List<Movie> movieListResult2 = user2.suggestedList(Interest.ANIMALS);
            for(Movie movie: movieListResult2){
                System.out.println(movie);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}