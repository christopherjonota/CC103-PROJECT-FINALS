package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	public static void main(String[] args)  {		
		launch(args);
	}
	
	//Loading Scenes Using JAVAFX
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../Scenes/Login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../CSS/login.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
