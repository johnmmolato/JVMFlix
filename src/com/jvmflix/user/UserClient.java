package com.jvmflix.user;

import com.jvmflix.movie.Genre;
import com.jvmflix.movie.Interest;
import com.jvmflix.movie.Movie;
import com.jvmflix.movie.UserAccount;

import java.io.IOException;
import java.util.List;

public class UserClient {
    public static void main(String[] args) {


            // Testing factory
        try {
            UserAccount accounts= UserAccount.getInstance();
            System.out.println("Testing the factory method");
            User user1 = UserFactory.createUser("Vanessa", 32, Genre.ACTION);
            user1.suggestedList(Interest.ANIMALS);
            Movie movie = user1.toSelect("Dumb & Dumber");
            accounts.watchList(user1, movie);
            accounts.show();





        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}