package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class restaurantOrderPageController {
	 @FXML
	    private TableColumn<?, ?> OrderDate;

	    @FXML
	    private TableView<?> OrdersTable;

	    @FXML
	    private TableColumn<?, ?> Orderstatus;

	    @FXML
	    private TableColumn<?, ?> itemID;

	    @FXML
	    private Button returnToPortal;

	    @FXML
	    private Button selectOrderButton;

	    @FXML
	    void selectOrdertoProcess(ActionEvent event) {

	    }

	    @FXML
	    void toRestaurantPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("RestaurantPage.fxml");
	    }
}
