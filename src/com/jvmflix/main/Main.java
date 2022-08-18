package com.jvmflix.main;

import com.jvmflix.movie.JVMFlixApp;

import java.io.IOException;

class Main {
    public static void main(String[] args) {
        JVMFlixApp app = new JVMFlixApp();
        try {
            app.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}