package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Scenes.LoginPageController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	static Connection con;
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/payrollsystemdb";
	static String username = "root";
	static String password = "";
	
	Parent root;
	Scene scene;
	Stage stage;
	public static void main(String[] args)  {		
		launch(args);
	}
	
	//Loading Scenes Using JAVAFX
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getResource("../Scenes/registerPage.fxml"));
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../CSS/login.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
//		LoginPageController controller = new LoginPageController();
//		controller.initializeComboBox();
	}
	public static Connection getSQLConnection() throws SQLException {		
		try {
			Class.forName(driver);
			// This is used for loading mysql Driver				
			// REMINDER: THIS MUST CHANGE ACCORDING TO YOUR DEVICE ESPECIALLY THE PORT ADDRESS!!
			// those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
			con = DriverManager.getConnection(url, username, password);	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
	public void sceneChanger(ActionEvent event, String set) throws IOException {
		root = FXMLLoader.load(getClass().getResource(set)); 
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
	

}
