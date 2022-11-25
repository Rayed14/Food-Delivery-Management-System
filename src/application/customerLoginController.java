package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerLoginController {
	@FXML
    private Button customerLoginSubmit;

    @FXML
    private Label invalidDetails;

    @FXML
    private PasswordField passowrdLoginCustomer;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameCustomer;

    @FXML
    void customerPage(ActionEvent event) throws IOException {
    	if(usernameCustomer.getText().isEmpty() || passowrdLoginCustomer.getText().isEmpty())
    	{
    		invalidDetails.setText("Invalid Details");
    	}
    	else {
    		Main m = new Main();
    		m.changeScene("CustomerPage.fxml");
    	}
    }

    @FXML
    void registrationCustomer(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("CustomerRegistration.fxml");
    }

}
