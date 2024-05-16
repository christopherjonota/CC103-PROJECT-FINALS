package Scenes;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class RegisterPageController {
	DatabaseConnection dbCon = new DatabaseConnection();
	SceneController controller = new SceneController();
	@FXML private TextField signup_companyname;
	@FXML private TextField signup_username;
	@FXML private TextField signup_email;
	@FXML private TextField signup_password;
	@FXML private TextField signup_confirmpassword;
	
	@FXML private TextField passwordInput;
	@FXML private ImageView passwordEye;
	
	@FXML private TextField confirmPasswordInput;
	@FXML private ImageView confirmPasswordEye;
	
	@FXML private Label errorMessage;
	@FXML private Button errorButton;
	@FXML private Rectangle errorMessageBackground;	
	@FXML private TextField username;
	
	
	// This will toggle the visibility of the eye icon in the password field
	public void passwordEyeClicked() {
		if(signup_password.isVisible()) {
			passwordInput.setVisible(true);
			passwordInput.setText(signup_password.getText());
			signup_password.setVisible(false);;
			Image newImage = new Image("./img/registerPage/hide.png");
			passwordEye.setImage(newImage);
		}
		else {
			passwordInput.setVisible(false);
			signup_password.setText(passwordInput.getText());
			signup_password.setVisible(true);;
			Image newImage = new Image("./img/registerPage/view.png");
			passwordEye.setImage(newImage);
		}
	}
		
	// This will toggle the visibility of the eye icon in the confirm password field
	public void confirmPasswordEyeClicked() {
		if(signup_confirmpassword.isVisible()) {
			confirmPasswordInput.setVisible(true);
			confirmPasswordInput.setText(signup_confirmpassword.getText());
			signup_confirmpassword.setVisible(false);;
			
			//replace the view icon(eye icon) with hide icon
			Image newImage = new Image("./img/registerPage/hide.png");
			confirmPasswordEye.setImage(newImage);
		}
		else {
			confirmPasswordInput.setVisible(false);
			signup_confirmpassword.setText(confirmPasswordInput.getText());
			signup_confirmpassword.setVisible(true);;
			Image newImage = new Image("./img/registerPage/view.png");
			confirmPasswordEye.setImage(newImage);
		}
	}
	
	// It serve as an event listener to detect if there are still inputs in the field
	public void EyeVisibility() {
		if(signup_password.getText().length() == 0) {
			passwordEye.setVisible(false);
		}
		else {
			passwordEye.setVisible(true);
		}
		
		if(signup_confirmpassword.getText().length() == 0) {
			confirmPasswordEye.setVisible(false);
		}
		else {
			confirmPasswordEye.setVisible(true);
		}
	}
		
	
	public void signupClicked(ActionEvent event) throws IOException {
		boolean checkpoint1 = false, checkpoint2 = false, checkpoint3 = false, checkpoint4 = false;
		//	trim() -	is used to remove whitespaces on the input <3 
		String companyname_Input = signup_companyname.getText().trim();
		String username_Input = signup_username.getText().trim();
		String email_Input = signup_email.getText().trim();
		String password_Input = signup_password.getText().trim();
		String confirmpassword_Input = signup_confirmpassword.getText().trim();
		
		
		// For Validation of confirm password
		if (!password_Input.equals(confirmpassword_Input)) {
			checkpoint1 = false;
			
			//This will reset the password fields visibility
			signup_password.setVisible(false);
			signup_confirmpassword.setVisible(false);
			passwordEyeClicked();
			confirmPasswordEyeClicked();
			
			//Change the styles of the borders
			signup_password.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			signup_confirmpassword.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			
			// Prompt an error message
			errorMessage.setText("Passwords do not match");
			errorMessage.setVisible(true);
			errorMessageBackground.setVisible(true);
			errorButton.setVisible(true);
		}
		else {
			checkpoint1 = true;
			signup_password.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			signup_confirmpassword.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			
		}
		
		
		// Email validation
		if (!email_Input.contains("@") || !email_Input.contains(".com")) {
			checkpoint2 = false;
			
			signup_email.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			errorMessage.setText("Invalid email address");
			errorMessageBackground.setVisible(true);
			errorMessage.setVisible(true);
			errorButton.setVisible(true);
		}
		else {
			signup_email.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			checkpoint2= true;
		}
		
			
		// Username validation checking
		try {
			Connection con = dbCon.getConnection();
			String statement = "SELECT count(1) FROM credentials WHERE BINARY username= ?";
			PreparedStatement ps = con.prepareStatement(statement);				
			ps.setString(1, username_Input);
			ResultSet queryResult = ps.executeQuery();	
			
			while (queryResult.next()) {
				if(queryResult.getInt(1) == 1) {
					checkpoint4 = false;
					signup_username.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
					errorMessage.setText("Username already exist");
					errorMessage.setVisible(true);
					errorMessageBackground.setVisible(true);
					errorButton.setVisible(true);
				}
				else {
					checkpoint3 = true;
					signup_username.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
				}
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		
		
		// Checks for the blank fields
		if(companyname_Input.isBlank() || username_Input.isBlank() || email_Input.isBlank() || password_Input.isBlank() || confirmpassword_Input.isBlank()) {
			checkpoint1 = false;
			
			errorMessage.setText("Please complete all required fields");
			errorMessage.setVisible(true);
			errorMessageBackground.setVisible(true);
			errorButton.setVisible(true);
			if(companyname_Input.isBlank()) {
				signup_companyname.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			else {
				signup_companyname.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			if(username_Input.isBlank()) {
				signup_username.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			else {
				signup_username.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			if(email_Input.isBlank()) {
				signup_email.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			} 
			else {
				signup_email.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			if(password_Input.isBlank()) {
				signup_password.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			else {
				signup_password.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			if(confirmpassword_Input.isBlank()) {
				signup_confirmpassword.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
			else {
				signup_confirmpassword.setStyle("-fx-border-color: #FFFFFF; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			}
		}
		else {
			checkpoint4 = true;
		}
		
		
		
		// Checks if there are no error or lapses in the fields
		if(checkpoint1 == true && checkpoint2 == true && checkpoint3 == true && checkpoint4 == true) {
			try {
				
				Connection con = dbCon.getConnection();
				String statement = "INSERT INTO credentials (companyname,username,email,password) VALUES(?,?,?,?);";
				PreparedStatement ps ;
				Alert infoAlert = new Alert(AlertType.INFORMATION);
		        infoAlert.setTitle("Sign Up");
		        infoAlert.setHeaderText(null);
		        infoAlert.setContentText("You have successfully signed in");
		        infoAlert.showAndWait();


				ps = con.prepareStatement(statement);
				ps.setString(1,companyname_Input);
				ps.setString(2,username_Input);
				ps.setString(3,email_Input);
				ps.setString(4,password_Input);

				
				ps.executeUpdate();
				controller.sceneChanger(event, "LoginPage.fxml");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	// for exiting the error box
	public void errorMessageButton() {
		errorMessage.setVisible(false);
		errorMessageBackground.setVisible(false);
		errorButton.setVisible(false);
	}		
	
	@FXML private void switchToLoginLabel(MouseEvent event) throws IOException {
		controller.sceneChanger(event, "LoginPage.fxml");
	}
	
	@FXML private void switchToLoginBtn(ActionEvent event) throws IOException {
		controller.sceneChanger(event, "LoginPage.fxml");
	}
	
	
	@FXML public void switchToRegisterPage(ActionEvent event) throws IOException {
		controller.sceneChanger(event, "RegisterPage.fxml");
	}
}
