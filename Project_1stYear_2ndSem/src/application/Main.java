// JavaFX Setup
// Configure build path by setting user library with JAVAFX
// go to Run > Run Configurations > Java Application > (Select your Main Class/project) > Arguments > VM Arguments
// Add vm arguments
//--module-path "C:\Users\Christopher\Desktop\PROGRAM Applications\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml


// mySql Connection Setup
// Right-Click(Project) > Properties > Java Build Path > Library > Class Path > Add External Jar > Add the mysqlconnector jar file
package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application{
	public static void main(String[] args)  {
		Main pro = new Main();
		pro.createConnection();
		
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
	
	
	//Connecting to Database
	private void createConnection(){
		try {
			//This is used for loading mysql Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "");
			System.out.println("DB Connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
