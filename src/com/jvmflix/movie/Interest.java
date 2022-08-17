package com.jvmflix.movie;
// making this enum public because User needs to pull this info
public enum Interest {
    NATURE,
    LOVE,
    FOOD,
    ANIMALS,
    SPORTS;

    public static Interest getInterest(String interest){

        Interest result = null;
        switch (interest){
            case "N":
                result = NATURE;
                break;
            case "L":
                result = LOVE;
                break;
            case "F":
                result = FOOD;
                break;
            case "A":
                result = ANIMALS;
                break;
            case "S":
                result = SPORTS;
                break;
        }
        return result;
    }
}