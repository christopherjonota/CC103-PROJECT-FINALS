package Scenes;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneController {
	Parent root;
	Scene scene;
	Stage stage;
	
	public void sceneChanger(ActionEvent event, String setScene) throws IOException {
		root = FXMLLoader.load(getClass().getResource(setScene)); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}

	public void sceneChanger(MouseEvent event, String setScene) throws IOException {
		// TODO Auto-generated method stub
		root = FXMLLoader.load(getClass().getResource(setScene)); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
}
