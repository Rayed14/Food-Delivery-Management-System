package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class restaurantPageController {
	 @FXML
	    private Button addItemsButton;

	    @FXML
	    private Button deleteItemsButton;

	    @FXML
	    private Label invalidDetails;

	    @FXML
	    private Button logoutButton;

	    @FXML
	    private Button processOrder;

	    @FXML
	    private Button updateMenuButton;

	    @FXML
	    void addFoodPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("AddFoodItem.fxml");
	    }

	    @FXML
	    void deleteItemsPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("DeleteFoodItem.fxml");
	    }

	    @FXML
	    void goBacktoHome(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("Home.fxml");
	    }

	    @FXML
	    void menuUpdatePage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("UpdateMenu.fxml");
	    }

	    @FXML
	    void ordersPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("RestaurantOrderPage.fxml");
	    }
}
