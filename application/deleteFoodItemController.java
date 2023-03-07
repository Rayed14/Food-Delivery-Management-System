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

public class deleteFoodItemController implements Initializable {
	
	Controller contr = new Controller();
	
	@FXML
    private TableColumn<FoodItem, String> ItemName;

    @FXML
    private TableColumn<FoodItem, Double> ItemPrice;

    @FXML
    private Button deleteFoodButton;

    @FXML
    private TableView<FoodItem> delteFoodItemTable;

    @FXML
    private TableColumn<FoodItem, Integer> itemID;
    
    @FXML
    private TableColumn<FoodItem, String> ingredients;

    @FXML
    private Button returnToPortal;

    @FXML
    void removeFoodItem(ActionEvent event) throws IOException {
    	
    	if (delteFoodItemTable.getSelectionModel().getSelectedIndex() == -1)
    	{
    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
    		alertObj.setHeaderText("There is no Food Item selected");
    		alertObj.setTitle("Warning");
    		alertObj.setContentText("Please select a Food Item before pressing the delete button.");
    		alertObj.showAndWait();
    	}
    	else
    	{
    		FoodItem itemObj = delteFoodItemTable.getSelectionModel().getSelectedItem();
    		contr.clickOnDelete(itemObj);
    		
    		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
    		alertObj.setHeaderText("SUCCESSFULL");
    		alertObj.setTitle("Successful");
    		alertObj.setContentText("The selected Food Item is successfully deleted from your menu.");
    		alertObj.showAndWait();
    		
    		Main m = new Main();
    		m.changeScene("DeleteFoodItem.fxml");
    		
    		
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

		delteFoodItemTable.setItems(data);

	}

    @FXML
    void toRestaurantPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RestaurantPage.fxml");
    }
}
