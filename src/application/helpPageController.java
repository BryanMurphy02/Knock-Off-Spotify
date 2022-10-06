package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class helpPageController {

    @FXML
    private Button homeButton;

    @FXML
    void homeButtonClicked(MouseEvent event) {
    	try {
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/MainPage.fxml"));
			Scene helpPageScene = new Scene(root2);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(helpPageScene);
			window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
