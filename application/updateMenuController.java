package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class updateMenuController implements Initializable{
	
	Controller contr = new Controller();
	
	 @FXML
    private TextArea newIngredients;

    @FXML
    private TextField newName;

    @FXML
    private TextField newPrice;
	
	@FXML
    private TableColumn<FoodItem, String> ItemName;

    @FXML
    private TableColumn<FoodItem, Double> ItemPrice;

    @FXML
    private TableColumn<FoodItem, Integer> itemID;
    
    @FXML
    private TableColumn<FoodItem, String> ingredients;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button updateFoodButton;

    @FXML
    private TableView<FoodItem> updateFoodItemTable;
    
    @FXML
    private Label warning;


    @FXML
    void toRestaurantPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RestaurantPage.fxml");
    }

    @FXML
    void updateFoodItem(ActionEvent event) throws IOException  {
    	
    	if (updateFoodItemTable.getSelectionModel().getSelectedIndex() == -1)
    	{
    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
    		alertObj.setHeaderText("There is no food selected");
    		alertObj.setTitle("Warning");
    		alertObj.setContentText("Please select a Food before pressing the update button.");
    		alertObj.showAndWait();
    	}
    	else
    	{
    		if(newName.getText().isEmpty() || newPrice.getText().isEmpty() || newIngredients.getText().isEmpty())
        	{
        		warning.setText("Please fill in all fields");
        	}
    		else
    		{
    			FoodItem itemObj = updateFoodItemTable.getSelectionModel().getSelectedItem();
    			
    			contr.clickOnModify(itemObj, newName.getText(), Double.parseDouble(newPrice.getText()), newIngredients.getText());
    			
    			Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
        		alertObj.setHeaderText("SUCCESSFULL");
        		alertObj.setTitle("Successful");
        		alertObj.setContentText("The selected Food Item is successfully updated with the new values.");
        		alertObj.showAndWait();
        		
        		Main m = new Main();
        		m.changeScene("UpdateMenu.fxml");
    			
    		}
    	}
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<FoodItem> foodList = contr.getFoodItems();
		
		ObservableList<FoodItem> data = FXCollections.observableArrayList(foodList);

		ItemName.setCellValueFactory(new PropertyValueFactory<FoodItem,String>("foodName"));
		ItemPrice.setCellValueFactory(new PropertyValueFactory<FoodItem,Double>("price"));
		itemID.setCellValueFactory(new PropertyValueFactory<FoodItem,Integer>("itemId"));
		ingredients.setCellValueFactory(new PropertyValueFactory<FoodItem,String>("details"));

		updateFoodItemTable.setItems(data);

	}
}
