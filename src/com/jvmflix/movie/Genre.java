package com.jvmflix.movie;

// Making Genre public because the User class needs it
public enum Genre {

    COMEDY,
    ACTION,
    ROMANCE,
    HORROR,
    DRAMA,
    SCIENCE_FICTION,
    FANTASY,
    CHILDRENS_FILM,
    ANIMATION,
    DOCUMENTARY;

    public static Genre get (String indicator){
        //switch case
        Genre result = null;
        switch (indicator){
            case "C":
                result = COMEDY;
                break;
            case "A":
                result = ACTION;
                break;
            case "R":
                result = ROMANCE;
            case "H":
                result = HORROR;
            case "DR":
                result = DRAMA;
            case "SF":
                result = SCIENCE_FICTION;
            case "F":
                result = FANTASY;
            case "CF":
                result = CHILDRENS_FILM;
            case "AN":
                result = ANIMATION;
            case "D":
                result = DOCUMENTARY;
        }
        return result;
    }
}