package com.jvmflix.user;

import com.jvmflix.movie.Genre;
import com.jvmflix.movie.Interest;
import com.jvmflix.movie.Movie;
import com.jvmflix.movie.Rating;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User {

    //PROPERTIES
    private String name;
    private int age;
    private Genre genre;

    //CONSTRUCTORS

    public User(String name, int age, Genre genre) {
        setName(name);
        setAge(age);
        setGenre(genre);

    }

    //BUSINESS METH0DS
    public void toSelect() {

    }

    public void watch() {

    }
//this section was worked on by Miggie but commented out to not disturb the original code during the commit process
    /*
     * Psuedo Code:
     * user picks a movie they want to "save for later"
     * movie has the properties: title, rating, genre, interest
     * user property: name and age
     * add movie to list on the text file 'watchlist.txt' (this is already created)
     * continue to add movie item to list
     * be able to access this list from file whenever the user wants to
     */

    /*
    public static void main(String[] args) throws IOException {

        String[] movies = {"Movies1", "Movie2", "Movie3"}; //need to change to enums
        try {
            // file is only created first time this is ran
            BufferedWriter writer = new BufferedWriter(new FileWriter("watchlist.txt"));
            // testing out text for file
            writer.write("This is Movie1:  Genre:, Title: , Rating: ");
            //everytime you add something to file, it is overwritten to add this data
            writer.write("\nThis is Movie2. Genre:, Title: , Rating: (new line).");
            writer.write("\nThis is Movie3. Genre:, Title: , Rating: (new line).");


            for (String movie : movies) { //returns the string
                writer.write("\n" + movie); //writes string in external file and \n puts on sep. lines
            }
            writer.close(); //needs to be included for file to actually be made
        } catch (IOException e) {
            e.printStackTrace();
        }
// need to pull in enums of genre and interest based on user wanting to use later
// return an option of save for later list incase user doesnt save anything for later
        try {
            BufferedReader reader = new BufferedReader(new FileReader("watchlist.txt"));
            String line;
            // this while loop reads each line of text until the end of the line,
            // that the signifcance of =null
            while((line = reader.readLine()) !=null) {
                System.out.println(line); // prints line by line
            }
            //  System.out.println(reader.readLine()); //prints to the console
            reader.close(); //closer the reader object
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
     *This is the save for later list based on what the user inputs from reccomended list
     * BufferedReading is going to read list from the watchlist text file,
     */
    //  public void List<Movie> saveForLater( ) throws IOException{

 //       List<String> lines = Files.readAllLines(Path.of("watchlist.txt"));
 //       List<Movie> watchList = new ArrayList<>();

 //       for(String line: lines){

//          Movie line = new Movie(genre);
  //          watchList.add(line);
  //      }
 //       return watchList;
 //   }


    public void download() {

    }

    public List<Movie> videoList( ) throws IOException {

        /* Pulling array of recommended movies here.
        Scanner is going to read the list of movies text file, filtering by interest and
        *Or statement*
         */
        List<String> lines =Files.readAllLines(Path.of("conf/moviesListDemo.csv"));
        List<Movie> entireDatabase = new ArrayList<>();

        for(String line: lines){
            String [] properties = line.split(",");
            int id = Integer.parseInt(properties[0]);
            String title = properties[1];
            Genre genre = Genre.valueOf(properties[2]);
            int dateRelease = Integer.parseInt(properties[3]);
            Rating rating = Rating.valueOf(properties[4]);
            Interest interest = Interest.valueOf(properties[5]);

            Movie movie = new Movie(id, title, genre, dateRelease, rating, interest);
            entireDatabase.add(movie);


        }

            return entireDatabase;

    }

    public List<Movie> suggestedList(Interest interest) throws IOException{
        List<Movie> suggested = new ArrayList<>();
        List<Movie> database = videoList();

        for(Movie movie: database){
            if(movie.getInterest() == interest || movie.getGenre() == getGenre()){
                suggested.add(movie);
            }
        }

        return suggested;
    }


    //ACCESSOR METHODS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s: name=%s, age=%s, genre=%s",
                getClass().getSimpleName(), getName(), getAge(), getGenre());
    }
}