package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import BusinessLogic.*;

public class adminLoginController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button goBack;
	
	 @FXML
	    private Button adminLoginSubmit;

	    @FXML
	    private Label invalidDetails;

	    @FXML
	    private PasswordField passowrdLoginAdmin;

	    @FXML
	    private TextField usernameAdmin;

	    @FXML
	    void adminPage(ActionEvent event) throws IOException {
	    	if(usernameAdmin.getText().isEmpty() || passowrdLoginAdmin.getText().isEmpty())
	    	{
	    		invalidDetails.setText("Invalid Details");
	    	}
	    	else {
	    		ArrayList<Admin> adminList = contr.getAdmins();
	    		
	    		for (Admin obj : adminList)
	    		{
	    			if (obj.getUserAccount().getUserName().equals(usernameAdmin.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginAdmin.getText()))
	    			{
	    				Main m = new Main();
	    	    		m.changeScene("adminPortal.fxml");
	    	    		break;
	    			}
	    		}
	    		invalidDetails.setText("Invalid Details");
	    		
	    	}
	    }
	    
	    @FXML
	    void goBackAck(ActionEvent event) throws IOException {
	    	
	    	Main m = new Main();
    		m.changeScene("Home.fxml");

	    }
}
