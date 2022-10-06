package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;

public class newController {
	
	//non Java-Fx Variables
	private File directory;
	
	private Media media;
    
    private MediaPlayer mediaPlayer;
    
    private int songNumber;
    
    private int volume;
    
    private Timer timer;
    
	private TimerTask task;
	
	private boolean running;
	
	private double currentSongTime = 0;
	
	private String nowPlayingSong;
	
	private String nowPlayingArtist;
    
    private ArrayList<String> clickedSongs = new ArrayList<>();
	
	
	//table columns
    @FXML
    private TableColumn<music, String> albumColumn;
    
    @FXML
    private TableColumn<music, String> songColumn;

    @FXML
    private TableColumn<music, String> artistColumn;

    @FXML
    private TableView<music> libraryTable;
    
    @FXML
    private TableView<music> likedSongsTable;
    
    @FXML
    private TableColumn<music, String> likedSongsColumn;
    
    @FXML
    private TableColumn<music, String> likedSongsArtistColumn;
    
    @FXML
    private TableColumn<music, String> likedSongsAlbumColumn;

    @FXML
    private Pane albumCoverPane;

    @FXML
    private Pane buttonsPane;

    @FXML
    private Label createPlaylistButton;

    @FXML
    private Label homeButton;

    @FXML
    private Pane homePane;

    @FXML
    private Label likedSongsButton;
    
    @FXML
    private ImageView shadedLikeButton;

    @FXML
    private Pane nowPlayingPane;

    @FXML
    private ImageView playButtonImage;

    @FXML
    private Label searchButton;

    @FXML
    private ImageView skipBackwardsButton;

    @FXML
    private ImageView skipForwardButton;

    @FXML
    private Slider volumeSlider;
    
    @FXML
    private Pane libraryPane;
    
    @FXML
    private ImageView likeSongButton;
    
    @FXML
    private Pane likedSongsPane;
    
    @FXML
    private ImageView pauseButtonImage;
    
    @FXML
    private Label artistNameLabel;
    
    @FXML
    private Label songNameLabel;
    
    @FXML
    private Label nowPlayingLabel;
    
    @FXML
    private ProgressBar songProgressBar;
    
    
    
    public void println(String x) {
    	System.out.println(x);
    }
    
    public void println(int x) {
    	System.out.println(x);
    }
    
    public void println(double x) {
    	System.out.println(x);
    }
    
    //creating the observable lists to be populated
    private ObservableList<music>library= FXCollections.observableArrayList();
    private ObservableList<music>selectedSongs = FXCollections.observableArrayList();
    private ObservableList<music>likedSongs = FXCollections.observableArrayList();
    
    
  //method that returns an Observable List that has been populated by the library ArrayList containing the objects of the songs
    public ObservableList<music> getLibrary(){
    	for(int i = 0; i < playlists.library.size(); i++) {
    		library.add(playlists.library.get(i));
    	}
    	
    	return library;
    }
    
  //method that returns an Observable List that has been populated by the likedSongs ArrayList containing the objects of the songs
    public ObservableList<music> getLikedSongs(){
    	for(int i = 0; i < playlists.likedSongs.size(); i++) {
    		if(!(likedSongs.contains(playlists.likedSongs.get(i)))) {
    			likedSongs.add(playlists.likedSongs.get(i));
    		}
    	}
    	
    	return likedSongs;
    }
    
    public void initialize() {
    	
//This try method reads from the file songs.txt and creates new objects for each song of type music and adds them to the ArrayList named library
    	
    	File[] mp3;
    			try {
    				File songs = new File("music\\songs.txt");
    				
    				Scanner reader = new Scanner(songs);
    				
    				
    				while(reader.hasNext()) {
    					String songName = "";
    					String artistName = "";
    					String albumName = "";
    					String mp3Name = "";
    					
    					String temp = reader.nextLine();
    					
    					songName = temp.substring(0, temp.indexOf("'"));
    					temp = temp.substring(temp.indexOf("'") + 1);
    					
    					artistName = temp.substring(0, temp.indexOf("'"));
    					temp = temp.substring(temp.indexOf("'") + 1);
    					
    					albumName = temp.substring(0, temp.indexOf("'"));
    					temp = temp.substring(temp.indexOf("'") + 1);
    					
    					mp3Name = temp.substring(0, temp.indexOf("'"));
    					temp = temp.substring(temp.indexOf("'") + 1);
    					
    					
    					
    					music newSong = new music(songName, artistName, albumName, mp3Name);
    					playlists.addToLibrary(newSong, playlists.library);
    				}
    				
    				reader.close();
    				
    				
    				
    				
    				
    			} catch (IOException e) {
    				System.out.print("Could not read from the file");
    				e.printStackTrace();
    			}
    			
    			
    			//takes in all the mp3 files and puts them into the playlist.mp3 ArrayList
    			directory = new File("musicFiles");
				mp3 = directory.listFiles();
				
				if(mp3 != null) {
					for(File file : mp3) {
						playlists.mp3.add(file);
					}
				}
				
				
				//setting the columns of the main table on the home page
    			songColumn.setCellValueFactory(new PropertyValueFactory<music, String>("name"));
    			artistColumn.setCellValueFactory(new PropertyValueFactory<music, String>("artist"));
    			albumColumn.setCellValueFactory(new PropertyValueFactory<music, String>("album"));
    			
    			//load the data from the Observable List for the home page
    			libraryTable.setItems((ObservableList<music>) getLibrary());
    			
    			//setting the columns of the liked songs table on the liked page
    			likedSongsColumn.setCellValueFactory(new PropertyValueFactory<music, String>("name"));
    			likedSongsArtistColumn.setCellValueFactory(new PropertyValueFactory<music, String>("artist"));
    			likedSongsAlbumColumn.setCellValueFactory(new PropertyValueFactory<music, String>("album"));
    			
    			
    			//volume initialization
    			volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
						
						mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
						
					}
    				
    			});
    	
    }
    
    public void beginTimer() {
    	timer = new Timer();
    	
    	task = new TimerTask() {
    		
    		public void run() {
    			running = true;
    			double current = mediaPlayer.getCurrentTime().toSeconds();
    			double end = media.getDuration().toSeconds();
//    			println(current/end);
    			currentSongTime = current/end;
    			songProgressBar.setProgress(currentSongTime);
    			
    			if(current/end == 1) {
    				cancelTimer();
    			}
    		}
    	};
    	
    	timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    public double getSongTime() {
    	return songProgressBar.getProgress();
    }
    
    public void cancelTimer() {
    	running = false;
    	timer.cancel();
    	
    	if(!doubleClick()) {
    		//check selectedSongs to see if current song equals the last selected song
    	}
//    	else {
//    		
//    	}
//    	
    	
    }
    
    public boolean doubleClick() {
    	boolean doubleClick = false;
    	
    	
    	
    	if(selectedSongs.size() > 1) {
    		String temp1 = selectedSongs.get(0).getSongName();
        	String temp2 = selectedSongs.get(1).getSongName();
    		if(temp1.equals(temp2)) {
    			doubleClick = true;
    		}
    	}
    	
    	return doubleClick;
    }
    
    public void nowPlayingVisible() {
    	nowPlayingLabel.setVisible(true);
    	songNameLabel.setVisible(true);
    	artistNameLabel.setVisible(true);
    }
    
    public void nowPlayingInvisible() {
    	nowPlayingLabel.setVisible(false);
    	songNameLabel.setVisible(false);
    	artistNameLabel.setVisible(false);
    }
    
    public void setNowPlaying(String x, String y) {
    	nowPlayingVisible();
    	
    	songNameLabel.setText("");
    	artistNameLabel.setText("");
    	
    	
    	//add if statements that say if the string is above a certain length to decrease the font size
    	if(x.length() >= 10 || y.length() >=10) {
    		songNameLabel.setText(x);
    		songNameLabel.setFont(new Font("Kristen ITC", 8));
        	artistNameLabel.setText(y);
        	artistNameLabel.setFont(new Font("Kristen ITC", 10));
    	}
    	else {
    		songNameLabel.setText(x);
        	artistNameLabel.setText(y);
    	}
    	
    }
    
    @FXML
    void likedSongsTableClicked(MouseEvent event) {
    	selectedSongs = likedSongsTable.getSelectionModel().getSelectedItems();
    	alreadyLiked();
    }
    
    @FXML
    void libraryTableClicked(MouseEvent event) {
    	selectedSongs = libraryTable.getSelectionModel().getSelectedItems();
    	alreadyLiked();
    }
    
    public void resetSelectedSongs() {
    	selectedSongs.clear();
    }
    
    public void addToLikedSongs() {
    	if(selectedSongs.size() != 0) {
    		for(int i = 0; i < selectedSongs.size(); i++) {
    			playlists.likedSongs.add(selectedSongs.get(i));
    		}
        	
        	//load the data from the Observable List for the liked page
    		likedSongsTable.setItems((ObservableList<music>) getLikedSongs());
    		
    		likeSongButton.setVisible(false);
    		shadedLikeButton.setVisible(true);
    		
    		
    	}
    	
    	
    	
    }
    
    public void alreadyLiked() {
    	if(likedSongs.contains(selectedSongs.get(0))) {
    		likeSongButton.setVisible(false);
    		shadedLikeButton.setVisible(true);
    	}
    	else {
    		likeSongButton.setVisible(true);
    		shadedLikeButton.setVisible(false);
    	}
    }
    
    @FXML
    void likeButtonClicked(MouseEvent event) {
    	addToLikedSongs();
    }
    
    
    //method triggered from clicking the play button
    @FXML
    void playButtonClicked(MouseEvent event) {
    	playSong();
    	nowPlayingSong = selectedSongs.get(0).getSongName();
    	nowPlayingArtist = selectedSongs.get(0).getArtist();
    	setNowPlaying(nowPlayingSong, nowPlayingArtist);
    	playButtonImage.setVisible(false);
    	pauseButtonImage.setVisible(true);
    }
    
    @FXML
    void pauseButtonImageClicked(MouseEvent event) {
    	cancelTimer();
    	mediaPlayer.pause();
    	pauseButtonImage.setVisible(false);
    	playButtonImage.setVisible(true);
    }
    
    //method that actually plays the music
    public void playSong() {
//    	ArrayList<String> temp = new ArrayList<>();
//    	String selectedName = selectedSongs.get(0).getName();
//    	
//    	for(int i = 0; i < playlists.mp3.size(); i++) {
//    		String mp3Name = playlists.mp3.get(i).toString();
//    		mp3Name = mp3Name.substring(11, mp3Name.indexOf(".")); 		
//    		
//    		temp.add(mp3Name);
//    		
//    	}
//    	
//    	for(int i = 0; i < temp.size(); i++) {
//    		if(selectedName.equals(temp.get(i))) {
//    			songNumber = i;
//    		}
//    	}
//    	
//    	//creates the mediaPlayer with a loaded song
//		media = new Media(playlists.mp3.get(songNumber).toURI().toString());
//		mediaPlayer = new MediaPlayer(media);
//    	
//		beginTimer();
//		mediaPlayer.play();
		
    	if(getSongTime() > 0) {
    		//Need to set the start time
    		//Has to do something with a duration
    		//mediaPlayer.setStartTime(null);
    	}
    	else {
    		ArrayList<String> temp = new ArrayList<>();
        	String selectedName = selectedSongs.get(0).getName();
        	
        	for(int i = 0; i < playlists.mp3.size(); i++) {
        		String mp3Name = playlists.mp3.get(i).toString();
        		mp3Name = mp3Name.substring(11, mp3Name.indexOf(".")); 		
        		
        		temp.add(mp3Name);
        		
        	}
        	
        	for(int i = 0; i < temp.size(); i++) {
        		if(selectedName.equals(temp.get(i))) {
        			songNumber = i;
        		}
        	}
        	
        	//creates the mediaPlayer with a loaded song
    		media = new Media(playlists.mp3.get(songNumber).toURI().toString());
    		mediaPlayer = new MediaPlayer(media);
        	
    		beginTimer();
    		mediaPlayer.play();
    	}
    	
    }
    
    @FXML
    void likedSongsClicked(MouseEvent event) {
    	libraryPane.setVisible(false);
    	likedSongsPane.setVisible(true);
    	clickedSongs.clear();
    	
    	likeSongButton.setVisible(true);
    	shadedLikeButton.setVisible(false);
    }
    
    @FXML
    void homeClicked(MouseEvent event) {
    	likedSongsPane.setVisible(false);
    	libraryPane.setVisible(true);
    	clickedSongs.clear();
    	
    	likeSongButton.setVisible(true);
    	shadedLikeButton.setVisible(false);
    }
    
    

}
