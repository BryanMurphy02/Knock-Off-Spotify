# Knock Off Spotify
##### Created By: Bryan Murphy
## Description
This JavaFX application uses a simple GUI and strives to emulate the spotify experience. The user can select from the library of songs and add to their liked songs and even make playlists. 
Please also keep in mind there are many things that need to be fixed and imporoved upon!
#
## Usage
- Play, pause, and skip songs
- Like songs
- Create playlists
#
## Algorithms and Data Structures
- Array Lists
- Queues
- Binary search
- Bubble sort

## Prerequisites
Before running the program, make sure you have the following installed:
- JavaFX javafx-sdk-11.0.2

## Running Knock Off Spotify
Before running Knock Off Spotify, the JavaFX library must be properly installed into Eclipse.

Here are the steps to insall JavaFX:

1. Create a new folder and move the JavaFX sdk into it to keep it secure.
2. Open a new text document and copy the path to the JavaFX\lib folder:
   - Open the JavaFX folder.
   - Open the lib folder.
   - Click on the address bar at the top of the window to highlight it.
   - Copy the highlighted path to the clipboard.
3. In the text document, paste the following line, replacing "JavaFX Path\lib" with the path copied in step 2:
```bash
--module-path "JavaFX Path\lib" 
--add-modules javafx.controls,javafx.fxml,javafx.media
4. Open Eclipse and right-click on the project in the Package Explorer, then select "Properties" at the bottom.
5. In the left-hand panel, select "Java Build Path."
6. At the top of the window, select the "Libraries" tab.
7. Click the "Add External JARs" button on the right side.
8. Navigate to the directory where JavaFX\lib is located and select all the files in that directory.
9. Click "Apply and Close." All the errors should disappear.
10. Right-click on the project in the Package Explorer again, hover over "Run As," and then click "Run Configurations."
11. Select "Main" on the left-hand side, and then select the "Arguments" tab at the top.
12. In the "VM Arguments" field, paste the edited version of the line from step 3.
13. Click "Apply" and then "Run."

Once you've completed these steps, the Knock Off Spotify program should run successfully. If you encounter any issues, make sure that you've followed all the steps carefully and that the required dependencies are installed correctly.

