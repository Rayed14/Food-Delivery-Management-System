package application;

import java.io.IOException;

import BusinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerRegistrationController {
	
	Controller contr = new Controller();
	
	@FXML
	private Button goBackButt;
	
	@FXML
    private TextField customerAddress;

    @FXML
    private TextField customerEmail;

    @FXML
    private TextField customerName;

    @FXML
    private PasswordField customerPassword;

    @FXML
    private TextField customerPhNumber;

    @FXML
    private TextField customerUsername;

    @FXML
    private Button registerButton;

    @FXML
    private Label warning;

    @FXML
    void customerLoginPage(ActionEvent event) throws IOException {
    	if(customerName.getText().isEmpty() || customerPhNumber.getText().isEmpty() || customerEmail.getText().isEmpty() || customerAddress.getText().isEmpty() || customerUsername.getText().isEmpty() || customerPassword.getText().isEmpty())
    	{
    		warning.setText("Please fill in all fields");
    	}
    	else {
    		
    		contr.enterSignUpButtonCust(customerName.getText(), customerPhNumber.getText(), customerEmail.getText(), customerAddress.getText(), customerUsername.getText(), customerPassword.getText());
    		
    		Main m = new Main();
    		m.changeScene("CustomerLogin.fxml");
    	}
    }
    
    @FXML
    void goBackAct(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("CustomerLogin.fxml");

    }
    
}
