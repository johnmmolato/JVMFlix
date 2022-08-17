package com.jvmflix.user;

import com.jvmflix.movie.Genre;
import com.jvmflix.movie.Interest;
import com.jvmflix.movie.Movie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserClient {
    public static void main(String[] args) {


            // Testing factory
        try {
            System.out.println("Testing the factory method");
            User factoryUser1 = UserFactory.createUser("Vanessa", 17, Genre.COMEDY);
        List<Movie> factoryList1 = null;

            factoryList1 = factoryUser1.suggestedList(Interest.FOOD);
            System.out.println(factoryUser1.videoList());

            factoryUser1.toSelect("The Amazing Spiderman");
            factoryUser1.watch();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}