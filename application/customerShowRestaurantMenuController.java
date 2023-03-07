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

public class customerShowRestaurantMenuController implements Initializable {
	
	Controller contr = new Controller();
	
	 @FXML
	    private TableColumn<FoodItem, String> FoodItemDescription;

	    @FXML
	    private TableColumn<FoodItem, Integer> FoodItemID;

	    @FXML
	    private TableColumn<FoodItem, String> FoodItemName;

	    @FXML
	    private TableColumn<FoodItem, Double> FoodItemPrice;

	    @FXML
	    private TableView<FoodItem> MenuTable;

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
	    	
	    	if (MenuTable.getSelectionModel().getSelectedIndex() == -1)
	    	{
	    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
	    		alertObj.setHeaderText("There is no Food Item selected");
	    		alertObj.setTitle("Warning");
	    		alertObj.setContentText("Please select a Food Item before pressing the Addd Item to Cart button.");
	    		alertObj.showAndWait();
	    	}
	    	else
	    	{
	    		FoodItem itemObj = MenuTable.getSelectionModel().getSelectedItem();
	    		contr.addToCart(itemObj);
	    		
	    		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
		    	alertObj.setHeaderText("SUCCESSFULL");
		   		alertObj.setTitle("Item Added");
		    	alertObj.setContentText("Item added to your Cart!");
		    	alertObj.showAndWait();
	    	}
	    	
	    	
	    	
	    	
	    }
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	    	
	    	ArrayList<FoodItem> foodList = contr.getFoodItems();
			
			ObservableList<FoodItem> data = FXCollections.observableArrayList(foodList);

			FoodItemName.setCellValueFactory(new PropertyValueFactory<FoodItem,String>("foodName"));
			FoodItemPrice.setCellValueFactory(new PropertyValueFactory<FoodItem,Double>("price"));
			FoodItemID.setCellValueFactory(new PropertyValueFactory<FoodItem,Integer>("itemId"));
			FoodItemDescription.setCellValueFactory(new PropertyValueFactory<FoodItem,String>("details"));

			MenuTable.setItems(data);

		}

	    @FXML
	    void toCustomerPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerPage.fxml");
	    }

}
