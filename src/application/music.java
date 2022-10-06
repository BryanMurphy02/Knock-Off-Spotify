package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.sound.sampled.*;

import javafx.beans.property.SimpleStringProperty;



public class music {
	
	
	SimpleStringProperty name;
	SimpleStringProperty artist;
	SimpleStringProperty album;
	String mp3Name;

	
	
	public music(String name, String artist, String album, String mp3Name) {
		this.name = new SimpleStringProperty(name);
		this.artist = new SimpleStringProperty(artist);
		this.album = new SimpleStringProperty(album);
		this.mp3Name = mp3Name;
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getArtist() {
		return artist.get();
	}
	
	public void setArtist(String artist) {
		this.artist.set(artist);
	}
	
	public String getAlbum() {
		return album.get();
	}
	
	public void setAlbum(String album) {
		this.album.set(album);
	}
	
	public String getSongName() {
		return this.mp3Name.substring(0, mp3Name.length() - 4);
	}
	
	public String toString() {
		return "Song: " + name + "\nArtist: " + artist + "\nAlbum: " + album;
	}
	
	
		
}
