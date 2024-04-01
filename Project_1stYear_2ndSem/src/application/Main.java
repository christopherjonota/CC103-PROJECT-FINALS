// JavaFX Setup
// Configure build path by setting user library with JAVAFX
// go to Run > Run Configurations > Java Application > (Select your Main Class/project) > Arguments > VM Arguments
// Add vm arguments
//--module-path "C:\Users\Christopher\Desktop\PROGRAM Applications\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml


// mySql Connection Setup
// Right-Click(Project) > Properties > Java Build Path > Library > Class Path > Add External Jar > Add the mysqlconnector jar file
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
