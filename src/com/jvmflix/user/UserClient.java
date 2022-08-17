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



            System.out.println();
            User factoryUser2 = UserFactory.createUser("Woodley", 34, Genre.ACTION);
            List<Movie> factoryList2 = factoryUser2.suggestedList(Interest.LOVE);
            System.out.println(factoryUser2.videoList());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}