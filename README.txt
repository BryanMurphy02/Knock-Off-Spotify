Needed to be installed: JavaFX javafx-sdk-11.0.2

Put JavaFX in a secure folder where it can be reached but not easily deleted

Open a new text document to copy and paste things into

Copy the path to JavaFX\lib:
	-Open javaFX folde
	-Open the lib folder
	-At the top, click on the bar right next to the word lib
	-copy and paste into the new text file
	
Copy the following into your text file:
	--module-path "JavaFX Path\lib" --add-modules javafx.controls,javafx.fxml
	--add-modules javafx.controls,javafx.fxml,javafx.media
	
Where it says "JavaFX Path\lib" in what was just copy and pasted, replace the words inside the quotation marks with the JavaFX path(the first thing in the text file)

-Open Eclipse and right click on the project, then select properties at the very bottom
-On the left side select Java Build Path
-Select Libraries at the top menu and then add external jars on the right side
-Go to the directory where JavaFX\lib is and import all the files in that directory
-Hit apply and then close(You know it worked if all the errors are gone)

Right click on the project again, hover over run as, and then click run configurations

Click on Main on the left side, and then arguments on the top

In VM Arguments paste the edited version of the following from your text file:
	--module-path "JavaFX Path\lib" --add-modules javafx.controls,javafx.fxml
	--add-modules javafx.controls,javafx.fxml,javafx.media

Hit apply


-Have a good time using Knock Off Spotify!
