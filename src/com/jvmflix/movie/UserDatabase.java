package com.jvmflix.movie;

public class UserDatabase {
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
}