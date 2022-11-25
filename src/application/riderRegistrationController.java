package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class riderRegistrationController {
	@FXML
    private Button registerButton;

    @FXML
    private TextField riderEmail;

    @FXML
    private TextField riderLicenseNo;

    @FXML
    private TextField riderName;

    @FXML
    private PasswordField riderPassword;

    @FXML
    private TextField riderPhNumber;

    @FXML
    private TextField riderUsername;

    @FXML
    private Label warning;

    @FXML
    void restaurantLoginPage(ActionEvent event) throws IOException {
    	if(riderName.getText().isEmpty() || riderPhNumber.getText().isEmpty() || riderEmail.getText().isEmpty() || riderLicenseNo.getText().isEmpty() || riderUsername.getText().isEmpty() || riderPassword.getText().isEmpty())
    	{
    		warning.setText("Please fill in all fields");
    	}
    	else {
    		Main m = new Main();
    		m.changeScene("RiderLogin.fxml");
    	}
    }
}
