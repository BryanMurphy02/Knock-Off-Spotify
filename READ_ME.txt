Import projet into Eclipse

There should most likely be errors in the beginning

Right click on the project, go to run as, then run configuartions, then under Java Application select Main

Go to the arguments tab

In the VM Arguments, there needs to be a path to JavaFX and the java control media for playing audio:


	--module-path "C:\Eclipse\JavaFX\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
	
	--add-modules javafx.controls,javafx.media
	
The first argument needs to be changed to where the javafx is installed on your pc, the second argument can be copy and pasted in

Save the arduments, the program should be able to run now