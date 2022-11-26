package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerCartPageController {
	 @FXML
	    private Button ConfirmOrderButoon;

	    @FXML
	    private TableColumn<?, ?> FoodItemDescription;

	    @FXML
	    private TableColumn<?, ?> FoodItemID;

	    @FXML
	    private TableColumn<?, ?> FoodItemName;

	    @FXML
	    private TableColumn<?, ?> FoodItemPrice;

	    @FXML
	    private TableView<?> OrderedItemsTable;

	    @FXML
	    private Button returnToMenu;

	    @FXML
	    void ConfirmOrderandGotoPortal(ActionEvent event) throws IOException {
	    	Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
	    	alertObj.setHeaderText("ORDER SUCCESSFULL");
	   		alertObj.setTitle("Order Placed");
	    	alertObj.setContentText("Order has been Placed!");
	    	alertObj.showAndWait();
	    	
	    	Main m = new Main();
	    	m.changeScene("CustomerPage.fxml");
	    }

	    @FXML
	    void toMenuPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerShowRestaurantMenu.fxml");
	    }
}
