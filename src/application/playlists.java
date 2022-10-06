package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class playlists {
	
	public static ArrayList<music>library = new ArrayList<music>();
	public static ArrayList<music>likedSongs = new ArrayList<music>();
	public static ArrayList<music>selectedSongs = new ArrayList<music>();
	public static ArrayList<music>playlist1 = new ArrayList<music>();
	public static ArrayList<music>playlist2 = new ArrayList<music>();
	public static ArrayList<music>playlist3 = new ArrayList<music>();
	public static ArrayList<music>playlist4 = new ArrayList<music>();
	public static ArrayList<File>mp3 = new ArrayList<File>();




	/*
	 * Adds song to the full song library
	 * @param song Song being added to the library
	 * @param x Library ArrayList
	 */
	public static void addToLibrary(music song, ArrayList<music> x) {
		x.add(song);
	}
	
	/*
	 * Adds to a song to given play list
	 * @param song Song being added to the playlist
	 * @param x Given playlist to be added to
	 */
	public static void addToPlaylist(music song, ArrayList<music> x) {
		x.add(song);
	}
	
	/*
	 * Removes song from a given playlist
	 * @param song Song being remomved from the playlist
	 * @param x Given playlist to remove song from
	 */
	public static void removeFromPlaylist(music song, ArrayList<music> x) {
		if(x.contains(song)) {
			x.remove(song);
		}
		else {
			System.out.print("The song \"" + song.getName() + "\" was not found in the playlist");
		}
		
		
	}
	
	/*
	 * This is a method that passes in an ArrayList and prints the contents
	 */
	public static <T> void printList(List<T> x) {
		for(int i = 0; i < x.size(); i++) {
			System.out.print(x.get(i) + "\n");
		}
	}
	
	/*
	 * Adds the mp3 File to an ArrayList
	 * @param File Song being added to the ArrayList
	 * @param x Given ArrayList to add to
	 */
	public static void addTomp3(File song, ArrayList<File> x) {
		x.add(song);
	}
	
//	public static <T> void alphabeticalMusic(ArrayList<music> x) {
//		for(int i = 0; i < x.size(); i++) {
//			Collections.sort((List<T>) x);
//		}
//	}
	
	
}
