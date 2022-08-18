package com.jvmflix.movie;

import com.apps.util.Prompter;
import com.jvmflix.user.User;
import com.jvmflix.user.UserFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JVMFlixApp{
    private static final int MINOR = 18;
    private static final int MINIMUM_AGE = 1;
    private static final int MAXIMUM_AGE = 115;
    private int age;
    private String select;
    private String name;
    private Movie option;
    private Genre genre;
    private Interest interest;

    Prompter prompter = new Prompter(new Scanner(System.in));

    public void initialize() throws IOException {
        setName(userInputName());
        setAge(userInputAge());
        setGenre(userInputGenre());
        listMovies(getName(), getAge(), getGenre());
        setInterest(userInputInterest());
        listMovieInterest();
        setSelect(userInputSelect());
        setOption(selectedMovie());
        options();

    }

    private void options() throws IOException {
        User user = UserFactory.createUser(getName(),getAge(),getGenre());
        boolean validOption = false;
        Movie selectedMovie = getOption();

        while(!validOption){
            String option = prompter.prompt("Good choice! Please select from the following options\n" +
                    "[1] - to watch\n[2] - to download\n[3] - to save to watch for later\n" +
                    "[4] - to exit\n");
            int choice = Integer.parseInt(option);
            switch (choice) {
                case 1:
                    user.watch();
                    break;
                case 2:
                    user.saveOnComputer();
                    break;
                case 3:
                    System.out.println("Saving for later");
                    break;
                case 4:
                    System.out.println("Good Bye!");

            }validOption = true;
        }
    }

    private Movie selectedMovie() throws IOException {
        String input = getSelect();
        Movie selected = null;
        User user = UserFactory.createUser(getName(),getAge(),getGenre());
        List<Movie> suggested = user.suggestedList(getInterest());
        int id = Integer.parseInt(input);
        for (Movie movie : suggested){
            if(movie.getId() == id){
                System.out.println(movie);
                selected = movie;
            }
        }return selected;
    }

    private String userInputSelect() {
        return prompter.prompt("Please select a movie by id number: ");
    }

    private void listMovieInterest() throws IOException {
        User user = UserFactory.createUser(getName(), getAge(), getGenre());
        List<Movie> movieInterest = user.suggestedList(getInterest());
        for (Movie movie : movieInterest) {
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
            String selection = prompter.prompt("Please enter type of genre of a movie. \n" +
                    "Selections are - [C]-COMEDY, [A]-ACTION, [R]-ROMANCE, [H]-HORROR, " +
                    "[DR]-DRAMA,\n [SF] SCIENCE_FICTION, [F]-FANTASY, [CF]-CHILDRENS_FILM" +
                    ",[AN]-ANIMATION,[D]-DOCUMENTARY: ").toUpperCase();
            if (selection.matches("C|A|R|H|DR|SF|F|CF|AN|D")) {
                genre = Genre.get(selection);
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
            ageResult = Integer.parseInt(result);
            if (ageResult >= MINIMUM_AGE && ageResult <= MAXIMUM_AGE) {
                validInput = true;
            }
        }
        return ageResult;
    }

    private int getAge() {
        return age;
    }

    private String getName() {
        return name;
    }

    private Genre getGenre() {
        return genre;
    }

    private Interest getInterest() {
        return interest;
    }

    private String getSelect() {
        return select;
    }

    public Movie getOption() {
        return option;
    }

    public void setOption(Movie option) {
        this.option = option;
    }

    private void setSelect(String select) {
        this.select = select;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setGenre(Genre genre) {
        this.genre = genre;
    }

    private void setInterest(Interest interest) {
        this.interest = interest;
    }
}