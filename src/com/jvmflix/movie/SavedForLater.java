package com.jvmflix.movie;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class SavedForLater {

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
}