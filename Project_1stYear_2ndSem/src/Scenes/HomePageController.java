package Scenes;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class HomePageController {
	SceneController controller = new SceneController();
	DashboardController login = new DashboardController();
	@FXML private Label user_name;
	
	
	private int userID = getUserID();
    
    // Setter method to set the userID
    public void setUserID(int userID) {
        //HomePageController.userID = userID;
    }
    // Getter method to get the userID
    public int getUserID() {
        return userID;
    }
	

	
	
	
}
