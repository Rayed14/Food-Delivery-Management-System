package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class deleteFoodItemController {
	@FXML
    private TableColumn<?, ?> ItemName;

    @FXML
    private TableColumn<?, ?> ItemPrice;

    @FXML
    private Button deleteFoodButton;

    @FXML
    private TableView<?> delteFoodItemTable;

    @FXML
    private TableColumn<?, ?> itemID;

    @FXML
    private Button returnToPortal;

    @FXML
    void removeFoodItem(ActionEvent event) {

    }

    @FXML
    void toRestaurantPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RestaurantPage.fxml");
    }
}
