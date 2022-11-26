package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class customerPageController {
	 @FXML
	    private Button CancelOrderButton;

	    @FXML
	    private Button PlaceOrderButton;

	    @FXML
	    private Button logoutButton;

	    @FXML
	    void OrderListPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerCancelOrder.fxml");
	    }

	    @FXML
	    void RestaurantListsPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerPlaceOrder.fxml");
	    }

	    @FXML
	    void goBacktoHome(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("Home.fxml");
	    }
}
