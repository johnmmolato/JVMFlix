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
                break;
            case "H":
                result = HORROR;
                break;
            case "DR":
                result = DRAMA;
                break;
            case "SF":
                result = SCIENCE_FICTION;
                break;
            case "F":
                result = FANTASY;
                break;
            case "CF":
                result = CHILDRENS_FILM;
                break;
            case "AN":
                result = ANIMATION;
                break;
            case "D":
                result = DOCUMENTARY;
                break;
        }
        return result;
    }
}