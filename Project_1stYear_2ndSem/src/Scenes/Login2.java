package Scenes;

import javafx.event.ActionEvent;

import java.io.IOException;
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

public class Login2 {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML private Label signupMessageLabel;
	@FXML private TextField signup_companyname;
	@FXML private TextField signup_username;
	@FXML private TextField signup_email;
	@FXML private TextField signup_password;
	@FXML private TextField signup_confirmpassword;
	
	@FXML
	public void switchToHomePage(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void switchToSignup(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	// WHEN SIGNUP BUTTON IS CLICKED
	@FXML public void signupClicked(ActionEvent event) throws IOException {
		
		try {
			//This is used for loading mysql Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "");
			System.out.println("Connection Created");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//	trim() -	is used to remove whitespaces on the input <3 
		String companynameInput = signup_companyname.getText().trim();
		String usernameInput = signup_username.getText().trim();
		String emailInput = signup_email.getText().trim();
		String passwordInput = signup_password.getText().trim();
		String confirmpasswordInput = signup_confirmpassword.getText().trim();

		//loginMessageLabel.setText("Invalid Username/ Password! Please Try Again!");
		Alert alertMessage = new Alert(AlertType.WARNING); //This will create an object for an alert box

		if(signup_companyname.getText().isBlank() || signup_username.getText().isBlank() || signup_email.getText().isBlank() || signup_password.getText().isBlank() || signup_confirmpassword.getText().isBlank()) {
		alertMessage.setTitle("low");
			alertMessage.showAndWait();
		}
		else{

			try {
				//This is used for loading mysql Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//those inside the getConnection parameter is => (Database:Driver://ServerAddress:PortAddress/DatabaseName,Username,Password)
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "");
				/////
				String statement = "INSERT INTO signup (companyname,username,email,password,confirmpassword) VALUES(?,?,?,?,?);";
				PreparedStatement ps ;
				ps = con.prepareStatement(statement);
				ps.setString(1,companynameInput);
				ps.setString(2,usernameInput);
				ps.setString(3,emailInput);
				ps.setString(4,passwordInput);
				ps.setString(5,confirmpasswordInput);
				
				ps.executeUpdate();
				
//				Statement stat = con.createStatement();
//			    ResultSet queryResult = stat.executeQuery(statement);
				
//				while(queryResult.next()) {
//					if(queryResult.getString("username").equals(usernameInput) && queryResult.getString("password").equals(passwordInput)) {
//						System.out.println(queryResult.getString("password"));
//						root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
//						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//						scene = new Scene(root);
//						stage.setScene(scene);
//						stage.show();
//						alertMessage.setTitle("pasok");
//						alertMessage.showAndWait();
//					}
//					else {
////						login_username.setText("");
////						login_password.setText("");
//						alertMessage.setTitle("labas");
//						alertMessage.showAndWait();
//					}
//				}
//				
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