package application;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerLoginController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button goBackButt;
	
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
    		ArrayList<Customer> custList = contr.getCustomers();
    		
    		for (Customer obj : custList)
    		{
    			if (obj.getUserAccount().getUserName().equals(usernameCustomer.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginCustomer.getText()))
    			{
    				contr.setCurrentCustomer(obj);
    				
    				ArrayList<Order> orderList = contr.getAllOrders();
    				ArrayList<Order> custOrderList = new ArrayList<Order>();
    				
    				for (Order obj2 : orderList)
    				{
    					if (obj2.getCustId() == obj.getCustId())
    					{
    						custOrderList.add(obj2);
    					}
    				}
    				
    				obj.setOrderList(custOrderList);
    				contr.setCurrentCustomer(obj);
    				
    				
    				Main m = new Main();
    	    		m.changeScene("CustomerPage.fxml");
    	    		break;
    			}
    		}
    		invalidDetails.setText("Invalid Details");
    	}
    }

    @FXML
    void registrationCustomer(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("CustomerRegistration.fxml");
    }

    @FXML
    void goBackAct(ActionEvent event) throws IOException  {
    	Main m = new Main();
		m.changeScene("Home.fxml");
    }
    
}
