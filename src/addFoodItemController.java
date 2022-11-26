package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class addFoodItemController {
	@FXML
    private TextArea ItemIngredients;

    @FXML
    private TextField ItemName;

    @FXML
    private TextField ItemPrice;

    @FXML
    private Button addButton;

    @FXML
    private Button toPortalButton;

    @FXML
    private Label warning;

    @FXML
    void addItem(ActionEvent event) {
    	if(ItemName.getText().isEmpty() || ItemIngredients.getText().isEmpty() || ItemPrice.getText().isEmpty())
    	{
    		warning.setText("Please fill in all fields");
    	}
    	else {
    		
    	}
    }

    @FXML
    void toRestaurantPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RestaurantPage.fxml");
    }
}
