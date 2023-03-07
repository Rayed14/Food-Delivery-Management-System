package application;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLogic.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class riderLoginController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button goBackButt;
	
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
    		
    		//Checking Rider login and also getting the current rider along with its orders
    		
    		ArrayList<Rider> riderList = contr.getRiders();
    		
    		for (Rider obj : riderList)
    		{
    			if (obj.getUserAccount().getUserName().equals(usernameRider.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginRider.getText()))
    			{
    				contr.setCurrentRider(obj);
    				
    				ArrayList<Order> orderList = contr.getAllOrders();
    				ArrayList<Order> ridOrderList = new ArrayList<Order>();
    				
    				for (Order obj2 : orderList)
    				{
    					if (obj2.getRiderId() == obj.getRiderId())
    					{
    						ridOrderList.add(obj2);
    					}
    				}
    				obj.setOrderList(ridOrderList);
    				contr.setCurrentRider(obj);
    				
    				Main m = new Main();
    	    		m.changeScene("RiderPage.fxml");
    	    		break;
    			}
    		}
    		invalidDetails.setText("Invalid Details");
    	}
    }
    
    @FXML
    void GoBackAct(ActionEvent event) throws IOException {
    	
    	Main m = new Main();
		m.changeScene("Home.fxml");

    }

}
