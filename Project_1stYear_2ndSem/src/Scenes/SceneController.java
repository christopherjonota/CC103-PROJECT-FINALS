
package Scenes;


import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML private Label loginMessageLabel;
	
	
	@FXML
	public void switchToHomePage(ActionEvent event) throws IOException {
		try {
			//This is used for loading mysql Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "");
			Statement stat = con.createStatement();

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void switchToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML public void loginClicked(ActionEvent event) {
		loginMessageLabel.setText("Invalid Username/ Password! Please Try Again!");
	}
	
}
