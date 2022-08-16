package com.jvmflix.movie;


import com.apps.util.Prompter;
import com.apps.util.SplashApp;
import com.jvmflix.user.MinorUser;
import com.jvmflix.user.User;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JVMFlixApp implements SplashApp {
    private static final int MINOR = 18;
    JFrame frame;
    //SplashApp app;
    Prompter prompter = new Prompter(new Scanner(System.in));

    @Override
    public void start() {
        //app.welcome("JVMFlix.jpeg");
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() throws IOException {
        //welcome("JVMFlix.jpeg");
        String name = userInputName();
        int age = userInputAge();
        Genre genre = userInputGenre();
        listMovies(name, age, genre);

    }

    private void listMovies(String name, int age, Genre genre) throws IOException {
        User user = new User(name, age, genre);
        MinorUser minorUser = new MinorUser(name, age, genre);
        List<Movie> userList = new ArrayList<>(user.videoList());
        List<Movie> userListMinor = (List<Movie>) userList.stream().filter(movie -> !movie.getRating().equals(Rating.R));
        List<Movie> userMovies = new ArrayList<>();
        for (Movie movie : userListMinor) {
            if (userInputAge() < MINOR) {
                userMovies.add(movie);
            }
            userMovies.add(movie);
        }
        System.out.println(userMovies);
    }

    private Genre userInputGenre() {
        Genre genre = null;
        boolean validInput = false;
        while (!validInput) {
            String name = prompter.prompt("Please enter type of genre of a movie: ").toUpperCase();
            if (name.matches("C|A|R|H|DR|SF|F|CF|AN|D")) {//add selection description
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
        String result = prompter.prompt("Please enter your age: ", "\\d+", "\nPlease enter a valid age!\n");//empty string for no error text
        int ageResult = Integer.parseInt(result);// add restriction
        return ageResult;
    }
}