package Scenes;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
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

	public String usernameInput;
	public String passwordInput;
	public String username;
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField middleName;
	@FXML
	private TextField jobPosition;
	@FXML
	private TextField employmentType;
	@FXML
	private TextField employeeID;
	@FXML
	private TextField basicRate;
	@FXML
	private TextField per;
	@FXML
	private ImageView profile;
	@FXML
	private TextField birthday;
	@FXML
	private TextField contactNumber;
	@FXML
	private TextField emailAddress;
	@FXML
	private TextField sssIdNumber;
	@FXML
	private TextField street1;
	@FXML
	private TextField street2;
	@FXML
	private TextField city;
	@FXML
	private TextField region;
	@FXML
	private TextField zip;
	@FXML
	private TextField contactFullName;
	@FXML
	private TextField contactRelationship;
	@FXML
	private TextField contactPhoneNumber;
	@FXML
	private TextField contactEmailAddress;
//////////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField employeeIDpayroll;
	@FXML
	private TextField workingHours;
	@FXML
	private TextField salaryPerDay;
	@FXML
	private Label salaryPerMonth;
	@FXML
	private TextField OtTime;
	@FXML
	private Label OtAmount;
	@FXML
	private Label name;
	@FXML
	private TextField late;
	@FXML
	private TextField absent;
	@FXML
	private Label lateAmount;
	@FXML
	private Label absentAmount;
	@FXML
	private Label deductionTotal;
	@FXML
	private Label salaryTotal;

	
	
	
	
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
		usernameInput = login_username.getText().trim();
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
				
				Connection con = Main.getSQLConnection(); //Get the connection from main class
				System.out.println("low");
				// This will check if there are similar data inside the database according to the input of the user 
				// This will retrieve the username and password based on the input of the user		
				// The 'BINARY' function will convert the string to a value which it is used as case-sensitivity checking.
				String statement = "SELECT count(1) FROM credentials WHERE BINARY username= ? AND BINARY password= ?";

				
				// This will prepare a statement to replace the values in ?
				PreparedStatement ps = con.prepareStatement(statement);				
				ps.setString(1, usernameInput);
				ps.setString(2, passwordInput);
				
				
				ResultSet queryResult = ps.executeQuery();	
				
				while (queryResult.next()) {
					System.out.println(queryResult.getInt(1));
					
					System.out.println("checkpoint2");
					if(queryResult.getInt(1) == 1) {
						queryResult.close();
						statement = "SELECT newUser FROM credentials WHERE BINARY username= ? AND BINARY password= ?;";
						ps = con.prepareStatement(statement);				
						ps.setString(1, usernameInput);
						ps.setString(2, passwordInput);
						queryResult = ps.executeQuery();	
						
						while(queryResult.next()) {
							
							if(queryResult.getInt(1) == 0) {
								userData();
								// This will switch the page to homepage if validated 
								root = FXMLLoader.load(getClass().getResource("payroll.fxml")); 
								stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
								scene = new Scene(root); 
								stage.setScene(scene); 
								stage.show();
							}	
							else if(queryResult.getInt(1) == 1) {
								userData();
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
			} 
			catch (SQLException e) {
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
	
	public String userData() throws SQLException {
		Connection con = Main.getSQLConnection();
		String statement = "SELECT username FROM credentials WHERE BINARY username= ? AND BINARY password= ?";

		// This will prepare a statement to replace the values in ?
		PreparedStatement ps = con.prepareStatement(statement);				
		ps.setString(1, usernameInput);
		ps.setString(2, passwordInput);
		
		ResultSet queryResult = ps.executeQuery();	
		while(queryResult.next()) {
			username = queryResult.getString(1);
		}
		return username;
	}
	
	
// ADD Employee Tab
	@FXML
	private void addPhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");

        // Add filters if needed (e.g., to restrict to specific image types)
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
	            new FileChooser.ExtensionFilter("All Files", "*.*")
	    );

        // Show the file chooser dialog and get the selected file
        File selectedFile = fileChooser.showOpenDialog(null);

        // Check if a file was selected
        if (selectedFile != null) {
        	String profImage = selectedFile.toURI().toString();
        	Image profileImage = new Image(selectedFile.toURI().toString());
            profile.setImage(profileImage);
            // Perform actions with the selected file here
        } else {
            System.out.println("No file selected.");
        }
    }
	
	@FXML
	private void addEmployeeButtonClicked(ActionEvent event) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "")) {
            // Create a SQL INSERT statement
            String sql = "INSERT INTO userdata (firstname, middlename, lastname, job_position, employment_type, basic_rate, per, birthday, contactNumber, emailAddress, "
            		+ "sssIdNumber, address, contactfullname, contactrelationship, contactPhoneNumber, contactEmailAddress) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            String address = (street1.getText() + " " + street2.getText() + " " + city.getText() + " " + region.getText() + " " + " - " + zip.getText());
           
            // Create a PreparedStatement to safely execute the SQL statement
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set the parameters in the PreparedStatement
                statement.setString(1, firstName.getText());
                statement.setString(2, middleName.getText());
                statement.setString(3, lastName.getText());
                statement.setString(4, jobPosition.getText());
                statement.setString(5, employmentType.getText());
                statement.setString(6, basicRate.getText());
                statement.setString(7, per.getText());
                statement.setString(8, birthday.getText());
                statement.setString(9, contactNumber.getText());
                statement.setString(10, emailAddress.getText());
                statement.setString(11, sssIdNumber.getText());
                statement.setString(12, address);
                statement.setString(13, contactFullName.getText());
                statement.setString(14, contactRelationship.getText());
                statement.setString(15, contactPhoneNumber.getText());
                statement.setString(16, contactEmailAddress.getText());

                // Execute the INSERT statement
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Failed to insert data.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saving data to database: " + e.getMessage());
        }
	}
//	@FXML
//	public void initializeComboBox() {
//		birthday_month.setItems(FXCollections.observableArrayList(
//				"01","02","03","04","05","06","07","08","09","10","11", "12"
//				));
//		birthday_day.setItems(FXCollections.observableArrayList(
//				"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
//                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
//                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
//				));
//		
//		List<String> yearsList = new ArrayList<>();
//		for (int year = 1950; year <= 2024; year++) {
//            yearsList.add(String.valueOf(year));
//        }
//		birthday_day.setItems(FXCollections.observableArrayList(yearsList));
//		
//		per.getItems().addAll(FXCollections.observableArrayList(
//				"Day","Week","Month","Year"
//				));
//		basicRate.getItems().addAll(FXCollections.observableArrayList(
//				"P500", "P1000", "P5000", "P10,000","P20,000","P30,000","P40,000"
//				));
//		jobPosition.getItems().addAll(FXCollections.observableArrayList(
//				"Finance", "Sales", "Coordinator", "Security Guard","Janitor","Customer Support","Clerk"
//				));
//		employmentType.getItems().addAll(FXCollections.observableArrayList(
//				"Full-Time Employee", "Part-Time Employee", "Contractual"
//				));
//	}
	
	
	
	
	
// NAVIGATION BARS

	@FXML
	private void logOutButtonClicked(javafx.scene.input.MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Login.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
	
	
	@FXML
	private void payrollButtonClicked(javafx.scene.input.MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("payroll.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
	
	@FXML
	private void addEmployeesButtonClicked(javafx.scene.input.MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addEmployees.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
//        // Establish a connection to the MySQL database
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "")) {
//            // Create a SQL query to count the rows in the table
//            String sql = "SELECT COUNT(*) AS row_count FROM userdata";
//
//            // Create a Statement to execute the query
//            try (Statement statement = connection.createStatement()) {
//                // Execute the query and retrieve the result set
//                ResultSet resultSet = statement.executeQuery(sql);
//
//                // Retrieve the row count from the result set
//                if (resultSet.next()) {
//                    int rowCount = resultSet.getInt("row_count");
//
//                    // Update the label with the row count
//                    if(employeeID == null) {
//                    	 employeeID.setText("" + rowCount+1);
//                    }
//                   
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("Error retrieving row count from database: " + e.getMessage());
//        }
    }
	
	
	@FXML
	private void manageEmployeesButtonClicked(javafx.scene.input.MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("manageEmployees.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
	@FXML
	private void homeButtonClicked(javafx.scene.input.MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("home.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
	
	
	//////////////////////////////////
	@FXML
	private void findButtonClicked(ActionEvent event) throws IOException {
		System.out.println("low");
		int data = Integer.parseInt(employeeIDpayroll.getText());
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollsystemdb", "root", "")) {
            // Create a SQL query to count the rows in the table
            String sql = "SELECT firstname, lastname FROM userdata WHERE id = " + data;

            // Create a Statement to execute the query
            try (Statement statement = connection.createStatement()) {
                // Execute the query and retrieve the result set
                ResultSet resultSet = statement.executeQuery(sql);

                // Retrieve the row count from the result set
                if (resultSet.next()) {
                    name.setText(resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
                    System.out.println(resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
                    workingHours.clear();
                    salaryPerDay.clear();
                    OtTime.clear();
                    late.clear();
                    absent.clear();
                
                    workingHours.setDisable(false);
                    salaryPerDay.setDisable(false);
                    OtTime.setDisable(false);
                    late.setDisable(false);
                    absent.setDisable(false);
                    
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving row count from database: " + e.getMessage());
        }
	}
	@FXML
	private void computeButtonClicked(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("home.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
	@FXML
	private void clearButtonClicked(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("home.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show();
	}
}
