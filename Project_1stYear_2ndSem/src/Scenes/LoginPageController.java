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
	private Rectangle loginADADADAADAund;	// fxid for the background of the label
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
		
		System.out.println("Halo");
		System.out.println("Halo");
		System.out.println("Halo");
		
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
	
	
	public void exitMessage(ActionEvent event) throws IOException{
		loginMessageLabel.setText("");
		loginMessageBackground.setVisible(false);
		exitMessageLabel.setVisible(false);
	}
}
