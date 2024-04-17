package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	Parent root;
	Scene scene;
	Stage stage;
	public static void main(String[] args)  {		
		launch(args);
	}
	
	//Loading Scenes Using JAVAFX
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getResource("../Scenes/Login.fxml"));
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../CSS/login.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void mySQLConnection() throws SQLException {

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// This is used for loading mysql Driver				
			// REMINDER: THIS MUST CHANGE ACCORDING TO YOUR DEVICE ESPECIALLY THE PORT ADDRESS!!
			// those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "");	
			// This will check if there are similar data inside the database according to the input of the user 
			// This will retrieve the username and password based on the input of the user		
			// The 'BINARY' function will convert the string to a value which it is used as case-sensitivity checking.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sceneChanger(ActionEvent event, String set) throws IOException {
		root = FXMLLoader.load(getClass().getResource(set)); 
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
	

}
