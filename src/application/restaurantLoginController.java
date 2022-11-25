package application;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class restaurantLoginController {
	 @FXML
	    private Label invalidDetails;

	    @FXML
	    private PasswordField passowrdLoginRestaurant;

	    @FXML
	    private Button restaurantLoginSubmit;

	    @FXML
	    private TextField usernameRestaurant;
	    
	    @FXML
	    private Button signupButton;

	    @FXML
	    void restaurantPage(ActionEvent event) throws IOException {
	    	if(usernameRestaurant.getText().isEmpty() || passowrdLoginRestaurant.getText().isEmpty())
	    	{
	    		invalidDetails.setText("Invalid Details");
	    	}
	    	else {
	    		Main m = new Main();
	    		m.changeScene("RestaurantPage.fxml");
	    	}
	    }
	    
	    @FXML
	    void registrationRestaurant(ActionEvent event) throws IOException {
	    	Main m = new Main();
    		m.changeScene("RestaurantRegistration.fxml");
	    }
}
