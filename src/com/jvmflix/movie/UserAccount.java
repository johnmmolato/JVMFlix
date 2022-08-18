package com.jvmflix.movie;

import com.jvmflix.user.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class UserAccount implements Serializable {

    //private static final String filePathName = "data/useraccount.dat";

    public static UserAccount getInstance(User user) {
        UserAccount accounts = null;
        String filePathName = "data/" + user.getName() + ".dat";

        if (Files.exists(Path.of(filePathName))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePathName))) {
                accounts = (UserAccount) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            accounts = new UserAccount();
        }
        return accounts;

    }

    private Map<String,User> savedForLaterMap = new TreeMap<>();



    public void watchList(User user, Movie movie){
        User userInMap = null;

        if(savedForLaterMap.containsKey(user.getName())){
            userInMap = savedForLaterMap.get(user.getName());
        }
        else{
            userInMap = new User(user.getName(), user.getAge(), user.getGenre());
            savedForLaterMap.put(user.getName(), user);

        }
        user.savedForLater(movie);
        userInMap.savedForLater(movie);
        save(user);
    }

    private void save(User user){
        String filePathName = "data/" + user.getName() + ".dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePathName))) {
            out.writeObject(this); //this passes the ref to yourself
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void show(){
        if(savedForLaterMap.isEmpty()){
            System.out.println("You do not have any saved movies");
        }else{
            System.out.println("Users Saved Movies");
            System.out.println("==================");

            Collection<User> users = savedForLaterMap.values();

            for(User user: users){
                System.out.println(user.getName()
                        + " " + user.getSavedForLaterMovies());
            }
        }
    }

}