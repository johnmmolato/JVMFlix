package com.jvmflix.movie;

import com.apps.util.Prompter;
import com.apps.util.SplashApp;
import com.jvmflix.user.User;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class JVMFlixApp implements SplashApp {
    JFrame frame;
    SplashApp app;
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
        User user = new User(name,age,genre);
        List<Movie> userList = new ArrayList<>(user.videoList());
        List<Movie> userMovies = new ArrayList<>();
        for(Movie movie : userList){
            userMovies.add(movie);
        }
        System.out.println(userMovies);
    }

    private Genre userInputGenre() {
        Genre genre = null;
        boolean validInput = false;
        while (!validInput) {
            String name = prompter.prompt("Please enter type of genre of a movie: ").toUpperCase();
            if (name.matches("C|A|R|H|DR|SF|F|CF|AN|D")) {
                if ("C".equals(name)) {
                    genre = Genre.COMEDY;
                } else if ("A".equals(name)) {
                    genre = Genre.ACTION;
                } else if ("R".equals(name)) {
                    genre = Genre.ROMANCE;
                } else if ("H".equals(name)) {
                    genre = Genre.HORROR;
                } else if ("DR".equals(name)) {
                    genre = Genre.DRAMA;
                } else if ("SF".equals(name)) {
                    genre = Genre.SCIENCE_FICTION;
                } else if ("F".equals(name)) {
                    genre = Genre.FANTASY;
                } else if ("CF".equals(name)) {
                    genre = Genre.CHILDRENS_FILM;
                } else if ("AN".equals(name)) {
                    genre = Genre.CHILDRENS_FILM;
                } else if ("D".equals(name)) {
                    genre = Genre.CHILDRENS_FILM;
                }
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
       String result = prompter.prompt("Please enter your age: ", "\\d+", "\nPlease enter a valid age!\n");
        int ageResult = Integer.parseInt(result);
        return ageResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JVMFlixApp app1 = (JVMFlixApp) o;
        return Objects.equals(app, app1.app) && Objects.equals(prompter, app1.prompter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(app, prompter);
    }
}