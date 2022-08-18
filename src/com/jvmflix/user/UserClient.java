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

            System.out.println("Testing the factory method");
            User user1 = UserFactory.createUser("Vanessa", 32, Genre.ACTION);
            UserAccount account1= UserAccount.getInstance(user1);
            user1.suggestedList(Interest.ANIMALS);
            Movie movie = user1.toSelect("Dumb & Dumber");
            account1.watchList(user1, movie);
            account1.show();

            User user2 = UserFactory.createUser("Woodley", 33, Genre.ACTION);
            UserAccount account2= UserAccount.getInstance(user2);
            user2.suggestedList(Interest.ANIMALS);
            Movie movie2 = user2.toSelect("Dumb & Dumber");
            account2.watchList(user2, movie2);
            account2.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}