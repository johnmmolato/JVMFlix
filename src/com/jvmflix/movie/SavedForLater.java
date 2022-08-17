package com.jvmflix.movie;


import java.io.*;
import java.nio.file.Files;


import java.util.*;
import java.nio.file.Path;

import java.io.IOException;

// user selected movie to save for later
// file gets updated
// show the user

public class SavedForLater implements Serializable {//serialization or serialisation is the process of translating a data structure or object state into a format that can be stored or transmitted and reconstructed later.

	public static SavedForLater getInstance() {
		SavedForLater savedForLater = null;
		if (Files.exists(Path.of("data/savedForLater.dat"))) {
			try (OjectInputStream in = new OjectInputStream(new FileInputStream("data/savedForLater.dat"))) {
				savedForLater = (SavedForLater) in.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else savedForLater = new SavedForLater();
		return savedForLater;
	}

	//fields
	private final Map<Integer,String> nameMap = loadNameMap();
	private final Map<String, Movie> movieMap = new TreeMap<String, Movie>();

	private Map loadNameMap() {
	}



	//const
	private SavedForLater() {

	}

	// method
	public void display() {
		if (movieMap.isEmpty()){
			System.out.println("Have you selected a movie to add?");
		} else
			System.out.println(" ");
			Collection<Movie> movies = movieMap.values();
			for (Movie movie : movies) {
				System.out.println(movie);
			}
		}


	public void update(String user, List title){
		Movie movie = null;
		if (movieMap.containsValue(user)) {
		} else {
			Movie movies = new Movie (user, nameMap.get(user));
			movieMap.put(user, movie);
		}
		assert movie != null;
		movie.new(title);
		save();
	}


	private void save(){
	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/savedForLater.dat"))) {
		out.writeObject(this); //this passes the ref to yourself
	}
	catch (Exception e){
		e.printStackTrace();
	 }
	}

	private Map<Integer, String> loadMovieMap() {
		Map<Integer, String> idMap = new HashMap<>();

		try {
			List<String> lines = Files.readAllLines(Path.of("conf/movieCollectionNew.csv"));
			for (String line : lines) {
				String[] tokens = line.split(",");
				Integer id = Integer.valueOf(tokens[0]);
				String title = tokens[1];
				idMap.put(id, title);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return idMap;
	}

}
	/*

	public static void main(String[] args) throws IOException {

		String[] names = {"Movie1/Placeholder", "Movie2/Placeholder", "Movie3/Placeholder"}; //need to change to enums

		try {
			// file is only created first time this is ran
			BufferedWriter writer = new BufferedWriter(new FileWriter("watchlist.txt"));
			// testing out text for file
			writer.write("Saved for Later List:");
			//everytime you add something to file, it is overwritten to add this data
			writer.write("\nThis is your saved for later list");
			for (String name : names) { //returns the string
				writer.write("\n" + name); //writes string in external file and \n puts on sep. lines
			}
			writer.close(); //needs to be included for file to actually be made
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader("watchlist.txt"));
			String line;
			// this while loop reads each line of text until the end of the line,
			// that the signifcance of =null
			while((line = reader.readLine()) !=null) {
				System.out.println(line);
			}
			//  System.out.println(reader.readLine()); //prints to the console
			reader.close(); //closer the reader object
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	 */
