Needed to be installed: JavaFX javafx-sdk-11.0.2

Put JavaFX in a secure folder where it can be reached but not easily deleted

Get the path to javafx-sdk-11.0.2\lib and cop it

In eclipse right click on the project and click the following:
	-Run configuarations
	-Select the Main class
	-Click on the arguments tab
	-Paste the following two lines with the updated JavaFX library path

--module-path "JavaFX Path\lib" --add-modules javafx.controls,javafx.fxml

--add-modules javafx.controls,javafx.fxml,javafx.media

Next the Build Path needs to be updated:
	-Right click on the project and select properties
	-On the left side select Java Build Path
	-Select Libraries at the top menu and then add external jars on the right side
	-Go to the directory where JavaFX\lib is and import all the files in that directory
	-Hit apply and then close(You know it worked if all the errors are gone)



-Have a good time using Knock Off Spotify!