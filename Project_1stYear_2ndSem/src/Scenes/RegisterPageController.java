package Scenes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;

public class RegisterPageController {
	@FXML private TextField signup_companyname;
	@FXML private TextField signup_username;
	@FXML private TextField signup_email;
	@FXML private TextField signup_password;
	@FXML private TextField signup_confirmpassword;
	
	@FXML private TextField passwordInput;
	@FXML private ImageView passwordEye;
	
	@FXML private TextField confirmPasswordInput;
	@FXML private ImageView confirmPasswordEye;
	
	@FXML private Label signupMessageLabel;
	
	@FXML
	private TextField username;
	
	//INSERT INTO `credentials`(`username`, `password`) VALUES ("Chris", "hahha");
	
	
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
	
	
//		signup_password.textProperty().addListener((observable, oldValue, newValue) -> {
//            //passwordEye.setVisible(!newValue.isEmpty());
//            System.out.println("Text changed from " + oldValue + " to " + newValue);
//        });
		
		
//		
//		PasswordField passwordField = new PasswordField();
//        ToggleButton toggleButton = new ToggleButton();
//        Image showImage = new Image(getClass().getResourceAsStream("../img/registerPage/show.png"));
//        Image hideImage = new Image(getClass().getResourceAsStream("../img/registerPage/hide.png"));
//        ImageView imageView = new ImageView(hideImage);
//        imageView.setFitWidth(16);
//        imageView.setFitHeight(16);
//        toggleButton.setGraphic(imageView);
//
//        toggleButton.setOnAction(event -> {
//            if (toggleButton.isSelected()) {
//                passwordField.setManaged(false);
//                passwordField.setVisible(false);
//                passwordField.setManaged(true);
//                passwordField.setVisible(true);
//                passwordField.setText(passwordField.getText());
//                imageView.setImage(showImage);
//            } else {
//                passwordField.setManaged(false);
//                passwordField.setVisible(false);
//                passwordField.setManaged(true);
//                passwordField.setVisible(true);
//                passwordField.setText(passwordField.getText());
//                imageView.setImage(hideImage);
//            }
//        });
	
	public void signupClicked(ActionEvent event) throws IOException {

		//		trim() -	is used to remove whitespaces on the input <3 
		String companyname_Input = signup_companyname.getText().trim();
		String username_Input = signup_username.getText().trim();
		String email_Input = signup_email.getText().trim();
		String password_Input = signup_password.getText().trim();
		String confirmpassword_Input = signup_confirmpassword.getText().trim();
		
		if (!password_Input.equals(confirmpassword_Input)) {
			passwordInput.setVisible(false);
			confirmPasswordInput.setVisible(false);
			signup_password.setVisible(true);
			signup_confirmpassword.setVisible(true);
			
			signup_password.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			passwordInput.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			signup_confirmpassword.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
			confirmPasswordInput.setStyle("-fx-border-color: red; -fx-background-color:  rgba(0,0,0,0); -fx-border-width:  2px; -fx-text-fill:  #FFFFFF;");
		}
		else {
			
			
		}
		
		
		
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
