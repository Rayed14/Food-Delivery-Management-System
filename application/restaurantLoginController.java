package application;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLogic.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class restaurantLoginController {
	
	Controller contr = new Controller();
	
	@FXML
    private Button goBackButt;
	
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
	    		//Checking Restaurant and also getting the current Restaurant and its menus FooItems obj to controller
	    		//Also getting its orders
	    		
	    		ArrayList<Restaurant> restList = contr.getRestaurants();
	    		
	    		Restaurant currRest = new Restaurant(); 
	    		
	    		for (Restaurant obj : restList)
	    		{
	    			if (obj.getUserAccount().getUserName().equals(usernameRestaurant.getText()) && obj.getUserAccount().getPassword().equals(passowrdLoginRestaurant.getText()))
	    			{
	    				currRest = obj;
	    				contr.setCurrentRestaurant(obj);
	    				
	    				//Foodlist
	    				ArrayList<FoodItem> restFoodList = contr.getFoodItems();
	    				obj.getMenuObj().setFoodList(restFoodList);
	    				contr.setCurrentRestaurant(obj);
	    				
	    				//Orders
	    				ArrayList<Order> restOrders = contr.getOrders();
	    				obj.setOrderList(restOrders);
	    				contr.setCurrentRestaurant(obj);
	    				
	    				Main m = new Main();
	    	    		m.changeScene("RestaurantPage.fxml");
	    	    		break;
	    			}
	    		}
	    		invalidDetails.setText("Invalid Details");
	    		
	    		
	    	}
	    }
	    
	    @FXML
	    void registrationRestaurant(ActionEvent event) throws IOException {
	    	Main m = new Main();
    		m.changeScene("RestaurantRegistration.fxml");
	    }
	    
	    @FXML
	    void goBackAct(ActionEvent event) throws IOException {
	    	Main m = new Main();
    		m.changeScene("Home.fxml");

	    }
}
