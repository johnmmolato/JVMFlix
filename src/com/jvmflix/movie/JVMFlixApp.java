package com.jvmflix.movie;


import com.apps.util.Prompter;
import com.apps.util.SplashApp;
import com.jvmflix.user.User;
import com.jvmflix.user.UserFactory;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class JVMFlixApp implements SplashApp {
    private static final int MINOR = 18;
    private static final int MINIMUM_AGE = 1;
    private static final int MAXIMUM_AGE = 115;
    JFrame frame;
    Prompter prompter = new Prompter(new Scanner(System.in));

    @Override
    public void start() {
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() throws IOException {
        String name = userInputName();
        int age = userInputAge();
        Genre genre = userInputGenre();
        listMovies(name, age, genre);
        userInputInterest();
        listMovieInterest();
    }

    private void listMovieInterest() throws IOException {
        User user = UserFactory.createUser(userInputName(), userInputAge(), userInputGenre());
        List<Movie> movieInterest = user.suggestedList(userInputInterest());

        for(Movie movie : movieInterest){
            System.out.println(movie);
        }
    }

    private Interest userInputInterest() {
        Interest interest = null;
        boolean validInput = false;
        while (!validInput) {
            String input = prompter.prompt("Please provide select your interest: \n" +
                    "[N]-NATURE, [L]-LOVE, [F]-FOOD, [A] ANIMALS, [S]-SPORTS. ").toUpperCase();
            if (input.matches("N|L|F|A|S")) {
                interest = Interest.getInterest(input);
                validInput = true;
            } else {
                System.out.println("Please enter a valid selection");
            }
        }
        return interest;
    }

    private void listMovies(String name, int age, Genre genre) throws IOException {
        User user = UserFactory.createUser(name, age, genre);
        List<Movie> userList = user.videoList();

        for (Movie movie : userList) {
            System.out.println(movie);
        }
    }

    private Genre userInputGenre() {
        Genre genre = null;
        boolean validInput = false;
        while (!validInput) {
            String name = prompter.prompt("Please enter type of genre of a movie. \n" +
                    "Selections are - [C]-COMEDY, [A]-ACTION, [R]-ROMANCE, [H]-HORROR, " +
                    "[DR]-DRAMA,\n [SF] SCIENCE_FICTION, [F]-FANTASY, [CF]-CHILDRENS_FILM" +
                    ",[AN]-ANIMATION,[D]-DOCUMENTARY: ").toUpperCase();
            if (name.matches("C|A|R|H|DR|SF|F|CF|AN|D")) {
                genre = Genre.get(name);
                validInput = true;
            } else {
                System.out.println("Please enter valid selection");
            }
        }
        return genre;
    }

    private String userInputName() {
        return prompter.prompt("Please enter you name: ");
    }

    private int userInputAge() {
        int ageResult = 0;
        boolean validInput = false;
        while (!validInput) {
            String result = prompter.prompt("Please enter your age: ", "\\d+", "");
            if (Integer.parseInt(result) >= MINIMUM_AGE && Integer.parseInt(result) <= MAXIMUM_AGE) {
                validInput = true;
            }
        }
        return ageResult;
    }

}