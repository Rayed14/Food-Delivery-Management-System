package application;

import java.io.IOException;

import BusinessLogic.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class restaurantRegistrationController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button goBackButt;
	
	@FXML
    private Button registerButton;

    @FXML
    private TextField restaurantAddress;

    @FXML
    private TextField restaurantEmail;

    @FXML
    private TextField restaurantName;

    @FXML
    private PasswordField restaurantPassword;

    @FXML
    private TextField restaurantPhNumber;

    @FXML
    private TextField restaurantUsername;
    
    @FXML
    private TextField restaurantMenuName;

    @FXML
    private Label warning;

    @FXML
    void restaurantLoginPage(ActionEvent event) throws IOException {
    	if(restaurantName.getText().isEmpty() || restaurantPhNumber.getText().isEmpty() || restaurantEmail.getText().isEmpty() || restaurantAddress.getText().isEmpty() || restaurantUsername.getText().isEmpty() || restaurantPassword.getText().isEmpty() || restaurantMenuName.getText().isEmpty())
    	{
    		warning.setText("Please fill in all fields");
    	}
    	else {
    		
    		contr.enterSignUpButtonRest(restaurantName.getText(), restaurantPhNumber.getText(), restaurantEmail.getText(), restaurantAddress.getText(), restaurantUsername.getText(), restaurantPassword.getText(), restaurantMenuName.getText());
    		
    		Main m = new Main();
    		m.changeScene("RestaurantLogin.fxml");
    	}
    }
    
    @FXML
    void goBackAct(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("RestaurantLogin.fxml");

    }
}
