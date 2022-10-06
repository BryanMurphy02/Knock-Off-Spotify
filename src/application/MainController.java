package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MainController {
	
	
	//Java-FX Installation Guide
	//https://www.youtube.com/watch?v=9XJicRt_FaI&t=45s&ab_channel=BroCode
	
	@FXML
    private TableView<music> libraryTable;
	
	@FXML
    private TableColumn<music, String> songColumn;
	
    @FXML
    private TableColumn<music, String> albumColumn;

    @FXML
    private TableColumn<music, String> artistColumn;

    @FXML
    private TableView<music> likedSongsTable;
    
    @FXML
    private TableColumn<music, String> songColumn1;
	
    @FXML
    private TableColumn<music, String> albumColumn1;

    @FXML
    private TableColumn<music, String> artistColumn1;
    
    @FXML
    private TableView<music> playlistOneTable;
    
    @FXML
    private TableColumn<music, String> songColumn2;
	
    @FXML
    private TableColumn<music, String> albumColumn2;

    @FXML
    private TableColumn<music, String> artistColumn2;
    
    @FXML
    private TableView<music> playlistTwoTable;
    
    @FXML
    private TableColumn<music, String> songColumn3;
	
    @FXML
    private TableColumn<music, String> albumColumn3;

    @FXML
    private TableColumn<music, String> artistColumn3;
    
    @FXML
    private TableView<music> playlistThreeTable;
    
    @FXML
    private TableColumn<music, String> songColumn4;
	
    @FXML
    private TableColumn<music, String> albumColumn4;

    @FXML
    private TableColumn<music, String> artistColumn4;
    
    @FXML
    private TableView<music> playlistFourTable;
    
    @FXML
    private TableColumn<music, String> songColumn5;
	
    @FXML
    private TableColumn<music, String> albumColumn5;

    @FXML
    private TableColumn<music, String> artistColumn5;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    private Tab homeTab;
    
    @FXML
    private Tab likedSongsTab;

    @FXML
    private Tab playlistFour;

    @FXML
    private Tab playlistOne;

    @FXML
    private Tab playlistThree;

    @FXML
    private Tab playlistTwo;

    @FXML
    private ImageView likeButton;
    
    @FXML
    private ImageView questionmark;
    
    @FXML
    private ImageView defualtPlaylistFour;

    @FXML 
    private ImageView defualtPlaylistOne;

    @FXML
    private ImageView defualtPlaylistThree;

    @FXML
    private ImageView defualtPlaylistTwo;
    
    @FXML
    private ImageView defualtLikedSongs;
    
    @FXML
    private ImageView addToPlaylist;
    
    @FXML
    private Button playlistOneButton;
    
    @FXML
    private Button playlistTwoButton;
    
    @FXML
    private Button playlistThreeButton;
    
    @FXML
    private Button playlistFourButton;
    
    @FXML
    private Label addToPlaylistLabel;
    
    @FXML
    private Label namePlaylistLabel;
    
    @FXML
    private TextField createName;
    
    @FXML
    private ImageView returnArrow;
    
    @FXML
    private Tab testingTab;
    
    @FXML
    private Button playButton;
    
    @FXML
    private ImageView likeButton2;
    
    @FXML
    private ImageView trashCan;
    
    @FXML
    private ImageView likedSongsTrashcan;
    
    private Media media;
    
    private MediaPlayer mediaPlayer;
    
    private File directory;
    
    private static int songNumber;
    
    @FXML
    private Button tempPlayButton;
    
    
    
    
    //creating the observable lists so they can be displayed for them to be later populated
    private ObservableList<music>library= FXCollections.observableArrayList();
    private ObservableList<music>selectedSongs = FXCollections.observableArrayList();
    private ObservableList<music>likedSongs = FXCollections.observableArrayList();
    private ObservableList<music>playlistOneList = FXCollections.observableArrayList();
    private ObservableList<music>playlistTwoList = FXCollections.observableArrayList();
    private ObservableList<music>playlistThreeList = FXCollections.observableArrayList();
    private ObservableList<music>playlistFourList = FXCollections.observableArrayList();
//    SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
    
    public String playlistName = "";
    
    
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
    
    //method that returns an Observable List that has been populated by the playlist1 ArrayList containing the objects of the songs
    public ObservableList<music>getPlaylistOne(){
    	for(int i = 0; i < playlists.playlist1.size(); i++) {
    		if(!(playlistOneList.contains(playlists.playlist1.get(i)))) {
    			playlistOneList.add(playlists.playlist1.get(i));
    		}
    	}
    	
    	return playlistOneList;
    }
    
  //method that returns an Observable List that has been populated by the playlist2 ArrayList containing the objects of the songs
    public ObservableList<music>getPlaylistTwo(){
    	for(int i = 0; i < playlists.playlist2.size(); i++) {
    		if(!(playlistTwoList.contains(playlists.playlist2.get(i)))) {
    			playlistTwoList.add(playlists.playlist2.get(i));
    		}
    	}
    	
    	return playlistTwoList;
    }
    
  //method that returns an Observable List that has been populated by the playlist3 ArrayList containing the objects of the songs
    public ObservableList<music>getPlaylistThree(){
    	for(int i = 0; i < playlists.playlist3.size(); i++) {
    		if(!(playlistThreeList.contains(playlists.playlist3.get(i)))) {
    			playlistThreeList.add(playlists.playlist3.get(i));
    		}
    	}
    	
    	return playlistThreeList;
    }
    
  //method that returns an Observable List that has been populated by the playlist4 ArrayList containing the objects of the songs
    public ObservableList<music>getPlaylistFour(){
    	for(int i = 0; i < playlists.playlist4.size(); i++) {
    		if(!(playlistFourList.contains(playlists.playlist4.get(i)))) {
    			playlistFourList.add(playlists.playlist4.get(i));
    		}
    	}
    	
    	return playlistFourList;
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
    			songColumn1.setCellValueFactory(new PropertyValueFactory<music, String>("name"));
    			artistColumn1.setCellValueFactory(new PropertyValueFactory<music, String>("artist"));
    			albumColumn1.setCellValueFactory(new PropertyValueFactory<music, String>("album"));
    			
    			//setting the columns of the playlistOne table
    			songColumn2.setCellValueFactory(new PropertyValueFactory<music, String>("name"));
    			artistColumn2.setCellValueFactory(new PropertyValueFactory<music, String>("artist"));
    			albumColumn2.setCellValueFactory(new PropertyValueFactory<music, String>("album"));
    			
    			//setting the columns of the playlistTwo table
    			songColumn3.setCellValueFactory(new PropertyValueFactory<music, String>("name"));
    			artistColumn3.setCellValueFactory(new PropertyValueFactory<music, String>("artist"));
    			albumColumn3.setCellValueFactory(new PropertyValueFactory<music, String>("album"));
    			
    			//setting the columns of the playlistThree table
    			songColumn4.setCellValueFactory(new PropertyValueFactory<music, String>("name"));
    			artistColumn4.setCellValueFactory(new PropertyValueFactory<music, String>("artist"));
    			albumColumn4.setCellValueFactory(new PropertyValueFactory<music, String>("album"));
    			
    			//setting the columns of the playlistFour table
    			songColumn5.setCellValueFactory(new PropertyValueFactory<music, String>("name"));
    			artistColumn5.setCellValueFactory(new PropertyValueFactory<music, String>("artist"));
    			albumColumn5.setCellValueFactory(new PropertyValueFactory<music, String>("album"));
    			
    			
    			
    			tabPane.getTabs().remove(playlistOne);
    			tabPane.getTabs().remove(playlistTwo);
    			tabPane.getTabs().remove(playlistThree);
    			tabPane.getTabs().remove(playlistFour);
    			
    			

    }
    
    //End of the Initialized method
    
    //adds the selected row to an observable list
    @FXML
    void getSong(MouseEvent click) {
    	if(tabPane.getSelectionModel().getSelectedItem() == homeTab) {
    		selectedSongs = libraryTable.getSelectionModel().getSelectedItems();
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == likedSongs) {
    		selectedSongs = likedSongsTable.getSelectionModel().getSelectedItems();
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == playlistOne) {
    		selectedSongs = playlistOneTable.getSelectionModel().getSelectedItems();
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == playlistTwo) {
    		selectedSongs = playlistTwoTable.getSelectionModel().getSelectedItems();
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == playlistThree) {
    		selectedSongs = playlistThreeTable.getSelectionModel().getSelectedItems();
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == playlistFour) {
    		selectedSongs = playlistFourTable.getSelectionModel().getSelectedItems();
    	}
    }
    
    public void resetSelectedSongs() {
    	selectedSongs.clear();
    }
    
    //Adds the contents of the selectedSongs to the likedSongs ArrayList
    @FXML
    void likeButtonClicked(MouseEvent event) {
    	addToLikedSongs();
    }
    
    
    //Changes the scene from the Main Page to the Help Page when when the question mark is clicked
    @FXML
    void questionmarkClicked(MouseEvent event) {
    	try {
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/helpPage.fxml"));
			Scene helpPageScene = new Scene(root2);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(helpPageScene);
			window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //Changes the scene from the Main Page to the Playlist Page when when the playlist icon is clicked
    @FXML
    void addToPlaylist(MouseEvent event) {
    	showAddToPlaylistPage();
    }
    
    public void showAddToPlaylistPage() {
    	if(!(selectedSongs.size() == 0)) {
    		//Hiding everything that is visible by defualt
        	libraryTable.setVisible(false);
        	likeButton.setVisible(false);
        	addToPlaylist.setVisible(false);
        	questionmark.setVisible(false);
        	
        	//setting the new things to be visible
        	addToPlaylistLabel.setVisible(true);
        	createName.setVisible(true);
        	namePlaylistLabel.setVisible(true);
        	returnArrow.setVisible(true);
        	
        	//makes the text field empty
        	createName.setText("");
        	
        	//if statements to see if the playlists already have names and if they do to set them as visible
        	if(playlistOneList.size() == 0) {
        		playlistOneButton.setVisible(false);
        	}
        	else {
        		playlistOneButton.setVisible(true);
        	}
        	
        	if(playlistTwoList.size() == 0) {
        		playlistTwoButton.setVisible(false);
        	}
        	else {
        		playlistTwoButton.setVisible(true);
        	}
        	
        	if(playlistThreeList.size() == 0) {
        		playlistThreeButton.setVisible(false);
        	}
        	else {
        		playlistThreeButton.setVisible(true);
        	}
        	
        	if(playlistFourList.size() == 0) {
        		playlistFourButton.setVisible(false);
        	}
        	else {
        		playlistFourButton.setVisible(true);
        	}
    	}
    }
    
    
    public void goToRegularHomePage() {
    	addToPlaylistLabel.setVisible(false);
    	playlistOneButton.setVisible(false);
    	playlistTwoButton.setVisible(false);
    	playlistThreeButton.setVisible(false);
    	playlistFourButton.setVisible(false);
    	createName.setVisible(false);
    	namePlaylistLabel.setVisible(false);
    	returnArrow.setVisible(false);
    	
    	libraryTable.setVisible(true);
    	likeButton.setVisible(true);
    	addToPlaylist.setVisible(true);
    	questionmark.setVisible(true);
    }
    
    @FXML
    void returnArrowClicked(MouseEvent event) {
    	goToRegularHomePage();
    }
    
    @FXML
    void getLikedSong(MouseEvent event) {
    	
    }
    
    @FXML
    void playlistOneButtonClicked(MouseEvent event) {
    	addToPlaylistOne();
    	addToLikedSongs();
    	if(!(playlistName.equals("") || playlistName.equals(" "))) {
    		playlistOne.setText(playlistName);
    		playlistOneButton.setText(playlistName);
    		tabPane.getTabs().add(playlistOne);
    		goToRegularHomePage();
    	}
    }
    
    @FXML
    void playlistTwoButtonClicked(MouseEvent event) {
    	addToPlaylistTwo();
    	addToLikedSongs();
    	if(!(playlistName.equals("") || playlistName.equals(" "))) {
    		playlistTwo.setText(playlistName);
    		playlistTwoButton.setText(playlistName);
    		tabPane.getTabs().add(playlistTwo);
    		goToRegularHomePage();
    	}
    }
    
    @FXML
    void playlistThreeButtonClicked(MouseEvent event) {
    	addToPlaylistThree();
    	addToLikedSongs();
    	if(!(playlistName.equals("") || playlistName.equals(" "))) {
    		playlistThree.setText(playlistName);
    		playlistThreeButton.setText(playlistName);
    		tabPane.getTabs().add(playlistThree);
    		goToRegularHomePage();
    	}
    }
    
    @FXML
    void playlistFourButtonClicked(MouseEvent event) {
    	addToPlaylistFour();
    	addToLikedSongs();
    	if(!(playlistName.equals("") || playlistName.equals(" "))) {
    		playlistFour.setText(playlistName);
    		playlistFourButton.setText(playlistName);
    		tabPane.getTabs().add(playlistFour);
    		goToRegularHomePage();
    	}
    }
    
    public void addToLikedSongs() {
    	if(selectedSongs.size() != 0) {
    		for(int i = 0; i < selectedSongs.size(); i++) {
    			playlists.likedSongs.add(selectedSongs.get(i));
    		}
        	
        	
        	//hide the defualt image and make the table visible
        	defualtLikedSongs.setVisible(false);
        	
        	//load the data from the Observable List for the liked page
    		likedSongsTable.setItems((ObservableList<music>) getLikedSongs());
    	}
    	
    }

    
    public void addToPlaylistOne() {
    	
    	if(selectedSongs.size() != 0) {
    		defualtPlaylistOne.setVisible(false);
        	
        	
        	for(int i = 0; i < selectedSongs.size(); i++) {
        		playlists.playlist1.add(selectedSongs.get(i));
        	}
        	
        	playlistOneTable.setItems((ObservableList<music>) getPlaylistOne());
    	}
    	
    }
    
    public void addToPlaylistTwo() {
    	
    	if(selectedSongs.size() != 0) {
    		defualtPlaylistTwo.setVisible(false);
        	
        	
        	for(int i = 0; i < selectedSongs.size(); i++) {
        		playlists.playlist2.add(selectedSongs.get(i));
        	}
        	
        	playlistTwoTable.setItems((ObservableList<music>) getPlaylistTwo());
    	}
    	
    }
    
    public void addToPlaylistThree() {
    	if(selectedSongs.size() != 0) {
    		defualtPlaylistThree.setVisible(false);
        	
        	
        	for(int i = 0; i < selectedSongs.size(); i++) {
        		playlists.playlist3.add(selectedSongs.get(i));
        	}
        	
        	playlistThreeTable.setItems((ObservableList<music>) getPlaylistThree());
    	}
    	
    }
    
    
    public void addToPlaylistFour() {
    	if(selectedSongs.size() != 0) {
    		defualtPlaylistFour.setVisible(false);
        	
        	
        	for(int i = 0; i < selectedSongs.size(); i++) {
        		playlists.playlist4.add(selectedSongs.get(i));
        	}
        	
        	playlistFourTable.setItems((ObservableList<music>) getPlaylistFour());
    	}
    	
    }
    
    @FXML
    void getPlaylistName(ActionEvent event) {
    	this.playlistName = createName.getText();
    	playlistOneButton.setVisible(true);
    	playlistTwoButton.setVisible(true);
    	playlistThreeButton.setVisible(true);
    	playlistFourButton.setVisible(true);
    }
    
    //method to put the user back to the home tab
    @FXML
    void likeButton2Clicked(MouseEvent event) {
    	tabPane.getSelectionModel().select(homeTab);
    	showAddToPlaylistPage();
    }
    
    @FXML
    void deleteFromPlaylist(MouseEvent event) {
    	if(tabPane.getSelectionModel().getSelectedItem() == playlistOne) {
    		for(int i = 0; i < selectedSongs.size(); i++) {
    			playlistOneList.remove(selectedSongs.get(i));
    			playlists.removeFromPlaylist(selectedSongs.get(i), playlists.playlist1);
    		}
//    		resetSelectedSongs();
//			System.out.println(selectedSongs.get(i));
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == playlistTwo) {
    		for(int i = 0; i < selectedSongs.size(); i++) {
    			playlistTwoList.remove(selectedSongs.get(i));
    			playlists.removeFromPlaylist(selectedSongs.get(i), playlists.playlist2);
    		}
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == playlistThree) {
    		for(int i = 0; i < selectedSongs.size(); i++) {
    			playlistThreeList.remove(selectedSongs.get(i));
    			playlists.removeFromPlaylist(selectedSongs.get(i), playlists.playlist3);
    		}
    	}
    	else if(tabPane.getSelectionModel().getSelectedItem() == playlistFour) {
    		for(int i = 0; i < selectedSongs.size(); i++) {
    			playlistFourList.remove(selectedSongs.get(i));
    			playlists.removeFromPlaylist(selectedSongs.get(i), playlists.playlist4);
    		}
    	}
    }
    
    
    //deleting from the liked song
    @FXML
    void deleteFromLikedSongs(MouseEvent event) {
    	likedSongs.remove(selectedSongs.get(0));
    }
    
    
    
    //website link: https://edencoding.com/playing-audio/#mediaplayer
    
    //also watch this youtube video: https://www.youtube.com/watch?v=-D2OIekCKes&ab_channel=BroCode
    
//    Media buzzer = new Media(getClass().getResource("/musicFiles/Black Catcher.mp3").toExternalForm());
//	MediaPlayer mediaPlayer = new MediaPlayer(buzzer);
	
    @FXML
    void playButtonClicked(MouseEvent event) {
    	mediaPlayer.play();
//    	System.out.println("It's working");
    }
    
    @FXML
    void tempPlayButtonClicked(MouseEvent event) {
    	
    	ArrayList<String> temp = new ArrayList<>();
//    	System.out.println("It's working");
    	String selectedName = selectedSongs.get(0).getName();
    	
    	for(int i = 0; i < playlists.mp3.size(); i++) {
    		String mp3Name = playlists.mp3.get(i).toString();
    		mp3Name = mp3Name.substring(11, mp3Name.indexOf(".")); 		
//    		System.out.println(mp3Name);
    		
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
    	
    	mediaPlayer.play();
    	
    	
    }
    
    



		
	}
    
    


