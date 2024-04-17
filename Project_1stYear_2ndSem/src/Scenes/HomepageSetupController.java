package Scenes;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomepageSetupController {
	private Stage stage;	
	private Scene scene; 	
	private Parent root;
	
	@FXML 
	private ImageView dropdownButton;
	
	@FXML
	private Pane dropdownPane;
	
	@FXML
	private Label settingsButton;
	
	@FXML
	private Label logoutButton;
	
	
	
	public void showLogOutBox(){
		if (dropdownPane.isVisible() == true) {
			dropdownPane.setVisible(false);
		}
		else {
			dropdownPane.setVisible(true);
		}
		
	}
	public void logOutButton(ActionEvent event) throws Exception {
		Main main = new Main();
		main.sceneChanger(event, "Login.fxml");;
	}
	public void redirectToSettings(ActionEvent event) throws Exception {
		root = FXMLLoader.load(getClass().getResource("Login.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
}
