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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;

public class LoginPageController {
	//////////////////////////////////////////////////////////////////////////////////////////////
	// SETUP
	private Stage stage;	
	private Scene scene; 	
	private Parent root;

	@FXML
	private Label loginMessageLabel;			// fxid for the label that shows if the input is incorrect
	@FXML
	private Button exitMessageLabel;			// used to exit the login message label
	@FXML
	private Rectangle loginMessageBackground;	// fxid for the background of the label
	@FXML
	private TextField login_username; 			// fxid for Username textbox
	@FXML
	private TextField login_password;			// fxid for Password textbox
	//////////////////////////////////////////////////////////////////////////////////////////////

	
	//////////////////////////////////////////////////////////////////////////////////////////////
	// FOR THE NAVIGATION BAR - LOGIN
	
	// This will load the scenes or pages if you call this method
	// This is attached as 'On Action' on the Login Button located above as navigation bar
	@FXML
	public void switchToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	// FOR THE NAVIGATION BAR - REGISTER
	// This will load the scene for Register page
	//
	//
	//
	//		Put your code or method here like above to switch to register page
	//
	//
	//////////////////////////////////////////////////////////////////////////////////////////////

	
	//////////////////////////////////////////////////////////////////////////////////////////////
	// Method for the Login Button in the input area
	@FXML
	public void loginClicked(ActionEvent event) throws IOException {

		// trim() - is used to remove whitespaces on the input of the user
		String usernameInput = login_username.getText().trim();
		String passwordInput = login_password.getText().trim();

		// If the user do not input something or inputs a white space and click the
		// login button, this will return.
		if (login_username.getText().isBlank() || login_password.getText().isBlank()) {
			loginMessageLabel.setText("Please fill out the fields below.");
			
			// This will enable the visibility of the background for the message label
			loginMessageBackground.setVisible(true);	
			exitMessageLabel.setVisible(true);
			
			// FOR CSS Purposes only
			if(login_username.getText().isBlank() && login_password.getText().isBlank()) {
				login_username.getStyleClass().add("borderBox");	// This will add a class inside the css to the fxid so it can have a design
				login_password.getStyleClass().add("borderBox");
			}
			else if (login_username.getText().isBlank()) {
				login_username.getStyleClass().add("borderBox");
				login_password.getStyleClass().remove("borderBox");	// This will remove the class added inside the the fxid 
			}
			else {
				login_username.getStyleClass().remove("borderBox");
				login_password.getStyleClass().add("borderBox");			
			}
		}
		else {
			try {
				login_username.getStyleClass().remove("borderBox");
				login_password.getStyleClass().remove("borderBox");
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");	// This is used for loading mysql Driver				
				// REMINDER: THIS MUST CHANGE ACCORDING TO YOUR DEVICE ESPECIALLY THE PORT ADDRESS!!
				// those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "");

				
				// This will check if there are similar data inside the database according to the input of the user 
				// This will retrieve the username and password based on the input of the user		
				// The 'BINARY' function will convert the string to a value which it is used as case-sensitivity checking.
				String statement = "SELECT count(1) FROM credentials WHERE BINARY username= '" + usernameInput +"' AND BINARY password='"+ passwordInput + "';";

				
				// This will create and execute the statement
				Statement stat = con.createStatement();
				ResultSet queryResult = stat.executeQuery(statement);

				
				while (queryResult.next()) {
					if(queryResult.getInt(1) == 1) {
						queryResult.close();
						statement = "SELECT newUser FROM credentials WHERE BINARY username= '" + usernameInput +"' AND BINARY password='"+ passwordInput + "';";
						queryResult = stat.executeQuery(statement);
						
						while(queryResult.next()) {
							if(queryResult.getInt(1) == 0) {
								// This will switch the page to homepage if validated 
								root = FXMLLoader.load(getClass().getResource("HomePageSetup.fxml")); 
								stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
								scene = new Scene(root); 
								stage.setScene(scene); 
								stage.show();
							}	
							else if(queryResult.getInt(1) == 1) {
								// This will switch the page to homepage if validated 
								root = FXMLLoader.load(getClass().getResource("HomePage.fxml")); 
								stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
								scene = new Scene(root); 
								stage.setScene(scene); 
								stage.show();
							}	
						}	
					}
					else {
						login_username.setText("");
						login_password.setText("");
						loginMessageLabel.setText("Incorrect username or password.");
						loginMessageBackground.setVisible(true);
						exitMessageLabel.setVisible(true);
						login_username.getStyleClass().add("borderBox");
						login_password.getStyleClass().add("borderBox");
					}		
				} 
				

				// This will catch the errors and prints it in the console to be diagnosed
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void exitMessage(ActionEvent event) throws IOException{
		loginMessageLabel.setText("");
		loginMessageBackground.setVisible(false);
		exitMessageLabel.setVisible(false);
	}
}
