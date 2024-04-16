package Scenes;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HomepageSetupController {
	
	@FXML 
	private ImageView dropdownButton;
	
	@FXML
	private Pane dropdownPane;
	
	
	
	public void showLogOutBox(){
		if (dropdownPane.isVisible() == true) {
			dropdownPane.setVisible(false);
		}
		else {
			dropdownPane.setVisible(true);
		}
		
	}
}
