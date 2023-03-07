package application;

import java.io.IOException;

import BusinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class addFoodItemController {
	
	Controller contr = new Controller();
	
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
    void addItem(ActionEvent event) throws IOException {
    	if(ItemName.getText().isEmpty() || ItemIngredients.getText().isEmpty() || ItemPrice.getText().isEmpty())
    	{
    		warning.setText("Please fill in all fields");
    	}
    	else {
    		
    		contr.clickOnAddButtonRes(ItemName.getText(), Double.parseDouble(ItemPrice.getText()), ItemIngredients.getText());
    		
    		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
    		alertObj.setHeaderText("SUCCESSFULL");
    		alertObj.setTitle("Successfull");
    		alertObj.setContentText("The entered food item has been successfully entered!");
    		alertObj.showAndWait();
    		
    		Main m = new Main();
    		m.changeScene("AddFoodItem.fxml");
    		
    	}
    }

    @FXML
    void toRestaurantPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RestaurantPage.fxml");
    }
}
