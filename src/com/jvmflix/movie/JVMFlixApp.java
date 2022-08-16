package com.jvmflix.movie;


import com.apps.util.Prompter;
import com.apps.util.SplashApp;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class JVMFlixApp implements SplashApp {
    JFrame frame;
    SplashApp app;
    Prompter prompter = new Prompter(new Scanner(System.in));

    @Override
    public void start() {
        //app.welcome("JVMFlix.jpeg");
        initialize();
    }
    private void initialize(){
        //welcome("JVMFlix.jpeg");
        userInputAge();
        userInputName();
        userInputGenre();
        //listMovies();

    }

    private Genre userInputGenre() {
        Genre genre = null;
        boolean validInput = false;
        while(!validInput){
            String name = prompter.prompt("Please enter type of genre of a movie: ").toUpperCase();
            if(name.matches("C|A|R|H|DR|SF|F|CF|AN|D")){
                if("C".equals(name)){
                    genre = Genre.COMEDY;
                }else if("A".equals(name)){
                    genre = Genre.ACTION;
                }else if("R".equals(name)) {
                    genre = Genre.ROMANCE;
                }else if("H".equals(name)) {
                    genre = Genre.HORROR;
                }else if("DR".equals(name)) {
                    genre = Genre.DRAMA;
                }else if("SF".equals(name)) {
                    genre = Genre.SCIENCE_FICTION;
                }else if("F".equals(name)) {
                    genre = Genre.FANTASY;
                }else if("CF".equals(name)) {
                    genre = Genre.CHILDRENS_FILM;
                }else if("AN".equals(name)) {
                    genre = Genre.CHILDRENS_FILM;
                }else if("D".equals(name)) {
                    genre = Genre.CHILDRENS_FILM;
                }
                validInput = true;
            }
        }
        return genre;
    }

    private void userInputName() {
        prompter.prompt("Please enter you name: ");
        System.out.println("");
    }

    private void userInputAge() {
        prompter.prompt("Please enter your age: ", "\\d+", "\nPlease enter a valid age!\n");
    }




    /*
     * KeyHandler that handles spacebar event
     */
    public static class KeyHandler extends KeyAdapter {
        public boolean spacePressed;

        @Override
        public void keyTyped(KeyEvent e) {//not use
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_SPACE)
                spacePressed = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_SPACE)
                spacePressed = false;
        }
    }
}