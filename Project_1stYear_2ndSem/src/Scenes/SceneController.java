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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML private Label loginMessageLabel;
	@FXML private TextField login_username;
	@FXML private TextField login_password;

	@FXML
	public void switchToHomePage(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("Login2.fxml"));
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
	
	// WHEN LOGIN BUTTON IS CLICKED
	@FXML public void loginClicked(ActionEvent event) throws IOException {
		
		//	trim() -	is used to remove whitespaces on the input <3 
		String usernameInput = login_username.getText().trim();
		String passwordInput = login_password.getText().trim();
	
		loginMessageLabel.setText("Invalid Username/ Password! Please Try Again!");
		Alert alertMessage = new Alert(AlertType.WARNING); //This will create an object for an alert box
		
		if(login_username.getText().isBlank() || login_password.getText().isBlank()) {
			alertMessage.setTitle("low");
			alertMessage.showAndWait();
		}
		else{
			try {
				//This is used for loading mysql Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "");
				
				String statement = "SELECT username, password FROM credentials WHERE username='"+ usernameInput + "' AND password='" + passwordInput +"';";
				
				Statement stat = con.createStatement();
				ResultSet queryResult = stat.executeQuery(statement);
				
				while(queryResult.next()) {
					if(queryResult.getString("username").equals(usernameInput) && queryResult.getString("password").equals(passwordInput)) {
						System.out.println(queryResult.getString("password"));
						root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						alertMessage.setTitle("pasok");
						alertMessage.showAndWait();
					}
					else {
						login_username.setText("");
						login_password.setText("");
						alertMessage.setTitle("labas");
						alertMessage.showAndWait();
					}
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
		}
	}
}
