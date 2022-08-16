package com.jvmflix.user;

import com.jvmflix.movie.Genre;
import com.jvmflix.movie.Interest;

import java.io.FileNotFoundException;
import java.io.IOException;

public class UserClient {
    public static void main(String[] args) {

        User user1 = new User("Miggie", 21, Genre.HORROR);
        try {
            System.out.println(user1.suggestedList(Interest.ANIMALS));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}