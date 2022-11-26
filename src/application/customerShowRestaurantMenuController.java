package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerShowRestaurantMenuController {
	 @FXML
	    private TableColumn<?, ?> FoodItemDescription;

	    @FXML
	    private TableColumn<?, ?> FoodItemID;

	    @FXML
	    private TableColumn<?, ?> FoodItemName;

	    @FXML
	    private TableColumn<?, ?> FoodItemPrice;

	    @FXML
	    private TableView<?> MenuTable;

	    @FXML
	    private Button gotoCart;

	    @FXML
	    private Button returnToPortal;

	    @FXML
	    private Button selectItemButton;

	    @FXML
	    void GoToCart(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerCartPage.fxml");
	    }

	    @FXML
	    void selectItemstoAdd(ActionEvent event) {
	    	Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
	    	alertObj.setHeaderText("SUCCESSFULL");
	   		alertObj.setTitle("Item Added");
	    	alertObj.setContentText("Item added to Cart!");
	    	alertObj.showAndWait();
	    }

	    @FXML
	    void toCustomerPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerPage.fxml");
	    }

}
