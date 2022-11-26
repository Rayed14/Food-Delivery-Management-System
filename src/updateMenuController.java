package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class updateMenuController {
	@FXML
    private TableColumn<?, ?> ItemName;

    @FXML
    private TableColumn<?, ?> ItemPrice;

    @FXML
    private TableColumn<?, ?> itemID;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button updateFoodButton;

    @FXML
    private TableView<?> updateFoodItemTable;

    @FXML
    void toRestaurantPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RestaurantPage.fxml");
    }

    @FXML
    void updateFoodItem(ActionEvent event) {
    	
    }
}
