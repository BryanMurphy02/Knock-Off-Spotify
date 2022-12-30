# Knock Off Spotify
##### Created By: Bryan Murphy
## Description
This JavaFX application uses a simple GUI and strives to emulate the spotify experience. The user can select from the library of songs and add to their liked songs and even make playlists. 
Please also keep in mind there are many things that need to be fixed and imporoved upon!
#
## Project Takeaways
- GUI creation
- Data Structures
- Project planning
#
## Running Knock Off Spotify
Below are the libraries needed:
- JavaFX javafx-sdk-11.0.2

The following steps are to run this program in Eclipse IDE:
1. Put JavaFX in a secure folder where it can be reached but not easily deleted
2. Open a new text document to copy and paste things into
3. Copy the path to JavaFX\lib:
    - Open javaFX folder
    - Open the lib folder
    - At the top, click on the bar right next to the word lib
    - Copy and paste into the new text file
4. Copy the following into your text file:
    - --module-path "JavaFX Path\lib" --add-modules javafx.controls,javafx.fxml
    - --add-modules javafx.controls,javafx.fxml,javafx.media
5. Where it says "JavaFX Path\lib" in what was just copy and pasted, replace the words inside the quotation marks with the JavaFX path(the first thing in the text file)
6. Open Eclipse and right click on the project, then select properties at the very bottom
7. On the left side select Java Build Path
8. Select Libraries at the top menu and then add external jars on the right side
9. Go to the directory where JavaFX\lib is and import all the files in that directory
10. Hit apply and then close(You know it worked if all the errors are gone)
11. Right click on the project again, hover over run as, and then click run configurations
12. Click on Main on the left side, and then arguments on the top
13. In VM Arguments paste the edited version of the following from your text file:
    - --module-path "JavaFX Path\lib" --add-modules javafx.controls,javafx.fxml
    - --add-modules javafx.controls,javafx.fxml,javafx.media
14. Hit apply
