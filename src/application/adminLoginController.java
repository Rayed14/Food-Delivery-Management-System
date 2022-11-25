package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class adminLoginController {
	 @FXML
	    private Button adminLoginSubmit;

	    @FXML
	    private Label invalidDetails;

	    @FXML
	    private PasswordField passowrdLoginAdmin;

	    @FXML
	    private TextField usernameAdmin;

	    @FXML
	    void restaurantPage(ActionEvent event) throws IOException {
	    	if(usernameAdmin.getText().isEmpty() || passowrdLoginAdmin.getText().isEmpty())
	    	{
	    		invalidDetails.setText("Invalid Details");
	    	}
	    	else {
	    		Main m = new Main();
	    		m.changeScene("AdminPage.fxml");
	    	}
	    }
}
