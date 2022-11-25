package application;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class riderLoginController {
	@FXML
    private Label invalidDetails;

    @FXML
    private PasswordField passowrdLoginRider;

    @FXML
    private Button riderLoginSubmit;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameRider;

    @FXML
    void registrationRider(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("RiderRegistration.fxml");
    }

    @FXML
    void riderPage(ActionEvent event) throws IOException {
    	if(usernameRider.getText().isEmpty() || passowrdLoginRider.getText().isEmpty())
    	{
    		invalidDetails.setText("Invalid Details");
    	}
    	else {
    		Main m = new Main();
    		m.changeScene("RiderPage.fxml");
    	}
    }

}
