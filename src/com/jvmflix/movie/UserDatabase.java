//package com.jvmflix.movie;
//
//import org.jetbrains.annotations.*;
//
//import java.util.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Scanner;
//import java.nio.file.Path;
//import java.nio.file.Files;
//import java.nio.charset.Charset;
//import java.io.IOException;
//
//public class UserDatabase {
//
//	public static void main(String[] args) {
//		ArrayList<String> movies = readFromFile("watchlist.txt");
//		System.out.println(Arrays.toString(movies.toArray()));
//		Collections.sort(movies);
//		System.out.println(Arrays.toString(movies.toArray()));
//		saveToFile("watchlist.txt", movies);
//	}
//
//	public static @NotNull
//	Arraylist readFromFile(String fileName){
//		ArrayList<String> userList = new ArrayList<>();
//		try{
//			Scanner scanner = new Scanner(new File(fileName));
//			while (scanner.hasNextLine()){
//				userList.add(scanner.nextLine());
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		return userList;
//	}
//
//	public static void saveToFile(String fileName, ArrayList list) {
//		 Path filePath = Path.get(fileName);
//		try{
//			Files.write(filePath, list, Charset.defaultCharset());
//		} catch (IOException e){
//			e.printStackTrace();
//		}
//	}
//}