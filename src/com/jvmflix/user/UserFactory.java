package com.jvmflix.user;

import com.jvmflix.movie.Genre;

class UserFactory {
    public static User createUser(String name, int age, Genre genre){
        if (age>= 18){
            return new User(name,age, genre);
        }else{
            return new MinorUser(name, age, genre);
        }
    }
}